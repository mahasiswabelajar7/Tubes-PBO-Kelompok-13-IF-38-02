/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuEditDokter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuEditDokter implements ActionListener{
    private Aplikasi model;
    private MenuEditDokter menuEditDokter;

    public ControllerMenuEditDokter(Aplikasi model) {
        this.model = model;
        menuEditDokter = new MenuEditDokter();
        menuEditDokter.addListener(this);
        menuEditDokter.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source.equals(menuEditDokter.getBtnBatalEditDokter())){
            menuEditDokter.dispose();
            new ControllerMenuDokter(model);
        }
        
        if (source.equals(menuEditDokter.getBtnSelesaiEditDokter())){
            if (menuEditDokter.getFieldEditNamaDokter().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf nama Harus diinputkan");
            } else if (menuEditDokter.getFieldEditSpesialisDokter().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Spesialis Harus diinputkan");
            } else if (menuEditDokter.getFieldEditAlamatDokter().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Spesialis Harus diinputkan");
            } else if (menuEditDokter.getFieldEditAlamatDokter().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Alamat Harus diinputkan");
            } else if (menuEditDokter.getFieldEditNoHpDokter().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf No Hp Harus diinputkan");
            } else if (menuEditDokter.getFieldEditJenisKelaminDokter().equals("")){
                JOptionPane.showMessageDialog(null, "Maaf Jenis Kelamin Harus diinputkan");
            } else{
                int i = 0;
                while (i < model.getDaftarDokter().size()){
                    if (model.getDaftarDokter().get(i).getIdDokter().equals(model.getCariDokter().getIdDokter())){
                        model.getDaftarDokter().get(i).setNama(menuEditDokter.getFieldEditNamaDokter().getText());
                        model.getDaftarDokter().get(i).setSpesialis(menuEditDokter.getFieldEditSpesialisDokter().getText());
                        model.getDaftarDokter().get(i).setAlamat(menuEditDokter.getFieldEditAlamatDokter().getText());
                        try{
                        model.getDaftarDokter().get(i).setNoHP(Long.parseLong(menuEditDokter.getFieldEditNoHpDokter().getText()));
                        } catch (Exception ex){
                            JOptionPane.showMessageDialog(null, "Maaf Nomor Hp Harus Angka, No Hp Kami Isikan dengan 0");
                        }
                        model.getDaftarDokter().get(i).setJenisKelamin(menuEditDokter.getFieldEditJenisKelaminDokter().getText());
                        JOptionPane.showMessageDialog(null, "Data Dokter Berhasil diedit");
                        menuEditDokter.dispose();
                        new ControllerMenuDokter(model);
                    }
                    i++;
                }
            }
        }
    }    
}
