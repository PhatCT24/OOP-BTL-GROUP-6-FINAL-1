/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_and_db;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author TRAN XUAN THANH
 */
public class Admin {

    
    private String username;
    private String password;

    public Admin(String username, String password){
        this.username = username;
        this.password = password;
    }
    // Check if correct login username and password
    public static boolean login(String username, String password)
    throws Exception{
        Scanner sc = new Scanner(new File("src/code_and_db/Account.txt"));
        while (sc.hasNextLine()){
            if (sc.next().equals(username) && sc.next().equals(password)){
                return true;
            }
        }
        return false;
    }
    public static void ADDBOOKS(Books book) throws IOException{
        try (FileWriter fw = new FileWriter("src/code_and_db/Books.txt", true)){ 
            fw.write(book.id + "\n" + book.name + "\n" + book.category + "\n" + book.publisher + "\n" + book.author + "\n" + book.volume + "\n" + book.quantity + "\n"); 
        } catch (IOException ex) { 
            ex.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "An error occurred while writing to the file.", "Error", JOptionPane.ERROR_MESSAGE); 
        }
    }
}
