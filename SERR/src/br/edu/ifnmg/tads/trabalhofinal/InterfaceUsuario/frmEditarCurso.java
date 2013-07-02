/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.InterfaceUsuario;

import br.edu.ifnmg.tads.trabalhofinal.DataAccess.CursoDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.DisciplinaDAO;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Curso;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Disciplina;
import java.awt.Component;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo
 */
public class frmEditarCurso extends javax.swing.JInternalFrame {
    
    private Curso curso;
    private Disciplina disciplina;
    private CursoDAO cursodao;
    private DisciplinaDAO disciplinadao;
    private Component RootPane;
    
    /**
     * Creates new form frmEditarCurso
     */
    public frmEditarCurso(int cod) {
        initComponents();
        
        cursodao = new CursoDAO();
        disciplinadao = new DisciplinaDAO();
        curso = cursodao.Abrir(cod);
        
        for (Disciplina disciplina : disciplinadao.ListarDisciplina(cod)){
            curso.addDisciplina(disciplina);
        }
        
        adicionadisciplinatable();
        
        txtNome.setText(curso.getNome());
        txtQtd.setText(Integer.toString(curso.getDuracao()));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneCurso = new javax.swing.JTabbedPane();
        paneDadosGerais = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblQtdeSemestre = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtQtd = new javax.swing.JTextField();
        paneDisciplinas = new javax.swing.JPanel();
        txtNomeDisc = new javax.swing.JTextField();
        lblNomeDisc = new javax.swing.JLabel();
        lblEmenta = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDisciplinas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEmenta = new javax.swing.JTextArea();
        btnLimparCampos = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Editar Curso");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setText("Nome:");

        lblQtdeSemestre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQtdeSemestre.setText("Quantidade de Semestres:");

        javax.swing.GroupLayout paneDadosGeraisLayout = new javax.swing.GroupLayout(paneDadosGerais);
        paneDadosGerais.setLayout(paneDadosGeraisLayout);
        paneDadosGeraisLayout.setHorizontalGroup(
            paneDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDadosGeraisLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(paneDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(paneDadosGeraisLayout.createSequentialGroup()
                        .addComponent(lblQtdeSemestre)
                        .addGap(18, 18, 18)
                        .addComponent(txtQtd))
                    .addGroup(paneDadosGeraisLayout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(433, Short.MAX_VALUE))
        );
        paneDadosGeraisLayout.setVerticalGroup(
            paneDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDadosGeraisLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(paneDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(paneDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQtdeSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(281, Short.MAX_VALUE))
        );

        paneCurso.addTab("Dados Gerais", paneDadosGerais);

        lblNomeDisc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNomeDisc.setText("Nome:");

        lblEmenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmenta.setText("Ementa:");

        btnAdicionar.setBackground(new java.awt.Color(98, 155, 88));
        btnAdicionar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_add.fw.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(98, 155, 88));
        btnRemove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_remove.fw.png"))); // NOI18N
        btnRemove.setText("Remover");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        tblDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDisciplinasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDisciplinas);

        txtEmenta.setColumns(20);
        txtEmenta.setRows(5);
        jScrollPane2.setViewportView(txtEmenta);

        btnLimparCampos.setBackground(new java.awt.Color(183, 70, 53));
        btnLimparCampos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_cancel.fw.png"))); // NOI18N
        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paneDisciplinasLayout = new javax.swing.GroupLayout(paneDisciplinas);
        paneDisciplinas.setLayout(paneDisciplinasLayout);
        paneDisciplinasLayout.setHorizontalGroup(
            paneDisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDisciplinasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneDisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneDisciplinasLayout.createSequentialGroup()
                        .addGroup(paneDisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
                            .addGroup(paneDisciplinasLayout.createSequentialGroup()
                                .addGroup(paneDisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNomeDisc)
                                    .addComponent(lblEmenta))
                                .addGap(33, 33, 33)
                                .addGroup(paneDisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addComponent(txtNomeDisc))))
                        .addContainerGap())
                    .addGroup(paneDisciplinasLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126)
                        .addComponent(btnLimparCampos)
                        .addGap(44, 44, 44))))
        );
        paneDisciplinasLayout.setVerticalGroup(
            paneDisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDisciplinasLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(paneDisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeDisc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeDisc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneDisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(paneDisciplinasLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lblEmenta, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(paneDisciplinasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparCampos, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        paneCurso.addTab("Cadastro de Disciplinas", paneDisciplinas);

        btnAtualizar.setBackground(new java.awt.Color(98, 155, 88));
        btnAtualizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_confirm.fw.png"))); // NOI18N
        btnAtualizar.setText(" Atualizar");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualizar)
                .addGap(169, 169, 169)
                .addComponent(btnCancelar)
                .addGap(244, 244, 244))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 883, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void adicionadisciplinatable() {

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nome");
        model.addColumn("Ementa");
        for (Disciplina d : curso.getDisciplinas()) {
            Vector v = new Vector();
            v.add(d.getCoddisciplina());
            v.add(d);
            v.add(d.getEmenta());
            model.addRow(v);
        }
        tblDisciplinas.setModel(model);
    }

    private void LimpaCampos() {
        
        adicionadisciplinatable();
        txtNomeDisc.setText("");
        txtEmenta.setText("");

    }
    
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(RootPane, "Deseja adicionar Disciplina?") == 0) {
            int cod = 0;
            if (tblDisciplinas.getSelectedRow() >= 0){
                Disciplina disciplinaant = (Disciplina) tblDisciplinas.getValueAt(tblDisciplinas.getSelectedRow(), 1);
                cod = disciplinaant.getCoddisciplina();
                if (curso.getDisciplinas().contains(disciplinaant)){
                    curso.removeDisciplina(disciplinaant);
                }
            }
            
            
            disciplina = new Disciplina();
            if (cod > 0){
                disciplina.setCoddisciplina(cod);
            }
            disciplina.setNome(txtNomeDisc.getText());
            disciplina.setEmenta(txtEmenta.getText());
            disciplina.setCurso(curso);
            if (curso.getDisciplinas().contains(disciplina)) {
                JOptionPane.showMessageDialog(RootPane, "Disciplina já adicionado!");
            } else {
                curso.addDisciplina(disciplina);
                adicionadisciplinatable();
                LimpaCampos();
                if (disciplina.getCoddisciplina() == 0){
                    JOptionPane.showMessageDialog(RootPane, "Disciplina adicionada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(RootPane, "Disciplina atualizada com sucesso!");
                }
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        if(tblDisciplinas.getSelectedRow() >= 0) {
            if (JOptionPane.showConfirmDialog(RootPane, "Deseja remover esta Disciplina?") == 0){
                Disciplina disciplinaselect = (Disciplina) tblDisciplinas.getValueAt(tblDisciplinas.getSelectedRow(), 0);
                if(curso.getDisciplinas().contains(disciplinaselect)){
                    curso.removeDisciplina(disciplinaselect);
                }
                JOptionPane.showMessageDialog(RootPane, "Disciplina removida com sucesso!");
                adicionadisciplinatable();
                LimpaCampos();
            } else {
                JOptionPane.showMessageDialog(RootPane, "Selecione um email por favor!");
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        // TODO add your handling code here:
        LimpaCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(RootPane, "Deseja atualizar o Curso?") == 0) {
            try {
                curso.setNome(txtNome.getText());
                curso.setDuracao(Integer.parseInt(txtQtd.getText()));
            }catch (Exception ex) {
                Logger.getLogger(frmCadCurso.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(cursodao.Salvar(curso)){
                for(Disciplina d : curso.getDisciplinas()){
                    disciplina = new Disciplina(d.getCoddisciplina(), d.getNome(), d.getEmenta(), curso);
                    disciplinadao.Salvar(disciplina);
                }
            }
            cursodao.Salvar(curso);
            JOptionPane.showMessageDialog(RootPane, "Curso Atualizado com Sucesso!");
            this.dispose();
        } else {
             JOptionPane.showMessageDialog(RootPane, "Atualização cancelada!");
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void tblDisciplinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDisciplinasMouseClicked
        // TODO add your handling code here:
        Disciplina disciplina = (Disciplina) tblDisciplinas.getValueAt(tblDisciplinas.getSelectedRow(), 1);
        
        txtNomeDisc.setText(disciplina.getNome());
        txtEmenta.setText(disciplina.getEmenta());
    }//GEN-LAST:event_tblDisciplinasMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(RootPane, "Deseja cancelar a atualização do Curso?") == 0) {
            JOptionPane.showMessageDialog(RootPane, "Atualização cancelada!");
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEmenta;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeDisc;
    private javax.swing.JLabel lblQtdeSemestre;
    private javax.swing.JTabbedPane paneCurso;
    private javax.swing.JPanel paneDadosGerais;
    private javax.swing.JPanel paneDisciplinas;
    private javax.swing.JTable tblDisciplinas;
    private javax.swing.JTextArea txtEmenta;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeDisc;
    private javax.swing.JTextField txtQtd;
    // End of variables declaration//GEN-END:variables
}