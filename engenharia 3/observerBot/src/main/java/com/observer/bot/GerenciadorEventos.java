package com.observer.bot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GerenciadorEventos {
    private HashMap<String, List<Observer>> observers;

    public GerenciadorEventos() {
        this.observers = new HashMap<>();
    }

    public void addObserver(String event, Observer observer) {
        this.observers.computeIfAbsent(event, k -> new ArrayList<>()).add(observer);
    }

    public void removeObserver(String event, Observer observer) {
        List<Observer> eventObservers = this.observers.get(event);
        if(eventObservers != null) {
            eventObservers.remove(observer);
        }
    }

    public void notifyObservers(String event, int placarCasa, int placarFora) {
        List<Observer> eventObservers = this.observers.get(event);
        if(eventObservers != null) {
            for(Observer observer : eventObservers) {
                observer.update(event, placarCasa, placarFora);
            }
        }
    }
}
