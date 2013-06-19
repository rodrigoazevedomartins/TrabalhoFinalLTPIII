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
public class Recurso {
    
    private int codrecurso;
    private String nome;
    private TipoRecurso tiporecurso;
    
    public Recurso(int codrecurso,String nome,TipoRecurso tiporecurso){
        this.codrecurso = codrecurso;
        this.nome = nome;
        this.tiporecurso = tiporecurso;
    }
    public Recurso(){
        this.codrecurso = 0;
        this.nome = "";
        this.tiporecurso = null;
    }

    public int getCodrecurso() {
        return codrecurso;
    }

    public void setCodrecurso(int codrecurso) {
        this.codrecurso = codrecurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoRecurso getTiporecurso() {
        return tiporecurso;
    }

    public void setTiporecurso(TipoRecurso tiporecurso) {
        this.tiporecurso = tiporecurso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.codrecurso;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.tiporecurso);
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
        final Recurso other = (Recurso) obj;
        if (this.codrecurso != other.codrecurso) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.tiporecurso, other.tiporecurso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recurso{" + "codrecurso=" + codrecurso + ", nome=" + nome + ", tiporecurso=" + tiporecurso + '}';
    }
    
}
