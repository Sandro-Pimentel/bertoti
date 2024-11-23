package com.facade;

public class Notificacao {
    public void enviar(boolean operacaoAceita, double saldo, double preco) {
        if (operacaoAceita) {
            System.out.println("Ingresso comprado com sucesso!");
            System.out.println("Preço: " + preco);
        } else {
            System.out.println("Saldo insuficiente, compra cancelada!");
            System.out.println("Saldo: " + saldo);
            System.out.println("Preço: " + preco);
        }
    }
}
