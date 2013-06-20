/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Reserva;
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
public class ReservaDAO {
    
    private BD bd;
    
    public ReservaDAO(){
        
        bd =  new BD();
    }
    
    public boolean Salvar(Reserva reserva) {
        try {
            if (reserva.getCodreserva() == 0) {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into reservas(codreserva,datainicio,datafinal,situacao) values(?, ?)");
                comando.setInt(1, reserva.getCodreserva());
               
               
                comando.executeUpdate();

            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update reservas set  codtiporecurso = ?");
                comando.setInt(1, reserva.getCodreserva());
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
     
     public List<Reserva> Abrir(int cod) {
        List<Reserva> reservas = new LinkedList<>();
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from reservas where codreserva = ? and ativo = 1");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Reserva reserva = new Reserva();
                reserva.setCodreserva(resultado.getInt("codreserva"));
               
                reservas.add(reserva);
            }
            return reservas;
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean Apagar(int cod) {
        try {
            PreparedStatement comando = bd
                    .getConexao().prepareStatement("update reservas set ativo = 0 where codreserva = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
