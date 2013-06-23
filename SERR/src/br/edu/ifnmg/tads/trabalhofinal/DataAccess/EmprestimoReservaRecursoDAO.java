/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.EmprestimoReservaRecurso;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Recurso;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.StatusRecurso;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauro
 */
public class EmprestimoReservaRecursoDAO {
    
    BD bd;
    
    public EmprestimoReservaRecursoDAO(){
        bd = new BD();
    }
    
    public boolean Salvar(EmprestimoReservaRecurso empreserecurso){
        try {
            if (empreserecurso.getCodemprestimoreservarecurso() == 0){
            PreparedStatement comando = bd.getConexao()
                    .prepareStatement("insert into emprestimo_reserva_recurso(codrecurso, codemprestimo_reserva, "
                    + "codstatus_recurso, dataprevdevolucao_empr, ativo) values(?,?,?,?,?)");
            comando.setInt(1, empreserecurso.getRecurso().getCodrecurso());
            comando.setInt(2, empreserecurso.getEmprestimoreserva().getCodemprestimoreserva());
            comando.setInt(3, empreserecurso.getStatus().getCodstatusrecurso());
            comando.setDate(4, (Date) empreserecurso.getDataprevdevolucao());
            comando.setInt(5, 1);
            comando.executeUpdate();
            } else if (empreserecurso.getStatus().getCodstatusrecurso() == 2) {
                PreparedStatement comando = bd.getConexao()
                        .prepareStatement("update emprestimo_reserva_recurso set "
                        + "datadevolucao_empr = now() where codemprestimo_reserva_recurso = ?");
                comando.setInt(1, empreserecurso.getCodemprestimoreservarecurso());
                comando.executeUpdate();
            }
            return true;
                    
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoReservaRecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
        public List<EmprestimoReservaRecurso> ListarTodos(int cod){
        try {
            List<EmprestimoReservaRecurso> listaEmprestimoreservarecurso = new LinkedList<>();
            PreparedStatement comando = bd.getConexao()
                    .prepareStatement("select * from emprestimo_reserva_recurso where codemprestimo_reserva = ? "
                    + "and ativo = 1");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                EmprestimoReservaRecurso emprestimoreservarecurso = new EmprestimoReservaRecurso();
                Recurso recurso = new Recurso();
                StatusRecurso statusrecurso = new StatusRecurso();
                emprestimoreservarecurso.setCodemprestimoreservarecurso(resultado.getInt("codemprestimo_reserva_recurso"));
                emprestimoreservarecurso.setDataprevdevolucao(resultado.getDate("dataprevdevolucao_empr"));
                emprestimoreservarecurso.setDatadevolucao(resultado.getDate("datadevolucao_empr"));                   
                recurso.setCodrecurso(resultado.getInt("codrecurso"));
                statusrecurso.setCodstatusrecurso(resultado.getInt("codstatus_recurso"));
                emprestimoreservarecurso.setRecurso(recurso);
                emprestimoreservarecurso.setStatus(statusrecurso);
                
                listaEmprestimoreservarecurso.add(emprestimoreservarecurso);
            }
            
            return listaEmprestimoreservarecurso;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoReservaRecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
            
            
        }
        
        public boolean Apagar(int cod){
        try {
            PreparedStatement comando = bd.getConexao()
                    .prepareStatement("update emprestimo_reserva_recurso set ativo = 0 "
                    + "where codemprestimo_reserva_recurso = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoReservaRecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
            
        }
                
        
        
        
}
