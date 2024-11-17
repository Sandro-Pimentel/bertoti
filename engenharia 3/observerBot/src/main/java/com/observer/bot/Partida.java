package com.observer.bot;

public class Partida {
    private GerenciadorEventos events;
    private int placarCasa;
    private int placarFora;

    public Partida() {
        this.events = new GerenciadorEventos();
        this.placarCasa = 0;
        this.placarFora = 0;
    }

    public void addObserver(String event, Observer observer) {
        this.events.addObserver(event, observer);
    }

    public void golCasa() {
        this.placarCasa++;
        this.events.notifyObservers("Gol Casa", placarCasa, placarFora);
    }

    public void golFora() {
        this.placarFora++;
        this.events.notifyObservers("Gol Fora", placarCasa, placarFora);
    }
}
