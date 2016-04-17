/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuDokter;
import View.MenuUtama;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuUtama implements ActionListener{
private MenuUtama menuUtama;
private Aplikasi model;

public ControllerMenuUtama(Aplikasi model){
    this.model = model;
    menuUtama = new MenuUtama();
    menuUtama.setVisible(true);
    menuUtama.addListener(this);
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();
        if (source.equals(menuUtama.getButtonDokter())){
            menuUtama.dispose();
            new ControllerMenuDokter(model);
        }
        
        if (source.equals(menuUtama.getButtonPasien())){
            menuUtama.dispose();
            new ControllerMenuPasien(model);
        }
        
        if (source.equals(menuUtama.getButtonRuangan())){
            menuUtama.dispose();
            new ControllerMenuRuangan(model);
        }
        
        if (source.equals(menuUtama.getButtonPasienInap())){
            menuUtama.dispose();
            new ControllerMenuPasienInap(model);
        }
        
        if (source.equals(menuUtama.getButtonKeluar())){
            menuUtama.dispose();
        }
    }
    
}
