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
    private String id;
    private String name;
    private String category;
    private String publisher;
    private String author;
    private String volume;
    private int quantity;
    
    public Books(String id, String name, String category, String publisher, String author, String volume, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.publisher = publisher;
        this.author = author;
        this.volume = volume;
        this.quantity = quantity;
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

    public String getVolume() {
        return volume;
    }

    public int getQuantity() {
        return quantity;
    }
    
}
