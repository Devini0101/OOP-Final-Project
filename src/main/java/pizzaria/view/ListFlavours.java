package pizzaria.view;

import pizzaria.model.Flavour;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pizzaria.Pizzaria;

/**
 * @author eduardo
 * @author Vinicius Dias
 */
public class ListFlavours extends javax.swing.JPanel {

    private DefaultTableModel tableModel;
    private ArrayList<Flavour> flavourList;
    private Pizzaria sistema;
    private javax.swing.JPanel lastScreen;
    
    public ListFlavours(Pizzaria sistema, javax.swing.JPanel lastScreen) {
        this.lastScreen = lastScreen;
        initComponents();
        this.sistema = sistema;
        this.flavourList = this.sistema.getFlavoursList();
        this.tableModel = (DefaultTableModel) jTable1.getModel();
        updateTable(this.flavourList);
    }

    private void updateTable(ArrayList<Flavour> listToShow) {
        tableModel.setNumRows(0);
        for (Flavour f : listToShow) {
            tableModel.addRow(new Object[]{
                f.getName(),
                f.getType().name()
            });
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton1    = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2     = new javax.swing.JLabel();
        jScrollPane1= new javax.swing.JScrollPane();
        jTable1     = new javax.swing.JTable();
        jButton4    = new javax.swing.JButton();
        jButton2    = new javax.swing.JButton();
        jButton3    = new javax.swing.JButton();
        btnVoltar   = new javax.swing.JButton();
        jLabel1     = new javax.swing.JLabel();

        jButton1.setText("Buscar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jTextField1.setToolTipText("Buscar sabor pelo nome");
        jTextField1.addActionListener(this::jButton1ActionPerformed);

        jLabel2.setText("Buscar Sabor");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {
                {null, null}, {null, null}, {null, null}, {null, null}
            },
            new String[] { "Sabor", "Tipo" }
        ) {
            Class[] types = new Class[]{ java.lang.String.class, java.lang.String.class };
            public Class getColumnClass(int columnIndex) { return types[columnIndex]; }
            public boolean isCellEditable(int r, int c) { return false; }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton4.setBackground(new java.awt.Color(0, 255, 0));
        jButton4.setText("Adicionar");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Excluir");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setText("Editar");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel1.setText("Sabores");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVoltar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btnVoltar)
                    .addComponent(jButton4))
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }
    
    // Busca por nome
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String search = jTextField1.getText().toLowerCase().trim();
        if (search.isEmpty()) { updateTable(flavourList); return; }
        ArrayList<Flavour> filtered = new ArrayList<>();
        for (Flavour f : flavourList)
            if (f.getName().toLowerCase().contains(search)) filtered.add(f);
        updateTable(filtered);
    }

    // Adicionar novo sabor
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        SignupFlavour tela = new SignupFlavour(flavourList, -1, this, this.sistema);
        javax.swing.JFrame janela = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        janela.setContentPane(tela);
        janela.revalidate();
        janela.repaint();
    }

    // Excluir sabor selecionado
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            int resp = JOptionPane.showConfirmDialog(this,
                "Tem certeza que deseja excluir esse sabor?", "Confirmação",
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (resp == JOptionPane.YES_OPTION) {
                flavourList.remove(row);
                tableModel.removeRow(row);
                JOptionPane.showMessageDialog(this, "Sabor excluído com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(this,
                "Selecione um sabor na tabela para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Editar sabor selecionado
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            SignupFlavour tela = new SignupFlavour(flavourList, row, this, this.sistema);
            javax.swing.JFrame janela = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
            janela.setContentPane(tela);
            janela.revalidate();
            janela.repaint();
        } else {
            JOptionPane.showMessageDialog(this,
                "Por favor, selecione um sabor para edição!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.lastScreen != null) {
            javax.swing.JFrame janela = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
            if (janela != null) {
                janela.setContentPane(this.lastScreen);
                janela.revalidate();
                janela.repaint();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma tela anterior foi registrada.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    
    private javax.swing.JButton jButton1, jButton2, jButton3, jButton4, btnVoltar;
    private javax.swing.JLabel jLabel1, jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
}