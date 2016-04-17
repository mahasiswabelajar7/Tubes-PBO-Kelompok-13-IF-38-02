/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuViewRuangan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuViewRuangan implements ActionListener{
    private Aplikasi model;
    private MenuViewRuangan menuViewRuangan;

    public ControllerMenuViewRuangan(Aplikasi model) {
        this.model = model;
        menuViewRuangan = new MenuViewRuangan();
        menuViewRuangan.addListener(this);
        menuViewRuangan.setVisible(true);
        menuViewRuangan.getListRuangan().setListData(model.getDaftarRuanganArray());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source .equals(menuViewRuangan.getBtnKembaliViewRuangan())){
            menuViewRuangan.dispose();
            new ControllerMenuRuangan(model);
        }
    }
    
}
