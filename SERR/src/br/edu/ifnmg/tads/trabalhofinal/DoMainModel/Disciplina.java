/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.Objects;

/**
 *
 * @author Maike Jordan
 */
public class Disciplina {
    
    private int coddisciplina;
    private String nome;
    private String ementa;
    private Curso curso;

    public Disciplina(int coddisciplina, String nome, String ementa, Curso curso) {
        this.coddisciplina = coddisciplina;
        this.nome = nome;
        this.ementa = ementa;
        this.curso = curso;
    }

    public Disciplina() {
        this.coddisciplina = 0;
        this.nome = "";
        this.ementa = "";
        this.curso = new Curso();
    }
    
    public int getCoddisciplina() {
        return coddisciplina;
    }

    public void setCoddisciplina(int coddisciplina) {
        this.coddisciplina = coddisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.ementa);
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
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.ementa, other.ementa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
