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
    
    public int ConsultaRecurso(EmprestimoReservaRecurso err){
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select count(*) from emprestimos_reservas_recursos err "
                    + "inner join emprestimos_reservas er on (er.codemprestimo_reserva = err.codemprestimo_reserva) "
                    + "where ((err.codstatusrecurso = 1 and er.dataemprestimo >= ? and err.dataprevdevolucao_empr <= ?) "
                    + "or (err.codstatusrecurso = 3 and er.dataprevempr >= ? and err.dataprevdevolucao_empr <= ?)) and err.codrecurso = ?");
            java.sql.Timestamp dataempr = new java.sql.Timestamp(err.getEmprestimoreserva().getDataemprestimo().getTime());
            comando.setTimestamp(1, dataempr);
            java.sql.Timestamp dataprevdevempr = new java.sql.Timestamp(err.getDataprevdevolucao().getTime());
            comando.setTimestamp(2, dataprevdevempr);
            java.sql.Timestamp dataprevempr = new java.sql.Timestamp(err.getEmprestimoreserva().getDataprevemprestimo().getTime());
            comando.setTimestamp(3, dataprevempr);
            comando.setTimestamp(4, dataprevdevempr);
            comando.setInt(5, err.getRecurso().getCodrecurso());
            ResultSet resultado = comando.executeQuery();
            resultado.first();
                
                    
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoReservaRecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
        
    }
    
    public boolean Salvar(EmprestimoReservaRecurso empreserecurso){
        try {
            if (empreserecurso.getCodemprestimoreservarecurso() == 0 && empreserecurso.getEmprestimoreserva().
                    getOperacao().getCodoperacao() == 2){
            PreparedStatement comando = bd.getConexao()
                    .prepareStatement("insert into emprestimos_reservas_recursos(codrecurso, codemprestimo_reserva, "
                    + "codstatusrecurso, ativo) values(?,?,?,?)");
            comando.setInt(1, empreserecurso.getRecurso().getCodrecurso());
            comando.setInt(2, empreserecurso.getEmprestimoreserva().getCodemprestimoreserva());
            comando.setInt(3, 3);
            comando.setInt(4, 1);
            comando.executeUpdate();
            } else if (empreserecurso.getCodemprestimoreservarecurso() == 0 && empreserecurso.getEmprestimoreserva().
                    getOperacao().getCodoperacao() == 1) {
                    PreparedStatement comando = bd.getConexao()
                    .prepareStatement("insert into emprestimos_reservas_recursos(codrecurso, codemprestimo_reserva, "
                    + "dataprevdevolucao_empr, codstatusrecurso, ativo) values(?,?,?,?,?)");
                    comando.setInt(1, empreserecurso.getRecurso().getCodrecurso());
                    comando.setInt(2, empreserecurso.getEmprestimoreserva().getCodemprestimoreserva());
                    java.sql.Timestamp datahora = new java.sql.Timestamp(empreserecurso.getDataprevdevolucao().getTime());
                    comando.setTimestamp(3, datahora);
                    comando.setInt(4, 1);
                    comando.setInt(5, 1);
                    comando.executeUpdate();
                   } else if (empreserecurso.getCodemprestimoreservarecurso() > 0 && empreserecurso.getStatus().
                           getCodstatusrecurso() == 2){
                            PreparedStatement comando = bd.getConexao()
                            .prepareStatement("update emprestimo_reserva_recurso set "
                                + "datadevolucao_empr = now(), codstatusrecurso = ? where codemprestimo_reserva_recurso = ?");
                            comando.setInt(1, empreserecurso.getCodemprestimoreservarecurso());
                            comando.setInt(1, 2);
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
