/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gabri
 */
public class Tela {
    private int id, id_tab;
    private String corpo, imagem, titulo;

    public Tela(int id, int id_tab, String corpo, String imagem, String titulo) {
        this.id = id;
        this.id_tab = id_tab;
        this.corpo = corpo;
        this.imagem = imagem;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_tab() {
        return id_tab;
    }

    public void setId_tab(int id_tab) {
        this.id_tab = id_tab;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    
}
