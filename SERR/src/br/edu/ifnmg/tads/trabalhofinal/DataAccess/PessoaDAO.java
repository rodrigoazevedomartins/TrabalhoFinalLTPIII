/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Pessoa;
import java.sql.Date;
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
 * @author Rodrigo
 */
public class PessoaDAO {
     private BD bd;
    
    public PessoaDAO(){
        bd = new BD();
    }
    
    
    public int Consultacodpessoa(){
        int codpessoa = 0;    
        try {
                
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("select max(codpessoa) as codpessoa from pessoas");
                ResultSet resultado = comando.executeQuery();
                resultado.first();
                codpessoa = (resultado.getInt("codpessoa"));
                System.out.println(codpessoa);
                
            } catch (SQLException ex) {
                Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        return codpessoa;    
    }
    
    public boolean Salvar(Pessoa pessoa){
        try{
            if (pessoa.getCodpessoa() == 0){
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into pessoas(nome, rg, cpf, ativo) values (?,?,?,?)");
                comando.setString(1, pessoa.getNome());
                comando.setString(2, pessoa.getRg());
                comando.setInt(3, pessoa.getCpf());
                //comando.setDate(4, (Date) (pessoa.getDatanasc()));
                comando.setInt(4, 1);
                comando.executeUpdate();
            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update pessoas set nome = ?, rg = ?, cpf = ?, datanasc = ? where codpessoa = ?");
                comando.setString(1, pessoa.getNome());
                comando.setString(2, pessoa.getRg());
                comando.setInt(3, pessoa.getCpf());
                comando.setDate(4, (Date) pessoa.getDatanasc());
                comando.setInt(5, pessoa.getCodpessoa());
                comando.executeUpdate();
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public List<Pessoa> BuscarPessoa(Pessoa filtro){
        
         try {
             List<Pessoa> pessoas = new LinkedList<>();
             String sql = "select * from pessoas";
             String where = "";
             String order = " order by codpessoa asc";
             
             if (filtro.getNome().length() > 0){
                 where = "nome like '%" + filtro.getNome() + "%'";
             }
             
             if (filtro.getCpf() > 0){
                 where = "cpf = " + filtro.getCpf();
             }
             
             if (filtro.getRg().length() > 0){
                 where = "rg = " + filtro.getRg();
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
                 Pessoa pessoa = new Pessoa();
                 pessoa.setCodpessoa(resultado.getInt("codpessoa"));
                 pessoa.setCpf(resultado.getInt("cpf"));
                 pessoa.setRg(resultado.getString("rg"));
                 pessoa.setDatanasc(resultado.getDate("datanasc"));
                 pessoas.add(pessoa);
             }
             
             
             return pessoas;
         } catch (SQLException ex) {
             Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
        
        
        
        
    } 
    
    public Pessoa Abrir(int cod){
        try {
            Pessoa pessoa = new Pessoa();
            PreparedStatement comando;
            comando = bd.getConexao().prepareStatement("select * from pessoas where codpessoa = ?");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            resultado.first();
            pessoa.setCodpessoa(resultado.getInt("codpessoa"));
            pessoa.setNome(resultado.getString("nome"));
            pessoa.setRg(resultado.getString("rg"));
            pessoa.setCpf(resultado.getInt("cpf"));
            pessoa.setDatanasc(resultado.getDate("datanasc"));
            return pessoa;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }            
    }
    
    public boolean Apagar(int cod){
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("update pessoas set ativo = 0 where codpessoa = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    
    }
}
