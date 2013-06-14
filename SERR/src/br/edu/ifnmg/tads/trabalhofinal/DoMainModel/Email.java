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
public class Email {
    private int codemail;
    private String endereco;
    private Pessoa pessoa;

    public Email(int codemail, String endereco, Pessoa pessoa) {
        this.codemail = codemail;
        this.endereco = endereco;
        this.pessoa = pessoa;
    }

    public Email() {
        this.codemail = 0;
        this.endereco = "";
        this.pessoa = null;
    }

    public int getCodemail() {
        return codemail;
    }

    public void setCodemail(int codemail) {
        this.codemail = codemail;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
        hash = 13 * hash + Objects.hashCode(this.endereco);
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
        final Email other = (Email) obj;
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        return true;
    }

 

    @Override
    public String toString() {
        return endereco;
    }
    
    
    
    
    
    
    
}
