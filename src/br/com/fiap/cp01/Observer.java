package br.com.fiap.cp01;

public interface Observer {
    void notificarEmprestimo(Emprestimo emprestimo);
    void notificarDevolucao(Emprestimo emprestimo);
}