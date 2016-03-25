package tubes_pbo_13;

import java.util.ArrayList;

public class Pasien extends Orang{
    private String idPasien;
    private static int intIdPasien;
    private ArrayList<String> riwayatPenyakit = new ArrayList<>();

    public Pasien(String nama, String alamat, long noHP, String jeniskelamin) {
        super(nama, alamat, noHP, jeniskelamin);
        idPasien = "P-" + (++intIdPasien);
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setRiwayatPenyakit(String Penyakit) {
        riwayatPenyakit.add(Penyakit);
    }

    public String getRiwayatPenyakit(int id) {
        return riwayatPenyakit.get(id);
    }
    
    public void updatePasien(String nama, String alamat, long noHP, String jeniskelamin){
        super.setNama(nama);
        super.setAlamat(alamat);
        super.setNoHP(noHP);
        super.setJenisKelamin(jeniskelamin);
    }
}