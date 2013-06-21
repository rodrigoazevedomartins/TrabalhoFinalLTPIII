/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Maike Jordan
 */
public class Curso {
    
    private int codcurso;
    private String nome;
    private int duracao;
    private List<Disciplina> disciplinas;

    public Curso(int codcurso, String nome, int duracao, List<Disciplina> disciplinas) {
        this.codcurso = codcurso;
        this.nome = nome;
        this.duracao = duracao;
        this.disciplinas = disciplinas;
    }

    public Curso() {
        this.codcurso = 0;
        this.nome = "";
        this.duracao = 0;
        this.disciplinas = new LinkedList<>();
    }
    
    public int getCodcurso() {
        return codcurso;
    }

    public void setCodcurso(int codcurso) {
        this.codcurso = codcurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + this.duracao;
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.duracao != other.duracao) {
            return false;
        }
        return true;
    }
   
    @Override
    public String toString() {
        return nome;
    }    
}
