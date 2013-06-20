/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.List;
import java.util.Objects;
/**
 *
 * @author Mauro
 */

public class TipoRecurso {
    private int codtiporecurso;
    private String nome; 
    
    public TipoRecurso(int codtiporecurso,String nome){
       this.codtiporecurso = codtiporecurso;
       this.nome = nome;
    }
    
public TipoRecurso(){
   this.codtiporecurso = 0;
   this.nome = "";
}

    public int getCodtiporecurso() {
        return codtiporecurso;
    }

    public void setCodtiporecurso(int codtiporecurso) {
        this.codtiporecurso = codtiporecurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.codtiporecurso;
        hash = 71 * hash + Objects.hashCode(this.nome);
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
        final TipoRecurso other = (TipoRecurso) obj;
        if (this.codtiporecurso != other.codtiporecurso) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void add(List<TipoRecurso> tiporecursos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
