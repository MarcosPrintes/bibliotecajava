package com.livraria.models;

import java.time.LocalDate;
import java.util.Date;

public class Autor {
    private String id;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(String id, String nome, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}


