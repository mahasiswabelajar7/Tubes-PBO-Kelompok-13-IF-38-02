/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tubes_pbo_13.Dokter;

/**
 *
 * @author Anang Kur
 */
public class FileDatabase implements Serializable{
    
    public void saveFileDokter(ArrayList<Dokter> fileDokter){
        try{
            FileOutputStream fos = new FileOutputStream("filedokter.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(fileDokter);
            oos.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Dokter> loadFileDokter(){
        ArrayList<Dokter> temp=null;
        try{
        FileInputStream fis = new FileInputStream("filedokter.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        temp = (ArrayList<Dokter>) ois.readObject();
        } catch (IOException | ClassNotFoundException e){
            System.out.println("ERROR..!!");
        }
        return temp;
    }
}