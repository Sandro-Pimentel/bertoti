package com.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static Database instance;
    private static final String URL = "jdbc:mysql://localhost:3306/banco";
    private static final String USER = "usuario";
    private static final String PASSWORD = "senha";

    private Database() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return connection;
    }

    public static Database getInstance() {
        if(this.instance == null) {
            acquireThreadLock();
            if(this.instance == null) {
                this.instance = new Database();
            }
        }
        return this.instance;
    }

    public void query(String sql) {
        System.out.println(sql);
    }
}
