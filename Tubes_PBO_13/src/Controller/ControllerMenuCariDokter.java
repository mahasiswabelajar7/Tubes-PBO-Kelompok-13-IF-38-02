   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuCariDokter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuCariDokter implements ActionListener{
    private Aplikasi model;
    private MenuCariDokter menuCariDokter;

    public ControllerMenuCariDokter(Aplikasi model) {
        this.model = model;
        menuCariDokter = new MenuCariDokter();
        menuCariDokter.addListener(this);
        menuCariDokter.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuCariDokter.getBtnBatalCariDokter())){
            menuCariDokter.dispose();
            new ControllerMenuDokter(model);
        }
        
        if (source.equals(menuCariDokter.getBtnCariDeleteDokter())){
            this.model.setCariDokter(model.cariIdDokter(menuCariDokter.getFieldCariDokter().getText()));
            int i = 0;
            while (i < model.getDaftarDokter().size()){
                if (model.getDaftarDokter().get(i).getIdDokter().equals(menuCariDokter.getFieldCariDokter().getText())){
                    model.getDaftarDokter().remove(i);
                    JOptionPane.showMessageDialog(null, "Delete Berhasil");
                    menuCariDokter.dispose();
                    new ControllerMenuDokter(model);
                }
                i++;
            }
            if (i == model.getDaftarDokter().size()){
                JOptionPane.showMessageDialog(null, "Maaf Data Dokter Tidak Ditemukan");
            }
        }
        
        if (source.equals(menuCariDokter.getBtnCariEditDokter())){
            model.setCariDokter(model.cariIdDokter(menuCariDokter.getFieldCariDokter().getText()));
            if (model.getCariDokter() != null){
                new ControllerMenuEditDokter(model);
                menuCariDokter.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Maaf Data Dokter Tidak ditemukan");
            }
        }
    }
    
}
