package tubes_pbo_13;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    /*public static void main(String[] args){
     Scanner scanner1 = new Scanner(System.in);
     int pilih = 1;
     System.out.println("Menu");
     System.out.println("1. Pasien");
     System.out.println("2. Dokter");
     System.out.println("3. Ruangan");
     System.out.println("4. Keluar");
     System.out.print("Pilih: ");
     try{
     pilih = scanner1.nextInt();
     }
     catch (Exception e){
     System.out.println("Maaf Input Salah"+e);
     }
     finally{
     switch (pilih){
     case 1 : 
     System.out.println("Pasien");
     System.out.println("1. Input Data Pasien");
     System.out.println("2. Lihat Data Pasien");
     System.out.println("3. Edit Data Pasien");
     System.out.println("4. Delete Data Pasien");
     System.out.println("5. Kembali");
     System.out.print("Pilih: ");
     pilih = scanner1.nextInt();
                                
     switch (pilih){
     case 1: 
     System.out.println("Input Data Pasien");
                        
     case 2: 
     System.out.println("Lihat Data Pasien");
                        
     case 3:
     System.out.println("Edit Pasien");
                        
     case 4:
     System.out.println("Hapus Data Pasien");
                        
     }
     case 2:
     System.out.println("Dokter");
     System.out.println("1. Input Data Dokter");
     System.out.println("2. Lihat Data Pasien");
     System.out.println("3. Edit Data Pasien");
     System.out.println("4. Delete Data Pasien");
     System.out.println("5. Kembali");
     System.out.print("Pilih: ");
                
     pilih = scanner1.nextInt();
     switch (pilih){
     case 1:
     System.out.println("Input Data Dokter");
     case 2:
     System.out.println("lihat Data Dokter");
     case 3:
     System.out.println("Edit Data Dokter");
     case 4:
     System.out.println("Delete Data Dokter");
                        
     }
     case 3:
     System.out.println("Ruangan");
     System.out.println("1. Input Data Ruangan");
     System.out.println("2. Lihat Data Ruangan");
     System.out.println("3. Edit Data Ruangan");
     System.out.println("4. Delete Data Ruangan");
     System.out.println("5. Kembali");
     System.out.print("Pilih: ");
     switch (pilih){
     case 1:
     System.out.println("Input Data Ruangan");
     case 2:
     System.out.println("Lihat Data Ruangan");
     case 3:
     System.out.println("Edit Data Ruangan");
     case 4:
     System.out.println("Delete Data Ruangan");
                        
     }
     case 4:
     System.exit(0);
                
     }
     }
     }*/


    private ArrayList<Dokter> daftarDokter = new ArrayList<>();
    private ArrayList<Pasien> daftarPasien = new ArrayList<>();
    private ArrayList<Ruangan> daftarRuangan = new ArrayList<>();
    int i;
    
    public void addDokter(String nama, String alamat, long noHP, String jeniskelamin, String spesialis, String idDokter) {
        Dokter dokter = new Dokter(nama, alamat, noHP, jeniskelamin, spesialis, idDokter);
        daftarDokter.add(dokter);
    }
    
    public Dokter getDokter(String id) {
        /*int i = 0;
        while (i <= idxD && daftarDokter[i].getIdDokter() != id) {
            i++;
        }
        return daftarDokter[i];*/
        i = 0;
        while (i <= daftarDokter.size()){
            if (daftarDokter.get(i).getIdDokter().equals(id)){
                return daftarDokter.get(i);
            }
            i++;
        }
        return null;
    }
    
        public void removeDokter(String id) {
        i = 0;
        while (i <= daftarDokter.size()){
            if (daftarDokter.get(i).getIdDokter().equals(id)){
                daftarDokter.remove(i);
            }
            i++;
        }
    }

    public void addPasien(String idPasien, String nama, String alamat, long noHP, String jeniskelamin) {
        Pasien pasien = new Pasien(idPasien, nama, alamat, noHP, jeniskelamin);
        daftarPasien.add(pasien);
    }
    
    public Pasien getPasien(String id) {
        /*while (i <= idxP && daftarPasien[i].getIdPasien() != id) {
            i++;
        }
        return daftarPasien[i];*/
        i = 0;
        while (i <= daftarPasien.size()){
            if (daftarPasien.get(i).getIdPasien().equals(id)){
                return daftarPasien.get(i);
            }
            i++;
        }
        return null;
    }
    
    public void removePasien(String id){
        i = 0;
        while (i <= daftarPasien.size()){
            if (daftarPasien.get(i).getIdPasien().equals(id)){
                daftarPasien.remove(i);
            }
        }
    }

    public void addRuangan(int jumlahPasienInap, int noRuangan, String namaRuangan) {
        Ruangan ruangan = new Ruangan(jumlahPasienInap, noRuangan, namaRuangan);
        daftarRuangan.add(ruangan);
    }
    
    public Ruangan getRuangan(int id){
        i = 0;
        while (i <= daftarRuangan.size()){
            if (daftarRuangan.get(i).getNomorRuangan() == id){
                return daftarRuangan.get(id);
            }
        }
        return null;
    }

    /*@Override
    public String toString() {
        String a = null, b = null, c = null;

        return a + b + c;*/
//return "Console{" + "daftarDokter=" + daftarDokter + ", daftarPasien=" + daftarPasien + ", daftarRuangan=" + daftarRuangan + '}';
    }


