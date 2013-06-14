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
public class Endereco {
    private int codendereco;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private int cep;
    private String estado;
    private String pais;
    private Pessoa pessoa;

    public Endereco(int codendereco, String rua, int numero, String complemento, String bairro, String cidade, int cep, String estado, String pais, Pessoa pessoa) {
        this.codendereco = codendereco;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.pais = pais;
        this.pessoa = pessoa;
    }

    public Endereco() {
        this.codendereco = 0;
        this.rua = "";
        this.numero = 0;
        this.complemento = "";
        this.bairro = "";
        this.cidade = "";
        this.cep = 0;
        this.estado = "";
        this.pais = "";
        this.pessoa = null;
    }

    public int getCodendereco() {
        return codendereco;
    }

    public void setCodendereco(int codendereco) {
        this.codendereco = codendereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.rua);
        hash = 17 * hash + this.numero;
        hash = 17 * hash + Objects.hashCode(this.complemento);
        hash = 17 * hash + Objects.hashCode(this.bairro);
        hash = 17 * hash + Objects.hashCode(this.cidade);
        hash = 17 * hash + this.cep;
        hash = 17 * hash + Objects.hashCode(this.estado);
        hash = 17 * hash + Objects.hashCode(this.pais);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (this.cep != other.cep) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rua;
    }
    
    
    
    

    
    
    
}
