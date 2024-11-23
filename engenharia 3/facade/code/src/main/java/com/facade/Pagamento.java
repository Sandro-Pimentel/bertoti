package com.facade;

public class Pagamento {
    private double saldo;
    private double preco;
    private boolean operacaoAceita;

    public Pagamento(double saldo, double preco) {
        this.saldo = saldo;
        this.preco = preco;
        this.operacaoAceita = false;
    }

    public void processar(boolean premium) {
        if (premium) {
            this.preco *= 1.1;
        }

        if (this.saldo >= this.preco) {
            this.saldo -= this.preco;
            this.operacaoAceita = true;
        } else {
            this.operacaoAceita = false;
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double getPreco() {
        return this.preco;
    }

    public boolean isOperacaoAceita() {
        return this.operacaoAceita;
    }
}
