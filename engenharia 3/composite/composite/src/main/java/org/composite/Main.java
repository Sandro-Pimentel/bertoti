package org.composite;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto(10.0);
        Produto produto2 = new Produto(15.0);
        Combo combo1 = new Combo(20.0);

        Cardapio cardapio = new Cardapio();
        cardapio.add(produto1);
        cardapio.add(produto2);
        cardapio.add(combo1);

        System.out.println("Exibindo itens do cardápio:");
        cardapio.show();

        System.out.println("\nRealizando compras:");
        cardapio.buy();
    }
}
