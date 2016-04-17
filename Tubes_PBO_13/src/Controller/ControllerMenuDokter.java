/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuDokter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuDokter implements ActionListener{
    private MenuDokter menuDokter;
    private Aplikasi model;

    public ControllerMenuDokter(Aplikasi model) {
        this.model = model;
        menuDokter = new MenuDokter();
        menuDokter.setVisible(true);
        menuDokter.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuDokter.getButtonKembaliDokter())){
            menuDokter.dispose();
                new ControllerMenuUtama(model);
        }
        
        if (source.equals(menuDokter.getButtonInputDokter())){
            menuDokter.dispose();
            new ControllerMenuInputDokter(model);
        }
        
        if (source.equals(menuDokter.getButtonEditDokter())){
            menuDokter.dispose();
            new ControllerMenuCariDokter(model);
        }
        
        if (source.equals(menuDokter.getButtonViewDokter())){
            menuDokter.dispose();
            new ControllerMenuViewDokter(model);
        }
        
        if (source.equals(menuDokter.getButtonDeleteDokter())){
            menuDokter.dispose();
            new ControllerMenuCariDokter(model);
        }
    }
    
}
