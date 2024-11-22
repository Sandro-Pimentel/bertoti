package com.strategy;

class Quadrado implements Area {
    public float calcularArea() {
        System.out.println("Cálculo da Área do Quadrado");
        return 25.0f;
    }
}
