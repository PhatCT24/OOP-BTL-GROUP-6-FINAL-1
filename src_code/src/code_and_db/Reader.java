/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code_and_db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author TRAN XUAN THANH
 */
public class Reader implements Comparable<Reader>{
    private String cccd;
    private String name;
    private String gender;
    private String contact_number;
    
    private static ArrayList<Reader> readers = new ArrayList<>();
    
    public static void autoaddreaders() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("src/code_and_db/Reader.txt"));
        String cccd;
        while ((cccd = br.readLine()) != null) {
            Reader reader = new Reader(cccd,br.readLine(),br.readLine(),br.readLine());
            readers.add(reader);
        }
    }

    public Reader(String cccd, String name, String gender, String contact_number) {
        this.cccd = cccd;
        this.name = name;
        this.gender = gender;
        this.contact_number = contact_number;
    }

    public String getCccd() {
        return cccd;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getContact_number() {
        return contact_number;
    }

    public static ArrayList<Reader> ReadersList() {
        return readers;
    }
    public static void AddToReadersList(Reader reader){
        readers.add(reader);
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public static void setReaders(ArrayList<Reader> readers) {
        Reader.readers = readers;
    }

    @Override
    public int compareTo(Reader o) {
        return this.getCccd().compareTo(o.getCccd());
    }
}
