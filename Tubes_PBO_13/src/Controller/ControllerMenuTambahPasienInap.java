/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import View.MenuTambahPasienInap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import tubes_pbo_13.Dokter;
import tubes_pbo_13.Pasien;
import tubes_pbo_13.Ruangan;

/**
 *
 * @author Anang Kur
 */
public class ControllerMenuTambahPasienInap implements ActionListener{
    private Aplikasi Model;
    private MenuTambahPasienInap menuTambahPasienInap;

    public ControllerMenuTambahPasienInap(Aplikasi Model) {
        this.Model = Model;
        menuTambahPasienInap = new MenuTambahPasienInap();
        menuTambahPasienInap.addListener(this);
        menuTambahPasienInap.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        Ruangan r = null;
        Dokter d = null;
        Pasien p = null;
        
        if (source.equals(menuTambahPasienInap.getBtnBatalTambahPasienInap())) {
            menuTambahPasienInap.dispose();
            new ControllerMenuPasienInap(Model);
        }
        if (source.equals(menuTambahPasienInap.getBtnSelesaiTambahPasienInap())) {
            if (menuTambahPasienInap.getFieldInputCariNoRuanganTambahPasienInap().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf no Ruangan Harus diisi");
            } else {
                r = Model.cariNoRuangan(menuTambahPasienInap.getFieldInputCariNoRuanganTambahPasienInap().getText());
            }
            if (menuTambahPasienInap.getFieldInputCariIdPasienTambahPasienInap().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf Id Pasien Harus diinputkan");
            } else {
                p = Model.cariIdPasien(menuTambahPasienInap.getFieldInputCariIdPasienTambahPasienInap().getText());
            }
            if (menuTambahPasienInap.getFieldInputCariIdDokterTambahPasienInap().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf Id Dokter Harus diinputkan");
            } else {
                d = Model.cariIdDokter(menuTambahPasienInap.getFieldInputCariIdDokterTambahPasienInap().getText());
            }
            if (r == null) {
                JOptionPane.showMessageDialog(null, "Maaf Data Ruangan Tidak ditemukan");
            } else if (d == null) {
                JOptionPane.showMessageDialog(null, "Maaf data Dokter Tidak ditemukan");
            } else if (p == null) {
                JOptionPane.showMessageDialog(null, "Maaf data Pasien tidak ditemukan");
            } else if (r.getDaftarpasien().size() >= r.getJumlahPasienInap()) {
                JOptionPane.showMessageDialog(null, "Maaf Ruangan Penuh");
            } else {
                r.tambahPasienInap(p, d);
                JOptionPane.showMessageDialog(null, "Data Pasien Inap Berhasil diinputkan");
            }
        }
    }
    
}
