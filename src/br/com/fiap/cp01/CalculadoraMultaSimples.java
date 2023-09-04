package br.com.fiap.cp01;

public class CalculadoraMultaSimples implements CalculadoraMultaStrategy {
    @Override
    public double calcularMulta(Emprestimo emprestimo) {
        return 5.0;
    }
}
