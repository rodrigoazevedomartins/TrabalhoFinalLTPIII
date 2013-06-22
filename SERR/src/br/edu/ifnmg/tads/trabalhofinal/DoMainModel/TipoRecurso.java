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
    private String descricao;
    
    public TipoRecurso(int codtiporecurso, String nome, String descricao){
       this.codtiporecurso = codtiporecurso;
       this.nome = nome;
       this.descricao = descricao;
    }
    
public TipoRecurso(){
   this.codtiporecurso = 0;
   this.nome = "";
   this.descricao = "";
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.codtiporecurso;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.descricao);
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
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
}
