package com.livraria.utils;

import com.livraria.models.Autor;
import com.livraria.models.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LivrariaUtils {

    public static List<Livro> obterListaDeLivros() {
        List<Livro> livros = new ArrayList<Livro>();

        livros.add(new Livro( "O senhor dos anéis: A sociedade do anel", new Autor("1", "JRR Tolkien", LocalDate.of(1970, 1,1)) , LocalDate.of(1970, 1,1), "Aventura",1));
        livros.add(new Livro( "O senhor dos anéis: As duas torres", new Autor("1", "JRR Tolkien", LocalDate.of(1970, 1,1)), LocalDate.of(1970, 1,1), "Aventura", 2));
        livros.add(new Livro( "O senhor dos anéis: O retorno do rei", new Autor("1", "JRR Tolkien", LocalDate.of(1970, 1,1)), LocalDate.of(1970, 1,1), "Aventura",3));
        livros.add(new Livro( "Harry Potter e a pedra filosofal", new Autor("1", "J. K. Rowling", LocalDate.of(1970, 1,1)), LocalDate.of(1970, 1,1), "Fantasia", 4));

        return livros;
    }

    public static List<Autor> obterAutores() {
        List<Livro> livros = obterListaDeLivros();
        List<Autor> autores = new ArrayList<Autor>();

        livros.forEach(item -> {
            autores.add(item.getAutor());
        });

        return autores;
    }

    public static void listarLivros() {
        List<Livro> livros = obterListaDeLivros();

        livros.forEach((item) -> {
            System.out.println( "Código: " + item.getCodigo()  + " - Livro: " + item.getTitulo());
        });
    }

    public static void listarAutores() {
        List<Autor> autores = new ArrayList<Autor>();

        autores.forEach(autor -> {
            System.out.println(autor.getNome());
        });
    }
}
