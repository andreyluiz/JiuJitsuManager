package br.com.jiujitsu.manager.view;

import br.com.jiujitsu.manager.controller.database.AtletasDataManager;
import br.com.jiujitsu.manager.model.AtletaModel;
import br.com.jiujitsu.manager.model.AtletasTableModel;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ToolTipManager;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Andrey Luiz
 */
public class Cadastro extends JPanel implements EditingOperator {

    private static Cadastro instance = null;
    private AtletasTableModel tableModelPesquisa = new AtletasTableModel();
    private Main parent;
    
    /**
     * Creates new form Cadastro
     */
    public Cadastro(Main parent) {
        this.parent = parent;
        initComponents();
    }
    
    public static Cadastro getInstance(Main parent) {
        if (instance == null) {
            instance = new Cadastro(parent);
        }
        return instance;
    }
    
    @Override
    public void preConfigure() {
        evaluateCombosPesquisa();        
        tablePesquisa.setModel(tableModelPesquisa);
        
        editPesquisa.requestFocus();
        changeInterfaceCadastro(false);
        parent.changeMainButtons(false, true);

        buttonFiltrar.setEnabled(false);

        ToolTipManager.sharedInstance().setDismissDelay(60000);
        formatTableAtletasCadastro();
    }

    @Override
    public void actionIncluir() {
        editingProcedure(true, true, false, true, 1, editNome);
    }
    
    @Override
    public void actionEditar() {
        if (tablePesquisa.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha, primeiro.", "Espere!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        AtletaModel atleta = tableModelPesquisa.getAtleta(tablePesquisa.getSelectedRow());
        
        editId.setText(String.valueOf(atleta.getId()));
        editNome.setText(atleta.getNome());
        editDataNasc.setDate(atleta.getData_nasc());
        editPeso.setValue(atleta.getPeso());
        radioMasc.setSelected(atleta.getSexo() == 'M');
        radioFem.setSelected(atleta.getSexo() == 'F');
        checkboxKimono.setSelected(atleta.isKimono());
        radioLiso.setSelected(atleta.getTipo_kimono() == 'L');
        radioTrancado.setSelected(atleta.getTipo_kimono() == 'T');
        editAcademia.setText(atleta.getAcademia());
        comboFaixa.setSelectedItem(atleta.getFaixa());
        comboCatIdade.setSelectedItem(atleta.getCategoria_idade());
        comboCatPeso.setSelectedItem(atleta.getCategoria_peso());
        
        editingProcedure(true, true, true, true, 1, editNome);
    }
    
    @Override
    public void actionSalvar() {
        AtletasDataManager manager = new AtletasDataManager();
        
        if (parent.editing) {
            
            AtletaModel example = new AtletaModel(Long.parseLong(editId.getText()));
            AtletaModel atleta = new AtletaModel();
            
            atleta.setNome(editNome.getText());
            atleta.setData_nasc(editDataNasc.getDate());
            atleta.setPeso(Double.valueOf(editPeso.getValue().toString()));
            atleta.setSexo(radioMasc.isSelected() ? 'M' : 'F');
            atleta.setKimono(checkboxKimono.isSelected());
            atleta.setTipo_kimono(radioLiso.isSelected() ? 'L' : 'T');
            atleta.setAcademia(editAcademia.getText());
            atleta.setFaixa(comboFaixa.getSelectedItem().toString());
            atleta.setCategoria_idade(comboCatIdade.getSelectedItem().toString());
            atleta.setCategoria_peso(comboCatPeso.getSelectedItem().toString());
            
            manager.update(example, atleta);
            
            parent.editing = false;            
        } else {
            AtletaModel atleta = new AtletaModel(manager.getLastID() + 1);
        
            atleta.setNome(editNome.getText());
            atleta.setData_nasc(editDataNasc.getDate());
            atleta.setPeso(Double.valueOf(editPeso.getValue().toString()));
            atleta.setSexo(radioMasc.isSelected() ? 'M' : 'F');
            atleta.setKimono(checkboxKimono.isSelected());
            atleta.setTipo_kimono(radioLiso.isSelected() ? 'L' : 'T');
            atleta.setAcademia(editAcademia.getText());
            atleta.setFaixa(comboFaixa.getSelectedItem().toString());
            atleta.setCategoria_idade(comboCatIdade.getSelectedItem().toString());
            atleta.setCategoria_peso(comboCatPeso.getSelectedItem().toString());
            
            manager.store(atleta);
        }       
        
        JOptionPane.showMessageDialog(this, "Atleta '" + editNome.getText() + "' salvo.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        
        filterTable(editPesquisa.getText());
        
        clearFieldsCadastro();
        
        editingProcedure(false, false, false, true, 0, editPesquisa);
    }
    
    @Override
    public void actionCancelar() {
        clearFieldsCadastro();
        editingProcedure(false, false, false, true, 0, editPesquisa);
    }
    
    @Override
    public void actionExcluir() {
        if (tablePesquisa.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione uma linha, primeiro!", "Ei...", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        int resposta = JOptionPane.showConfirmDialog(this, "Deseja mesmo excluir o atleta '" + editNome.getText() + "'?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (resposta == JOptionPane.YES_OPTION) {
            AtletasDataManager manager = new AtletasDataManager();            
            int linha = tablePesquisa.getSelectedRow();
            AtletaModel atleta = tableModelPesquisa.getAtleta(linha);
            String nome_atleta = atleta.getNome();
            manager.delete(atleta);
            tableModelPesquisa.removerAtleta(linha);
            JOptionPane.showMessageDialog(this, "Atleta '" + nome_atleta + "' foi excluido.", "Pronto", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabCadastro1 = new javax.swing.JTabbedPane();
        panelPesquisa = new javax.swing.JPanel();
        checkTodos = new javax.swing.JCheckBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablePesquisa = new javax.swing.JTable();
        editPesquisa = new javax.swing.JTextField();
        comboCampoPesquisa = new javax.swing.JComboBox();
        checkActiveTyping = new javax.swing.JCheckBox();
        comboPesquisa = new javax.swing.JComboBox();
        buttonFiltrar = new javax.swing.JButton();
        buttonLimpar = new javax.swing.JButton();
        panelCadastro = new javax.swing.JPanel();
        panelAtleta = new javax.swing.JPanel();
        labelCodigo = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelDataNasc = new javax.swing.JLabel();
        labelPeso = new javax.swing.JLabel();
        labelSexo = new javax.swing.JLabel();
        labelFaixa = new javax.swing.JLabel();
        labelCatIdade = new javax.swing.JLabel();
        labelCatPeso = new javax.swing.JLabel();
        editId = new javax.swing.JTextField();
        editNome = new javax.swing.JTextField();
        editPeso = new javax.swing.JSpinner();
        panelSexo = new javax.swing.JPanel();
        radioMasc = new javax.swing.JRadioButton();
        radioFem = new javax.swing.JRadioButton();
        comboFaixa = new javax.swing.JComboBox();
        comboCatIdade = new javax.swing.JComboBox();
        comboCatPeso = new javax.swing.JComboBox();
        labelKimono = new javax.swing.JLabel();
        panelKimono = new javax.swing.JPanel();
        checkboxKimono = new javax.swing.JCheckBox();
        radioLiso = new javax.swing.JRadioButton();
        radioTrancado = new javax.swing.JRadioButton();
        labelAcademia = new javax.swing.JLabel();
        editAcademia = new javax.swing.JTextField();
        editDataNasc = new com.toedter.calendar.JDateChooser();

        setMaximumSize(new java.awt.Dimension(999, 643));
        setMinimumSize(new java.awt.Dimension(999, 643));
        setPreferredSize(new java.awt.Dimension(999, 643));

        checkTodos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        checkTodos.setText("Exibir todos os registros");
        checkTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTodosActionPerformed(evt);
            }
        });

        tablePesquisa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tablePesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablePesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablePesquisaMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tablePesquisa);

        editPesquisa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        editPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editPesquisaKeyReleased(evt);
            }
        });

        comboCampoPesquisa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboCampoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID/Nome", "Peso", "Sexo", "Faixa", "Cat. Idade", "Cat. Peso", "Academia" }));
        comboCampoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCampoPesquisaActionPerformed(evt);
            }
        });

        checkActiveTyping.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        checkActiveTyping.setText("Active Typing");
        checkActiveTyping.setToolTipText("<html>\n<b>Marcado:</b> enquanto você digita, os dados vão sendo filtrados instantaneamente.<br />\n<b>Desmarcado:</b> os dados só serão filtrados quando você pressionar <b>|Enter|</b> ou clicar em <b>OK</b>.\n</html>");

        comboPesquisa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPesquisaActionPerformed(evt);
            }
        });

        buttonFiltrar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        buttonFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jiujitsu/manager/view/imagens/tick.png"))); // NOI18N
        buttonFiltrar.setText("OK");
        buttonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFiltrarActionPerformed(evt);
            }
        });

        buttonLimpar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        buttonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jiujitsu/manager/view/imagens/clear.png"))); // NOI18N
        buttonLimpar.setText("Limpar");
        buttonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPesquisaLayout = new javax.swing.GroupLayout(panelPesquisa);
        panelPesquisa.setLayout(panelPesquisaLayout);
        panelPesquisaLayout.setHorizontalGroup(
            panelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPesquisaLayout.createSequentialGroup()
                        .addComponent(checkTodos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelPesquisaLayout.createSequentialGroup()
                        .addGroup(panelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addGroup(panelPesquisaLayout.createSequentialGroup()
                                .addComponent(editPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkActiveTyping, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(buttonLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        panelPesquisaLayout.setVerticalGroup(
            panelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkActiveTyping)
                    .addComponent(buttonFiltrar)
                    .addComponent(buttonLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        tabCadastro1.addTab("Pesquisar", new javax.swing.ImageIcon(getClass().getResource("/br/com/jiujitsu/manager/view/imagens/search.png")), panelPesquisa); // NOI18N

        panelCadastro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelAtleta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atleta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        panelAtleta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        labelCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelCodigo.setText("Código");

        labelNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelNome.setText("Nome");

        labelDataNasc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelDataNasc.setText("Data de Nascimento");

        labelPeso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelPeso.setText("Peso");

        labelSexo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelSexo.setText("Sexo");

        labelFaixa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelFaixa.setText("Faixa");

        labelCatIdade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelCatIdade.setText("Cat. Idade");

        labelCatPeso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelCatPeso.setText("Cat. por Peso");

        editId.setEditable(false);
        editId.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        editNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        editNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        editPeso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        editPeso.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), null, null, Float.valueOf(1.0f)));

        panelSexo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        radioMasc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        radioMasc.setSelected(true);
        radioMasc.setText("Masculino");

        radioFem.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        radioFem.setText("Feminino");

        javax.swing.GroupLayout panelSexoLayout = new javax.swing.GroupLayout(panelSexo);
        panelSexo.setLayout(panelSexoLayout);
        panelSexoLayout.setHorizontalGroup(
            panelSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSexoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioMasc)
                    .addComponent(radioFem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSexoLayout.setVerticalGroup(
            panelSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSexoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioMasc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioFem)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        comboFaixa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboFaixa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Branca", "Cinza", "Amarela", "Laranja", "Verde", "Azul", "Roxa", "Marrom", "Preta", "Vermelha e Preta", "Vermelha" }));

        comboCatIdade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboCatIdade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mirim", "Infantil A", "Infantil B", "Infanto Juvenil A", "Infanto Juvenil B", "Juvenil", "Adulto", "Master", "Senior", "Super Senior" }));

        comboCatPeso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        comboCatPeso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Galo", "Pluma", "Pena", "Leve", "Médio", "Meio Pesado", "Pesado", "Super Pesado", "Pesadíssimo" }));

        labelKimono.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelKimono.setText("Kimono");

        panelKimono.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        checkboxKimono.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        checkboxKimono.setText("Com Kimono");

        radioLiso.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        radioLiso.setSelected(true);
        radioLiso.setText("Liso");

        radioTrancado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        radioTrancado.setText("Trançado");

        javax.swing.GroupLayout panelKimonoLayout = new javax.swing.GroupLayout(panelKimono);
        panelKimono.setLayout(panelKimonoLayout);
        panelKimonoLayout.setHorizontalGroup(
            panelKimonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKimonoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKimonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKimonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(checkboxKimono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radioLiso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(radioTrancado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelKimonoLayout.setVerticalGroup(
            panelKimonoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKimonoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkboxKimono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioLiso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioTrancado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelAcademia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelAcademia.setText("Academia");

        editAcademia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout panelAtletaLayout = new javax.swing.GroupLayout(panelAtleta);
        panelAtleta.setLayout(panelAtletaLayout);
        panelAtletaLayout.setHorizontalGroup(
            panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtletaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAtletaLayout.createSequentialGroup()
                        .addGroup(panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelSexo)
                            .addComponent(panelSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(editDataNasc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editNome, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNome)
                            .addGroup(panelAtletaLayout.createSequentialGroup()
                                .addGroup(panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelPeso)
                                    .addComponent(editPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelKimono)
                                    .addComponent(panelKimono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboCatIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelCatIdade)
                                    .addComponent(comboFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelFaixa)
                                    .addComponent(labelCatPeso)
                                    .addComponent(comboCatPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(labelAcademia)
                    .addComponent(editAcademia, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAtletaLayout.setVerticalGroup(
            panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtletaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo)
                    .addComponent(labelNome))
                .addGap(2, 2, 2)
                .addGroup(panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDataNasc)
                    .addComponent(labelPeso)
                    .addComponent(labelFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboFaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(editDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSexo)
                    .addComponent(labelKimono)
                    .addComponent(labelCatIdade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAtletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelKimono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAtletaLayout.createSequentialGroup()
                        .addComponent(comboCatIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelCatPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCatPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addComponent(labelAcademia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editAcademia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelCadastroLayout = new javax.swing.GroupLayout(panelCadastro);
        panelCadastro.setLayout(panelCadastroLayout);
        panelCadastroLayout.setHorizontalGroup(
            panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAtleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(439, Short.MAX_VALUE))
        );
        panelCadastroLayout.setVerticalGroup(
            panelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAtleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        tabCadastro1.addTab("Detalhe", new javax.swing.ImageIcon(getClass().getResource("/br/com/jiujitsu/manager/view/imagens/document.png")), panelCadastro); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabCadastro1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabCadastro1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
        
    private void checkTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTodosActionPerformed
        AtletasDataManager manager = new AtletasDataManager();
        tableModelPesquisa.addAll(manager.getAll());
    }//GEN-LAST:event_checkTodosActionPerformed

    private void editPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editPesquisaKeyReleased
        if (checkActiveTyping.isSelected()) {
            filterTable(editPesquisa.getText());
        }
        buttonFiltrar.setEnabled(!editPesquisa.getText().equals(""));
    }//GEN-LAST:event_editPesquisaKeyReleased

    private void comboCampoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCampoPesquisaActionPerformed
        evaluateCombosPesquisa();
    }//GEN-LAST:event_comboCampoPesquisaActionPerformed

    private void buttonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFiltrarActionPerformed
        filterTable(editPesquisa.getText());
    }//GEN-LAST:event_buttonFiltrarActionPerformed

    private void buttonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimparActionPerformed
        tableModelPesquisa.limpar();
    }//GEN-LAST:event_buttonLimparActionPerformed

    private void tablePesquisaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePesquisaMouseReleased
        if (evt.getClickCount() == 2) {
            actionEditar();
        }
    }//GEN-LAST:event_tablePesquisaMouseReleased

    private void comboPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPesquisaActionPerformed
        buttonFiltrar.setEnabled(comboPesquisa.getSelectedIndex() >= 0);
    }//GEN-LAST:event_comboPesquisaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFiltrar;
    private javax.swing.JButton buttonLimpar;
    private javax.swing.JCheckBox checkActiveTyping;
    private javax.swing.JCheckBox checkTodos;
    private javax.swing.JCheckBox checkboxKimono;
    private javax.swing.JComboBox comboCampoPesquisa;
    private javax.swing.JComboBox comboCatIdade;
    private javax.swing.JComboBox comboCatPeso;
    private javax.swing.JComboBox comboFaixa;
    private javax.swing.JComboBox comboPesquisa;
    private javax.swing.JTextField editAcademia;
    private com.toedter.calendar.JDateChooser editDataNasc;
    private javax.swing.JTextField editId;
    private javax.swing.JTextField editNome;
    private javax.swing.JSpinner editPeso;
    private javax.swing.JTextField editPesquisa;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel labelAcademia;
    private javax.swing.JLabel labelCatIdade;
    private javax.swing.JLabel labelCatPeso;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDataNasc;
    private javax.swing.JLabel labelFaixa;
    private javax.swing.JLabel labelKimono;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPeso;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JPanel panelAtleta;
    private javax.swing.JPanel panelCadastro;
    private javax.swing.JPanel panelKimono;
    private javax.swing.JPanel panelPesquisa;
    private javax.swing.JPanel panelSexo;
    private javax.swing.JRadioButton radioFem;
    private javax.swing.JRadioButton radioLiso;
    private javax.swing.JRadioButton radioMasc;
    private javax.swing.JRadioButton radioTrancado;
    private javax.swing.JTabbedPane tabCadastro1;
    private javax.swing.JTable tablePesquisa;
    // End of variables declaration//GEN-END:variables
        
    private void editingProcedure(boolean interf, boolean cadbtn, boolean editing, boolean changetab, int tabindex, Component toFocus) {
        changeInterfaceCadastro(interf);
        parent.changeMainButtons(cadbtn, true);
        
        parent.editing = editing;
        
        if (changetab) {
            tabCadastro1.setSelectedIndex(tabindex);
        }
        
        if (toFocus != null) {
            toFocus.requestFocus();
        }
    }
    
    private void changeInterfaceCadastro(boolean enabled) {
        panelAtleta.setEnabled(enabled);
        editNome.setEnabled(enabled);
        editDataNasc.setEnabled(enabled);
        editPeso.setEnabled(enabled);
        radioMasc.setEnabled(enabled);
        radioFem.setEnabled(enabled);
        checkboxKimono.setEnabled(enabled);
        radioLiso.setEnabled(enabled);
        radioTrancado.setEnabled(enabled);
        editAcademia.setEnabled(enabled);
        comboFaixa.setEnabled(enabled);
        comboCatIdade.setEnabled(enabled);
        comboCatPeso.setEnabled(enabled);
    }
    
    private void clearFieldsCadastro() {
        editId.setText(null);
        editNome.setText(null);
        editDataNasc.setDate(null);
        editPeso.setValue(0);
        radioMasc.setSelected(true);
        checkboxKimono.setSelected(false);
        radioLiso.setSelected(true);
        editAcademia.setText(null);
        comboFaixa.setSelectedIndex(0);
        comboCatIdade.setSelectedIndex(0);
        comboCatPeso.setSelectedIndex(0);
    }
    
    private void evaluateCombosPesquisa() {
        if (comboCampoPesquisa.getSelectedIndex() == 0 || comboCampoPesquisa.getSelectedIndex() == 1 || comboCampoPesquisa.getSelectedIndex() == 6) {
            editPesquisa.setEnabled(true);
            comboPesquisa.setEnabled(false);
            checkActiveTyping.setEnabled(true);
            comboPesquisa.setModel(new DefaultComboBoxModel());           
            
            buttonFiltrar.setEnabled(!editPesquisa.getText().equals(""));
        } else {
            if (comboCampoPesquisa.getSelectedIndex() == 2) {
                comboPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
            } else if (comboCampoPesquisa.getSelectedIndex() == 3) {
                comboPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Branca", "Cinza", "Amarela", "Laranja", "Verde", "Azul", "Roxa", "Marrom", "Preta", "Vermelha e Preta", "Vermelha"}));
            } else if (comboCampoPesquisa.getSelectedIndex() == 4) {
                comboPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Mirim", "Infantil A", "Infantil B", "Infanto Juvenil A", "Infanto Juvenil B", "Juvenil", "Adulto", "Master", "Senior", "Super Senior"}));
            } else if (comboCampoPesquisa.getSelectedIndex() == 5) {
                comboPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Galo", "Pluma", "Pena", "Leve", "Médio", "Meio Pesado", "Pesado", "Super Pesado", "Pesadíssimo"}));
            }
            editPesquisa.setEnabled(false);
            comboPesquisa.setEnabled(true);
            checkActiveTyping.setEnabled(false);
            checkActiveTyping.setSelected(false);
            
            buttonFiltrar.setEnabled(comboPesquisa.getSelectedIndex() >= 0);
        }
    }
    
    private void filterTable(String text) {
        AtletasDataManager manager = new AtletasDataManager();
        List<AtletaModel> atletas = new ArrayList<>();

        switch (comboCampoPesquisa.getSelectedIndex()) {
            case 0:
                try {
                    long id = Long.parseLong(text);
                    atletas = manager.getByAttr("id", id);
                } catch (NumberFormatException except) {
                    String nome = text;
                    atletas = manager.getByAttr("nome", nome);
                }
                break;
            case 1:
                try {
                    double peso = Double.parseDouble(text);
                    atletas = manager.getByAttr("peso", peso);
                } catch (NumberFormatException except) {
                    editPesquisa.setText(null);
                }
                break;
            case 2:
                char sexo = comboPesquisa.getSelectedIndex() == 0 ? 'M' : 'F';
                atletas = manager.getByAttr("sexo", sexo);
                break;
            case 3:
                String faixa = comboPesquisa.getSelectedItem().toString();
                atletas = manager.getByAttr("faixa", faixa);
                break;
            case 4:
                String cat_idade = comboPesquisa.getSelectedItem().toString();
                atletas = manager.getByAttr("categoria_idade", cat_idade);
                break;
            case 5:
                String cat_peso = comboPesquisa.getSelectedItem().toString();
                atletas = manager.getByAttr("categoria_peso", cat_peso);
                break;
            case 6:
                String academia = text;
                atletas = manager.getByAttr("academia", academia);
                break;
        }

        tableModelPesquisa.addAll(atletas);
        formatTableAtletasCadastro();
    }
    
    private void formatTableAtletasCadastro() {
        TableColumnModel colModel = tablePesquisa.getColumnModel();
        
        JTableHeader header = tablePesquisa.getTableHeader();
        header.setFont(new Font("Verdana", Font.PLAIN, 12));
        
        tablePesquisa.setTableHeader(header);
        
        tablePesquisa.setRowHeight(25);
        
        colModel.getColumn(0).setWidth(50);
        colModel.getColumn(0).setMaxWidth(50);
        colModel.getColumn(0).setMinWidth(50);
        colModel.getColumn(0).setPreferredWidth(50);
        
        colModel.getColumn(2).setWidth(300);
        colModel.getColumn(2).setMaxWidth(300);
        colModel.getColumn(2).setMinWidth(300);
        colModel.getColumn(2).setPreferredWidth(300);
        
        colModel.getColumn(3).setWidth(150);
        colModel.getColumn(3).setMaxWidth(150);
        colModel.getColumn(3).setMinWidth(150);
        colModel.getColumn(3).setPreferredWidth(150);
        
        colModel.getColumn(4).setWidth(200);
        colModel.getColumn(4).setMaxWidth(200);
        colModel.getColumn(4).setMinWidth(200);
        colModel.getColumn(4).setPreferredWidth(200);
        
        colModel.getColumn(5).setWidth(200);
        colModel.getColumn(5).setMaxWidth(200);
        colModel.getColumn(5).setMinWidth(200);
        colModel.getColumn(5).setPreferredWidth(200);
        
        colModel.getColumn(6).setWidth(200);
        colModel.getColumn(6).setMaxWidth(200);
        colModel.getColumn(6).setMinWidth(200);
        colModel.getColumn(6).setPreferredWidth(200);
        
        tablePesquisa.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tablePesquisa.setColumnModel(colModel);
    }

}
