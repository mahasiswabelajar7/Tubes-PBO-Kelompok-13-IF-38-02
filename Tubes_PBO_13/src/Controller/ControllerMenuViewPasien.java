/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuViewPasien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuViewPasien implements ActionListener{
    private Aplikasi model;
    private MenuViewPasien menuViewPasien;

    public ControllerMenuViewPasien(Aplikasi model) {
        this.model = model;
        menuViewPasien = new MenuViewPasien();
        menuViewPasien.addListener(this);
        menuViewPasien.setVisible(true);
        menuViewPasien.getListPasien().setListData(model.getDaftarPasienArray());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuViewPasien.getBtnKembaliViewPasien())){
            menuViewPasien.dispose();
            new ControllerMenuPasien(model);
        }
        
        
    }
    
}
