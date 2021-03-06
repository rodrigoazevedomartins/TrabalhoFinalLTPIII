/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.InterfaceUsuario;

import br.edu.ifnmg.tads.trabalhofinal.DataAccess.TiporecursoDAO;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.TipoRecurso;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauro
 */
public class frmEditarTiporecurso extends javax.swing.JInternalFrame {
    
    private TiporecursoDAO tiporecursodao;
    private TipoRecurso tiporecurso;
    private Component RootPane;
    /**
     * Creates new form frmEditarTiporecurso
     */
    public frmEditarTiporecurso(int cod) {
        initComponents();
        tiporecursodao = new TiporecursoDAO();
        tiporecurso = tiporecursodao.Abrir(cod);
        
        txtNome.setText(tiporecurso.getNome());
        txtDescricao.setText(tiporecurso.getDescricao());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        lblDescricao = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar Tipo de Recurso");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setText("NOME:");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        lblDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescricao.setText("DESCRIÇÃO:");

        btnAtualizar.setBackground(new java.awt.Color(98, 155, 88));
        btnAtualizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_confirm.fw.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(183, 70, 53));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_cancel.fw.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAtualizar)
                        .addGap(270, 270, 270)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNome)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja Atualizar o Tipo de Recurso?") == 0){
            tiporecurso.setNome(txtNome.getText());
            tiporecurso.setDescricao(txtDescricao.getText());
            
            if (tiporecursodao.Salvar(tiporecurso)){
                JOptionPane.showMessageDialog(RootPane, "Tipo de Recurso Atualizado com Sucesso!");
            }
            
        } else {
            
            JOptionPane.showMessageDialog(RootPane, "Atualização Cancelada!");
        
        }

    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja Cancelar o Cadastro?") == 0){
            this.dispose();
        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
