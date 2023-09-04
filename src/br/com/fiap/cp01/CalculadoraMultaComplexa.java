package br.com.fiap.cp01;

public class CalculadoraMultaComplexa extends CalculadoraMultaTemplate {
    @Override
    protected boolean temAtraso(Emprestimo emprestimo) {
        // Verifica se o empréstimo está atrasado
        return true;
    }

    @Override
    protected int calcularDiasAtraso(Emprestimo emprestimo) {
        // Calcula o número de dias de atraso
        return 3;
    }

    @Override
    protected double calcularValorPorDia(int diasAtraso) {
        // Calcula o valor da multa por dia de atraso
        return 2.0 * diasAtraso;
    }
}