/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Recurso;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.MedidaTempo;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.TipoRecurso;
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
public class RecursoDAO {
    
    private BD bd;
    
    public RecursoDAO(){
      
        bd =  new BD();
    }
    
    public boolean Salvar(Recurso recurso) {
        try {
            if (recurso.getCodrecurso() == 0) {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into recursos(nome, descricao, num_patrimonio, capacidade, tempomaximo, "
                        + "codmedidatempo, codtiporecurso, ativo) values(?,?,?,?,?,?,?,?)");
                comando.setString(1, recurso.getNome());
                comando.setString(2, recurso.getDescricao());
                comando.setInt(3, recurso.getNum_patrimonio());
                comando.setInt(4, recurso.getCapacidade());
                comando.setInt(5, recurso.getTempo());
                comando.setInt(6, recurso.getMedidatempo().getCodtempomaximo());
                comando.setInt(7, recurso.getTiporecurso().getCodtiporecurso());
                comando.setInt(8, 1);
                comando.executeUpdate();
            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update recursos set nome = ?, descricao = ?, num_patrimonio = ?, capacidade = ?, "
                        + "tempomaximo = ?, codmedidatempo = ?, codtiporecurso = ? where codrecurso = ?");
                comando.setString(1, recurso.getNome());
                comando.setString(2, recurso.getDescricao());
                comando.setInt(3, recurso.getNum_patrimonio());
                comando.setInt(4, recurso.getCapacidade());
                comando.setInt(5, recurso.getTempo());
                comando.setInt(6, recurso.getMedidatempo().getCodtempomaximo());
                comando.setInt(7, recurso.getTiporecurso().getCodtiporecurso());
                comando.setInt(8, recurso.getCodrecurso());
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public List<Recurso> BuscarRecurso(Recurso filtro){
        List<Recurso> recursos = new LinkedList<>();
        try {
            String sql = "select * from recursos";
            String where = "";
            String order = " order by codrecurso asc";
            
            if (filtro.getCodrecurso() > 0){
                where = "codrecurso = " + filtro.getCodrecurso();
            }
            
            if (filtro.getNome().length() > 0){
                where = "nome like '%" + filtro.getNome() + "%'";
            }
            
            if (filtro.getDescricao().length() > 0){
                where = "descricao like '%" + filtro.getDescricao() + "%'";
            }
            
            if (filtro.getNum_patrimonio() > 0){
                where = "num_patrimonio = " + filtro.getNum_patrimonio();
            }
            
            if (filtro.getCapacidade() > 0){
                where = "capacidade = " + filtro.getCapacidade();
            }
            
            if (filtro.getTempo() > 0 && filtro.getMedidatempo().getCodtempomaximo() > 0){
                where = "tempomaximo = " + filtro.getTempo() + 
                        " and codmedidatempo = " + filtro.getMedidatempo().getCodtempomaximo();
            }
            
            if (filtro.getTiporecurso().getCodtiporecurso() > 0){
                where = "codtiporecurso = " + filtro.getTiporecurso().getCodtiporecurso();
            }
            
            if (where.length() > 0){
                sql = sql + " where " + where + " and ativo = 1";
            } else {
                sql = sql + " where ativo = 1";
            }
            
            Statement comando = bd.getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            
            while (resultado.next()) {
                Recurso recurso = new Recurso();
                TipoRecurso tiporecurso = new TipoRecurso();
                MedidaTempo tempomaximo = new MedidaTempo();
                recurso.setCodrecurso(resultado.getInt("codrecurso"));
                recurso.setNome(resultado.getString("nome"));
                recurso.setDescricao(resultado.getString("descricao"));
                recurso.setNum_patrimonio(resultado.getInt("num_patrimonio"));
                recurso.setCapacidade(resultado.getInt("capacidade"));
                recurso.setTempo(resultado.getInt("tempomaximo"));
                tempomaximo.setCodtempomaximo(resultado.getInt("codmedidatempo"));
                recurso.setMedidatempo(tempomaximo);              
                tiporecurso.setCodtiporecurso(resultado.getInt("codtiporecurso"));
                recurso.setTiporecurso(tiporecurso);
                recursos.add(recurso);
            }
            return recursos;
        } catch (SQLException ex) {
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Recurso> ListarTodos() {
        List<Recurso> recursos = new LinkedList<>();
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from recursos where ativo = 1");
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Recurso recurso = new Recurso();
                TipoRecurso tiporecurso = new TipoRecurso();
                MedidaTempo tempomaximo = new MedidaTempo();
                recurso.setCodrecurso(resultado.getInt("codrecurso"));
                recurso.setNome(resultado.getString("nome"));
                recurso.setDescricao(resultado.getString("descricao"));
                recurso.setNum_patrimonio(resultado.getInt("num_patrimonio"));
                recurso.setCapacidade(resultado.getInt("capacidade"));
                recurso.setTempo(resultado.getInt("tempomaximo"));
                tempomaximo.setCodtempomaximo(resultado.getInt("codmedidatempo"));
                recurso.setMedidatempo(tempomaximo);              
                tiporecurso.setCodtiporecurso(resultado.getInt("codtiporecurso"));
                recurso.setTiporecurso(tiporecurso);
                recursos.add(recurso);
            }
            return recursos;
        } catch (SQLException ex) {
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public Recurso Abrir(int cod){
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from recursos where codrecurso = ?");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            resultado.first();
            Recurso recurso = new Recurso();
            TipoRecurso tiporecurso = new TipoRecurso();
            MedidaTempo tempomaximo = new MedidaTempo();
            recurso.setCodrecurso(resultado.getInt("codrecurso"));
            recurso.setNome(resultado.getString("nome"));
            recurso.setDescricao(resultado.getString("descricao"));
            recurso.setNum_patrimonio(resultado.getInt("num_patrimonio"));
            recurso.setCapacidade(resultado.getInt("capacidade"));
            recurso.setTempo(resultado.getInt("tempomaximo"));
            tempomaximo.setCodtempomaximo(resultado.getInt("codmedidatempo"));
            recurso.setMedidatempo(tempomaximo);              
            tiporecurso.setCodtiporecurso(resultado.getInt("codtiporecurso"));
            recurso.setTiporecurso(tiporecurso);
            return recurso;
            
        } catch (SQLException ex) {
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public boolean Apagar(int cod) {
        try {
            PreparedStatement comando = bd
                    .getConexao().prepareStatement("update recursos set ativo = 0 where codrecurso = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
