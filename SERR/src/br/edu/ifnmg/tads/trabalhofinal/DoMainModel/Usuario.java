/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Rodrigo
 */
public class Usuario extends Funcionario{
    private int codusuario;
    private String login;
    private String senha;
    private List<Secao> secoes;
    private Funcionario funcionario;

    public Usuario(int codusuario, String login, String senha, Funcionario funcionario) {
        this.codusuario = codusuario;
        this.login = login;
        this.senha = senha;
        this.funcionario = funcionario;
    }

    public Usuario() {
        this.codusuario = 0;
        this.login = "";
        this.senha = "";
        this.funcionario = new Funcionario();
    }

    public int getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(int codusuario) {
        this.codusuario = codusuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Secao> getSecoes() {
        return secoes;
    }

    public void setSecoes(List<Secao> secoes) {
        this.secoes = secoes;
    }

    public void addSecoes(Secao secao){
        if (!secoes.contains(secao)){
            secoes.add(secao);
        }
    }
    
    public void removeSecoes(Secao secao){
        if (secoes.contains(secao)){
            secoes.remove(secao);
        }
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.login);
        hash = 29 * hash + Objects.hashCode(this.senha);
        hash = 29 * hash + Objects.hashCode(this.funcionario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return funcionario.toString();
    }
    
    
    
    
    
    
    
    
}
