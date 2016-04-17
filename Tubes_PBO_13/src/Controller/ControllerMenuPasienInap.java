/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuPasienInap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuPasienInap implements ActionListener{
    private Aplikasi model;
    private MenuPasienInap menuPasienInap;

    public ControllerMenuPasienInap(Aplikasi model) {
        this.model = model;
        menuPasienInap = new MenuPasienInap();
        menuPasienInap.addListener(this);
        menuPasienInap.setVisible(true);
    }

    public MenuPasienInap getMenuPasienInap() {
        return menuPasienInap;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuPasienInap.getButtonKembaliPasienInap())){
            menuPasienInap.dispose();
                new ControllerMenuUtama(model);
        }
        
        if (source.equals(menuPasienInap.getButtonTambahPasienInap())){
            menuPasienInap.dispose();
            new ControllerMenuTambahPasienInap(model);
        }
        
        if (source.equals(menuPasienInap.getButtonViewPasienInap())){
            menuPasienInap.dispose();
            new ControllerMenuCariRuangan(model);
        }
        
        if (source.equals(menuPasienInap.getButtonViewRuanganAvailable())){
            menuPasienInap.dispose();
            new ControllerMenuViewRuanganTersedia(model);
        }
        
        if (source.equals(menuPasienInap.getButtonDeletePasienInap())){
            menuPasienInap.dispose();
            new ControllerMenuCariRuangan(model);
        }
    }
    
    
}
