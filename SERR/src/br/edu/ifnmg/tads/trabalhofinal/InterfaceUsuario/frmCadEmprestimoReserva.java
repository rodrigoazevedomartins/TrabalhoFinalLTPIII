/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.InterfaceUsuario;

import br.edu.ifnmg.tads.trabalhofinal.DataAccess.EmprestimoReservaDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.EmprestimoReservaRecursoDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.FuncionarioDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.MedidaTempoDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.OperacaoDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.PessoaDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.ProfessorDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.RecursoDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.SecaoDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.TiporecursoDAO;
import br.edu.ifnmg.tads.trabalhofinal.DataAccess.UsuarioDAO;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.EmprestimoReserva;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.EmprestimoReservaRecurso;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Funcionario;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.MedidaTempo;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Operacao;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Pessoa;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Professor;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Recurso;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Secao;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.TipoRecurso;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Usuario;
import java.awt.Component;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.DateTimeSyntax;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo
 */
public class frmCadEmprestimoReserva extends javax.swing.JInternalFrame {
    private  Component RootPane;
    private FuncionarioDAO funcionariodao;
    private ProfessorDAO professordao;
    private PessoaDAO pessoadao;
    private EmprestimoReservaRecursoDAO emprestimoreservarecursodao;
    private EmprestimoReservaDAO emprestimoreservadao;
    private List<Funcionario> funcionarios;
    private Pessoa pessoa;
    private List<Professor> professores;
    private EmprestimoReserva emprestimoreserva;
    private List<EmprestimoReservaRecurso> emprestimoreservarecurso; 
    private SecaoDAO secaodao;
    private OperacaoDAO operacaodao;
    private List<Operacao> operacoes;
    private RecursoDAO recursodao;
    private List<Recurso> recursos;
    private List<TipoRecurso> tiposrecurso;
    private TiporecursoDAO tiporecursodao;
    private Secao secao;
    private MedidaTempo medidatempo;
    private MedidaTempoDAO medidatempodao;
    /**
     * Creates new form frmCadReserva
     */
    public frmCadEmprestimoReserva(int cod) {
        initComponents();
        secao = new Secao();
        tiporecursodao = new TiporecursoDAO();
        operacaodao = new OperacaoDAO();
        funcionariodao = new FuncionarioDAO();
        pessoadao = new PessoaDAO();
        professordao = new ProfessorDAO();
        emprestimoreservarecursodao = new EmprestimoReservaRecursoDAO();
        emprestimoreservadao = new EmprestimoReservaDAO();
        secaodao = new SecaoDAO();
        secao.setCodsecao(secaodao.BuscarSecao(cod));
        recursodao = new RecursoDAO();
        operacoes = operacaodao.ListarTodos();
        professores = professordao.ListarTodos();
        funcionarios = funcionariodao.ListarTodos();
        emprestimoreserva = new EmprestimoReserva();
        tiposrecurso = tiporecursodao.ListarTodos();
        emprestimoreservarecurso = new LinkedList<>();
        medidatempodao = new MedidaTempoDAO();
               
        for (Professor professor : professores){
            pessoa = pessoadao.Abrir(professor.getCodpessoa());
            professor.setPessoa(pessoa);
            cbxRequisitante.addItem(professor);
        }
        
        for (Operacao operacao : operacoes){
            cbxOperacao.addItem(operacao);
        }
        
        Operacao operacao = (Operacao) cbxOperacao.getItemAt(0);
        if (operacao.getCodoperacao() == 1){
            ftxtDataEmpr.setEnabled(false);
        } else {
            ftxtDataEmpr.setEnabled(true);
        }
        
        for (TipoRecurso tipo : tiposrecurso){
            cbxTipoRecurso.addItem(tipo);
        }
        
        Recurso recurso = new Recurso();
        recurso.setTiporecurso((TipoRecurso) cbxTipoRecurso.getSelectedItem());
        
        recursos = recursodao.BuscarRecurso(recurso);
        
        cbxRecursos.removeAllItems();
        for (Recurso rec : recursos){
            medidatempo = new MedidaTempo();
            medidatempo = medidatempodao.Abrir(rec.getMedidatempo().getCodtempomaximo());
            rec.setMedidatempo(medidatempo);
            cbxRecursos.addItem(rec);
            
        }
        
        recurso = new Recurso();
        
        recurso = (Recurso) cbxRecursos.getItemAt(0);
        
        lblDescr.setText(recurso.getDescricao());
        lblNum.setText(Integer.toString(recurso.getNum_patrimonio()));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jpTablePainel = new javax.swing.JTabbedPane();
        jpDadosGerais = new javax.swing.JPanel();
        cbxOperacao = new javax.swing.JComboBox();
        lblOperacao = new javax.swing.JLabel();
        lblRequisitante = new javax.swing.JLabel();
        cbxRequisitante = new javax.swing.JComboBox();
        lblTipoRequisitante = new javax.swing.JLabel();
        cbxTipoRequisitante = new javax.swing.JComboBox();
        lblDataReserva = new javax.swing.JLabel();
        ftxtDataEmpr = new javax.swing.JFormattedTextField();
        jpRecursos = new javax.swing.JPanel();
        btnAdicionarRecurso = new javax.swing.JButton();
        btnRemoverRecurso = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecursos = new javax.swing.JTable();
        cbxRecursos = new javax.swing.JComboBox();
        lblRecursosAdicionados = new javax.swing.JLabel();
        lblRecursos = new javax.swing.JLabel();
        lblTiposRecurso = new javax.swing.JLabel();
        cbxTipoRecurso = new javax.swing.JComboBox();
        lblDescrRec = new javax.swing.JLabel();
        lblNumPatr = new javax.swing.JLabel();
        lblDescr = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setClosable(true);
        setTitle("Cadastrar Empréstimo ou Reserva");

        cbxOperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOperacaoActionPerformed(evt);
            }
        });

        lblOperacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblOperacao.setText("OPERAÇÃO:");

        lblRequisitante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRequisitante.setText("REQUISITANTE:");

        lblTipoRequisitante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTipoRequisitante.setText("TIPO REQUISITANTE:");

        cbxTipoRequisitante.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Professor", "Funcionário" }));
        cbxTipoRequisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoRequisitanteActionPerformed(evt);
            }
        });

        lblDataReserva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDataReserva.setText("DATA PARA RESERVA:");
        lblDataReserva.setEnabled(false);

        try {
            ftxtDataEmpr.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftxtDataEmpr.setEnabled(false);

        javax.swing.GroupLayout jpDadosGeraisLayout = new javax.swing.GroupLayout(jpDadosGerais);
        jpDadosGerais.setLayout(jpDadosGeraisLayout);
        jpDadosGeraisLayout.setHorizontalGroup(
            jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosGeraisLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosGeraisLayout.createSequentialGroup()
                        .addComponent(lblOperacao)
                        .addGap(18, 18, 18)
                        .addComponent(cbxOperacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDadosGeraisLayout.createSequentialGroup()
                        .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDadosGeraisLayout.createSequentialGroup()
                                .addComponent(lblTipoRequisitante)
                                .addGap(18, 18, 18)
                                .addComponent(cbxTipoRequisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpDadosGeraisLayout.createSequentialGroup()
                                .addComponent(lblDataReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ftxtDataEmpr, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(lblRequisitante)
                        .addGap(32, 32, 32)
                        .addComponent(cbxRequisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jpDadosGeraisLayout.setVerticalGroup(
            jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosGeraisLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTipoRequisitante, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(cbxTipoRequisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblRequisitante, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(cbxRequisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(ftxtDataEmpr, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );

        jpTablePainel.addTab("Dados Gerais", jpDadosGerais);

        btnAdicionarRecurso.setBackground(new java.awt.Color(98, 155, 88));
        btnAdicionarRecurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdicionarRecurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_add.fw.png"))); // NOI18N
        btnAdicionarRecurso.setText("  Adicionar");
        btnAdicionarRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarRecursoActionPerformed(evt);
            }
        });

        btnRemoverRecurso.setBackground(new java.awt.Color(98, 155, 88));
        btnRemoverRecurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRemoverRecurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_remove.fw.png"))); // NOI18N
        btnRemoverRecurso.setText("  Remover");
        btnRemoverRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverRecursoActionPerformed(evt);
            }
        });

        tblRecursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRecursos);

        lblRecursosAdicionados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRecursosAdicionados.setText("Recursos Adicionados ");

        lblRecursos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRecursos.setText("RECURSOS: ");

        lblTiposRecurso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTiposRecurso.setText("TIPOS DE RECURSO:");

        cbxTipoRecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoRecursoActionPerformed(evt);
            }
        });

        lblDescrRec.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescrRec.setText("DESCRIÇÃO DO RECURSO:");

        lblNumPatr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNumPatr.setText("NÚMERO DO PATRIMÔNIO:");

        lblDescr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jpRecursosLayout = new javax.swing.GroupLayout(jpRecursos);
        jpRecursos.setLayout(jpRecursosLayout);
        jpRecursosLayout.setHorizontalGroup(
            jpRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecursosLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jpRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpRecursosLayout.createSequentialGroup()
                        .addComponent(lblDescrRec)
                        .addGap(18, 18, 18)
                        .addComponent(lblDescr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRecursosLayout.createSequentialGroup()
                        .addComponent(lblTiposRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxTipoRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpRecursosLayout.createSequentialGroup()
                        .addComponent(lblNumPatr)
                        .addGap(18, 18, 18)
                        .addComponent(lblNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpRecursosLayout.createSequentialGroup()
                        .addGroup(jpRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdicionarRecurso)
                            .addComponent(lblRecursosAdicionados, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(172, 172, 172)
                        .addComponent(btnRemoverRecurso)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jpRecursosLayout.setVerticalGroup(
            jpRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRecursosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jpRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTipoRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTiposRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescrRec, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(lblDescr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNumPatr, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpRecursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemoverRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarRecurso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRecursosAdicionados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpTablePainel.addTab("Recursos", jpRecursos);

        btnCadastrar.setBackground(new java.awt.Color(98, 155, 88));
        btnCadastrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon_confirm.fw.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jpTablePainel, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnCadastrar)
                        .addGap(186, 186, 186)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpTablePainel, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static Date formataData(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }

        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            date = (java.util.Date) formatter.parse(data);
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }
       
    private void adicionarecursotable(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Recurso");
        model.addColumn("Descrição");
        model.addColumn("Número do Patrimônio");
        for (Recurso recurso : emprestimoreserva.getRecursos()){
            Vector v = new Vector();
            v.add(recurso);
            v.add(recurso.getDescricao());
            v.add(recurso.getNum_patrimonio());
            model.addRow(v);
        }
        
        tblRecursos.setModel(model);
        
    }
    
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
       if (JOptionPane.showConfirmDialog(rootPane, "Deseja Cadastrar o Recurso?") == 0){
           if (cbxTipoRequisitante.getSelectedIndex() == 0){
               Professor professor = (Professor) cbxRequisitante.getSelectedItem();
               emprestimoreserva.setPessoa(professor.getPessoa());
           } else {
               Funcionario funcionario = (Funcionario) cbxRequisitante.getSelectedItem();
               emprestimoreserva.setPessoa(funcionario.getPessoa());
           }
           
           emprestimoreserva.setOperacao((Operacao) cbxOperacao.getSelectedItem());
           if (emprestimoreserva.getOperacao().getCodoperacao() == 2){
               
               Date datareserva = null;
               try {
                   datareserva = formataData(ftxtDataEmpr.getText());
                   emprestimoreserva.setDataprevemprestimo(datareserva);
               } catch (Exception ex) {
                   Logger.getLogger(frmCadEmprestimoReserva.class.getName()).log(Level.SEVERE, null, ex);
               }             
           }
           
           emprestimoreserva.setSecao(secao);
           
           emprestimoreservadao.Salvar(emprestimoreserva);
           
           emprestimoreserva.setCodemprestimoreserva(emprestimoreservadao.Consultacodemprestimoreserva());
           
           emprestimoreserva = emprestimoreservadao.Abrir(emprestimoreserva.getCodemprestimoreserva());
                     
           for (EmprestimoReservaRecurso err : emprestimoreservarecurso){
               err.setEmprestimoreserva(emprestimoreserva);
               if (emprestimoreserva.getOperacao().getCodoperacao() == 1){
                 Calendar c = new GregorianCalendar(2013, emprestimoreserva.getDataemprestimo().getMonth(),
                 emprestimoreserva.getDataemprestimo().getDay(), emprestimoreserva.getDataemprestimo().getHours(), emprestimoreserva.getDataemprestimo().getMinutes(), 
                 emprestimoreserva.getDataemprestimo().getSeconds());
                if (err.getRecurso().getMedidatempo().getCodtempomaximo() == 1){                
                   c.add(c.MINUTE, err.getRecurso().getTempo());
                   err.setDataprevdevolucao(c.getTime());
                                     
                }
                
                if (err.getRecurso().getMedidatempo().getCodtempomaximo() == 2){
                    c.add(c.HOUR, err.getRecurso().getTempo());
                    err.setDataprevdevolucao(c.getTime());
                }
                
                if (err.getRecurso().getMedidatempo().getCodtempomaximo() == 3){
                    c.add(c.DAY_OF_MONTH, err.getRecurso().getTempo());
                    err.setDataprevdevolucao(c.getTime());
                }
                
                if (err.getRecurso().getMedidatempo().getCodtempomaximo() == 4){
                    c.add(c.WEEK_OF_MONTH, err.getRecurso().getTempo());
                    err.setDataprevdevolucao(c.getTime());
                }               
               }
               
               emprestimoreservarecursodao.Salvar(err);
           }
           
           if (emprestimoreserva.getOperacao().getCodoperacao() == 1){
                JOptionPane.showMessageDialog(rootPane, "Empréstimo realizado com sucesso!");
           } else {
               JOptionPane.showMessageDialog(rootPane, "Reserva realizada com sucesso!");
           }
           
           this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Cadastro Cancelado!");
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
       if (JOptionPane.showConfirmDialog(rootPane, "Deseja Cancelar o Cadastro?") == 0){
            JOptionPane.showMessageDialog(rootPane, "Cadastro Cancelado!");
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAdicionarRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarRecursoActionPerformed
        // TODO add your handling code here:
       if (JOptionPane.showConfirmDialog(RootPane, "Deseja adicionar recurso?") == 0){
            EmprestimoReservaRecurso err = new EmprestimoReservaRecurso();
            Recurso recurso = new Recurso();
            recurso = (Recurso) cbxRecursos.getSelectedItem();
            if (emprestimoreserva.getRecursos().contains(recurso)){
                JOptionPane.showMessageDialog(RootPane, "Recurso já adicionado!");
            } else {
                err.setRecurso(recurso);
                err.setEmprestimoreserva(emprestimoreserva);
                emprestimoreservarecurso.add(err);
                emprestimoreserva.addRecursos(recurso);
                JOptionPane.showMessageDialog(RootPane, "Recurso adicionado com sucesso!");
                adicionarecursotable();
            }
            
        } else {
           JOptionPane.showMessageDialog(RootPane, "Recurso não adicionado!");
       }
    }//GEN-LAST:event_btnAdicionarRecursoActionPerformed

    private void btnRemoverRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverRecursoActionPerformed
        // TODO add your handling code here:

       if (tblRecursos.getSelectedRow() >= 0){
            if (JOptionPane.showConfirmDialog(RootPane, "Deseja remover esse recurso?") == 0){
                Recurso recurso = new Recurso();
                recurso = (Recurso) cbxRecursos.getSelectedItem();
                emprestimoreserva.removeRecursos(recurso);
                JOptionPane.showMessageDialog(RootPane, "Recurso removido com sucesso!");
                adicionarecursotable();
            } else {
                JOptionPane.showMessageDialog(RootPane, "Recurso não removido!");
            }
        } else {
            JOptionPane.showMessageDialog(RootPane, "Selecione um recurso por favor!");
        }
    }//GEN-LAST:event_btnRemoverRecursoActionPerformed

    private void cbxTipoRequisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoRequisitanteActionPerformed
        // TODO add your handling code here:
        if (cbxTipoRequisitante.getSelectedIndex() == 0){
            cbxRequisitante.removeAllItems();
            for (Professor professor : professores){
                pessoa = pessoadao.Abrir(professor.getCodpessoa());
                professor.setPessoa(pessoa);
                cbxRequisitante.addItem(professor);
            }
        } else {
            cbxRequisitante.removeAllItems();
            for (Funcionario funcionario : funcionarios){
                pessoa = pessoadao.Abrir(funcionario.getCodpessoa());
                funcionario.setPessoa(pessoa);
                cbxRequisitante.addItem(funcionario);
            }
        }
    }//GEN-LAST:event_cbxTipoRequisitanteActionPerformed

    private void cbxTipoRecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoRecursoActionPerformed
        // TODO add your handling code here:
        TipoRecurso tiporecurso = new TipoRecurso();
        Recurso recurso = new Recurso();
        tiporecurso = (TipoRecurso) cbxTipoRecurso.getSelectedItem();
        recurso.setTiporecurso(tiporecurso);
        recursos = new LinkedList<>();
        recursos = recursodao.BuscarRecurso(recurso);
        
        cbxRecursos.removeAllItems();
        for (Recurso rec : recursos){
            medidatempo = new MedidaTempo();
            medidatempo = medidatempodao.Abrir(rec.getMedidatempo().getCodtempomaximo());
            rec.setMedidatempo(medidatempo);
            cbxRecursos.addItem(rec);
        }
        
        recurso = new Recurso();
        
        recurso = (Recurso) cbxRecursos.getItemAt(0);
        
        lblDescr.setText(recurso.getDescricao());
        lblNum.setText(Integer.toString(recurso.getNum_patrimonio()));
        
        
    }//GEN-LAST:event_cbxTipoRecursoActionPerformed

    private void cbxOperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOperacaoActionPerformed
        // TODO add your handling code here:
        Operacao operacao = (Operacao) cbxOperacao.getSelectedItem();
        if (operacao.getCodoperacao() == 1){
            ftxtDataEmpr.setEnabled(false);
        } else {
            ftxtDataEmpr.setEnabled(true);
        }
    }//GEN-LAST:event_cbxOperacaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarRecurso;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemoverRecurso;
    private javax.swing.JComboBox cbxOperacao;
    private javax.swing.JComboBox cbxRecursos;
    private javax.swing.JComboBox cbxRequisitante;
    private javax.swing.JComboBox cbxTipoRecurso;
    private javax.swing.JComboBox cbxTipoRequisitante;
    private javax.swing.JFormattedTextField ftxtDataEmpr;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpDadosGerais;
    private javax.swing.JPanel jpRecursos;
    private javax.swing.JTabbedPane jpTablePainel;
    private javax.swing.JLabel lblDataReserva;
    private javax.swing.JLabel lblDescr;
    private javax.swing.JLabel lblDescrRec;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblNumPatr;
    private javax.swing.JLabel lblOperacao;
    private javax.swing.JLabel lblRecursos;
    private javax.swing.JLabel lblRecursosAdicionados;
    private javax.swing.JLabel lblRequisitante;
    private javax.swing.JLabel lblTipoRequisitante;
    private javax.swing.JLabel lblTiposRecurso;
    private javax.swing.JTable tblRecursos;
    // End of variables declaration//GEN-END:variables
}
