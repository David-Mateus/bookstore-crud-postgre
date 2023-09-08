package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexao {
    public Connection connect_to_db(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
    public void createTable(Connection conn, String table_name){
        Statement statement;
        try{
            String query="create table "+table_name+"(isbn INTEGER, titulo varchar(200),autor varchar(200),primary key(isbn));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void insert_row(Connection conn,String table_name,Integer isbn, String titulo, String autor){
        Statement statement;
        try {
            String query=String.format("insert into %s(isbn,titulo,autor) values('%s','%s','%s');",table_name,isbn,titulo, autor);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}