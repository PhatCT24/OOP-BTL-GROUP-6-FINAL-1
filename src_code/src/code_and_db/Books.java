/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_and_db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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
    private String volume;
    private int quantity;
    
    public Books(String id, String name, String category, String publisher, String author, String volume, int quantity) {
        try{
            this.id = id;
            this.name = name;
            this.category = category;
            this.publisher = publisher;
            this.author = author;
            this.volume = volume;
            this.quantity = quantity;
            writeIntoFile(this);
            JOptionPane.showMessageDialog(null, "Book added to the library's database!","AddBook", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    
    public static void writeIntoFile(Books book) throws IOException{
        try (FileWriter fw = new FileWriter("src/code_and_db/Books.txt", true)){ 
            fw.write(book.id + "\n" + book.name + "\n" + book.category + "\n" + book.publisher + "\n" + book.author + "\n" + book.volume + "\n" + book.quantity + "\n"); 
        } catch (IOException ex) { 
            ex.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "An error occurred while writing to the file.", "Error", JOptionPane.ERROR_MESSAGE); 
        }
    }
}
