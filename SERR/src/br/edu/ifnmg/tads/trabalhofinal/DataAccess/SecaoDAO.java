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
            PreparedStatement comando = bd.getConexao().prepareStatement("insert into secoes(codusuario, ativo) values (?,?)");
            //comando.setDate(1, (Date) secao.getIniciosecao());
            comando.setInt(1, secao.getUsuario().getCodusuario());
            comando.setInt(2, 1);
            comando.executeUpdate();
        } else {
            PreparedStatement comando = bd.getConexao().prepareStatement("update secoes set codsecao = ? where codsecao = ?");
            //comando.setDate(1, (Date) secao.getFinalsecao());
            comando.setInt(1, secao.getCodsecao());
            comando.setInt(2, secao.getCodsecao());
            comando.executeUpdate();
        }  
            return true;
        } catch (SQLException ex) {
                Logger.getLogger(SecaoDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
    
    public int BuscarSecao(int cod){
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("select max(codsecao) as codsecao from secoes where codusuario = ?");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            resultado.first();
            int codigosecao = 0;
            codigosecao = resultado.getInt("codsecao");
            return codigosecao;
        } catch (SQLException ex) {
            Logger.getLogger(SecaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
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
