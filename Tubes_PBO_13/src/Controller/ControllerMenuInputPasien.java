/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuInputPasien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuInputPasien implements ActionListener{
    private Aplikasi model;
    private MenuInputPasien menuInputPasien;

    public ControllerMenuInputPasien(Aplikasi model) {
        this.model = model;
        menuInputPasien = new MenuInputPasien();
        menuInputPasien.addListener(this);
        menuInputPasien.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(menuInputPasien.getBtnBatalInputPasien())){
            menuInputPasien.dispose();
            new ControllerMenuPasien(model);
        }
        
        if (source.equals(menuInputPasien.getBtnSelesaiInputPasien())){
            if (menuInputPasien.getFieldInputNamaPasien().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Nama Harus diinputkan");
            }
            else if (menuInputPasien.getFieldInputAlamatPasien().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Alamat Harus diinputkan");
            }
            else if (menuInputPasien.getFieldInputNoHpPasien().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf No HP Harus diinputkan");
            }
            else if (menuInputPasien.getFieldInputJenisKelaminPasien().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Jenis Kelamin Harus diinputkan");
            }
            else if (menuInputPasien.getFieldInputKeluhanPasien().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Keluhan Harus diinputkan");
            }
            else{
                String nama = menuInputPasien.getFieldInputNamaPasien().getText();
                String alamat = menuInputPasien.getFieldInputAlamatPasien().getText();
                long noHp;
                try{
                noHp = Long.parseLong(menuInputPasien.getFieldInputNoHpPasien().getText());
                } catch (Exception ex){
                    noHp = 0;
                    JOptionPane.showMessageDialog(null, "Maaf Nomor HP Harus Angka, Silahkan Edit, no Hp kami isikan dengan 0");
                }
                String jenisKelamin = menuInputPasien.getFieldInputJenisKelaminPasien().getText();
                String Keluhan = menuInputPasien.getFieldInputKeluhanPasien().getText();
                model.inputPasien(nama, alamat, noHp, jenisKelamin, Keluhan);
                JOptionPane.showMessageDialog(null, "Data Pasien Berhasil diinputkan");
                menuInputPasien.dispose();
                new ControllerMenuPasien(model);
            }
        }
    }
    
}
