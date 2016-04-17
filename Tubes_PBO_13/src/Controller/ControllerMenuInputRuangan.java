/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuInputRuangan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuInputRuangan implements ActionListener{
    private Aplikasi model;
    private MenuInputRuangan menuInputRuangan;

    public ControllerMenuInputRuangan(Aplikasi model) {
        this.model = model;
        menuInputRuangan = new MenuInputRuangan();
        menuInputRuangan.addListener(this);
        menuInputRuangan.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuInputRuangan.getBtnBatalInputRuangan())){
            menuInputRuangan.dispose();
            new ControllerMenuRuangan(model);
        }
        
        if (source.equals(menuInputRuangan.getBtnSelesaiInputRuangan())){
            if (menuInputRuangan.getFieldInputNamaRuangan().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Nama Ruangan Harus diinputkan");
            }
            else if (menuInputRuangan.getFieldInputKapasitasRuangan().getText().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Kapasitas Ruangan Harus diinputkan");
            }
            else{
                String nama = menuInputRuangan.getFieldInputNamaRuangan().getText();
                int kapasitas = 0;
                try{
                kapasitas = Integer.parseInt(menuInputRuangan.getFieldInputKapasitasRuangan().getText());
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Maaf Kapasitas Ruangan Harus Angka, Silahkan Edit, kapasitas kami isikan dengan 0");
                }
                model.inputRuangan(kapasitas, nama);
                JOptionPane.showMessageDialog(null, "Data Ruangan Berhasil diinputkan");
                menuInputRuangan.dispose();
                new ControllerMenuRuangan(model);
                
            }
        }
    }
}
