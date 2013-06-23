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
    
    private int codemprestimoreservarecurso;
    private EmprestimoReserva emprestimoreserva;
    private Recurso recurso;
    private Date dataprevdevolucao;     // final previsto para devolucao
    private Date datadevolucao;         // devolucao do recurso 
    private StatusRecurso statusrecurso;

    public EmprestimoReservaRecurso(int codemprestimoreservarecurso, EmprestimoReserva emprestimoreserva, Recurso recurso, Date dataprevdevolucao, Date datadevolucao, StatusRecurso statusrecurso) {
        this.codemprestimoreservarecurso = codemprestimoreservarecurso;
        this.emprestimoreserva = emprestimoreserva;
        this.recurso = recurso;
        this.dataprevdevolucao = dataprevdevolucao;
        this.datadevolucao = datadevolucao;
        this.statusrecurso = statusrecurso;
    }

    public EmprestimoReservaRecurso() {
        this.codemprestimoreservarecurso = 0;
        this.emprestimoreserva = new EmprestimoReserva();
        this.recurso = new Recurso();
        this.dataprevdevolucao = new Date();
        this.datadevolucao = new Date();
        this.statusrecurso = new StatusRecurso();
    }

    
    
    public int getCodemprestimoreservarecurso() {
        return codemprestimoreservarecurso;
    }

    public void setCodemprestimoreservarecurso(int codemprestimoreservarecurso) {
        this.codemprestimoreservarecurso = codemprestimoreservarecurso;
    } 
    
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

    public StatusRecurso getStatus() {
        return statusrecurso;
    }

    public void setStatus(StatusRecurso statusrecurso) {
        this.statusrecurso = statusrecurso;
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
