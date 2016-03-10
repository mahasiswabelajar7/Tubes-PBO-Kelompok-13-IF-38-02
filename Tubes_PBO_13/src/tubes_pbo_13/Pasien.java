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
public class Pasien extends Orang{
	private String idPasien;
	
	public Pasien(String idPasien, String nama, String alamat, long noHP, String jeniskelamin){
		super (nama, alamat, noHP, jeniskelamin);
		this.idPasien = idPasien;
	}
	public void setIdPasien(String idPasien){
		this.idPasien = idPasien;
	}
	public String getIdPasien(){
		return idPasien;
	}
}