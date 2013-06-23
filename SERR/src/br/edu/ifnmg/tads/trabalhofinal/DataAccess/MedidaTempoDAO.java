/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.MedidaTempo;
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
public class MedidaTempoDAO {
    
    private BD bd;
    
    public MedidaTempoDAO(){
        
        bd  = new BD();
        
    }
    
    public List<MedidaTempo> ListarTodos(){
        try {
            List<MedidaTempo> listatempomaximo = new LinkedList<>();
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from medidatempo");
            ResultSet resultado = comando.executeQuery();
            
            while (resultado.next()){
                MedidaTempo tempomaximo = new MedidaTempo();
                tempomaximo.setCodtempomaximo(resultado.getInt("codmedidatempo"));
                tempomaximo.setMedidatempomaximo(resultado.getString("medida"));
                listatempomaximo.add(tempomaximo);
            }
            
            return listatempomaximo;
        } catch (SQLException ex) {
            Logger.getLogger(MedidaTempoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
