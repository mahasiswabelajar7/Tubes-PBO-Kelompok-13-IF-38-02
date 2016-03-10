
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_pbo_13;
import java.util.Scanner;

/**
 *
 * @author Anang Kur
 */
public class Tubes_PBO_13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dokter dokter1 = new Dokter("dokter 1","Lampung",1234567890,"Pria","Kulit","001");
        Dokter dokter2 = new Dokter("dokter 2","Lampung",1111111111,"Wanita","Penyakit Dalam","002");
        
        Pasien pasien1 = new Pasien(1, "pasien 1", "Bandung", 12345, "Pria");
        Pasien pasien2 = new Pasien(2, "pasien 2", "Makassar", 54321, "Pria");
        
        Ruangan ruangan1 = new Ruangan(2,1,"ruangan 1");
        
        ruangan1.tambahPasienInap(pasien1, dokter1);
        ruangan1.tambahPasienInap(pasien2, dokter1);
        
        ruangan1.getPasienInap(0).addDiagnosa("Batuk");
        ruangan1.getPasienInap(0).addDiagnosa("Pilek");
        ruangan1.getPasienInap(0).addDiagnosa("Demam");
        
        ruangan1.getPasienInap(1).addDiagnosa("Bintik Merah");
        ruangan1.getPasienInap(1).addDiagnosa("Demam Tinggi");
        ruangan1.getPasienInap(1).addDiagnosa("Menggigil");
        
        System.out.println("Data Ruangan");
        System.out.println("Ruangan 1");
        System.out.println("Nomor Ruangan: "+ruangan1.getNomorRuangan());
        System.out.println("Nama Ruangan: "+ruangan1.getNamaRuangan());
        System.out.println("Jumlah Pasien: "+ruangan1.getIndexPasien());
        System.out.println();
        int count = 0;
        while (count < ruangan1.getIndexPasien()){
            System.out.println("Pasien "+(count+1));
            System.out.println("Id: "+ruangan1.getPasienInap(count).getPasien().getIdPasien());
            System.out.println("Nama: "+ruangan1.getPasienInap(count).getPasien().getNama());
            System.out.println("Alamat: "+ruangan1.getPasienInap(count).getPasien().getAlamat());
            System.out.println("Diagnosa: ");
            int count2 = 0;
            while(count2 < ruangan1.getPasienInap(count).getIndexDiagnosa()){
                System.out.println((count2+1)+". "+ruangan1.getPasienInap(count).getDiagnosa(count2));
                count2++;
            }
            System.out.println();
            count++;
        }
        
     ruangan1.removePasienInap(1);
     ruangan1.getPasienInap(0).DeleteDiagnosa(2);
     
     System.out.println("Data Ruangan");
        System.out.println("Ruangan 1");
        System.out.println("Nomor Ruangan: "+ruangan1.getNomorRuangan());
        System.out.println("Nama Ruangan: "+ruangan1.getNamaRuangan());
        System.out.println("Jumlah Pasien: "+ruangan1.getIndexPasien());
        System.out.println();
        count = 0;
        while (count < ruangan1.getIndexPasien()){
            System.out.println("Pasien "+(count+1));
            System.out.println("Id: "+ruangan1.getPasienInap(count).getPasien().getIdPasien());
            System.out.println("Nama: "+ruangan1.getPasienInap(count).getPasien().getNama());
            System.out.println("Alamat: "+ruangan1.getPasienInap(count).getPasien().getAlamat());
            System.out.println("Diagnosa: ");
            int count2 = 0;
            while(count2 < ruangan1.getPasienInap(count).getIndexDiagnosa()){
                System.out.println((count2+1)+". "+ruangan1.getPasienInap(count).getDiagnosa(count2));
                count2++;
            }
            System.out.println();
            count++;
        }
        
        Scanner input1 = new Scanner(System.in);
        System.out.println("Masukkan Id Pasien: ");
        long cari = input1.nextLong();
        PasienInap ketemu = ruangan1.getPasienInap(cari);
    
        System.out.println("Id Pasien: "+ketemu.getPasien().getIdPasien());
        System.out.println("Nama Pasien: "+ketemu.getPasien().getNama());
        System.out.println("Jenis Kelamin: "+ketemu.getPasien().getJenisKelamin());
        System.out.println("Alamat: "+ketemu.getPasien().getAlamat());
        int count3 = 0;
        while (count3 < ruangan1.getPasienInap(cari).getIndexDiagnosa()){
            System.out.println((count3+1)+". "+ruangan1.getPasienInap(cari).getDiagnosa(count3));
            count3++;
        }
    }
}