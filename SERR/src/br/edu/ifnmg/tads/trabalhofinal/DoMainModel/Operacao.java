/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.Objects;

/**
 *
 * @author Rodrigo
 */
public class Operacao {
    
    private int codoperacao;
    private String nomeoperacao;

    public Operacao(int codoperacao, String nomeoperacao) {
        this.codoperacao = codoperacao;
        this.nomeoperacao = nomeoperacao;
    }
    
    public Operacao() {
        this.codoperacao = 0;
        this.nomeoperacao = "";
    }

    public int getCodoperacao() {
        return codoperacao;
    }

    public void setCodoperacao(int codoperacao) {
        this.codoperacao = codoperacao;
    }

    public String getDescricao() {
        return nomeoperacao;
    }

    public void setDescricao(String nomeoperacao) {
        this.nomeoperacao = nomeoperacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nomeoperacao);
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
        final Operacao other = (Operacao) obj;
        if (!Objects.equals(this.nomeoperacao, other.nomeoperacao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeoperacao;
    }
    
}
