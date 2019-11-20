/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Diego
 */
public class Refeicao {
    
    private int idrefeicoes;
    private Instituicao instituicao;
    private String descricaoref;
    private String datacadastro;
    private String datarefeicao;

    public Refeicao(int idrefeicoes, Instituicao instituicao, String descricaoref, String datacadastro, String datarefeicao) {
        this.idrefeicoes = idrefeicoes;
        this.instituicao = instituicao;
        this.descricaoref = descricaoref;
        this.datacadastro = datacadastro;
        this.datarefeicao = datarefeicao;
    }

    public Refeicao() {
        
    }

    public int getIdrefeicoes() {
        return idrefeicoes;
    }

    public void setIdrefeicoes(int idrefeicoes) {
        this.idrefeicoes = idrefeicoes;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public String getDescricaoref() {
        return descricaoref;
    }

    public void setDescricaoref(String descricaoref) {
        this.descricaoref = descricaoref;
    }

    public String getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(String datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getDatarefeicao() {
        return datarefeicao;
    }

    public void setDatarefeicao(String datarefeicao) {
        this.datarefeicao = datarefeicao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Refeicao other = (Refeicao) obj;
        if (!Objects.equals(this.descricaoref, other.descricaoref)) {
            return false;
        }
        return true;
    }
    
}