/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Email;
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
public class EmailDAO {
    private BD bd;
    
    public EmailDAO(){
        bd = new BD();
    }
    
    public boolean Salvar(Email email){
        try {
        if (email.getCodemail() == 0){
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into emails(endereco, codpessoa, ativo) values(?, ?, ?)");
                comando.setString(1, email.getEndereco());
                comando.setInt(2, email.getPessoa().getCodpessoa());
                comando.setInt(3, 1);
                comando.executeUpdate();
                
        } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update emails set endereco = ? where codemail = ?");
                comando.setString(1, email.getEndereco());
                comando.setInt(2, email.getCodemail());
                comando.executeUpdate();
        }
        return true;
        } catch (SQLException ex) {
                Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
    
    public List<Email> Abrir(int cod){
        List<Email> emails = new LinkedList<>();
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from emails where codpessoa = ? and ativo = 1");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Email email = new Email();
                email.setCodemail(resultado.getInt("codemail"));
                email.setEndereco(resultado.getString("endereco"));
                emails.add(email);
            }
            return emails;
        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean Apagar(int cod){
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("update emails set status = 0 where codemail = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
