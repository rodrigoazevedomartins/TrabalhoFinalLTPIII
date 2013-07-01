/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Disciplina;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Professor;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.ProfessorDisciplinas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maike Jordan
 */
public class ProfessorDisciplinaDAO {

    private BD bd;

    public ProfessorDisciplinaDAO() {
        bd = new BD();
    }

    public boolean Salvar(ProfessorDisciplinas pd) {

        try {
            if (pd.getCodprofessordisciplina() == 0){
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into professor_disciplinas(codprofessor, coddisciplina, ativo) values (?,?,?)");
                comando.setInt(1, pd.getProfessor().getCodprofessor());
                comando.setInt(2, pd.getDisciplina().getCoddisciplina());
                comando.setInt(3, 1);
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<ProfessorDisciplinas> ListarTodas(int cod){
        List<ProfessorDisciplinas> pds = new LinkedList<>();
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from professor_disciplinas where codprofessor = ? and ativo = 1");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                ProfessorDisciplinas pd = new ProfessorDisciplinas();
                Professor professor = new Professor();
                Disciplina disciplina = new Disciplina();
                pd.setCodprofessordisciplina(resultado.getInt("codprofessor_disciplina"));
                professor.setCodprofessor(resultado.getInt("codprofessor"));
                disciplina.setCoddisciplina(resultado.getInt("coddisciplina"));
                pd.setProfessor(professor);
                pd.setDisciplina(disciplina);
                pds.add(pd);
            }
            return pds;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean Apagar(ProfessorDisciplinas pd){
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("update professor_disciplinas set ativo = 0 where codprofessor_disciplina = ?");
            comando.setInt(1, pd.getCodprofessordisciplina());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
