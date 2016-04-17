/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuViewRuanganTersedia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuViewRuanganTersedia implements ActionListener{
    private Aplikasi model;
    private MenuViewRuanganTersedia menuViewRuanganTersedia;

    public ControllerMenuViewRuanganTersedia(Aplikasi model) {
        this.model = model;
        menuViewRuanganTersedia = new MenuViewRuanganTersedia();
        menuViewRuanganTersedia.addListener(this);
        menuViewRuanganTersedia.setVisible(true);
        this.model.setRuanganTersedia();
        menuViewRuanganTersedia.getListRuanganTersedia().setListData(model.getDaftarRuanganTersediaArray());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuViewRuanganTersedia.getBtnKembaliViewRuanganTersedia())){
            menuViewRuanganTersedia.dispose();
            new ControllerMenuPasienInap(model);
        }
    }
    
}
