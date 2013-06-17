/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Endereco;
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
public class EnderecoDAO {
   private BD bd;
    
    public EnderecoDAO(){
        bd = new BD();
    }
    
    public boolean Salvar(Endereco endereco){
        try{
        if (endereco.getCodendereco() == 0){
            PreparedStatement comando = bd.getConexao().prepareStatement("insert into enderecos(rua, numero, complemento, bairro, cidade, cep, estado, pais, codpessoa, ativo) values (?,?,?,?,?,?,?,?,?,?)");
                comando.setString(1, endereco.getRua());
                comando.setInt(2, endereco.getNumero());
                comando.setString(3, endereco.getComplemento());
                comando.setString(4, endereco.getBairro());
                comando.setString(5, endereco.getCidade());
                comando.setInt(6, endereco.getCep());
                comando.setString(7, endereco.getEstado());
                comando.setString(8, endereco.getPais());
                comando.setInt(9, endereco.getPessoa().getCodpessoa());
                comando.setInt(10, 1);
                comando.executeUpdate();
        } else {
            PreparedStatement comando = bd.getConexao().prepareStatement("update enderecos set rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, cep = ?, estado = ?, pais = ? where codendereco = ?");
                comando.setString(1, endereco.getRua());
                comando.setInt(2, endereco.getNumero());
                comando.setString(3, endereco.getComplemento());
                comando.setString(4, endereco.getBairro());
                comando.setString(5, endereco.getCidade());
                comando.setInt(6, endereco.getCep());
                comando.setString(7, endereco.getEstado());
                comando.setString(8, endereco.getPais());
                comando.setInt(9, endereco.getCodendereco());
                comando.executeUpdate();
        }
        return true;
        } catch (SQLException ex) {
                Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        }
    }
    
    public List<Endereco> Abrir(int cod){
        List<Endereco> enderecos = new LinkedList<>();
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from enderecos where codpessoa = ? and ativo = 1");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Endereco endereco = new Endereco();
                endereco.setCodendereco(resultado.getInt("codendereco"));
                endereco.setRua(resultado.getString("rua"));
                endereco.setNumero(resultado.getInt("numero"));
                endereco.setComplemento(resultado.getString("complemento"));
                endereco.setBairro(resultado.getString("bairro"));
                endereco.setCidade(resultado.getString("cidade"));
                endereco.setCep(resultado.getInt("cep"));
                endereco.setEstado(resultado.getString("estado"));
                endereco.setPais(resultado.getString("pais"));
                enderecos.add(endereco);
            }   
            return enderecos;
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean Apagar(int cod){
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("update enderecos set ativo = 0 where codendereco = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
    }
}
