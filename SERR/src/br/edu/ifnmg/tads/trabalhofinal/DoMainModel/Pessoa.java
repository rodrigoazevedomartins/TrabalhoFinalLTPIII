/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author IFNMG
 */
public class Pessoa {
    private int codpessoa;
    private String nome;
    private String rg;
    private int cpf;
    private Date datanasc;
    private List<Endereco> enderecos;
    private List<Email> emails;
    private List<Telefone> telefones;

    public Pessoa(int codpessoa, String nome, String rg, int cpf, Date datanasc, List<Endereco> enderecos, List<Email> emails, List<Telefone> telefones) {
        this.codpessoa = codpessoa;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.datanasc = datanasc;
        this.enderecos = enderecos;
        this.emails = emails;
        this.telefones = telefones;
    }
    
    
    
    public Pessoa(){
        this.codpessoa = 0;
        this.nome = "";
        this.rg = "";
        this.cpf = 0;
        this.datanasc = new Date();
        this.enderecos = new LinkedList<>();
        this.emails = new LinkedList<>();
        this.telefones = new LinkedList<>();
    }

    public int getCodpessoa() {
        return codpessoa;
    }

    public void setCodpessoa(int codpessoa) {
        this.codpessoa = codpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    
    public void addEmails(Email ema){
        if(!emails.contains(ema)){
            emails.add(ema);
        }
    }
    
    public void removeEmails(Email ema){
        if(emails.contains(ema)){
            emails.remove(ema);
        }
    }
    
    public void addEnderecos(Endereco end){
        if(!enderecos.contains(end)){
            enderecos.add(end);
        }
    }
    
    public void removeEnderecos(Endereco end){
        if(enderecos.contains(end)){
            enderecos.remove(end);
        }
    }
    
    public void addTelefones(Telefone tel){
        if(!telefones.contains(tel)){
            telefones.add(tel);
        }
    }
    
    public void removeTelefones(Telefone tel){
        if(telefones.contains(tel)){
            telefones.remove(tel);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codpessoa;
        hash = 29 * hash + Objects.hashCode(this.rg);
        hash = 29 * hash + this.cpf;
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
        final Pessoa other = (Pessoa) obj;
        if (this.codpessoa != other.codpessoa) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (this.cpf != other.cpf) {
            return false;
        }
        return true;
    }


   @Override
    public String toString() {
        return nome;
    }
    
    
    
}
