package tubes_pbo_13;

public abstract class Orang{
	private String nama;
	private String alamat;
	private long noHP;
	private String jeniskelamin;
		
	public Orang( String nama, String alamat, long noHP, String jeniskelamin){
		this.nama = nama;
		this.alamat = alamat;
		this.noHP = noHP;
		this.jeniskelamin = jeniskelamin;
	}
	
	public void setNama(String nama){
		this.nama = nama;
	}
	public String getNama(){
		return nama;
	}
	public void setAlamat(String alamat){
		this.alamat = alamat;
	}
	public String getAlamat(){
		return alamat;
	}
	public void setNoHP(long noHP){
		this.noHP = noHP;
	}
	public long getNoHP(){
		return noHP;
	}
	public void setJenisKelamin(String jeniskelamin){
		this.jeniskelamin = jeniskelamin;
	}
	public String getJenisKelamin(){
		return jeniskelamin;
	}
}
