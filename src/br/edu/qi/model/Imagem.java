/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

/**
 *
 * @author Diego
 */
public class Imagem {
    
    private int codigoIm;
    private int codigoRef;
    Imagem foto;

    public int getCodigoIm() {
        return codigoIm;
    }

    public void setCodigoIm(int codigoIm) {
        this.codigoIm = codigoIm;
    }

    public Imagem(int codigoIm, int codigoRef, String descricaoRef, Imagem foto) {
        this.codigoIm = codigoIm;
        this.codigoRef = codigoRef;
        this.foto = foto;
    }

 

    public int getCodigoRef() {
        return codigoRef;
    }

    public void setCodigoRef(int codigoRef) {
        this.codigoRef = codigoRef;
    }


    public Imagem getFoto() {
        return foto;
    }

    public void setFoto(Imagem foto) {
        this.foto = foto;
    }
}
