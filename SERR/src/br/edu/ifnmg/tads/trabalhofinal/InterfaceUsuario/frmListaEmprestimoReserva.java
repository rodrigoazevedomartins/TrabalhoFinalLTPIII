/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.InterfaceUsuario;

import br.edu.ifnmg.tads.trabalhofinal.DataAccess.EmprestimoReservaDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.FuncionarioDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.OperacaoDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.PessoaDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.ProfessorDAO;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.EmprestimoReserva;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Funcionario;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Operacao;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Pessoa;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Professor;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo
 */
public class frmListaEmprestimoReserva extends javax.swing.JInternalFrame {
    
    private List<EmprestimoReserva> emprestimosreservas;
    private EmprestimoReservaDAO emprestimoreservadao;
    private List<Operacao> operacoes;
    private OperacaoDAO operacaodao;
    private PessoaDAO pessoadao;
    private Pessoa pessoa;
    
    /**
     * Creates new form frmListarReserva
     */
    public frmListaEmprestimoReserva() {
        initComponents();
        operacaodao = new OperacaoDAO();
        operacoes = operacaodao.ListarTodos();
        emprestimoreservadao = new EmprestimoReservaDAO();
        emprestimosreservas = emprestimoreservadao.ListarTodos();
        pessoadao = new PessoaDAO();
        
        preenchetabela(emprestimosreservas);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFiltro = new javax.swing.JTextField();
        cbxfiltro = new javax.swing.JComboBox();
        btnBuscarRecursos = new javax.swing.JButton();
        btnAlterarRecursos = new javax.swing.JButton();
        btnRemoverRecursos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaRecursos = new javax.swing.JTable();
        cbxfiltro_secundario = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Listar Reservas");

        cbxfiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Nome", "Operação" }));
        cbxfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxfiltroActionPerformed(evt);
            }
        });

        btnBuscarRecursos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarRecursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_busca.fw.png"))); // NOI18N
        btnBuscarRecursos.setText("  Buscar");
        btnBuscarRecursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRecursosActionPerformed(evt);
            }
        });

        btnAlterarRecursos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAlterarRecursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_editar.fw.png"))); // NOI18N
        btnAlterarRecursos.setText("  Alterar");
        btnAlterarRecursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarRecursosActionPerformed(evt);
            }
        });

        btnRemoverRecursos.setBackground(new java.awt.Color(98, 155, 88));
        btnRemoverRecursos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRemoverRecursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_remove.fw.png"))); // NOI18N
        btnRemoverRecursos.setText("  Remover ");
        btnRemoverRecursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverRecursosActionPerformed(evt);
            }
        });

        tblListaRecursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblListaRecursos);

        cbxfiltro_secundario.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxfiltro_secundario, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAlterarRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBuscarRecursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoverRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxfiltro_secundario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscarRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btnAlterarRecursos)
                        .addGap(51, 51, 51)
                        .addComponent(btnRemoverRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void preenchetabela(List<EmprestimoReserva> esrs){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nome do Requisitante");
        model.addColumn("Operação");
        for (EmprestimoReserva em : esrs){
            Vector v = new Vector();
            pessoa = new Pessoa();
            pessoa = pessoadao.Abrir(em.getPessoa().getCodpessoa());
            em.setPessoa(pessoa);          
            v.add(0, em);
            v.add(1, em.getPessoa().getNome());
            if (em.getOperacao().getCodoperacao() == 1){
                v.add(2, "Empréstimo");
            } else {
                v.add(2, "Reserva");
            }
            
            model.addRow(v);
        }
        
        tblListaRecursos.setModel(model);
    }
    
    private void cbxfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxfiltroActionPerformed
        // TODO add your handling code here:
        if (cbxfiltro.getSelectedIndex() == 2){
            cbxfiltro_secundario.setEnabled(true);
            txtFiltro.setEnabled(false);
            cbxfiltro_secundario.removeAllItems();
            
            for (Operacao op : operacoes){
                cbxfiltro_secundario.addItem(op);
            }
        } else {
            cbxfiltro_secundario.setEnabled(false);
            txtFiltro.setEnabled(true);
        }
    }//GEN-LAST:event_cbxfiltroActionPerformed

    private void btnBuscarRecursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRecursosActionPerformed
        // TODO add your handling code here:
        EmprestimoReserva er = new EmprestimoReserva();
        
        if (cbxfiltro.getSelectedIndex() == 0){
            er.setCodemprestimoreserva(Integer.parseInt(txtFiltro.getText()));
        }
        
        if (cbxfiltro.getSelectedIndex() == 1){
            pessoa = new Pessoa();
            pessoa.setNome(txtFiltro.getText());
            er.setPessoa(pessoa);
        }
        
        if (cbxfiltro.getSelectedIndex() == 2){
            Operacao op = new Operacao();
            op = (Operacao) cbxfiltro_secundario.getSelectedItem();
            er.setOperacao(op);
        }
        
        List<Pessoa> pessoas = pessoadao.BuscarPessoa(pessoa);
        List<EmprestimoReserva> esrs = emprestimoreservadao.BuscarEmprestimoReserva(er);
        
        emprestimosreservas = new LinkedList<>();
        
        for (EmprestimoReserva emr : esrs){
            for (Pessoa pe : pessoas){
                if (emr.getPessoa().getCodpessoa() == pe.getCodpessoa()){
                    emr.setPessoa(pe);
                    emprestimosreservas.add(emr);
                }
            }
        }
        
        preenchetabela(emprestimosreservas);
        
    }//GEN-LAST:event_btnBuscarRecursosActionPerformed

    private void btnAlterarRecursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarRecursosActionPerformed
        // TODO add your handling code here:
        /*if (tblListaRecursos.getSelectedRow() >= 0){
            Recurso recurso = (Recurso) tblListaRecursos.getValueAt(tblListaRecursos.getSelectedRow(), 1);
            frmEditarRecurso janela = new frmEditarRecurso(recurso.getCodrecurso());
            this.getParent().add(janela);
            janela.setVisible(true);
            this.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um Recurso por favor!");
        }*/
    }//GEN-LAST:event_btnAlterarRecursosActionPerformed

    private void btnRemoverRecursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverRecursosActionPerformed
        // TODO add your handling code here:
        /*if (tblListaRecursos.getSelectedRow() >= 0){
            recursos = recursodao.ListarTodos();
            Recurso recurso = (Recurso) tblListaRecursos.getValueAt(tblListaRecursos.getSelectedRow(), 1);
            if(recursodao.Apagar(recurso.getCodrecurso())){
                recursos.remove(recurso);
                JOptionPane.showMessageDialog(rootPane, "Recurso removido com Sucesso!");
            }
            preenchetabela(recursos);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um Recurso por favor!");
        }*/
    }//GEN-LAST:event_btnRemoverRecursosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarRecursos;
    private javax.swing.JButton btnBuscarRecursos;
    private javax.swing.JButton btnRemoverRecursos;
    private javax.swing.JComboBox cbxfiltro;
    private javax.swing.JComboBox cbxfiltro_secundario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaRecursos;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}