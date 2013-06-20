/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.TipoRecurso;
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
public class TiporecursoDAO {
    
    private BD bd;
    
    public TiporecursoDAO(){
        
        bd  = new BD();
        
    }
    
     public boolean Salvar(TipoRecurso tiporecurso) {
        try {
            if (tiporecurso.getCodtiporecurso() == 0) {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into tiposrecurso(codtiporecurso, nome) values(?, ?)");
                comando.setInt(1, tiporecurso.getCodtiporecurso());
                comando.setString(1, tiporecurso.getNome());
               
                comando.executeUpdate();

            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update tiposrecurso set nome = ? where codtiporecurso = ?");
                comando.setString(1, tiporecurso.getNome());
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TiporecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
     
     public List<TipoRecurso> Abrir(int cod) {
        List<TipoRecurso> tiporecursos = new LinkedList<>();
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from tiposrecurso where codtiporecurso = ? and ativo = 1");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                TipoRecurso tiporecurso = new TipoRecurso();
                tiporecurso.setCodtiporecurso(resultado.getInt("codtiporecurso"));
                tiporecurso.setNome(resultado.getString("nome"));
                
                tiporecursos.add(tiporecurso);
            }
            return tiporecursos;
        } catch (SQLException ex) {
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean Apagar(int cod) {
        try {
            PreparedStatement comando = bd
                    .getConexao().prepareStatement("update tiposrecurso set ativo = 0 where codtiporecurso = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TiporecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
