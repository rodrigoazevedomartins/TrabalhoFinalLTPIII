/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.Objects;

/**
 *
 * @author Rodrigo
 */
public class TempoMaximo {
    private int codtempomaximo;
    private String medidatempomaximo;
    
    public TempoMaximo(){
        this.codtempomaximo = 0;
        this.medidatempomaximo = "";
    }

    public int getCodtempomaximo() {
        return codtempomaximo;
    }

    public void setCodtempomaximo(int codtempomaximo) {
        this.codtempomaximo = codtempomaximo;
    }

    public String getMedidatempomaximo() {
        return medidatempomaximo;
    }

    public void setMedidatempomaximo(String medidatempomaximo) {
        this.medidatempomaximo = medidatempomaximo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.medidatempomaximo);
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
        final TempoMaximo other = (TempoMaximo) obj;
        if (!Objects.equals(this.medidatempomaximo, other.medidatempomaximo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return medidatempomaximo;
    }
    
    
    
    
}
