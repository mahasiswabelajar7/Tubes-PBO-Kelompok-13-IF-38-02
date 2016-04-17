/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuInputDokter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import tubes_pbo_13.Dokter;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuInputDokter implements ActionListener, Serializable{
    private Aplikasi model;
    private MenuInputDokter menuInputDokter;
    ArrayList<Dokter> tempDaftarDokter;
    
    public ControllerMenuInputDokter(Aplikasi model){
        this.model = model;
        menuInputDokter = new MenuInputDokter();
        menuInputDokter.addListener(this);
        menuInputDokter.setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuInputDokter.getBtnBatalInputDokter())){
            menuInputDokter.dispose();
            new ControllerMenuDokter(model);
        }
        
        if (source.equals(menuInputDokter.getBtnSelesaiInputDokter())){
            if (menuInputDokter.getFieldInputNamaDokter().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf nama harus diisi");
            }
            else if (menuInputDokter.getFieldInputAlamatDokter().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf alamat harus diisi");
            }
            else if (menuInputDokter.getFieldInputSpesialisDokter().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Spesialis harus diisi");
            }
            else if (menuInputDokter.getFieldInputNoHpDokter().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf No HP harus diisi");
            }
            else if (menuInputDokter.getFieldInputJenisKelaminDokter().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Jenis Kelamin harus diisi");
            }
            else{
                String nama = menuInputDokter.getFieldInputNamaDokter().getText();
                String spesialis = menuInputDokter.getFieldInputSpesialisDokter().getText();
                String alamat = menuInputDokter.getFieldInputAlamatDokter().getText();
                long noHp = 0;
                try{
                    noHp = Long.parseLong(menuInputDokter.getFieldInputNoHpDokter().getText());
                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Maaf Nomor Hp Harus Angka, Silahkan Edit, no HP kami isikan dengan 0");
                }
                String jenisKelamin = menuInputDokter.getFieldInputJenisKelaminDokter().getText();
                model.inputDokter(nama, alamat, noHp, jenisKelamin, spesialis);
                JOptionPane.showMessageDialog(null, "Data Dokter Berhasil diinputkan");
                tempDaftarDokter = model.getDaftarDokter();
                model.saveDataDokter(tempDaftarDokter);
                menuInputDokter.dispose();
                new ControllerMenuDokter(model);
            }
        }
    }
    
    
}
