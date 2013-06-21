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
 * @author IFNMG
 */
public class Professor extends Pessoa{
    private int codprofessor;
    private String titulacao;
    private int nivel;
    private Pessoa pessoa;
    private List<Disciplina> disciplinas;
    
    public Professor(){
        this.codprofessor = 0;
        this.titulacao = "";
        this.nivel = 0;
        this.pessoa = new Pessoa();
        this.disciplinas = new LinkedList<>();
    }

    public Professor(int codprofessor, String titulacao, int nivel, Pessoa pessoa, List<Disciplina> disciplinas) {
        this.codprofessor = codprofessor;
        this.titulacao = titulacao;
        this.nivel = nivel;
        this.pessoa = pessoa;
        this.disciplinas = disciplinas;
    }

    public int getCodprofessor() {
        return codprofessor;
    }

    public void setCodprofessor(int codprofessor) {
        this.codprofessor = codprofessor;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    public void addDisciplinas(Disciplina disciplina){
        if (!disciplinas.contains(disciplina)){
            disciplinas.add(disciplina);
        }
    }
    
    public void removeDisciplinas(Disciplina disciplina){
        if (disciplinas.contains(disciplina)){
            disciplinas.remove(disciplina);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.titulacao);
        hash = 41 * hash + this.nivel;
        hash = 41 * hash + Objects.hashCode(this.pessoa);
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
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.titulacao, other.titulacao)) {
            return false;
        }
        if (this.nivel != other.nivel) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pessoa.toString();
    }

   
    
    
    
}
