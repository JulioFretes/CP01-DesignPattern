package br.com.fiap.cp01;

import java.util.ArrayList;
import java.util.List;

public class Aluno implements Observer {
    private String nome;
    private List<Emprestimo> emprestimos;

    public Aluno(String nome) {
        this.nome = nome;
        this.emprestimos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void notificarEmprestimo(Emprestimo emprestimo) {
        System.out.println("Caro " + nome + ", o livro " + emprestimo.getLivro().getTitulo() + " foi emprestado para você.");
        emprestimos.add(emprestimo);
    }

    public void notificarDevolucao(Emprestimo emprestimo) {
        System.out.println("Caro " + nome + ", o livro " + emprestimo.getLivro().getTitulo() + " foi devolvido por você.");
        emprestimos.remove(emprestimo);
    }
}