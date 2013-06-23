/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Operacao;
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
public class OperacaoDAO {
    
    private BD bd;
    
    public OperacaoDAO(){
        
        bd  = new BD();
        
    }
    
    public List<Operacao> ListarTodos(){
        try {
            List<Operacao> operacoes = new LinkedList<>();
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from operacao");
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Operacao operacao = new Operacao();
                operacao.setCodoperacao(resultado.getInt("codoperacao"));
                operacao.setDescricao(resultado.getString("nomeoperacao"));
                operacoes.add(operacao);
            }
            return operacoes;
        } catch (SQLException ex) {
            Logger.getLogger(OperacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
