/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuRuangan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuRuangan implements ActionListener{
    private Aplikasi model;
    private MenuRuangan menuRuangan;

    public ControllerMenuRuangan(Aplikasi model) {
        this.model = model;
        menuRuangan = new MenuRuangan();
        menuRuangan.setVisible(true);
        menuRuangan.addListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuRuangan.getButtonKembaliRuangan())){
            menuRuangan.dispose();
                new ControllerMenuUtama(model);
        }
        
        if (source.equals(menuRuangan.getButtonInputRuangan())){
            menuRuangan.dispose();
            new ControllerMenuInputRuangan(model);
        }
        
//        if (source.equals((menuRuangan.getButtonEditRuangan()))){
//            menuRuangan.dispose();
////            new ControllerMenuCariRuanganPasienInap(model);
//        }
        
        if (source.equals(menuRuangan.getButtonViewRuangan())){
            menuRuangan.dispose();
            new ControllerMenuViewRuangan(model);
        }
        
        if (source.equals(menuRuangan.getButtonDeleteRuangan())){
            menuRuangan.dispose();
            new ControllerMenuCariRuangan(model);
        }
    }
    
}
