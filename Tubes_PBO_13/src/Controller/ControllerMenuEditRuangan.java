/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuEditRuangan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuEditRuangan implements ActionListener{
    private Aplikasi model;
    private MenuEditRuangan menuEditRuangan;

    public ControllerMenuEditRuangan(Aplikasi model) {
        this.model = model;
        menuEditRuangan = new MenuEditRuangan();
        menuEditRuangan.addListener(this);
        menuEditRuangan.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuEditRuangan.getBtnBatalEditRuangan())){
            menuEditRuangan.dispose();
            new ControllerMenuCariRuangan(model);
        }
        
        if (source.equals(menuEditRuangan.getBtnSelesaiEditRuangan())) {
            if (menuEditRuangan.getFieldEditNamaRuangan().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf nama Harus diinputkan");
            } else
            if (menuEditRuangan.getFieldEditKapasitasRuangan().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Kapasitas Harus diinputkan");
            } else {
                int i = 0;
                while (i < model.getDaftarRuangan().size()){
                    if (model.getDaftarRuangan().get(i).getNomorRuangan().equals(model.getCariRuangan().getNomorRuangan())){
                        model.getDaftarRuangan().get(i).setNamaRuangan(menuEditRuangan.getFieldEditNamaRuangan().getText());
                        try{
                        model.getDaftarRuangan().get(i).setJumlahPasienInap(Integer.parseInt(menuEditRuangan.getFieldEditKapasitasRuangan().getText()));
                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Maaf Kapasitas Harus Angka, Kapasitas Kami Isikan dengan 0");
                        }
                        JOptionPane.showMessageDialog(null, "Data Ruangan Berhasil diedit");
                        menuEditRuangan.dispose();
                        new ControllerMenuRuangan(model);
                    }
                    i++;
                }
            }
        }
    }
    
}
