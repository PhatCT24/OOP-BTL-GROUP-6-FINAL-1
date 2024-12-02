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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    
    public static void ADDREADERS(Reader reader){
        try (FileWriter fw = new FileWriter("src/code_and_db/Reader.txt", true)){
            Reader.AddToReadersList(reader); //thêm vào csdl là một ArrayList
            fw.write(reader.getCccd() + "\n" + reader.getName() + "\n" + reader.getGender() + "\n" + reader.getContact_number()+ "\n" );
            fw.flush();// viết vào file data của sách
        } catch (IOException ex) { 
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while writing to the file.", "Error", JOptionPane.ERROR_MESSAGE); 
        }
    }
    public static boolean REMOVEREADERS(String cccd){
        boolean deleteNextLines = false;
        try { 
            BufferedReader br = new BufferedReader(new FileReader("src/code_and_db/Reader.txt")); 
            ArrayList<String> lines = new ArrayList<>(); 
            String line; 
            int linesToDelete = 4; //data của mỗi reader chiếm 3 dòng để xóa, không tính cccd
            while ((line = br.readLine()) != null) { //đọc cho đến hết file
                if (line.trim().equals(cccd)) { //tìm cccd sách
                    deleteNextLines = true; //có thể xóa sách
                    continue; 
                } 
                if (deleteNextLines && linesToDelete > 0) { //nếu như có thể xóa và số dòng cần xóa >0
                    linesToDelete--; //skip dòng (xóa dòng)
                    continue; 
                } 
                lines.add(line); //thêm những dòng data của sách khác không được xóa
            } br.close(); 
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/code_and_db/Reader.txt")); 
            for (String l : lines) { //cả hàm BufferredWriter dùng để viết lại vào file data của các sách không bị xóa đã được lưu trong ArrayList<String> lines
                bw.write(l); 
                bw.newLine(); 
            } bw.close();
            if (deleteNextLines == true){//check xem có sách trong database để xóa không
                for (Reader r : Reader.ReadersList()){
                if (r.getCccd().equals(cccd)){
                    Reader.ReadersList().remove(r);
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
    public static ArrayList<Reader> FINDREADERS(String cccd, String name, String gender, String contact_number){
        return (ArrayList<Reader>) Reader.ReadersList().stream() //Books.storage() là db, stream() để duyệt qua cả ArrayList, filter là lọc, collect để chuyển về filter thu được dưới dạng list
        .filter(reader -> 
            (cccd == null || reader.getCccd().equalsIgnoreCase(cccd)) && //equalsIgnoreCase để tránh trường hợp ID trong DB và ID nhập vào filter khác nhau về uppercase và lowercase
            (name == null || reader.getName().toLowerCase().contains(name.toLowerCase())) &&
            (gender == null || reader.getGender().toLowerCase().contains(gender.toLowerCase())) &&
            (contact_number == null || reader.getContact_number().toLowerCase().contains(contact_number.toLowerCase())) //chuyển hết về lowercase để tránh trường hợp giống của ID, contains() check xem có sự giống nhau giữa thuộc tính trong db và filter
        )
        .collect(Collectors.toList());
        
    }
    public static void UPDATEREADERS(String cccd, String query, String updated_info){
        Reader filteredReader = Reader.ReadersList().stream().filter(reader -> {
            return reader.getCccd().equals(cccd);
        }).findFirst().orElse(null);
        
        String newCccd = filteredReader.getCccd();
        String newName = filteredReader.getName();
        String newGender = filteredReader.getGender();
        String newContact_number = filteredReader.getContact_number();
       
        if (query.equals("name")){
            REMOVEREADERS(filteredReader.getCccd());
            ADDREADERS(new Reader(newCccd, updated_info, newGender, newContact_number));
            
        }
        else if (query.equals("gender")){
            REMOVEREADERS(filteredReader.getCccd());
            ADDREADERS(new Reader(newCccd, newName, updated_info, newContact_number));
        }
        else if (query.equals("contact_number")){
            REMOVEREADERS(filteredReader.getCccd());
            ADDREADERS(new Reader(newCccd, newName, newGender, updated_info));
        }
    }
    public static void ADDTICKETS(Ticket ticket){
        try (FileWriter fw = new FileWriter("src/code_and_db/Ticket.txt", true)){
            Ticket.addToTicketList(ticket); //thêm vào csdl là một ArrayList
            fw.write(ticket.getTicketID() + "\n" + ticket.getReaderCCCD() + "\n" + ticket.getBookID() + "\n" + ticket.getBorrow_dateAsString() + "\n" + ticket.getReturn_dateAsString() + "\n" + ticket.getStatus() + "\n" + ticket.getNote() + "\n");
            fw.flush();// viết vào file data của sách
            
        } catch (IOException ex) { 
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while writing to the file.", "Error", JOptionPane.ERROR_MESSAGE); 
        }
    }
    public static boolean REMOVETICKETS(String ticketID){
        boolean deleteNextLines = false;
        try { 
            BufferedReader br = new BufferedReader(new FileReader("src/code_and_db/Ticket.txt")); 
            ArrayList<String> lines = new ArrayList<>(); 
            String line; 
            int linesToDelete = 6; //data của mỗi reader chiếm 3 dòng để xóa, không tính cccd
            while ((line = br.readLine()) != null) { //đọc cho đến hết file
                if (line.trim().equals(ticketID)) { //tìm ID ticket
                    deleteNextLines = true; //có thể xóa ticket
                    continue; 
                } 
                if (deleteNextLines && linesToDelete > 0) { //nếu như có thể xóa và số dòng cần xóa >0
                    linesToDelete--; //skip dòng (xóa dòng)
                    continue; 
                } 
                lines.add(line); //thêm những dòng data của sách khác không được xóa
            } br.close(); 
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/code_and_db/Ticket.txt")); 
            for (String l : lines) { //cả hàm BufferredWriter dùng để viết lại vào file data của các sách không bị xóa đã được lưu trong ArrayList<String> lines
                bw.write(l); 
                bw.newLine(); 
            } bw.close();
            if (deleteNextLines == true){//check xem có sách trong database để xóa không
                for (Ticket t : Ticket.getTicketList()){
                if (t.getTicketID().equals(ticketID)){
                    Ticket.getTicketList().remove(t);
                    break; //xóa khỏi arraylist
                    }
                }
            }            
        } catch (IOException ex ) {
            JOptionPane.showMessageDialog(null, "An error occurred while trying to delete the ticket", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        return deleteNextLines;
    }
    public static ArrayList<Ticket> FINDTICKETS(String ticketID, String cccd, String bookID, String status){
        return (ArrayList<Ticket>) Ticket.getTicketList().stream() 
        .filter(ticket -> 
            (ticketID == null || ticket.getTicketID().equalsIgnoreCase(ticketID)) && 
            (cccd == null || ticket.getReaderCCCD().toLowerCase().contains(cccd.toLowerCase())) &&
            (bookID == null || ticket.getBookID().toLowerCase().contains(bookID.toLowerCase())) &&
            (status == null || ticket.getStatus().toLowerCase().contains(status.toLowerCase())) 
        )
        .collect(Collectors.toList());
    }
    public static void UPDATETICKETS(String ticketID, String query, String updated_info){
        Ticket filteredTicket = Ticket.getTicketList().stream().filter(ticket -> {
                return ticket.getTicketID().equals(ticketID);
        }).findFirst().orElse(null);
        
        String newTicketID = filteredTicket.getTicketID();
        String newReaderID = filteredTicket.getReaderCCCD();
        String newBookID = filteredTicket.getBookID();
        LocalDate newBorrowDate = filteredTicket.getBorrow_date();
        LocalDate newReturnDate = filteredTicket.getReturn_date();
        String newStatus = filteredTicket.getStatus();
        String newNote = filteredTicket.getNote();
       
        if (query.equals("cccd")){
            REMOVETICKETS(filteredTicket.getTicketID());
            ADDTICKETS(new Ticket(newTicketID, updated_info, newBookID, newBorrowDate, newReturnDate , newStatus, newNote));
        }
        else if (query.equals("bookID")){
            REMOVETICKETS(filteredTicket.getTicketID());
            ADDTICKETS(new Ticket(newTicketID, newReaderID, updated_info, newBorrowDate, newReturnDate , newStatus, newNote));
        }
        else if (query.equals("borrow_date")){
            REMOVETICKETS(filteredTicket.getTicketID());
            ADDTICKETS(new Ticket(newTicketID, newReaderID, newBookID, LocalDate.parse(updated_info, DateTimeFormatter.ofPattern("dd/MM/yyyy")), newReturnDate , newStatus, newNote));
        }
        else if (query.equals("return_date")){
            REMOVETICKETS(filteredTicket.getTicketID());
            ADDTICKETS(new Ticket(newTicketID, newReaderID, newBookID, newBorrowDate, LocalDate.parse(updated_info, DateTimeFormatter.ofPattern("dd/MM/yyyy")), newStatus, newNote));
        }
        else if (query.equals("status")){
            REMOVETICKETS(filteredTicket.getTicketID());
            ADDTICKETS(new Ticket(newTicketID, newReaderID, newBookID, newBorrowDate, newReturnDate , updated_info, newNote));
        }
        else if (query.equals("note")){
            REMOVETICKETS(filteredTicket.getTicketID());
            ADDTICKETS(new Ticket(newTicketID, newReaderID, newBookID, newBorrowDate, newReturnDate , newStatus, updated_info));
        }
    }
}              
