package tubes_pbo_13;

import java.io.Serializable;

public class Dokter extends Orang implements Serializable{
	private String spesialis;
	private String idDokter;
        private static int intIdDokter;
	
	public Dokter(String nama, String alamat, long noHP, String jeniskelamin, String spesialis){
		super(nama, alamat, noHP, jeniskelamin);
		this.spesialis = spesialis;
		idDokter = "D-"+(++intIdDokter);
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
        public void updateDokter(String nama, String alamat, long noHP, String jeniskelamin, String spesialis){
            super.setNama(nama);
            super.setAlamat(alamat);
            super.setNoHP(noHP);
            super.setJenisKelamin(jeniskelamin);
            this.spesialis = spesialis;
        }
}