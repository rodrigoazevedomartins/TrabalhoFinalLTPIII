/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.Objects;

/**
 *
 * @author IFNMG
 */
public class Situacao {
    
    private int codsituacao;
    private String descricao;

    public Situacao(int codsituacao, String descricao) {
        this.codsituacao = codsituacao;
        this.descricao = descricao;
    }
    
    public Situacao() {
        this.codsituacao = 0;
        this.descricao = "";
    }

    public int getCodsituacao() {
        return codsituacao;
    }

    public void setCodsituacao(int codsituacao) {
        this.codsituacao = codsituacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.descricao);
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
        final Situacao other = (Situacao) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
}
