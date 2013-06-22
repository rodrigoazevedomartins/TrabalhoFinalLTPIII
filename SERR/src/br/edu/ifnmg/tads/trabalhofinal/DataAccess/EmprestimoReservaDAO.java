/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.EmprestimoReserva;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Operacao;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Pessoa;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Secao;
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
 * @author Mauro
 */
public class EmprestimoReservaDAO {
    
    private BD bd;
    
    public EmprestimoReservaDAO(){
        
        bd =  new BD();
    }
    
    public boolean Salvar(EmprestimoReserva emprestimoreserva) {
        try {
            if (emprestimoreserva.getCodemprestimoreserva() == 0 && 
                    emprestimoreserva.getOperacao().getCodoperacao() == 1) {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into emprestimos_reservas(dataemprestimo,"
                        + "codoperacao, codsecao, codpessoa, ativo) values(now(),?,?,?,?)");
                comando.setInt(1, emprestimoreserva.getOperacao().getCodoperacao());
                comando.setInt(2, emprestimoreserva.getSecao().getCodsecao());
                comando.setInt(3, emprestimoreserva.getPessoa().getCodpessoa());
                comando.setInt(4, 1);
                comando.executeUpdate();
            } else 
                if (emprestimoreserva.getCodemprestimoreserva() == 0 && 
                        emprestimoreserva.getOperacao().getCodoperacao() == 2){
                    PreparedStatement comando = bd.getConexao().
                            prepareStatement("insert into emprestimos_reservas(datareserva,"
                            + "codoperacao, codsecao, codpessoa, ativo) values(now(),?,?,?,?)");
                    comando.setInt(1, emprestimoreserva.getOperacao().getCodoperacao());
                    comando.setInt(2, emprestimoreserva.getSecao().getCodsecao());
                    comando.setInt(3, emprestimoreserva.getPessoa().getCodpessoa());
                    comando.setInt(4, 1);
                    comando.executeUpdate();
            } else 
                    if (emprestimoreserva.getCodemprestimoreserva() > 0 && 
                            emprestimoreserva.getOperacao().getCodoperacao() == 1){
                        PreparedStatement comando = bd.getConexao().
                            prepareStatement("update emprestimos_reservas set dataemprestimo = now(), "
                            + "codoperacao = ?, codsecao = ?, codpessoa = ? where codemprestimo_reserva = ?");
                        comando.setInt(1, emprestimoreserva.getOperacao().getCodoperacao());
                        comando.setInt(2, emprestimoreserva.getSecao().getCodsecao());
                        comando.setInt(3, emprestimoreserva.getPessoa().getCodpessoa());
                        comando.setInt(4, emprestimoreserva.getCodemprestimoreserva());
                        comando.executeUpdate();
                    } else
                        if (emprestimoreserva.getCodemprestimoreserva() > 0 &&
                                emprestimoreserva.getOperacao().getCodoperacao() == 2){
                            PreparedStatement comando = bd.getConexao().
                                prepareStatement("update emprestimos_reservas set datareserva = now(), "
                                + "codoperacao = ?, codsecao = ?, codpessoa = ? where codemprestimo_reserva = ?");
                            comando.setInt(1, emprestimoreserva.getOperacao().getCodoperacao());
                            comando.setInt(2, emprestimoreserva.getSecao().getCodsecao());
                            comando.setInt(3, emprestimoreserva.getPessoa().getCodpessoa());
                            comando.setInt(4, emprestimoreserva.getCodemprestimoreserva());
                            comando.executeUpdate();
                        }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
     
     public EmprestimoReserva Abrir(int cod) {
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from emprestimos_reservas where codemprestimo_reserva = ?");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            resultado.first();
            EmprestimoReserva emprestimoreserva = new EmprestimoReserva();
            Operacao operacao = new Operacao();
            Secao secao = new Secao();
            Pessoa pessoa = new Pessoa();
            emprestimoreserva.setCodemprestimoreserva(resultado.getInt("codemprestimo_reserva"));
            emprestimoreserva.setDataemprestimo(resultado.getDate("dataemprestimo"));
            emprestimoreserva.setDatareserva(resultado.getDate("datareserva"));
            operacao.setCodoperacao(resultado.getInt("codoperacao"));
            secao.setCodsecao(resultado.getInt("codsecao"));
            pessoa.setCodpessoa(resultado.getInt("codpessoa"));
            emprestimoreserva.setOperacao(operacao);
            emprestimoreserva.setPessoa(pessoa);
            emprestimoreserva.setSecao(secao);
            return emprestimoreserva;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
    public List<EmprestimoReserva> ListarTodos(){
        try {
            List<EmprestimoReserva> emprestimosreservas = new LinkedList<>();
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from emprestimos_reservas where ativo = 1");
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()){
                EmprestimoReserva emprestimoreserva = new EmprestimoReserva();
                Operacao operacao = new Operacao();
                Secao secao = new Secao();
                Pessoa pessoa = new Pessoa();
                emprestimoreserva.setCodemprestimoreserva(resultado.getInt("codemprestimoreserva"));
                emprestimoreserva.setDataemprestimo(resultado.getDate("dataemprestimo"));
                emprestimoreserva.setDatareserva(resultado.getDate("datareserva"));
                operacao.setCodoperacao(resultado.getInt("codoperacao"));
                secao.setCodsecao(resultado.getInt("codsecao"));
                pessoa.setCodpessoa(resultado.getInt("codpessoa"));
                emprestimoreserva.setOperacao(operacao);
                emprestimoreserva.setPessoa(pessoa);
                emprestimoreserva.setSecao(secao);
                emprestimosreservas.add(emprestimoreserva);
            }
            
            return emprestimosreservas;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    } 
    
    public List<EmprestimoReserva> BuscarEmprestimoReserva(EmprestimoReserva filtro){
        try {
            List<EmprestimoReserva> emprestimosreservas = new LinkedList<>();
            String sql = "select * from emprestimos_reservas";
            String where = "";
            String order = " order by codemprestimoreserva asc";
            
            if (filtro.getCodemprestimoreserva() > 0){
                where = "codemprestimo_reserva = " + filtro.getCodemprestimoreserva();
            }
            
            if (filtro.getOperacao().getCodoperacao() > 0){
                if (where.length() > 0)
                    where = where + " and ";
                where = "codoperacao = " + filtro.getOperacao();
            }
            
            if (filtro.getPessoa().getCodpessoa() > 0){
                if (where.length() > 0)
                    where = where + " and ";
                where = "codpessoa = " + filtro.getPessoa().getCodpessoa();
            }
            
            if (where.length() > 0){
                sql = sql + " where " + where + "and ativo = 1";
            } else {
                sql = sql + " where " + "ativo = 1";
            }
            
            sql = sql + order;
                        
            Statement comando = bd.getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while (resultado.next()){
                EmprestimoReserva emprestimoreserva = new EmprestimoReserva();
                Operacao operacao = new Operacao();
                Secao secao = new Secao();
                Pessoa pessoa = new Pessoa();
                emprestimoreserva.setCodemprestimoreserva(resultado.getInt("codemprestimoreserva"));
                emprestimoreserva.setDataemprestimo(resultado.getDate("dataemprestimo"));
                emprestimoreserva.setDatareserva(resultado.getDate("datareserva"));
                operacao.setCodoperacao(resultado.getInt("codoperacao"));
                secao.setCodsecao(resultado.getInt("codsecao"));
                pessoa.setCodpessoa(resultado.getInt("codpessoa"));
                emprestimoreserva.setOperacao(operacao);
                emprestimoreserva.setPessoa(pessoa);
                emprestimoreserva.setSecao(secao);
                emprestimosreservas.add(emprestimoreserva);
            }
            return emprestimosreservas;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean Apagar(int cod) {
        try {
            PreparedStatement comando = bd
                    .getConexao().prepareStatement("update emprestimos_reservas set ativo = 0 where codemprestimo_reserva = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
