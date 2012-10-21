package br.com.jiujitsu.manager.view;

import javax.swing.JFrame;

/**
 *
 * @author Andrey Luiz
 */
public class Main extends JFrame {
    
    protected boolean editing;
    private Cadastro cadastro = Cadastro.getInstance(this);
    private Chaveamento chaveamento = Chaveamento.getInstance(this);
    private Lutas lutas = Lutas.getInstance(this);
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        preConfigure(tabPanels.getSelectedIndex());
    }
    
    private void preConfigure(int tabIndex) {
        this.setLocationRelativeTo(null);
        
        switch (tabIndex) {
            case 0:
                if (!cadastro.isValid()) {                    
                    cadastro.setBounds(0, 0, 999, 643);
                    tabCadastro.add(cadastro);
                    cadastro.setVisible(true);
                }
                cadastro.preConfigure();
                break;
            case 1:
                if (!chaveamento.isValid()) {                    
                    chaveamento.setBounds(0, 0, 999, 643);
                    tabChaveamento.add(chaveamento);
                    chaveamento.setVisible(true);
                }
                chaveamento.preConfigure();
                break;
            case 2:
                if (!lutas.isValid()) {                    
                    lutas.setBounds(0, 0, 999, 643);
                    tabLutas.add(lutas);
                    lutas.setVisible(true);
                }
                lutas.preConfigure();
                break;
            case 3:
                break;           
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelButtons = new javax.swing.JPanel();
        buttonIncluir = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();
        tabPanels = new javax.swing.JTabbedPane();
        tabCadastro = new javax.swing.JPanel();
        tabChaveamento = new javax.swing.JPanel();
        tabLutas = new javax.swing.JPanel();
        tabRelatorios = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jiu Jitsu Manager");
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setResizable(false);

        panelButtons.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonIncluir.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        buttonIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jiujitsu/manager/view/imagens/plus.png"))); // NOI18N
        buttonIncluir.setText("Incluir");
        buttonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIncluirActionPerformed(evt);
            }
        });

        buttonEditar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        buttonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jiujitsu/manager/view/imagens/edit.png"))); // NOI18N
        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        buttonSalvar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        buttonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jiujitsu/manager/view/imagens/save.png"))); // NOI18N
        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        buttonCancelar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jiujitsu/manager/view/imagens/block.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonExcluir.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        buttonExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jiujitsu/manager/view/imagens/delete.png"))); // NOI18N
        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonsLayout = new javax.swing.GroupLayout(panelButtons);
        panelButtons.setLayout(panelButtonsLayout);
        panelButtonsLayout.setHorizontalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelButtonsLayout.setVerticalGroup(
            panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonIncluir)
                    .addComponent(buttonEditar)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonCancelar)
                    .addComponent(buttonExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabPanels.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabPanels.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabPanelsMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout tabCadastroLayout = new javax.swing.GroupLayout(tabCadastro);
        tabCadastro.setLayout(tabCadastroLayout);
        tabCadastroLayout.setHorizontalGroup(
            tabCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 999, Short.MAX_VALUE)
        );
        tabCadastroLayout.setVerticalGroup(
            tabCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        tabPanels.addTab("Cadastro", tabCadastro);

        tabChaveamento.setMaximumSize(new java.awt.Dimension(1008, 670));
        tabChaveamento.setPreferredSize(new java.awt.Dimension(1008, 670));

        javax.swing.GroupLayout tabChaveamentoLayout = new javax.swing.GroupLayout(tabChaveamento);
        tabChaveamento.setLayout(tabChaveamentoLayout);
        tabChaveamentoLayout.setHorizontalGroup(
            tabChaveamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 999, Short.MAX_VALUE)
        );
        tabChaveamentoLayout.setVerticalGroup(
            tabChaveamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        tabPanels.addTab("Chaveamento", tabChaveamento);

        javax.swing.GroupLayout tabLutasLayout = new javax.swing.GroupLayout(tabLutas);
        tabLutas.setLayout(tabLutasLayout);
        tabLutasLayout.setHorizontalGroup(
            tabLutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 999, Short.MAX_VALUE)
        );
        tabLutasLayout.setVerticalGroup(
            tabLutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        tabPanels.addTab("Lutas", tabLutas);

        javax.swing.GroupLayout tabRelatoriosLayout = new javax.swing.GroupLayout(tabRelatorios);
        tabRelatorios.setLayout(tabRelatoriosLayout);
        tabRelatoriosLayout.setHorizontalGroup(
            tabRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 999, Short.MAX_VALUE)
        );
        tabRelatoriosLayout.setVerticalGroup(
            tabRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        tabPanels.addTab("Relatórios", tabRelatorios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabPanels, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPanels, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIncluirActionPerformed
        switch (tabPanels.getSelectedIndex()) {
            case 0:
                cadastro.actionIncluir();
                break;            
        }
    }//GEN-LAST:event_buttonIncluirActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        switch (tabPanels.getSelectedIndex()) {
            case 0:
                cadastro.actionEditar();
                break;            
        }
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        switch (tabPanels.getSelectedIndex()) {
            case 0:
                cadastro.actionSalvar();
                break;            
        }
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        switch (tabPanels.getSelectedIndex()) {
            case 0:
                cadastro.actionCancelar();
                break;            
        }
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        switch (tabPanels.getSelectedIndex()) {
            case 0:
                cadastro.actionExcluir();
                break;           
        }
    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void tabPanelsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPanelsMouseReleased
        preConfigure(tabPanels.getSelectedIndex());
    }//GEN-LAST:event_tabPanelsMouseReleased

    //<editor-fold defaultstate="collapsed" desc="Main Method">
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton buttonIncluir;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JPanel panelButtons;
    private javax.swing.JPanel tabCadastro;
    private javax.swing.JPanel tabChaveamento;
    private javax.swing.JPanel tabLutas;
    private javax.swing.JTabbedPane tabPanels;
    private javax.swing.JPanel tabRelatorios;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
            
    protected void changeMainButtons(boolean editing, boolean cadastro) {
        buttonIncluir.setEnabled(!editing && cadastro);
        buttonEditar.setEnabled(!editing && cadastro);
        buttonSalvar.setEnabled(editing && cadastro);
        buttonCancelar.setEnabled(editing && cadastro);
        buttonExcluir.setEnabled(!editing && cadastro);
    }
    
}