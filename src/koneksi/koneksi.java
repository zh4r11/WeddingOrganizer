/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;
import java.sql.*;

/**
 *
 * @author Z
 */
public class koneksi {
    
    private Connection koneksi;
    public Connection connect(){
        try{
            Class.forName("com.myqsl.jdbc.Driver");
            System.out.println("berhasil konek");
        }
        catch(ClassNotFoundException ex){
            System.out.println("gagal koneksi" +ex);
        }
        String url ="jdbc:mysql://localhost:3306/nwedding";
        try{
            koneksi = DriverManager.getConnection(url,"root","");
            System.out.println("berhasil konek database");
        }
        catch (SQLException ex){
            System.out.println("gagal koneksi database"+ex);
        }
        return koneksi;
    }  
    
}
