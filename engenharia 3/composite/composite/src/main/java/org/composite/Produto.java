package org.composite;

public class Produto implements Component {
    private double preco;

    public Produto(double preco) {
        this.preco = preco;
    }

    @Override
    public void buy() {
        System.out.println("Produto comprado: R$" + preco);
    }

    @Override
    public void show() {
        System.out.println("Preço do produto: R$" + preco);
    }

    public double getPreco() {
        return this.preco;
    }
}

