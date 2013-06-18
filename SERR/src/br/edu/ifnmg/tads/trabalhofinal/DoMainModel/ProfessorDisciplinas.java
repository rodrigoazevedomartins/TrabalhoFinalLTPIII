/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author IFNMG
 */
public class ProfessorDisciplinas {
    
    private Professor professor;
    private List<Disciplina> disciplinas;

    public ProfessorDisciplinas() {
        this.professor = null;
        this.disciplinas = null;
    }
    
    public ProfessorDisciplinas(Professor professor, List<Disciplina> disciplinas) {
        this.professor = professor;
        this.disciplinas = disciplinas;
    } 

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    public void addDisciplina(Disciplina Disc){
        if(!disciplinas.contains(Disc)){
            disciplinas.add(Disc);
        }
    }
    
    public void removeDisciplina(Disciplina Disc){
        if(disciplinas.contains(Disc)){
            disciplinas.remove(Disc);
        }    
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.professor);
        hash = 53 * hash + Objects.hashCode(this.disciplinas);
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
        if (!Objects.equals(this.disciplinas, other.disciplinas)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "ProfessorDisciplinas{" + "professor=" + professor + ", disciplinas=" + disciplinas + '}';
    }
            
}
