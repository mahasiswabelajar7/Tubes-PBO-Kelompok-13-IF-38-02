/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuCariPasienInap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuCariPasienInap implements ActionListener{
    private Aplikasi model;
    private MenuCariPasienInap menuCariPasienInap;

    public ControllerMenuCariPasienInap(Aplikasi model) {
        this.model = model;
        menuCariPasienInap = new MenuCariPasienInap();
        menuCariPasienInap.addListener(this);
        menuCariPasienInap.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuCariPasienInap.getBtnBatalCariPasienInap())){
            menuCariPasienInap.dispose();
            new ControllerMenuPasienInap(model);
        }
    }
    
}
