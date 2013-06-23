/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.StatusRecurso;
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
public class StatusRecursoDAO {
    
    private BD bd;
    
    public StatusRecursoDAO(){
        
        bd  = new BD();
        
    }
    
    public List<StatusRecurso> ListarTodos(){
        try {
            List<StatusRecurso> listastatus = new LinkedList<>();
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from statusrecurso");
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                StatusRecurso status = new StatusRecurso();
                status.setCodstatusrecurso(resultado.getInt("codstatus"));
                status.setNomestatus(resultado.getString("nomestatus"));
                listastatus.add(status);
            }
            return listastatus;
        } catch (SQLException ex) {
            Logger.getLogger(StatusRecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
