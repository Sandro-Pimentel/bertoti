package com.strategy;

public class Main {
    public static void main(String[] args) {
        // Testando as formas com áreas diferentes
        Forma quadrado = new Forma();
        quadrado.setArea(new Quadrado());  // Define o tipo de área (Quadrado)

        Forma triangulo = new Forma();
        triangulo.setArea(new Triangulo());  // Define o tipo de área (Triangulo)

        Forma circulo = new Forma();
        circulo.setArea(new Circulo());  // Define o tipo de área (Circulo)

        // Calcular as áreas
        System.out.println("Área do Quadrado: " + quadrado.getArea().calcularArea());
        System.out.println("Área do Triângulo: " + triangulo.getArea().calcularArea());
        System.out.println("Área do Círculo: " + circulo.getArea().calcularArea());
    }
}
