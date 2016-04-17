/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuViewDokter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuViewDokter implements ActionListener{
    private Aplikasi model;
    private MenuViewDokter menuViewDokter;

    public ControllerMenuViewDokter(Aplikasi model) {
        this.model = model;
        menuViewDokter = new MenuViewDokter();
        menuViewDokter.addListener(this);
        menuViewDokter.setVisible(true);
        menuViewDokter.getListDokter().setListData(model.getDaftarDokterArray());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuViewDokter.getBtnKembaliViewDokter())){
            menuViewDokter.dispose();
            new ControllerMenuDokter(model);
        }
    }
    
    
}
