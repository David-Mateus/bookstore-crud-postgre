package com.company;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect_to_db("livraria", "postgres", "07081998");
//        conexao.createTable(conn, "livros");
        conexao.insert_row(conn, "livros", 1234,"sucess","David" );
//        Scanner sc = new Scanner(System.in);
//
//        List<Livraria> liv = new ArrayList<>();
//        System.out.println("""
//                1. Criar livros
//                2. livros cadastrados
//                3. Atualizar livro
//                4. Remover livro
//                5. Sair
//                """);
//        int escolha = sc.nextInt();
//        while  (escolha != 5) {
//            if (escolha == 1) {
//                int isbn = sc.nextInt();
//                String titulo = sc.next();
//                String autor = sc.next();
//                Livraria dados = new Livraria(isbn, titulo, autor);
//                liv.add(dados);
//
//            } else if (escolha == 2) {
//                if(liv.size() == 0){
//                    System.out.println("Nenhum livro cadastrado");
//                }else{
//                    for (int i = 0; i < liv.size(); i++) {
//                        System.out.println("ISBN: " + liv.get(i).getIsbn());
//                        System.out.println("Titulo: " + liv.get(i).getTitulo());
//                        System.out.println("Autor: " + liv.get(i).getAutor());
//                    }
//                }
//
//            } else if (escolha == 3) {
//                System.out.println("Digite isbn: ");
//                int search = sc.nextInt();
//                for (int i = 0; i < liv.size(); i++) {
//                    if (liv.get(i).getIsbn() == search) {
//
//                        System.out.println("Livro encontrado");
//                        System.out.println("ISBN: ");
//                        int isbn = sc.nextInt();
//                        System.out.println("Titulo: ");
//                        String titulo = sc.next();
//                        System.out.println("Autor: ");
//                        String autor = sc.next();
//
//                        liv.get(i).setIsbn(isbn);
//                        liv.get(i).setTitulo(titulo);
//                        liv.get(i).setAutor(autor);
//
//                    } else {
//                        System.out.println("Livro não encontrado");
//                    }
//                }
//            }else if(escolha == 4){
//                System.out.println("Digite isbn: ");
//                int search = sc.nextInt();
//                for (int i = 0; i < liv.size(); i++) {
//                    if (liv.get(i).getIsbn() == search) {
//                        liv.remove(i);
//                    } else {
//                        System.out.println("Livro não encontrado");
//                    }
//
//                }
//            }
//            System.out.println("Deseja continuar :");
//            escolha = sc.nextInt();
//
//
//        }
//        sc.close();
    }}
