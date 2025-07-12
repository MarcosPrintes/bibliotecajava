package com.livraria.models;

public class Emprestimo {
    private int codigoLivro;
    private String titulo;

    public Emprestimo(int codigoLivro, String titulo) {
        this.codigoLivro = codigoLivro;
        this.titulo = titulo;
    }


    public int getCodigoLivro() {
        return codigoLivro;
    }

    public String getTitulo() {
        return titulo;
    }
}
