/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuCariPasien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuCariPasien implements ActionListener{
    private Aplikasi model;
    private MenuCariPasien menuCariPasien;

    public ControllerMenuCariPasien(Aplikasi model) {
        this.model = model;
        menuCariPasien = new MenuCariPasien();
        menuCariPasien.addListener(this);
        menuCariPasien.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source .equals(menuCariPasien.getBtnBatalCariPasien())){
            menuCariPasien.dispose();
            new ControllerMenuPasien(model);
        }
        
        if (source.equals(menuCariPasien.getBtnCariDeletePasien())){
            this.model.setCariPasien(model.cariIdPasien(menuCariPasien.getFieldCariPasien().getText()));
            int i = 0;
            while (i < model.getDaftarPasien().size()){
                if (model.getDaftarPasien().get(i).getIdPasien().equals(menuCariPasien.getFieldCariPasien().getText())){
                    model.getDaftarPasien().remove(i);
                    JOptionPane.showMessageDialog(null, "Delete Berhasil");
                    menuCariPasien.dispose();
                    new ControllerMenuPasien(model);
                }
                i++;
            }
            if (i == model.getDaftarPasien().size()){
                JOptionPane.showMessageDialog(null, "Maaf Data Dokter Tidak Ditemukan");
            }
        }
        if (source.equals(menuCariPasien.getBtnCariEditPasien())){
            model.setCariPasien(model.cariIdPasien(menuCariPasien.getFieldCariPasien().getText()));
            if (model.getCariPasien() != null){
                new ControllerMenuEditPasien(model);
                menuCariPasien.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Maaf Data Pasien Tidak ditemukan");
            }
        }
    }
    
}
