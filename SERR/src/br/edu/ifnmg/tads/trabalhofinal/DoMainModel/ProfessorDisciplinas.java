/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Rodrigo
 */
public class ProfessorDisciplinas {
    
    private Professor professor;
    private Disciplina disciplina;
    
    public ProfessorDisciplinas(){
        this.disciplina = new Disciplina();
        this.professor = new Professor();
    }
    
    public ProfessorDisciplinas(Professor professor, Disciplina disciplina){
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.professor);
        hash = 29 * hash + Objects.hashCode(this.disciplina);
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
        final ProfessorDisciplinas other = (ProfessorDisciplinas) obj;
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        if (!Objects.equals(this.disciplina, other.disciplina)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return disciplina.toString();
    }
    
    
    
    
    
    
    
}
