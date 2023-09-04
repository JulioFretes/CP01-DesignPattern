package br.com.fiap.cp01;

public class Emprestimo {
    private Livro livro;
    private Aluno aluno;

    public Emprestimo(Livro livro, Aluno aluno) {
        this.livro = livro;
        this.aluno = aluno;
    }

    public Livro getLivro() {
        return livro;
    }

    public Aluno getAluno() {
        return aluno;
    }
}