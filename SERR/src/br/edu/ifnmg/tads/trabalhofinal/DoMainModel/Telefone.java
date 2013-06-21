/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

/**
 *
 * @author Rodrigo
 */
public class Telefone {
    private int codtelefone;
    private int ddd;
    private int numero;
    private Pessoa pessoa;

    public Telefone(int codtelefone, int ddd, int numero, Pessoa pessoa) {
        this.codtelefone = codtelefone;
        this.ddd = ddd;
        this.numero = numero;
        this.pessoa = pessoa;
    }

    public Telefone() {
        this.codtelefone = 0;
        this.ddd = 0;
        this.numero = 0;
        this.pessoa = new Pessoa();
    }

    public int getCodtelefone() {
        return codtelefone;
    }

    public void setCodtelefone(int codtelefone) {
        this.codtelefone = codtelefone;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.ddd;
        hash = 23 * hash + this.numero;
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
        final Telefone other = (Telefone) obj;
        if (this.ddd != other.ddd) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+numero;
    }
    
    

    

}
