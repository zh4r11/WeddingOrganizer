/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

/**
 *
 * @author Azhari
 */
public class save {
    private static String idbarang;
    private static String idcust;
    
    public static String getIdBarang(){
        return idbarang;
    }
    
    public void setIdBarang(String idbarang){
        save.idbarang = idbarang;
    }
    
    public static String getIdCust(){
        return idcust;
    }
    
    public void setIdCust(String idcust){
        save.idcust = idcust;
    }
    
}
