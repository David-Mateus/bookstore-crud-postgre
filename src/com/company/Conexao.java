package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
    //Create connection with database
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
    // Create table
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
    //Inserting data
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
    // Read data
    public void read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs=null;
        try {
            String query=String.format("select * from %s",table_name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            while(rs.next()){
                System.out.print("ISBN: "+rs.getString("isbn")+" ");
                System.out.print("TITULO: "+rs.getString("titulo")+" ");
                System.out.println("AUTOR: "+rs.getString("autor")+" ");
            }

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    //Update ISBN
    public void update_isbn(Connection conn, String table_name, Integer old_isbn, Integer new_isbn){
        Statement statement;
        try {
            String query=String.format("update %s set isbn='%s' where isbn='%s'",table_name,new_isbn,old_isbn);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //Update TITULO
    public void update_titulo(Connection conn, String table_name, String old_titulo, String new_titulo){
        Statement statement;
        try {
            String query=String.format("update %s set titulo='%s' where titulo='%s'",table_name,new_titulo,old_titulo);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //Update Autor
    public void update_autor(Connection conn, String table_name, String old_autor, String new_autor){
        Statement statement;
        try {
            String query=String.format("update %s set autor='%s' where autor='%s'",table_name,new_autor,old_autor);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void delete_row_id(Connection conn,String table_name, Integer isbn){
        Statement statement;
        try{
            String query=String.format("delete from %s where isbn= %s",table_name,isbn);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

}