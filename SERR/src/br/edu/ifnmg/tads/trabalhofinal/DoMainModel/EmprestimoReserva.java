/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
/**
 *
 * @author Mauro
 */
public class EmprestimoReserva {
    
    private int codemprestimoreserva;
    private Date dataprevemprestimo;        // previsao do emprestimo
    private Date datareserva;          // realizacao da reserva
    private Date dataemprestimo;        // realizacao do emprestimo 
    private Operacao operacao;          // emprestimo ou reserva
    private Secao secao;
    private Pessoa pessoa;
    private List<Recurso> recursos;

    public EmprestimoReserva(int codemprestimoreserva, Date dataprevemprestimo, Date datareserva, Date dataemprestimo, Operacao operacao, Secao secao, Pessoa pessoa, List<Recurso> recursos) {
        this.codemprestimoreserva = codemprestimoreserva;
        this.dataprevemprestimo = dataprevemprestimo;
        this.datareserva = datareserva;
        this.dataemprestimo = dataemprestimo;
        this.operacao = operacao;
        this.secao = secao;
        this.pessoa = pessoa;
        this.recursos = recursos;
    }

    public EmprestimoReserva() {
        this.codemprestimoreserva = 0;
        this.dataprevemprestimo = new Date();
        this.datareserva = new Date();
        this.dataemprestimo = new Date();
        this.operacao = new Operacao();
        this.secao = new Secao();
        this.pessoa = new Pessoa();
        this.recursos = new LinkedList<>();
    }

    public int getCodemprestimoreserva() {
        return codemprestimoreserva;
    }

    public void setCodemprestimoreserva(int codemprestimoreserva) {
        this.codemprestimoreserva = codemprestimoreserva;
    }

    public Date getDataprevemprestimo() {
        return dataprevemprestimo;
    }

    public void setDataprevemprestimo(Date dataprevemprestimo) {
        this.dataprevemprestimo = dataprevemprestimo;
    }

    public Date getDatareserva() {
        return datareserva;
    }

    public void setDatareserva(Date datareserva) {
        this.datareserva = datareserva;
    }

    public Date getDataemprestimo() {
        return dataemprestimo;
    }

    public void setDataemprestimo(Date dataemprestimo) {
        this.dataemprestimo = dataemprestimo;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }
    
    public void addRecursos(Recurso recurso){
        if (!recursos.contains(recurso)){
            recursos.add(recurso);
        }
    }
    
    public void removeRecursos(Recurso recurso){
        if (recursos.contains(recurso)){
            recursos.remove(recurso);
        }
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.codemprestimoreserva;
        hash = 17 * hash + Objects.hashCode(this.operacao);
        hash = 17 * hash + Objects.hashCode(this.secao);
        hash = 17 * hash + Objects.hashCode(this.pessoa);
        hash = 17 * hash + Objects.hashCode(this.recursos);
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
        final EmprestimoReserva other = (EmprestimoReserva) obj;
        if (this.codemprestimoreserva != other.codemprestimoreserva) {
            return false;
        }
        
        if (!Objects.equals(this.operacao, other.operacao)) {
            return false;
        }
        if (!Objects.equals(this.secao, other.secao)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.recursos, other.recursos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+codemprestimoreserva;
    }
    
}
