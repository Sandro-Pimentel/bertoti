package com.singleton;

public class Main {
    public static void main(String[] args) {
        Database db = Database.getInstance();

        db.query("CREATE DATABASE Vendas;");
    }
}
