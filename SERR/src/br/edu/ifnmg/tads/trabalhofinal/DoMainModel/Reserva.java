/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.Date;
import java.util.List;
import java.util.Objects;
/**
 *
 * @author Mauro
 */
public class Reserva {
    
    private int codreserva;
    private Date datainicio;
    private Date datafinal;
    private Situacao situacao;
    private Secao secao;
    private Pessoa pessoa;
    private List<Recurso> recursos;
    
    public Reserva(int codreserva,Date datainicio,Date datafinal,Situacao situacao,Secao secao,Pessoa pessoa,List<Recurso> recursos){
    
         this.codreserva = codreserva;
         this.datainicio = datainicio;
         this.datafinal = datafinal;
         this.situacao = situacao;
         this.secao = secao;
         this.pessoa = pessoa;
         this.recursos = recursos;
    }
    public Reserva(){
        this.codreserva = 0;
        this.datainicio = null;
        this.datafinal = null;
        this.situacao = null;
        this.secao = null;
        this.pessoa = null;
        this.recursos = null;
    }

    public int getCodreserva() {
        return codreserva;
    }

    public void setCodreserva(int codreserva) {
        this.codreserva = codreserva;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.codreserva;
        hash = 17 * hash + Objects.hashCode(this.datainicio);
        hash = 17 * hash + Objects.hashCode(this.datafinal);
        hash = 17 * hash + Objects.hashCode(this.situacao);
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
        final Reserva other = (Reserva) obj;
        if (this.codreserva != other.codreserva) {
            return false;
        }
        if (!Objects.equals(this.datainicio, other.datainicio)) {
            return false;
        }
        if (!Objects.equals(this.datafinal, other.datafinal)) {
            return false;
        }
        if (!Objects.equals(this.situacao, other.situacao)) {
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
        return "Reserva{" + "codreserva=" + codreserva + ", datainicio=" + datainicio + ", datafinal=" + datafinal + ", situacao=" + situacao + ", secao=" + secao + ", pessoa=" + pessoa + ", recursos=" + recursos + '}';
    }
    
}
