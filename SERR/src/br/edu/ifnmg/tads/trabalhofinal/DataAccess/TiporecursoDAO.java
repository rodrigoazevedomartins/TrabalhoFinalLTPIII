/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

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
public class TiporecursoDAO {
    
    private BD bd;
    
    public TiporecursoDAO(){
        
        bd  = new BD();
        
    }
    
     public boolean Salvar(TipoRecurso tiporecurso) {
        try {
            if (tiporecurso.getCodtiporecurso() == 0) {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into tiposrecurso(nome, descricao, ativo) values(?,?,?)");
                comando.setString(1, tiporecurso.getNome());
                comando.setString(2, tiporecurso.getDescricao());
                comando.setInt(3, 1);
                comando.executeUpdate();

            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update tiposrecurso set nome = ?, descricao = ? where codtiporecurso = ?");
                comando.setString(1, tiporecurso.getNome());
                comando.setString(2, tiporecurso.getDescricao());
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TiporecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
     
     public TipoRecurso Abrir(int cod){
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from tiposrecurso where codtiporecurso = ?");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            resultado.first();
            TipoRecurso tiporecurso = new TipoRecurso();
            tiporecurso.setCodtiporecurso(resultado.getInt("codtiporecurso"));
            tiporecurso.setNome(resultado.getString("nome"));
            tiporecurso.setDescricao(resultado.getString("descricao"));
                
            return tiporecurso;
        } catch (SQLException ex) {
            Logger.getLogger(TiporecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
         
         
     }
     public List<TipoRecurso> ListarTodos() {
        List<TipoRecurso> tiposrecurso = new LinkedList<>();
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from tiposrecurso where ativo = 1");
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                TipoRecurso tiporecurso = new TipoRecurso();
                tiporecurso.setCodtiporecurso(resultado.getInt("codtiporecurso"));
                tiporecurso.setNome(resultado.getString("nome"));
                tiporecurso.setDescricao(resultado.getString("descricao"));
                
                tiposrecurso.add(tiporecurso);
            }
            return tiposrecurso;
        } catch (SQLException ex) {
            Logger.getLogger(TiporecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
    public List<TipoRecurso> BuscarTipoRecurso(TipoRecurso filtro){
        try {
            List<TipoRecurso> tiposrecurso = new LinkedList<>();

            String sql = "select * from tiposrecurso";
            String where = "";
            String order = " order by codtiporecurso";

            if (filtro.getCodtiporecurso() > 0){
                where = "codtiporecurso = " + filtro.getCodtiporecurso();
            }

            if (filtro.getNome().length() > 0){
                where  = "nome like '%" + filtro.getNome() + "%'";
            }

            if (filtro.getDescricao().length() > 0){
                where = "descricao like '%" + filtro.getDescricao() + "%'";
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
                TipoRecurso tiporecurso = new TipoRecurso();
                tiporecurso.setCodtiporecurso(resultado.getInt("codtiporecurso"));
                tiporecurso.setNome(resultado.getString("nome"));
                tiporecurso.setDescricao(resultado.getString("descricao"));
                
                tiposrecurso.add(tiporecurso);   
            }
            
            return tiposrecurso;
        } catch (SQLException ex) {
            Logger.getLogger(TiporecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    } 
    
    public boolean Apagar(int cod) {
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("update tiposrecurso set ativo = 0 where codtiporecurso = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TiporecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
