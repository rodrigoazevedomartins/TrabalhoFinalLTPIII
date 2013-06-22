/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo
 */
public class ProfessorDAO {
    private BD bd;
    
    public ProfessorDAO(){
        bd = new BD();
    }
    
    
    public boolean Salvar(Professor professor){
        try {
            
            if (professor.getCodprofessor() == 0){
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into professores (titulacao, nivel, ativo, codpessoa) values (?, ?, ?, ?)");
                comando.setString(1, professor.getTitulacao());
                comando.setInt(2, professor.getNivel());
                comando.setInt(3, 1);
                comando.setInt(4, professor.getPessoa().getCodpessoa());
                comando.executeUpdate();
            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update professores set titulacao = ?, nivel = ? where codprofessor = ?");
                comando.setString(1, professor.getTitulacao());
                comando.setInt(2, professor.getNivel());
                comando.setInt(3, professor.getCodprofessor());
                comando.executeUpdate();
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public List<Professor> BuscarProfessor(Professor filtro){
        try {
        List<Professor> professores = new LinkedList<>();
        String sql = "select * from professores";
        String where = "";
        String order = " order by codprofessor asc";
        
        if (filtro.getCodprofessor() > 0){
            where = "codprofessor = " + filtro.getCodprofessor();
        }  
        
        if (filtro.getTitulacao().length() > 0){
            where = "titulacao like '%" + filtro.getTitulacao() + "%'";
        }
        
        if (filtro.getNivel() > 0){
            where = "nivel = " + filtro.getNivel();
        }
        
        if (where.length() > 0){
            sql = sql + " where " + where + " and ativo = 1";
        } else {
            sql = sql + " where ativo = 1";
        }
        
        sql = sql + order;
        
        Statement comando = bd.getConexao().createStatement();        
        ResultSet resultado = comando.executeQuery(sql);
        while(resultado.next()){
            Professor professor = new Professor();
            professor.setCodprofessor(resultado.getInt("codprofessor"));
            professor.setTitulacao(resultado.getString("titulacao"));
            professor.setNivel(resultado.getInt("nivel"));
            professor.setCodpessoa(resultado.getInt("codpessoa"));
            professores.add(professor);
        }
            return professores;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    public List<Professor> ListarTodos(){
        List<Professor> professores = new LinkedList<>();
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from professores where ativo = 1 ORDER BY codprofessor ASC");
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()){
                Professor professor = new Professor();
                professor.setCodprofessor(resultado.getInt("codprofessor"));
                professor.setTitulacao(resultado.getString("titulacao"));
                professor.setNivel(resultado.getInt("nivel"));
                professor.setCodpessoa(resultado.getInt("codpessoa"));
                professores.add(professor);
            }
            return professores;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }   
    
    public Professor Abrir(int cod){
        Professor professor = new Professor();
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from professores where codprofessor = ?");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            resultado.first();
            professor.setCodprofessor(resultado.getInt("codprofessor"));
            professor.setTitulacao(resultado.getString("titulacao"));
            professor.setNivel(resultado.getInt("nivel"));
            professor.setCodpessoa(resultado.getInt("codpessoa"));
            return professor;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }       
    }
    
    public boolean Apagar(int cod){
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("update professores set ativo = 0 where codprofessor = ?");
            comando.setInt(1, cod);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }   
    
}
