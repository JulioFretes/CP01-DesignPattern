package br.com.fiap.cp01;

public abstract class CalculadoraMultaTemplate implements CalculadoraMultaStrategy {
    @Override
    public final double calcularMulta(Emprestimo emprestimo) {
        if (!temAtraso(emprestimo)) {
            return 0.0;
        }
        
        int diasAtraso = calcularDiasAtraso(emprestimo);
        double valorPorDia = calcularValorPorDia(diasAtraso);
        
        return diasAtraso * valorPorDia;
    }
    
    protected abstract boolean temAtraso(Emprestimo emprestimo);
    
    protected abstract int calcularDiasAtraso(Emprestimo emprestimo);
    
    protected abstract double calcularValorPorDia(int diasAtraso);
}