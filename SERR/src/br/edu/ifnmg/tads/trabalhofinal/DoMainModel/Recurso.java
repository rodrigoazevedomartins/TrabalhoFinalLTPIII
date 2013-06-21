/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DoMainModel;

import java.util.Objects;

/**
 *
 * @author Mauro
 */
public class Recurso {
    
    private int codrecurso;
    private String nome;
    private String descricao;
    private int num_patrimonio;
    private int capacidade;
    private int tempo;
    private TempoMaximo medidatempo;
    private TipoRecurso tiporecurso;
    
    public Recurso(int codrecurso,String nome, String descricao, int num_patrimonio, 
                int capacidade, int tempo, TempoMaximo medidatempo, TipoRecurso tiporecurso){
        this.codrecurso = codrecurso;
        this.nome = nome;
        this.descricao = descricao;
        this.num_patrimonio = num_patrimonio;
        this.capacidade = capacidade;
        this.tempo = tempo;
        this.medidatempo = medidatempo;
        this.tiporecurso = tiporecurso;
    }
    public Recurso(){
        this.codrecurso = 0;
        this.nome = "";
        this.descricao = "";
        this.num_patrimonio = 0;
        this.capacidade = 0;
        this.tempo = 0;
        this.medidatempo = new TempoMaximo();
        this.tiporecurso = new TipoRecurso();
    }

    public int getCodrecurso() {
        return codrecurso;
    }

    public void setCodrecurso(int codrecurso) {
        this.codrecurso = codrecurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNum_patrimonio() {
        return num_patrimonio;
    }

    public void setNum_patrimonio(int num_patrimonio) {
        this.num_patrimonio = num_patrimonio;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public TempoMaximo getMedidatempo() {
        return medidatempo;
    }

    public void setMedidatempo(TempoMaximo medidatempo) {
        this.medidatempo = medidatempo;
    }
         
    public TipoRecurso getTiporecurso() {
        return tiporecurso;
    }

    public void setTiporecurso(TipoRecurso tiporecurso) {
        this.tiporecurso = tiporecurso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.codrecurso;
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + Objects.hashCode(this.descricao);
        hash = 11 * hash + this.num_patrimonio;
        hash = 11 * hash + this.capacidade;
        hash = 11 * hash + this.tempo;
        hash = 11 * hash + Objects.hashCode(this.medidatempo);
        hash = 11 * hash + Objects.hashCode(this.tiporecurso);
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
        final Recurso other = (Recurso) obj;
        if (this.codrecurso != other.codrecurso) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (this.num_patrimonio != other.num_patrimonio) {
            return false;
        }
        if (this.capacidade != other.capacidade) {
            return false;
        }
        if (this.tempo != other.tempo) {
            return false;
        }
        if (!Objects.equals(this.medidatempo, other.medidatempo)) {
            return false;
        }
        if (!Objects.equals(this.tiporecurso, other.tiporecurso)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
}
