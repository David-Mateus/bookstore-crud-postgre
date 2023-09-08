package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect_to_db("livraria", "postgres", "07081998");

        Scanner sc = new Scanner(System.in);

        System.out.println("""
                1. Criar livros
                2. livros cadastrados
                3. Atualizar ISBN do livro
                4. Atualizar Titulo do livro
                5. Atualizar Autor do livro
                6. Remover livro
                7. Sair
                """);
        int escolha = sc.nextInt();
        while  (escolha != 5) {
            //Insert data
            if (escolha == 1) {
                int isbn = sc.nextInt();
                String titulo = sc.next();
                String autor = sc.next();
                conexao.insert_row(conn, "livros", isbn, titulo, autor);

            } else if (escolha == 2) {
                conexao.read_data(conn, "livros");
            } else if (escolha == 3) {
                System.out.println("Digite o ISBN antigo e em seguida digite o novo ISBN");
                int old_isbn = sc.nextInt();
                int new_isbn = sc.nextInt();
                conexao.update_isbn(conn, "livros", old_isbn, new_isbn);
            }else if(escolha == 4){
                System.out.println("Digite o Titulo antigo e em seguida digite o novo Titulo");
                String old_titulo = sc.next();
                String new_titulo = sc.next();
                conexao.update_titulo(conn, "livros", old_titulo, new_titulo);
            }else  if(escolha == 5){
                System.out.println("Digite o Autor antigo e em seguida digite o novo Autor");
                String old_autor = sc.next();
                String new_autor = sc.next();
                conexao.update_titulo(conn, "livros", old_autor, new_autor);
            }else if(escolha == 6){
                System.out.println("Digite o ISBN: ");
                int isbn = sc.nextInt();
                conexao.delete_row_id(conn, "livros", isbn);
            }
            System.out.println("Deseja continuar :");
            escolha = sc.nextInt();


        }
        sc.close();
    }}
