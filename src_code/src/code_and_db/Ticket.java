/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_and_db;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author TRAN XUAN THANH
 */
public class Ticket implements Comparable<Ticket>{
    private String ticketID;
    private String readerCCCD;
    private String bookID;
    private LocalDate borrow_date;
    private LocalDate return_date;
    private String status;
    private String note;
    
    private static ArrayList<Ticket> tickets = new ArrayList<>();
    
    public static void autoaddTickets() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("src/code_and_db/Ticket.txt"));
        String ticketID;
        while ((ticketID = br.readLine()) != null){
            Ticket ticket = new Ticket(ticketID, br.readLine(), br.readLine(), LocalDate.parse(br.readLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    LocalDate.parse(br.readLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")), br.readLine(),br.readLine());
            tickets.add(ticket);
        }    
    }
    
    public Ticket(String ticketID, String readerCCCD, String bookID, LocalDate borrow_date, LocalDate return_date, String status, String note) {
        this.ticketID = ticketID;
        this.readerCCCD = readerCCCD;
        this.bookID = bookID;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
        this.status = status;
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public static ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public String getTicketID() {
        return ticketID;
    }

    public String getReaderCCCD() {
        return readerCCCD;
    }

    public String getBookID() {
        return bookID;
    }
    public String getNote(){
        return note;
    }

    public LocalDate getBorrow_date() {
        return borrow_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }
    public String getBorrow_dateAsString(){
        return getBorrow_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public String getReturn_dateAsString(){
        return getReturn_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    public static String normalize(String s){
        String[] a = s.split("/");
        s = "";
        while (a[0].length() < 2) a[0] = "0" + a[0];
        s += a[0] + "/";
        while (a[1].length() < 2) a[1] = "0" + a[1];
        s += a[1] + "/";
        while (a[2].length() < 4) a[2] = "0" + a[2];
        s += a[2];
        return s;
    }
    
    public static ArrayList<Ticket> getTicketList(){
        for (Ticket t : tickets){
            if (t.return_date.equals(LocalDate.now())){
                t.status = "Due Today";
            }
            else if (LocalDate.now().isAfter(t.return_date)){
                t.status = "Overdue";
            }
        }
        return tickets;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public void setReaderCCCD(String readerCCCD) {
        this.readerCCCD = readerCCCD;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setBorrow_date(LocalDate borrow_date) {
        this.borrow_date = borrow_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }
    public static void addToTicketList(Ticket ticket){
        tickets.add(ticket);
    }
    
    @Override
    public String toString(){
        return ticketID + " " + readerCCCD + " " + bookID + " " + borrow_date + " " + return_date + " " + status  + " " + note;
    }

    @Override
    public int compareTo(Ticket o) {
        return this.getTicketID().compareTo(o.getTicketID());
    }
}
