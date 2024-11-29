/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_and_db;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author TRAN XUAN THANH
 */
public class Books {
    private String id;
    private String name;
    private String category;
    private String publisher;
    private String author;
    private int quantity;
    
    private static ArrayList<Books> books = new ArrayList<>();
   
    public static void autoaddBooks() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/code_and_db/Books.txt"));
        String id;
        while ((id = br.readLine()) != null) {
            Books book = new Books(id,br.readLine(),br.readLine(), br.readLine(), br.readLine(),br.readLine());
            books.add(book);
        }
    }
    
    public Books(String id, String name, String category, String publisher, String author, String quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.publisher = publisher;
        this.author = author;
        this.quantity = Integer.parseInt(quantity);
    }
    public String getID(){
        return id;
    }
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }
    public static ArrayList<Books> storage(){
        return books;
    }
    public static void AddToStorage(Books book){
        books.add(book);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static void setBooks(ArrayList<Books> books) {
        Books.books = books;
    }
    
}
