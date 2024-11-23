package org.composite;

public class Combo extends Produto {
    public Combo(double preco) {
        super(preco);
    }

    @Override
    public void show() {
        System.out.println("Preço do combo (2x): R$" + (super.getPreco() * 2));
    }

    @Override
    public void buy() {
        System.out.println("Combo comprado: R$" + (super.getPreco() * 2));
    }
}

