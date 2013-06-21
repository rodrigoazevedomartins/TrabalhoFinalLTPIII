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
public class Funcionario extends Pessoa {
    private int codfuncionario;
    private String siape;
    private String cargo;
    private Pessoa pessoa;

    public Funcionario(int codfuncionario, String siape, String cargo, Pessoa pessoa) {
        this.codfuncionario = codfuncionario;
        this.siape = siape;
        this.cargo = cargo;
        this.pessoa = pessoa;
    }

    public Funcionario() {
        this.codfuncionario = 0;
        this.siape = "";
        this.cargo = "";
        this.pessoa = new Pessoa();
    }

    public int getCodfuncionario() {
        return codfuncionario;
    }

    public void setCodfuncionario(int codfuncionario) {
        this.codfuncionario = codfuncionario;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.siape);
        hash = 31 * hash + Objects.hashCode(this.cargo);
        hash = 31 * hash + Objects.hashCode(this.pessoa);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.siape, other.siape)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pessoa.toString();
    }  
}
