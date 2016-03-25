/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_pbo_13;

import java.util.ArrayList;

/**
 *
 * @author Anang Kur
 */
public class Ruangan{
	//definisi atribut
	//private PasienInap[] daftarPasien;
        private ArrayList<PasienInap> daftarPasienInap = new ArrayList<>();
	private int jumlahPasienInap;
	private int noRuangan;
	private String namaRuangan;
	//private int indexPasien = 0;
	
	//definisi method
	public Ruangan(int jumlahPasienInap, int noRuangan, String namaRuangan){
		//daftarPasien = new PasienInap[jumlahPasienInap];
		this.noRuangan = noRuangan;
		this.namaRuangan = namaRuangan;
                this.jumlahPasienInap = jumlahPasienInap;
            
	}
        
        public void setNamaRuangan(String namaRuangan){
            this.namaRuangan = namaRuangan;
        }
        
        public String getNamaRuangan(){
            return namaRuangan;
        }
        
        public void setNomorRuangan(int noRuangan){
            this.noRuangan = noRuangan;
        }
        
        public int getNomorRuangan(){
            return noRuangan;
        }
        
        public int getJumlahPasienInap(){
            return jumlahPasienInap;
        }
        
        /*public int getIndexPasien(){
            return indexPasien;
        }*/

	public void tambahPasienInap(Pasien p, Dokter d){
		/*daftarPasien[indexPasien] = new PasienInap(p,d);
		indexPasien++;*/
            PasienInap pasienInap = new PasienInap(p,d);
            daftarPasienInap.add(pasienInap);
	}
	public PasienInap getPasienInap(int n){
		//return daftarPasien[n];
            return daftarPasienInap.get(n);
	}
	public PasienInap getPasienInap(String cariIdPasien){
		/*int i=0;
		while(i < jumlahPasienInap && daftarPasien[i].getPasien().getIdPasien()!= cariIdPasien){
			i++;
		}
		return daftarPasien[i];*/
            int i = 0;
            while (i <= daftarPasienInap.size()){
                if (daftarPasienInap.get(i).getPasien().getIdPasien().equals(cariIdPasien)){
                    return daftarPasienInap.get(i);
                }
                i++;
            }
            return null;
	}
        
	public void removePasienInap(int n){
		/*daftarPasien[n] = null;
                indexPasien--;*/
            daftarPasienInap.remove(n);
	}
        public ArrayList getDaftarpasien(){
            return daftarPasienInap;
        }
}