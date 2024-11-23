package org.observer;

public class Tabela implements Observer {
    @Override
    public void update(String event, int placarCasa, int placarFora){
        System.out.println("Tabela atualizada:");
        System.out.println("Evento: " + event);
        System.out.println("Casa: " + placarCasa + " | Fora: " + placarFora);
    }
}
