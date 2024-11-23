package org.composite;

import java.util.ArrayList;

public class Cardapio implements Component {
    private ArrayList<Component> produtos;

    public Cardapio() {
        this.produtos = new ArrayList<>();
    }

    public void add(Component produto) {
        this.produtos.add(produto);
    }

    public void remove(Component produto) {
        this.produtos.remove(produto);
    }

    public ArrayList<Component> getChildren() {
        return this.produtos;
    }

    @Override
    public void show() {
        for (Component component : produtos) {
            component.show();
        }
    }

    @Override
    public void buy() {
        System.out.println("Comprando todos os itens do cardápio:");
        for (Component component : produtos) {
            component.buy();
        }
    }
}
