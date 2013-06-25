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
    private String iniciosecao;
    private String finalsecao;
    private Usuario usuario;

    public Secao(int codsecao, String iniciosecao, String finalsecao, Usuario usuario) {
        this.codsecao = codsecao;
        this.iniciosecao = iniciosecao;
        this.finalsecao = finalsecao;
        this.usuario = usuario;
    }

    public Secao() {
        this.codsecao = 0;
        this.iniciosecao = "";
        this.finalsecao = "";
        this.usuario = new Usuario();
    }

    public int getCodsecao() {
        return codsecao;
    }

    public void setCodsecao(int codsecao) {
        this.codsecao = codsecao;
    }

    public String getIniciosecao() {
        return iniciosecao;
    }

    public void setIniciosecao(String iniciosecao) {
        this.iniciosecao = iniciosecao;
    }

    public String getFinalsecao() {
        return finalsecao;
    }

    public void setFinalsecao(String finalsecao) {
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
        int hash = 7;
        hash = 83 * hash + this.codsecao;
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
        if (this.codsecao != other.codsecao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+codsecao;
    }
    
}
