/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Rodrigo
 */
public class Secao {
    private int codsecao;
    private Date iniciosecao;
    private Date finalsecao;
    private Usuario usuario;

    public Secao(int codsecao, Date iniciosecao, Date finalsecao, Usuario usuario) {
        this.codsecao = codsecao;
        this.iniciosecao = iniciosecao;
        this.finalsecao = finalsecao;
        this.usuario = usuario;
    }

    public Secao() {
        this.codsecao = 0;
        this.iniciosecao = new Date();
        this.finalsecao = new Date();
        this.usuario = null;
    }

    public int getCodsecao() {
        return codsecao;
    }

    public void setCodsecao(int codsecao) {
        this.codsecao = codsecao;
    }

    public Date getIniciosecao() {
        return iniciosecao;
    }

    public void setIniciosecao(Date iniciosecao) {
        this.iniciosecao = iniciosecao;
    }

    public Date getFinalsecao() {
        return finalsecao;
    }

    public void setFinalsecao(Date finalsecao) {
        this.finalsecao = finalsecao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.iniciosecao);
        hash = 29 * hash + Objects.hashCode(this.finalsecao);
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
        final Secao other = (Secao) obj;
        if (!Objects.equals(this.iniciosecao, other.iniciosecao)) {
            return false;
        }
        if (!Objects.equals(this.finalsecao, other.finalsecao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return usuario.toString();
    }
    
}
