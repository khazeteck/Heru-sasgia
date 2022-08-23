/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package perpustakaan;

import java.io.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class from_input_buku {
static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
static final String DB_URL="jdbc:mysql://localhost/dbperpustakaan_saya";
static final String USER="root";
static final String PASS="";

static Connection conn;
static Statement stat;
static ResultSet rs;

static InputStreamReader inputStreamReader=new InputStreamReader(System.in);
static BufferedReader input=new BufferedReader(inputStreamReader);

public static void main(String[]args){
    try {
        Class.forName(JDBC_DRIVER);
        conn=DriverManager.getConnection(DB_URL,USER,PASS);
        stat=conn.createStatement();
    } catch (Exception e) {
    }
    
    try {
        System.out.println("====================");
        System.out.println("  INPUT DATA BUKU   ");
        System.out.println("====================");
        System.out.println("MASUKAN DATA BUKU  :");
        String kdbuku=input.readLine().trim();
        System.out.println("MASUKAN JUDUL BUKU :");
        String judul=input.readLine().trim();
        System.out.println("MASUKAN PENGARANG  :");
        String pengarang=input.readLine().trim();
        System.out.println("MASUKAN HARGA      :");
        String harga=input.readLine().trim();
        
        String sql="insert into tblbuku(kodebuku,judul,pengarang,harga)values('%s','%s','%s','%s')";
        sql=String.format(sql,kdbuku,judul,pengarang,harga);
        stat.execute(sql);
        System.out.println("Data Berhasil Disimpan");
    } catch (Exception e) {
    }
}
}
