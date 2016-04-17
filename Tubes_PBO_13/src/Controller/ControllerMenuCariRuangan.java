/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuCariRuangan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuCariRuangan implements ActionListener{
    private Aplikasi model;
    private MenuCariRuangan menuCariRuangan;

    public ControllerMenuCariRuangan(Aplikasi model) {
        this.model = model;
        menuCariRuangan = new MenuCariRuangan();
        menuCariRuangan.addListener(this);
        menuCariRuangan.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuCariRuangan.getBtnBatalCariRuangan())){
            menuCariRuangan.dispose();
            new ControllerMenuRuangan(model);
        }
        
        if (source.equals(menuCariRuangan.getBtnCariDeleteRuangan())){
//            model.setCariRuangan(model.cariNoRuangan(menuCariRuangan.getFieldCariRuangan().getText()));
            int i = 0;
            while (i < model.getDaftarRuangan().size()){
                if (model.getDaftarRuangan().get(i).getNomorRuangan().equals(menuCariRuangan.getFieldCariRuangan().getText())){
                    model.getDaftarRuangan().remove(i);
                    JOptionPane.showMessageDialog(null, "Delete Berhasil");
                    menuCariRuangan.dispose();
                    new ControllerMenuRuangan(model);
                }
                i++;
            }
            if (i == model.getDaftarRuangan().size()){
                JOptionPane.showMessageDialog(null, "Maaf Data Ruangan Tidak Ditemukan");
            }
        }
        if (source.equals(menuCariRuangan.getBtnCariEditRuangan())){
            model.setCariRuangan(model.cariNoRuangan(menuCariRuangan.getFieldCariRuangan().getText()));
            if (model.getCariRuangan() != null){
                new ControllerMenuEditRuangan(model);
                menuCariRuangan.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Maaf Data Ruangan Tidak ditemukan");
            }
        }
        
        if (source.equals(menuCariRuangan.getBtnCariRuangan())){
            if (menuCariRuangan.getFieldCariRuangan().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Nomor Pasien Harus diinputkan");
            }
            model.setCariRuangan(model.cariNoRuangan(menuCariRuangan.getFieldCariRuangan().getText()));
            if (model.getCariRuangan() != null){
                JOptionPane.showMessageDialog(null, "Ruangan ditemukan");
                new ControllerMenuViewPasienInap(model);
                menuCariRuangan.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Maaf Nomor Ruangan Tidak Ditemukan");
                
            }
        }
    }
    
}
