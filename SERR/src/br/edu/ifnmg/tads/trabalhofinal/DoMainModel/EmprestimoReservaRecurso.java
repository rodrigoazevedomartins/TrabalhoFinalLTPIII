/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.Date;
import java.util.Objects;
/**
 *
 * @author Mauro
 */
public class EmprestimoReservaRecurso {
    
    private EmprestimoReserva emprestimoreserva;
    private Recurso recurso;
    private Date dataprevdevolucao;     // final previsto para devolucao
    private Date datadevolucao;         // devolucao do recurso 
    private Status status;

    public EmprestimoReserva getEmprestimoreserva() {
        return emprestimoreserva;
    }

    public void setEmprestimoreserva(EmprestimoReserva emprestimoreserva) {
        this.emprestimoreserva = emprestimoreserva;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Date getDataprevdevolucao() {
        return dataprevdevolucao;
    }

    public void setDataprevdevolucao(Date dataprevdevolucao) {
        this.dataprevdevolucao = dataprevdevolucao;
    }

    public Date getDatadevolucao() {
        return datadevolucao;
    }

    public void setDatadevolucao(Date datadevolucao) {
        this.datadevolucao = datadevolucao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.emprestimoreserva);
        hash = 29 * hash + Objects.hashCode(this.recurso);
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
        final EmprestimoReservaRecurso other = (EmprestimoReservaRecurso) obj;
        if (!Objects.equals(this.emprestimoreserva, other.emprestimoreserva)) {
            return false;
        }
        if (!Objects.equals(this.recurso, other.recurso)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return recurso.getNome();
    }
    
    
}
