/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes_pbo_13;

/**
 *
 * @author Anang Kur
 */
public class Ruangan{
	//definisi atribut
	private PasienInap[] daftarPasien;
	private int jumlahPasienInap;
	private int noRuangan;
	private String namaRuangan;
	private int indexRuangan;
	
	//definisi method
	public Ruangan(int jumlahPasienInap, int noRuangan, String NamaRuangan){
		PasienInap[] daftarPasien=new PasienInap[jumlahPasienInap];
		this.noRuangan=noRuangan;
		this.namaRuangan=namaRuangan;
	}
	public void tambahPasienInap(Pasien p, Dokter d){
		daftarPasien[indexRuangan]=new PasienInap(p,d);
		indexRuangan++;
	}
	public PasienInap getPasienInap(int n){
		return daftarPasien[n];
	}
	public PasienInap getPasienInap(String cariIdPasien){
		int i=0;
		while(i<=jumlahPasienInap && daftarPasien[i].getPasien().getIdPasien()!=cariIdPasien){
			i++;
		}
		return daftarPasien[i];
	}
	public void RemovePasienInap(int n){
		daftarPasien[n]=null;
	}
}