package br.com.fiap.cp01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
    private static Biblioteca instance;
    private Map<String, Livro> livros;
    private List<Aluno> alunos;
    private List<Emprestimo> emprestimos;
    private CalculadoraMultaStrategy calculadoraMulta;

    private Biblioteca() {
        livros = new HashMap<>();
        alunos = new ArrayList<>();
        emprestimos = new ArrayList<>();
        calculadoraMulta = new CalculadoraMultaSimples();
    }

    public static Biblioteca getInstance() {
        if (instance == null) {
            instance = new Biblioteca();
        }
        return instance;
    }

    public void adicionarLivro(String titulo, String autor, String isbn, int quantidade) {
        Livro livro = new Livro(titulo, autor, isbn, quantidade);
        livros.put(isbn, livro);
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public boolean emprestarLivro(String isbn, Aluno aluno) {
        Livro livro = livros.get(isbn);
        if (livro == null || livro.getQuantidadeDisponivel() == 0) {
            return false;
        }
        Emprestimo emprestimo = new Emprestimo(livro, aluno);
        emprestimos.add(emprestimo);
        aluno.notificarEmprestimo(emprestimo);
        livro.decrementarQuantidadeDisponivel();
        return true;
    }

    public boolean devolverLivro(Emprestimo emprestimo) {
        if (!emprestimos.contains(emprestimo)) {
            return false;
        }
        emprestimos.remove(emprestimo);
        emprestimo.getAluno().notificarDevolucao(emprestimo);
        emprestimo.getLivro().incrementarQuantidadeDisponivel();
        
        double multa = calculadoraMulta.calcularMulta(emprestimo);
        if (multa > 0) {
            System.out.println("Multa por atraso: R$" + multa);
        }
        
        return true;
    }
    
    public void setCalculadoraMulta(CalculadoraMultaStrategy calculadoraMulta) {
        this.calculadoraMulta = calculadoraMulta;
    }
    
    public Livro getLivroByIsbn(String isbn) {
        return livros.get(isbn);
    }
}