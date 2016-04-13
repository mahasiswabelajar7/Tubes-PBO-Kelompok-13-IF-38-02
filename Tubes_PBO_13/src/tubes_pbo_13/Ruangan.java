package tubes_pbo_13;

import java.util.ArrayList;

public class Ruangan{
	//definisi atribut
        private ArrayList<PasienInap> daftarPasienInap = new ArrayList<>();
	private int jumlahPasienInap;
	private String noRuangan;
        private static int no;
	private String namaRuangan;
	
	//definisi method
	public Ruangan(int jumlahPasienInap, String namaRuangan){
		noRuangan = "R-" +(++no);
		this.namaRuangan = namaRuangan;
                this.jumlahPasienInap = jumlahPasienInap;
	}
        
        public void setNamaRuangan(String namaRuangan){
            this.namaRuangan = namaRuangan;
        }
        
        public String getNamaRuangan(){
            return namaRuangan;
        }
                
        public String getNomorRuangan(){
            return noRuangan;
        }
        
        public int getJumlahPasienInap(){
            return jumlahPasienInap;
        }
        
	public void tambahPasienInap(Pasien p, Dokter d){
            if (daftarPasienInap.size() < jumlahPasienInap) {
                PasienInap pasienInap = new PasienInap(p, d);
                daftarPasienInap.add(pasienInap);
            } else {
                System.out.println("Maaf Ruangan Sudah Penuh");
            }
	}
        
	public PasienInap getPasienInap(int n){
            return daftarPasienInap.get(n);
	}
        
	public PasienInap getPasienInap(String cariIdPasien){
            int i = 0;
            while (i < daftarPasienInap.size()){
                if (daftarPasienInap.get(i).getPasien().getIdPasien().equals(cariIdPasien)){
                    return daftarPasienInap.get(i);
                }
                i++;
            }
            return null;
	}
        
	public void removePasienInap(int n){
            daftarPasienInap.remove(n);
	}
        
        public ArrayList getDaftarpasien(){
            return daftarPasienInap;
        }
        
        public void updateRuangan(int jumlahPasienInap, String namaRuangan){
            this.jumlahPasienInap = jumlahPasienInap;
            this.namaRuangan = namaRuangan;
        }
}