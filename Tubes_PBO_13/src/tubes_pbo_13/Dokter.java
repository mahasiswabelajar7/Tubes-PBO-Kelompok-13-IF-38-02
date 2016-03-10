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
public class Dokter extends Orang{
	private String spesialis;
	private String idDokter;
	
	public Dokter(String nama, String alamat, long noHP, String jeniskelamin, String spesialis, String idDokter){
		super(nama, alamat, noHP, jeniskelamin);
		this.spesialis = spesialis;
		this.idDokter = idDokter;
	}
	
	public void setSpesialis(String spesialis){
		this.spesialis = spesialis;
	}
	public String getSpesialis(){
		return spesialis;
	}
	public void setIdDokter(String idDokter){
		this.idDokter = idDokter;
	}
	public String getIdDokter(){
		return idDokter;
	}
}