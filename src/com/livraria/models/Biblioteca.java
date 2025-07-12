package com.livraria.models;

import com.livraria.utils.LivrariaUtils;

import java.util.*;

public class Biblioteca {
    private List<Livro> acervoLivros;
    private List<Emprestimo> emprestimos;
    Scanner sc = new Scanner(System.in);

    public Biblioteca(List<Livro> livros, List<Emprestimo> emprestimos) {
            this.acervoLivros = livros;
            this.emprestimos = emprestimos;
    }

    public void listarLivros() {
        System.out.println(" ===== ACERVO DE LIVROS ===== ");
        LivrariaUtils.listarLivros();
        System.out.println(" ");
    }

    public void listarAutores() {
        System.out.println(" ===== AUTORES ===== ");
        LivrariaUtils.listarAutores();
        System.out.println(" ");
    }

    public void listarLivrosEmprestados() {
        System.out.println(" ===== LIVROS EMPRESTADOS ===== ");
        this.emprestimos.forEach(emprestimo -> {
            System.out.println( "Código: " + emprestimo.getCodigoLivro()  + " - Livro: " + emprestimo.getTitulo());
        });
        System.out.println(" ");
    }

    public void listarLivrosDisponiveis() {
        System.out.println(" ");
        this.acervoLivros.forEach(emprestimo -> {
            System.out.println( "Código: " + emprestimo.getCodigo()  + " - Livro: " + emprestimo.getTitulo());
        });
        System.out.println(" ");
    }

    public void iniciarBiblioteca() {
        System.out.println("===== Escolha uma das opções abaixo: ======");
        System.out.println("1 - Ver acervo completo livros");
        System.out.println("2 - Emprestar um livro");
        System.out.println("3 - Devolver um livro");
        System.out.println("4 - Ver autores");
        System.out.println("5 - Ver livros emprestados");
        System.out.println("6 - Ver livros disponíveis");
        System.out.println("0 - Encerrar antendimento.");
        System.out.println("========================================");
    }

    public boolean emprestarLivro() {
        System.out.println("Qual o código do livro que você deseja emprestar?");
        int codigoLivro = this.sc.nextInt();

        try {
            int livrosDisponiveis = this.acervoLivros.size();

            if(livrosDisponiveis > 0) {
                Optional<Emprestimo> emprestado =  emprestimos.stream().filter(codig ->  codig.getCodigoLivro() == codigoLivro).findFirst();

                if(emprestado.isPresent()){
                    System.out.println("Livro indisponível. O que deseja fazer agora? \n");
                    return false;
                }

                Optional<Livro> livroAchado =  this.acervoLivros.stream().filter(codig ->  codig.getCodigo() == codigoLivro).findFirst();

                this.emprestimos.add(new Emprestimo(livroAchado.get().getCodigo(), livroAchado.get().getTitulo()));

                this.acervoLivros.remove(livroAchado.get());

                System.out.println("Empréstimo realizado com sucesso. O que deseja fazer agora?");

                return true;
            }

            System.out.println("Desculpe, no momento não temos nenhum livro disponível. Tente mais tarde.");
            return false;

        } catch (NoSuchElementException e) {
            System.out.println("Livro não encontrado");
            return false;
        }
    }

    public void devolverLivro() {
        System.out.println("Qual o código do livro que você deseja devolver?");
        int codigoLivro = this.sc.nextInt();

        Optional<Emprestimo> emprestado =  emprestimos.stream().filter(codig ->  codig.getCodigoLivro() == codigoLivro).findFirst();

        if(emprestado.isPresent()) {
            Optional<Livro> livro = LivrariaUtils.obterListaDeLivros().stream().filter(lv -> lv.getCodigo() == codigoLivro).findFirst();
            this.emprestimos.remove(emprestado.get());
            this.acervoLivros.add(livro.get());
            System.out.println("O livro " + livro.get().getTitulo() + " foi devolvido com sucesso.");
            return;
        }

        System.out.println("Este livro não consta como emprestado!");
    }

    public boolean actions(int option) {

        switch (option) {
            case 0:
                System.out.println("Volte sempre, meu patrão!");
                break;
            case 1:
                listarLivros();
                return true;
            case 2:
                emprestarLivro();
                return true;
            case 3:
                devolverLivro();
                return true;
            case 4:
                listarAutores();
                return true;
            case 5:
                listarLivrosEmprestados();
                return true;
            case 6:
                listarLivrosDisponiveis();
                return true;
            default:
                System.out.println("Opção não reconhecida" + option);
                return true;
        }

        return false;
    }
}
