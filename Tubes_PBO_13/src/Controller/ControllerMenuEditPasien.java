/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuEditPasien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuEditPasien implements ActionListener{
    private Aplikasi model;
    private MenuEditPasien menuEditPasien;

    public ControllerMenuEditPasien(Aplikasi model) {
        this.model = model;
        menuEditPasien = new MenuEditPasien();
        menuEditPasien.addListener(this);
        menuEditPasien.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuEditPasien.getBtnBatalEditPasien())){
            menuEditPasien.dispose();
            new ControllerMenuPasien(model);
        }
        
        if (source.equals(menuEditPasien.getBtnSelesaiEditPasien())){
            if (menuEditPasien.getFieldEditNamaPasien().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf nama Harus diinputkan");
            } else if (menuEditPasien.getFieldEditAlamatPasien().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Alamat Harus diinputkan");
            } else if (menuEditPasien.getFieldEditNoHpPasien().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf No HP Harus diinputkan");
            } else if (menuEditPasien.getFieldEditJenisKelaminPasien().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Jenis Kelamin Harus diinputkan");
            } else if (menuEditPasien.getFieldEditKeluhanPasien().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Keluhan Harus diinputkan");
            } else{
                int i = 0;
                while (i < model.getDaftarPasien().size()){
                    if (model.getDaftarPasien().get(i).getIdPasien().equals(model.getCariPasien().getIdPasien())){
                        model.getDaftarPasien().get(i).setNama(menuEditPasien.getFieldEditNamaPasien().getText());
                        model.getDaftarPasien().get(i).setAlamat(menuEditPasien.getFieldEditAlamatPasien().getText());
                        try{
                        model.getDaftarPasien().get(i).setNoHP(Long.parseLong(menuEditPasien.getFieldEditNoHpPasien().getText()));
                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Maaf Nomor Hp Harus Angka, No Hp Kami Isikan dengan 0");
                        }
                        model.getDaftarPasien().get(i).setJenisKelamin(menuEditPasien.getFieldEditJenisKelaminPasien().getText());
                        model.getDaftarPasien().get(i).setRiwayatPenyakit(menuEditPasien.getFieldEditKeluhanPasien().getText());
                        JOptionPane.showMessageDialog(null, "Data Pasien Berhasil diedit");
                        menuEditPasien.dispose();
                        new ControllerMenuPasien(model);
                    }
                    i++;
                }
            }
        }
    }
    
}
