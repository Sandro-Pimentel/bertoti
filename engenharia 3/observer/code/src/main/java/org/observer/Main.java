package org.observer;

public class Main {
    public static void main(String[] args) {
        Partida partida = new Partida();
        Placar placar = new Placar();
        Tabela tabela = new Tabela();

        partida.addObserver("Gol Casa", placar);
        partida.addObserver("Gol Fora", placar);
        partida.addObserver("Gol Casa", tabela);
        partida.addObserver("Gol Fora", tabela);

        partida.golCasa();
        partida.golFora();
    }
}
