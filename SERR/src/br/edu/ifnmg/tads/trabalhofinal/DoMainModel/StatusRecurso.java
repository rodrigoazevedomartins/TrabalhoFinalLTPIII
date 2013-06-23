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
public class StatusRecurso {
    
    private int codstatusrecurso;
    private String nomestatus;

    public StatusRecurso(int codstatusrecurso, String nomestatus) {
        this.codstatusrecurso = codstatusrecurso;
        this.nomestatus = nomestatus;
    }

    public StatusRecurso() {
        this.codstatusrecurso = 0;
        this.nomestatus = "";
    }

    public int getCodstatusrecurso() {
        return codstatusrecurso;
    }

    public void setCodstatusrecurso(int codstatusrecurso) {
        this.codstatusrecurso = codstatusrecurso;
    }

    public String getNomestatus() {
        return nomestatus;
    }

    public void setNomestatus(String nomestatus) {
        this.nomestatus = nomestatus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nomestatus);
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
        final StatusRecurso other = (StatusRecurso) obj;
        if (!Objects.equals(this.nomestatus, other.nomestatus)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomestatus;
    }
    
    
    

}
