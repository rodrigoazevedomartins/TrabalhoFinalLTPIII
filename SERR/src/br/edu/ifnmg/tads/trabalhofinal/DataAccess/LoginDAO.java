/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo
 */
public class LoginDAO {
    private BD bd;
    
    public LoginDAO(){
        bd = new BD();
    }
    
    public int Login(Usuario usuario){
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from usuarios where login = ? and senha = ? and ativo = 1");
            comando.setString(1, usuario.getLogin());
            comando.setString(2, usuario.getSenha());
            ResultSet resultado = comando.executeQuery();
            if(resultado.first()){
                //resultado.first();
                Usuario usuariologado = new Usuario();
                usuariologado.setCodusuario(resultado.getInt("codusuario"));
                return usuariologado.getCodusuario();
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }
    
    
}
