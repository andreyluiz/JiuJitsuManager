package br.com.jiujitsu.manager.view;

import javax.swing.JPanel;

/**
 *
 * @author Andrey Luiz
 */
public class Lutas extends JPanel implements EditingOperator {

    private Main parent;
    
    /** Creates new form Lutas */
    public Lutas(Main parent) {
        this.parent = parent;
        initComponents();
    }
    
    @Override
    public void preConfigure() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void actionIncluir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actionEditar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actionSalvar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actionCancelar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actionExcluir() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelChaveamento2 = new javax.swing.JPanel();
        panelProcurar_Cha2 = new javax.swing.JPanel();
        buttonOK_Cha2 = new javax.swing.JButton();
        comboCategoria2 = new javax.swing.JComboBox();
        panelProxLutas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProxLutas = new javax.swing.JTable();
        buttonIniciarLuta = new javax.swing.JButton();
        panelVencedores = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableVencedores = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(999, 643));
        setMinimumSize(new java.awt.Dimension(999, 643));
        setPreferredSize(new java.awt.Dimension(999, 643));

        panelChaveamento2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelProcurar_Cha2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Procurar por Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        panelProcurar_Cha2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        buttonOK_Cha2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        buttonOK_Cha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jiujitsu/manager/view/imagens/tick.png"))); // NOI18N
        buttonOK_Cha2.setText("OK");

        comboCategoria2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        javax.swing.GroupLayout panelProcurar_Cha2Layout = new javax.swing.GroupLayout(panelProcurar_Cha2);
        panelProcurar_Cha2.setLayout(panelProcurar_Cha2Layout);
        panelProcurar_Cha2Layout.setHorizontalGroup(
            panelProcurar_Cha2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProcurar_Cha2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboCategoria2, 0, 192, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(buttonOK_Cha2)
                .addContainerGap())
        );
        panelProcurar_Cha2Layout.setVerticalGroup(
            panelProcurar_Cha2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProcurar_Cha2Layout.createSequentialGroup()
                .addGroup(panelProcurar_Cha2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProcurar_Cha2Layout.createSequentialGroup()
                        .addComponent(buttonOK_Cha2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(comboCategoria2))
                .addContainerGap())
        );

        panelProxLutas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Próximas Lutas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        panelProxLutas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        jScrollPane1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tableProxLutas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tableProxLutas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableProxLutas);

        buttonIniciarLuta.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        buttonIniciarLuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jiujitsu/manager/view/imagens/forward.png"))); // NOI18N
        buttonIniciarLuta.setText("Iniciar Luta");

        javax.swing.GroupLayout panelProxLutasLayout = new javax.swing.GroupLayout(panelProxLutas);
        panelProxLutas.setLayout(panelProxLutasLayout);
        panelProxLutasLayout.setHorizontalGroup(
            panelProxLutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProxLutasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProxLutasLayout.createSequentialGroup()
                .addContainerGap(398, Short.MAX_VALUE)
                .addComponent(buttonIniciarLuta)
                .addGap(388, 388, 388))
        );
        panelProxLutasLayout.setVerticalGroup(
            panelProxLutasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProxLutasLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonIniciarLuta)
                .addContainerGap())
        );

        panelVencedores.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vencedores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N

        jScrollPane3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tableVencedores.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tableVencedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tableVencedores);

        javax.swing.GroupLayout panelVencedoresLayout = new javax.swing.GroupLayout(panelVencedores);
        panelVencedores.setLayout(panelVencedoresLayout);
        panelVencedoresLayout.setHorizontalGroup(
            panelVencedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVencedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelVencedoresLayout.setVerticalGroup(
            panelVencedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVencedoresLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelChaveamento2Layout = new javax.swing.GroupLayout(panelChaveamento2);
        panelChaveamento2.setLayout(panelChaveamento2Layout);
        panelChaveamento2Layout.setHorizontalGroup(
            panelChaveamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelChaveamento2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelChaveamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelVencedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelProxLutas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelChaveamento2Layout.createSequentialGroup()
                        .addComponent(panelProcurar_Cha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelChaveamento2Layout.setVerticalGroup(
            panelChaveamento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelChaveamento2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelProcurar_Cha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelProxLutas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelVencedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelChaveamento2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelChaveamento2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonIniciarLuta;
    private javax.swing.JButton buttonOK_Cha;
    private javax.swing.JButton buttonOK_Cha1;
    private javax.swing.JButton buttonOK_Cha2;
    private javax.swing.JComboBox comboCategoria;
    private javax.swing.JComboBox comboCategoria1;
    private javax.swing.JComboBox comboCategoria2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelChaveamento;
    private javax.swing.JPanel panelChaveamento1;
    private javax.swing.JPanel panelChaveamento2;
    private javax.swing.JPanel panelProcurar_Cha;
    private javax.swing.JPanel panelProcurar_Cha1;
    private javax.swing.JPanel panelProcurar_Cha2;
    private javax.swing.JPanel panelProxLutas;
    private javax.swing.JPanel panelVencedores;
    private javax.swing.JTable tableProxLutas;
    private javax.swing.JTable tableVencedores;
    // End of variables declaration//GEN-END:variables

}