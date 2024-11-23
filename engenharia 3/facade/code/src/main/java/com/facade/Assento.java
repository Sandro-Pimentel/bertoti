package com.facade;

public class Assento {
    private int numero;
    private boolean ocupado;
    private boolean premium;

    public Assento(int numero, boolean ocupado, boolean premium) {
        this.numero = numero;
        this.ocupado = ocupado;
        this.premium = premium;
    }

    public void reservar() {
        if (!this.ocupado) {
            this.ocupado = true;
        } else {
            System.out.println("Assento já está reservado!");
        }
    }

    public int getNumero() {
        return this.numero;
    }

    public boolean isOcupado() {
        return this.ocupado;
    }

    public boolean isPremium() {
        return this.premium;
    }
}
