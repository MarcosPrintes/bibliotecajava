import com.livraria.models.*;
import com.livraria.utils.LivrariaUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivrariaMain {
    public static void main(String [] args) {
        Scanner scCliente = new Scanner(System.in);

        Cliente cliente = new Cliente();

        List<Livro> livros = LivrariaUtils.obterListaDeLivros();
        List<Emprestimo> emprestimos = new ArrayList<>();

        Biblioteca biblioteca = new Biblioteca(livros, emprestimos);

        System.out.println("==== Seja bem vindo(a) a Livraria Foguete Maroto ====");

        System.out.println("==== Para começar, informe seu nome: ====");
        cliente.setNome(scCliente.next());

        System.out.println("==== informe seu CPF: ====");
        cliente.setCpf(scCliente.next());

        iniciar(biblioteca, cliente);
    }

    public static void iniciar(Biblioteca biblioteca, Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        int option;

        biblioteca.iniciarBiblioteca();

        option = sc.nextInt();
        boolean continueAction = biblioteca.actions(option);

        if(continueAction) {
            iniciar(biblioteca, cliente);
        }

    }
}
