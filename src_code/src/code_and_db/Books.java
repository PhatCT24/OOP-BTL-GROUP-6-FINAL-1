/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_and_db;


import java.io.IOException;

import javax.swing.JOptionPane;

/**
 *
 * @author TRAN XUAN THANH
 */
public class Books {
    String id;
    String name;
    String category;
    String publisher;
    String author;
    String volume;
    int quantity;
    
    public Books(String id, String name, String category, String publisher, String author, String volume, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.publisher = publisher;
        this.author = author;
        this.volume = volume;
        this.quantity = quantity;
        JOptionPane.showMessageDialog(null, "Book added to the library's database!","AddBook", JOptionPane.INFORMATION_MESSAGE);
    }
}
