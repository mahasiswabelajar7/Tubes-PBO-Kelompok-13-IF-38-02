/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuPasien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuPasien implements ActionListener{
    private MenuPasien menuPasien;
    private Aplikasi model;

    public ControllerMenuPasien(Aplikasi model) {
        this.model = model;
        menuPasien = new MenuPasien();
        menuPasien.setVisible(true);
        menuPasien.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuPasien.getButtonKembaliPasien())){
                new ControllerMenuUtama(model);
            menuPasien.dispose();
        }
        
        if (source.equals(menuPasien.getButtonInputPasien())){
            new ControllerMenuInputPasien(model);
            menuPasien.dispose();
        }
        
        if (source.equals(menuPasien.getButtonEditPasien())){
            new ControllerMenuCariPasien(model);
            menuPasien.dispose();
        }
        
        if (source.equals(menuPasien.getButtonViewPasien())){
            new ControllerMenuViewPasien(model);
            menuPasien.dispose();
        }
        
        if (source.equals(menuPasien.getButtonDeletePasien())){
            new ControllerMenuCariPasien(model);
            menuPasien.dispose();
        }
    }
    
}
