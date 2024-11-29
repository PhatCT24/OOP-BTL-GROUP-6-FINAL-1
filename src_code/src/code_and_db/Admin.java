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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;

import gui.menu;
import java.util.stream.Collectors;
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
            Books.AddToStorage(book); //thêm vào csdl là một ArrayList
            fw.write(book.getID() + "\n" + book.getName() + "\n" + book.getCategory() + "\n" + book.getPublisher() + "\n" + book.getAuthor() + "\n" + book.getQuantity() + "\n");
            fw.flush();// viết vào file data của sách
        } catch (IOException ex) { 
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while writing to the file.", "Error", JOptionPane.ERROR_MESSAGE); 
        }
    }
    public static boolean REMOVEBOOKS(String id) throws IOException { //xóa thông tin sách khỏi file
        boolean deleteNextLines = false;
        try { 
            BufferedReader br = new BufferedReader(new FileReader("src/code_and_db/Books.txt")); 
            ArrayList<String> lines = new ArrayList<>(); 
            String line; 
             //check xem có thể xóa sách được không. True = có, False = không
            int linesToDelete = 5; //data của mỗi quyển sách chiếm 5 dòng để xóa, không tính id
            while ((line = br.readLine()) != null) { //đọc cho đến hết file
                if (line.trim().equals(id)) { //tìm id sách
                    deleteNextLines = true; //có thể xóa sách
                    continue; 
                } 
                if (deleteNextLines && linesToDelete > 0) { //nếu như có thể xóa và số dòng cần xóa >0
                    linesToDelete--; //skip dòng (xóa dòng)
                    continue; 
                } 
                lines.add(line); //thêm những dòng data của sách khác không được xóa
            } br.close(); 
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/code_and_db/Books.txt")); 
            for (String l : lines) { //cả hàm BufferredWriter dùng để viết lại vào file data của các sách không bị xóa đã được lưu trong ArrayList<String> lines
                bw.write(l); 
                bw.newLine(); 
            } bw.close();
            if (deleteNextLines == true){//check xem có sách trong database để xóa không
                for (Books b : Books.storage()){
                if (b.getID().equals(id)){
                    Books.storage().remove(b);
                    break; //xóa khỏi arraylist
                    }
                }
            }            
        } catch (IOException ex ) {
            new menu().getRemoveID_Field().requestFocus();
            JOptionPane.showMessageDialog(null, "An error occurred while trying to delete the book", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        return deleteNextLines;
    }
    public static ArrayList<Books> FINDBOOKS(String id, String name, String category, String author) {
    return (ArrayList<Books>) Books.storage().stream() //Books.storage() là db, stream() để duyệt qua cả ArrayList, filter là lọc, collect để chuyển về filter thu được dưới dạng list
        .filter(book -> 
            (id == null || book.getID().equalsIgnoreCase(id)) && //equalsIgnoreCase để tránh trường hợp ID trong DB và ID nhập vào filter khác nhau về uppercase và lowercase
            (name == null || book.getName().toLowerCase().contains(name.toLowerCase())) &&
            (category == null || book.getCategory().toLowerCase().contains(category.toLowerCase())) &&
            (author == null || book.getAuthor().toLowerCase().contains(author.toLowerCase())) //chuyển hết về lowercase để tránh trường hợp giống của ID, contains() check xem có sự giống nhau giữa thuộc tính trong db và filter
        )
        .collect(Collectors.toList());
    }
    public static void UPDATEBOOKS(String id, String query, String updated_info) throws IOException{
        Books filteredBook = Books.storage().stream().filter(book -> {
            return book.getID().equals(id);
        }).findFirst().orElse(null);
        String newID = filteredBook.getID();
        String newName = filteredBook.getName();
        String newCategory = filteredBook.getCategory();
        String newPublisher = filteredBook.getPublisher();
        String newAuthor = filteredBook.getAuthor();
        int newQuantity = filteredBook.getQuantity();
        if (query.equals("name")){
            REMOVEBOOKS(filteredBook.getID());
            ADDBOOKS(new Books(newID, updated_info, newCategory, newPublisher, newAuthor, String.valueOf(newQuantity)));
        }
        else if (query.equals("category")){
            REMOVEBOOKS(filteredBook.getID());
            ADDBOOKS(new Books(newID, newName, updated_info, newPublisher, newAuthor, String.valueOf(newQuantity)));
        }
        else if (query.equals("quantity")){
            REMOVEBOOKS(filteredBook.getID());
            ADDBOOKS(new Books(newID, newName, newCategory, newPublisher, newAuthor, updated_info));
        }
        else if (query.equals("author")){
            REMOVEBOOKS(filteredBook.getID());
            ADDBOOKS(new Books(newID, newName, newCategory, newPublisher, updated_info, String.valueOf(newQuantity)));
        }
        else if (query.equals("publisher")){
            REMOVEBOOKS(filteredBook.getID());
            ADDBOOKS(new Books(newID, newName, newCategory, updated_info, newAuthor, String.valueOf(newQuantity)));
        }
    }
}              
