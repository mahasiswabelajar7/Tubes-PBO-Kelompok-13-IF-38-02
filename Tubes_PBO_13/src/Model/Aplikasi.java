/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.FileDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import tubes_pbo_13.Dokter;
import tubes_pbo_13.Pasien;
import tubes_pbo_13.PasienInap;
import tubes_pbo_13.Ruangan;

/**
 *
 * @author Anang Kur
 */
public class Aplikasi implements Serializable{
    private ArrayList<Dokter> daftarDokter;
    private ArrayList<Pasien> daftarPasien;
    private ArrayList<Ruangan> daftarRuangan;
    private ArrayList<Ruangan> daftarRuanganTersedia;
    private Ruangan cariRuangan;
    private Dokter cariDokter;
    private Pasien cariPasien;
    private PasienInap cariPasienInap;
    private FileDatabase database;
//    String nama, alamat, jenisKelamin, spesialis;
//    long noHP;

    public Aplikasi(){
        //new ArrayList<Dokter>();
        daftarPasien = new ArrayList<Pasien>();
        daftarRuangan = new ArrayList<Ruangan>();
        database = new FileDatabase();
        daftarDokter = new ArrayList<Dokter>();
        daftarDokter = database.loadFileDokter();
    }
    
//    public void saveDokterFile(ArrayList<Dokter> tempDaftarDokter) throws FileNotFoundException, IOException{
//        FileOutputStream fos = new FileOutputStream("dataDokter.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(tempDaftarDokter);
//        oos.flush();
//    }
    
//    public void loadDokterFile(ArrayList<Dokter> tempDaftarDokter) throws FileNotFoundException, IOException, ClassNotFoundException{
//        FileInputStream fis = new FileInputStream("dataDokter.txt");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        tempDaftarDokter = (ArrayList<Dokter>) ois.readObject();
//    }

    public void setDaftarDokter(ArrayList<Dokter> daftarDokter) {
        this.daftarDokter = daftarDokter;
    }

    public void setDaftarPasien(ArrayList<Pasien> daftarPasien) {
        this.daftarPasien = daftarPasien;
    }

    public void setDaftarRuangan(ArrayList<Ruangan> daftarRuangan) {
        this.daftarRuangan = daftarRuangan;
    }

    public ArrayList<Dokter> getDaftarDokter() {
        return daftarDokter;
    }

    public ArrayList<Pasien> getDaftarPasien() {
        return daftarPasien;
    }

    public Ruangan getCariRuangan() {
        return cariRuangan;
    }

    public void setCariRuangan(Ruangan cariRuangan) {
        this.cariRuangan = cariRuangan;
    }

    public ArrayList<Ruangan> getDaftarRuanganTersedia() {
        return daftarRuanganTersedia;
    }

    public void setDaftarRuanganTersedia(ArrayList<Ruangan> daftarRuanganTersedia) {
        this.daftarRuanganTersedia = daftarRuanganTersedia;
    }

    public Dokter getCariDokter() {
        return cariDokter;
    }

    public void setCariDokter(Dokter cariDokter) {
        this.cariDokter = cariDokter;
    }

    public Pasien getCariPasien() {
        return cariPasien;
    }

    public void setCariPasien(Pasien cariPasien) {
        this.cariPasien = cariPasien;
    }

    public PasienInap getCariPasienInap() {
        return cariPasienInap;
    }

    public void setCariPasienInap(PasienInap cariPasienInap) {
        this.cariPasienInap = cariPasienInap;
    }
    
    public void inputDokter(String nama, String alamat, long noHP, String jeniskelamin, String spesialis){
        daftarDokter.add(new Dokter(nama, alamat, noHP, jeniskelamin, spesialis));
    }
    
    public void inputPasien(String nama, String alamat, long noHP, String jeniskelamin, String keluhan){
        daftarPasien.add(new Pasien(nama, alamat, noHP, jeniskelamin, keluhan));
    }
    
    public void inputRuangan(int jumlahPasienInap, String namaRuangan){
        daftarRuangan.add(new Ruangan(jumlahPasienInap, namaRuangan));
    }

    public Object[] getDaftarDokterArray() {
        int i = 0;
        String[] s = new String[100];
        for(Dokter d:daftarDokter){
            s[i] = d.getIdDokter()+", "+d.getNama()+", "+d.getSpesialis()+", "+d.getAlamat()+", "+d.getJenisKelamin()+", "+String.valueOf(d.getNoHP());
            i++;
        }
        return s;
    }

    public Object[] getDaftarPasienArray() {
        int i = 0;
        String[] s = new String[100];
        for(Pasien p:daftarPasien){
            s[i] = p.getIdPasien()+", "+p.getNama()+", "+p.getAlamat()+", "+p.getJenisKelamin()+", "+String.valueOf(p.getNoHP())+", "+p.getRiwayatPenyakit(i);
            i++;
        }
        return s;
    }

    public Object[] getDaftarRuanganArray() {
        int i = 0;
        String[] s = new String[100];
        for(Ruangan r:daftarRuangan){
            s[i] = r.getNomorRuangan()+", "+r.getNamaRuangan()+", "+r.getJumlahPasienInap();
            i++;
        }
        return s;
    }
    
    public Object[] getDaftarPasienInapArray(Ruangan r){
        int i = 0;
        String[] s = new String[100];
        while (i < r.getDaftarpasien().size()){
            s[i] = r.getPasienInap(i).getPasien().getNama()+", "+r.getPasienInap(i).getDokter().getNama();
            i++;
        }
        return s;
    }
    
    public Ruangan getRuangan(int i){
        return daftarRuangan.get(i);
    }
    
    public ArrayList<Ruangan> getDaftarRuangan(){
        return daftarRuangan;
    }
    
    public Dokter cariIdDokter(String id){
        int i = 0;
        Dokter d = null;
        if (daftarDokter.isEmpty()){
            JOptionPane.showMessageDialog(null, "Maaf Daftar Dokter Masih Kosong");
        }
        else {
            while (i < daftarDokter.size()) {
                if (daftarDokter.get(i).getIdDokter().equals(id)) {
                    d = daftarDokter.get(i);
                    break;
                } else {
                    d = null;
                }
                i++;
            }
        }
        return d;
    }
    
    public Pasien cariIdPasien(String id){
        int i = 0;
        Pasien p = null;
        if (daftarPasien.isEmpty()){
            JOptionPane.showMessageDialog(null, "Maaf DaftarPasien Masih Kosong");
        }
        else {
            while (i < daftarPasien.size()) {
                if (daftarPasien.get(i).getIdPasien().equals(id)) {
                    p = daftarPasien.get(i);
                    break;
                } else {
                    p = null;
                }
                i++;
            }

        }
        return p;
    }
    
    public Ruangan cariNoRuangan(String no){
        int i = 0;
        Ruangan r = null;
        if (daftarRuangan.isEmpty()){
            JOptionPane.showMessageDialog(null, "Maaf Daftar Ruangan Masih Kosong");
        }
        else {
            while (i < daftarRuangan.size()) {
                if (daftarRuangan.get(i).getNomorRuangan().equals(no)) {
                    r = daftarRuangan.get(i);
                    break;
                }
                else {
                    r = null;
                }
                i++;
            }
        }
        return r;
    }
    
    public void setRuanganTersedia(){
        daftarRuanganTersedia = new ArrayList<>();
        if (daftarRuangan.isEmpty()){
            JOptionPane.showMessageDialog(null, "Maaf Daftar Ruangan Masih Kosong");
        } else {
            int i = 0;
            while (i < daftarRuangan.size()) {
                if (daftarRuangan.get(i).getDaftarpasien().size() < daftarRuangan.get(i).getJumlahPasienInap()) {
                    daftarRuangan.get(i).setJumlahPasienInap(daftarRuangan.get(i).getJumlahPasienInap() - daftarRuangan.get(i).getDaftarpasien().size());
                    daftarRuanganTersedia.add(daftarRuangan.get(i));
                }
                i++;
            }
        }
    }
    
    public Object[] getDaftarRuanganTersediaArray() {
        int i = 0;
        String[] s = new String[100];
        for(Ruangan r:daftarRuanganTersedia){
            s[i] = r.getNomorRuangan()+", "+r.getNamaRuangan()+", "+r.getJumlahPasienInap();
            i++;
        }
        return s;
    }
    
    public void saveDataDokter(ArrayList<Dokter> dataDokter){
        database.saveFileDokter(dataDokter);
    }
    
    
    public ArrayList<Dokter> loadDataDokter(){
        return database.loadFileDokter();
    }
}
