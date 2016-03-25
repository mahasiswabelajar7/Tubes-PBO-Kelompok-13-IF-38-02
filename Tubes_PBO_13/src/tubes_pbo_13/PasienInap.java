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
public class PasienInap{
	//definisi atribut
	//private int indexDiagnosa=0;
	private Pasien pasien;
	private	Dokter dokter;
	//private String[] diagnosa = new String[10];
        private ArrayList<String> diagnosa = new ArrayList<>();
	
	//definisi method
	
	public PasienInap(Pasien pasien, Dokter dokter){
		this.pasien=pasien;
		this.dokter=dokter;
	}
	
	public void setPasien(Pasien p){
		pasien=p;
	}
	
	public Pasien getPasien(){
		return pasien;
	}
	
	public void setDokter(Dokter d){
		dokter=d;
	}
	
	public Dokter getDokter(){
		return dokter;
	}
	
	public void addDiagnosa(String penyakit){
		diagnosa.add(penyakit);
	}
	
	public String getDiagnosa(int n){
		return diagnosa.get(n);
	}
	
	public void DeleteDiagnosa(int n){
		diagnosa.remove(n);
	}
        public ArrayList getJumlahDiagnosa(){
            return diagnosa;
        }
	
        /*
        public int getIndexDiagnosa(){
            return indexDiagnosa;
        }
        */
}
