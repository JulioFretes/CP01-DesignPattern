package br.com.fiap.cp01;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = Biblioteca.getInstance();
        biblioteca.setCalculadoraMulta(new CalculadoraMultaComplexa());

        biblioteca.adicionarLivro("O Senhor dos Anéis", "J.R.R. Tolkien", "978-0-261-10230-0", 2);
        biblioteca.adicionarLivro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "978-0-7475-3269-9", 3);

        Aluno aluno1 = new Aluno("João");
        Aluno aluno2 = new Aluno("Maria");
        biblioteca.adicionarAluno(aluno1);
        biblioteca.adicionarAluno(aluno2);

        biblioteca.emprestarLivro("978-0-261-10230-0", aluno1);
        biblioteca.emprestarLivro("978-0-7475-3269-9", aluno2);

        Emprestimo emprestimo1 = new Emprestimo(biblioteca.getLivroByIsbn("978-0-261-10230-0"), aluno1);
        biblioteca.devolverLivro(emprestimo1);
    }
}

