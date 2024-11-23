package org.observer;

public class Placar implements Observer {
    @Override
    public void update(String event, int placarCasa, int placarFora) {
        System.out.println("Placar atualizado:");
        System.out.println("Evento: " + event);
        System.out.println("Casa: " + placarCasa + " | Fora: " + placarFora);
    }
}
