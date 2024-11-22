package com.strategy;

import java.util.ArrayList;

class Forma {
    private ArrayList<Integer> lados;
    private Area area;

    public Forma() {
        this.lados = new ArrayList<>();
        this.area = null;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Area getArea() {
        return this.area;
    }
}
