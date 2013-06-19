/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.Objects;
/**
 *
 * @author Mauro
 */
public class ReservaRecurso {
    
    private Reserva reserva;
    private Recurso recurso;
    
    public ReservaRecurso(Reserva reserva, Recurso recurso){
        this.reserva = reserva;
        this.recurso = recurso;
    }
    
    public ReservaRecurso(){
        
        this.reserva = null;
        this.recurso = null;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.reserva);
        hash = 53 * hash + Objects.hashCode(this.recurso);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReservaRecurso other = (ReservaRecurso) obj;
        if (!Objects.equals(this.reserva, other.reserva)) {
            return false;
        }
        if (!Objects.equals(this.recurso, other.recurso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReservaRecurso{" + "reserva=" + reserva + ", recurso=" + recurso + '}';
    }
    
    
}
