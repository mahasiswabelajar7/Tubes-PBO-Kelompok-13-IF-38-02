/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuDeletePasienInap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuDeletePasienInap implements ActionListener{
    private Aplikasi model;
    private MenuDeletePasienInap menuDeletePasienInap;

    public ControllerMenuDeletePasienInap(Aplikasi model) {
        this.model = model;
        menuDeletePasienInap = new MenuDeletePasienInap();
        menuDeletePasienInap.addListener(this);
        menuDeletePasienInap.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuDeletePasienInap.getBtnBatalHapusPasienInap())){
            menuDeletePasienInap.dispose();
            new ControllerMenuDeletePasienInap(model);
        }
    }
    
}
