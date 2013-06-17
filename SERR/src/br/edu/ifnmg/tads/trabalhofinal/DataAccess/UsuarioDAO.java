/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo
 */
public class UsuarioDAO {
    private BD bd;
    
    public UsuarioDAO(){
        bd = new BD();
    }
    
    public boolean Salvar(Usuario usuario){
        try {
            if (usuario.getCodusuario() == 0){

                   PreparedStatement comando = bd.getConexao().prepareStatement("insert into usuarios(login, senha, codfuncionario, ativo) values (?,?,?,?)");
                   comando.setString(1, usuario.getLogin());
                   comando.setString(2, usuario.getSenha());
                   comando.setInt(3, usuario.getFuncionario().getCodfuncionario());
                   comando.setInt(4, 1);
                   comando.executeUpdate();
            } else {
                   PreparedStatement comando = bd.getConexao().prepareStatement("update usuarios set login = ?, senha = ? where codusuario = ?");
                   comando.setString(1, usuario.getLogin());
                   comando.setString(2, usuario.getSenha());
                   comando.setInt(3, usuario.getCodusuario());
                   comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
        
    }
    
    public List<Usuario> ListarTodos(){
        try {
            List<Usuario> usuarios = new LinkedList<>();
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from usuarios where ativo = 1 order by codusuario asc");
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Usuario usuario = new Usuario();
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setCodfuncionario(resultado.getInt("codfuncionario")); 
                usuarios.add(usuario);
            }
            return usuarios;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    public Usuario Abrir(int cod){
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from usuarios where codusuario = ?");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            resultado.first();
            Usuario usuario = new Usuario();
            usuario.setLogin(resultado.getString("login"));
            usuario.setSenha(resultado.getString("senha"));
            usuario.setCodfuncionario(resultado.getInt("codfuncionario")); 
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean Apagar(int cod){
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("update usuarios ativo = 0 where codusuario = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }

}
