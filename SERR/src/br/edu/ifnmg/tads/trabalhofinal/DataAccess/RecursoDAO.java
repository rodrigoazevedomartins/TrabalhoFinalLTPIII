/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Recurso;
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
public class RecursoDAO {
    
    private BD bd;
    
    public RecursoDAO(){
      
        bd =  new BD();
    }
    
    public boolean Salvar(Recurso recurso) {
        try {
            if (recurso.getCodrecurso() == 0) {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into recursos(codrecurso, nome, tiporecurso) values(?, ?, ?)");
                comando.setInt(1, recurso.getCodrecurso());
                comando.setString(1, recurso.getNome());
                comando.setInt(2, recurso.getTiporecurso().getCodtiporecurso());
             
                comando.executeUpdate();

            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update recursos set nome = ? where codrecurso = ?");
                comando.setString(1, recurso.getNome());
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    
    public List<Recurso> Abrir(int cod) {
        List<Recurso> recursos = new LinkedList<>();
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from recursos where codrecurso = ? and ativo = 1");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Recurso recurso = new Recurso();
                recurso.setCodrecurso(resultado.getInt("codrecurso"));
                recurso.setNome(resultado.getString("nome"));
                recurso.setTiporecurso(resultado.getInt("tiporecurso"));
                recursos.add(recurso);
            }
            return recursos;
        } catch (SQLException ex) {
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean Apagar(int cod) {
        try {
            PreparedStatement comando = bd
                    .getConexao().prepareStatement("update recursos set ativo = 0 where codcurso = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
