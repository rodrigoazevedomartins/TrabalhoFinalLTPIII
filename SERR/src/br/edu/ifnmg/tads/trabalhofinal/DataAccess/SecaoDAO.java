/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Secao;
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
 * @author Rodrigo
 */
public class SecaoDAO {
    private BD bd;
    
    public SecaoDAO(){
        bd = new BD();
    }
    
    public boolean Salvar(Secao secao){
        try {
        if (secao.getCodsecao() == 0){
            PreparedStatement comando = bd.getConexao().prepareStatement("insert into secoes(inicio, final, codusuario, ativo) values (?,?,?,?)");
            comando.setDate(1, (Date) secao.getIniciosecao());
            comando.setDate(2, (Date) secao.getFinalsecao());
            comando.setInt(3, secao.getUsuario().getCodusuario());
            comando.setInt(4, 1);
            comando.executeUpdate();
        }  
            return true;
        } catch (SQLException ex) {
                Logger.getLogger(SecaoDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
    
    public List<Secao> Abrir(int cod){
        List<Secao> secoes = new LinkedList<>();
        try{
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from secoes where codusuario = ? and ativo = 1");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Secao secao = new Secao();
                secao.setIniciosecao(resultado.getDate("inicio"));
                secao.setFinalsecao(resultado.getDate("final"));
                secoes.add(secao);
            }          
            return secoes;
        } catch(SQLException ex) {
                Logger.getLogger(SecaoDAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
        }
    }
    
    public boolean Apagar(int cod){
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("update secoes set ativo = 0 where codsecao = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SecaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
