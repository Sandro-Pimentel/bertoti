package com.strategy;

class Circulo implements Area {
    public float calcularArea() {
        System.out.println("Cálculo da Área do Círculo");
        return 50.0f;
    }
}