/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.InterfaceUsuario;

import br.edu.ifnmg.tads.trabalhofinal.DataAccess.FuncionarioDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.PessoaDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.SecaoDAO;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Usuario;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.UsuarioDAO;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Funcionario;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Pessoa;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Secao;
/**
 *
 * @author Rodrigo
 */
public class frmPrincipal extends javax.swing.JFrame {
    UsuarioDAO usuariodao = new UsuarioDAO();
    FuncionarioDAO funcionariodao = new FuncionarioDAO();
    PessoaDAO pessoadao = new PessoaDAO();
    Usuario usuario = new Usuario();
    Pessoa pessoa = new Pessoa();
    Funcionario funcionario = new Funcionario();
    SecaoDAO secaodao = new SecaoDAO();
    Secao secao = new Secao();
    
    
    /**
     * Creates new form frmPrincipal
     */
    public frmPrincipal(int codusuario) {
        initComponents();
        
        secao.setCodsecao(secaodao.BuscarSecao(codusuario));
        usuario = usuariodao.Abrir(codusuario);
        funcionario = funcionariodao.Abrir(usuario.getCodfuncionario());
        pessoa = pessoadao.Abrir(funcionario.getCodpessoa());
        jLabel1.setText(pessoa.getNome());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuProfessores = new javax.swing.JMenu();
        MenuListaProfessores = new javax.swing.JMenuItem();
        MenuCadProfessor = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(20, 20));

        jLabel1.setText("jLabel1");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenuBar1.setMinimumSize(new java.awt.Dimension(98, 32769));

        MenuProfessores.setText("Professores");

        MenuListaProfessores.setText("Listar Professores");
        MenuListaProfessores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListaProfessoresActionPerformed(evt);
            }
        });
        MenuProfessores.add(MenuListaProfessores);

        MenuCadProfessor.setText("Cadastrar Professor");
        MenuCadProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadProfessorActionPerformed(evt);
            }
        });
        MenuProfessores.add(MenuCadProfessor);

        jMenuBar1.add(MenuProfessores);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(659, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(140, 140, 140))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addContainerGap(320, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        secaodao.Salvar(secao);
        frmLogin janela = new frmLogin();
        janela.setVisible(true);
        this.setVisible(false);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void MenuListaProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListaProfessoresActionPerformed
        // TODO add your handling code here:
        frmListaProfessor janela = new frmListaProfessor();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_MenuListaProfessoresActionPerformed

    private void MenuCadProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadProfessorActionPerformed
        // TODO add your handling code here:
        frmCadProfessor janela = new frmCadProfessor();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_MenuCadProfessorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuCadProfessor;
    private javax.swing.JMenuItem MenuListaProfessores;
    private javax.swing.JMenu MenuProfessores;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
