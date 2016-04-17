/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuViewPasienInap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tubes_pbo_13.Ruangan;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuViewPasienInap implements ActionListener{
    private Aplikasi model;
    private MenuViewPasienInap menuViewPasienInap;
    private Ruangan r;

    public ControllerMenuViewPasienInap(Aplikasi model) {
        this.model = model;
        menuViewPasienInap = new MenuViewPasienInap();
        menuViewPasienInap.addListener(this);
        menuViewPasienInap.setVisible(true);
        r = model.getCariRuangan();
        menuViewPasienInap.getListPasienInap().setListData(model.getDaftarPasienInapArray(r));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuViewPasienInap.getBtnKembaliViewPasienInap())){
            menuViewPasienInap.dispose();
            new ControllerMenuPasienInap(model);
        }
    }
}
