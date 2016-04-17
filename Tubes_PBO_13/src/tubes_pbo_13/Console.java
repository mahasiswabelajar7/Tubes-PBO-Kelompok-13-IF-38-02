package tubes_pbo_13;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    Scanner inputString = new Scanner(System.in);
    Scanner inputInteger = new Scanner(System.in);
    Scanner inputLong = new Scanner(System.in);
    Scanner inputChar = new Scanner(System.in);
    private ArrayList<Dokter> daftarDokter = new ArrayList<>();
    private ArrayList<Pasien> daftarPasien = new ArrayList<>();
    private ArrayList<Ruangan> daftarRuangan = new ArrayList<>();
    String inNama, inSpesialis, inAlamat, inJenisKelamin, inKeluhan, inNoRuangan, inIdPasien, inIdDokter;
    long inNoHp;
    int i, pilih, inJmlPasienInap;
    String sudah;

    public void addDokter(String nama, String alamat, long noHP, String jeniskelamin, String spesialis) {
        Dokter dokter = new Dokter(nama, alamat, noHP, jeniskelamin, spesialis);
        daftarDokter.add(dokter);
    }

    public Dokter getDokter(String id) {
        i = 0;
        while (i <= daftarDokter.size()) {
            if (daftarDokter.get(i).getIdDokter().equals(id)) {
                return daftarDokter.get(i);
            }
            i++;
        }
        return null;
    }

    public void removeDokter(String id) {
        i = 0;
        while (i <= daftarDokter.size()) {
            if (daftarDokter.get(i).getIdDokter().equals(id)) {
                daftarDokter.remove(i);
            }
            i++;
        }
    }

    public void addPasien(String nama, String alamat, long noHP, String jeniskelamin, String keluhan) {
        Pasien pasien = new Pasien(nama, alamat, noHP, jeniskelamin, keluhan);
        daftarPasien.add(pasien);
    }
    
    public void addPasien(String nama, String alamat, long noHP, String jeniskelamin) {
        Pasien pasien = new Pasien(nama, alamat, noHP, jeniskelamin);
        daftarPasien.add(pasien);
    }

    public Pasien getPasien(String id) {
        i = 0;
        while (i <= daftarPasien.size()) {
            if (daftarPasien.get(i).getIdPasien().equals(id)) {
                return daftarPasien.get(i);
            }
            i++;
        }
        return null;
    }

    public void removePasien(String id) {
        i = 0;
        while (i <= daftarPasien.size()) {
            if (daftarPasien.get(i).getIdPasien().equals(id)) {
                daftarPasien.remove(i);
            }
        }
    }

    public void addRuangan(int jumlahPasienInap, String namaRuangan) {
        Ruangan ruangan = new Ruangan(jumlahPasienInap, namaRuangan);
        daftarRuangan.add(ruangan);
    }

    public Ruangan getRuangan(String id) {
        i = 0;
        while (i <= daftarRuangan.size()) {
            if (daftarRuangan.get(i).getNomorRuangan().equals(id)) {
                return daftarRuangan.get(i);
            }
        }
        return null;
    }

    public void menu_1() {
        System.out.println("Dokter");
        System.out.println("1. Input Data Dokter");
        System.out.println("2. View Data Dokter");
        System.out.println("3. Edit Data Dokter");
        System.out.println("4. Delete Data Dokter");
        System.out.println("5. Kembali");
    }

    public void menu_2() {
        System.out.println("Pasien");
        System.out.println("1. Input Data Pasien");
        System.out.println("2. View Data Pasien");
        System.out.println("3. Edit Data Pasien");
        System.out.println("4. Delete Data Pasien");
        System.out.println("5. Kembali");
    }

    public void menu_3() {
        System.out.println("Ruangan");
        System.out.println("1. Input Data Ruangan");
        System.out.println("2. View Data Ruangan");
        System.out.println("3. Edit Data Ruangan");
        System.out.println("4. Delete Data Ruangan");
        System.out.println("5. Kembali");
    }

    public void menu_1_2() {
        if (daftarDokter.isEmpty()) {
            System.out.println("Dokter belum diinputkan");
        } else {
            System.out.println("View Data Dokter");
            System.out.println("");
            i = 0;
            while (i < daftarDokter.size()) {
                System.out.println((i+1)+". ");
                System.out.println("Id: " + daftarDokter.get(i).getIdDokter());
                System.out.println("Nama: " + daftarDokter.get(i).getNama());
                System.out.println("");
                i++;
            }
        }
    }

    public void menu_2_2() {
        if (daftarPasien.isEmpty()) {
            System.out.println("Maaf pasien belum diinputkan");
        } else {
            System.out.println("View Data Pasien");
            i = 0;
            while (i < daftarPasien.size()) {
                System.out.println((i+1)+". ");
                System.out.println("Id: " + daftarPasien.get(i).getIdPasien());
                System.out.println("Nama: " + daftarPasien.get(i).getNama());
                System.out.println("");
                i++;
            }
        }
    }

    public void menu_3_2() {
        if (daftarRuangan.isEmpty()) {
            System.out.println("Maaf ruangan belum diinputkan");
        } else {
            System.out.println("View Data Ruangan");
            i = 0;
            while (i < daftarRuangan.size()) {
                System.out.println((i+1)+". ");
                System.out.println("No Ruangan: " + daftarRuangan.get(i).getNomorRuangan());
                System.out.println("Nama: " + daftarRuangan.get(i).getNamaRuangan());
                System.out.println("Kapasitas Ruangan: " + daftarRuangan.get(i).getJumlahPasienInap());
                System.out.println("");
                i++;
            }
        }
    }

    public void mainMenu(String args[]) {
        String back1 = "y";
        while (back1.equals("y")) {
            System.out.println("Menu");
            System.out.println("1. Dokter");
            System.out.println("2. Pasien");
            System.out.println("3. Ruangan");
            System.out.println("4. Pasien Inap");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            try {
                pilih = inputInteger.nextInt();
            } catch (Exception e) {
                inputInteger.next();
            }
            switch (pilih) {
                case 1:
                    String back2 = "y";
                    while (back2.equals("y") || back2.equals("Y")) {
                        menu_1();
                        System.out.print("Pilih: ");
                        try {
                            pilih = inputInteger.nextInt();
                        } catch (Exception e) {
                            pilih = 0;
                            inputInteger.next();
                        }
                        switch (pilih) {
                            case 1:
                                String back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    System.out.println("Input Data Dokter");
                                    System.out.print("nama: ");
                                    inNama = inputString.nextLine();
                                    System.out.print("Spesialis: ");
                                    inSpesialis = inputString.nextLine();
                                    System.out.print("Alamat: ");
                                    inAlamat = inputString.nextLine();
                                    System.out.print("No Hp: ");
                                    try {
                                        inNoHp = inputLong.nextLong();
                                    } catch (Exception e) {

                                        inputLong.next();
                                        break;
                                    }
                                    System.out.print("Jenis Kelamin: ");
                                    inJenisKelamin = inputString.nextLine();
                                    addDokter(inNama, inAlamat, inNoHp, inJenisKelamin, inSpesialis);
                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 2:
                                back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    menu_1_2();
                                    if (daftarDokter.isEmpty() == false){
                                        System.out.print("Pilih: ");
                                        try {
                                            pilih = inputInteger.nextInt();
                                        } catch (Exception e) {
                                            inputInteger.next();
                                        }
                                        if (pilih < daftarDokter.size() + 1 && pilih > 0) {
                                            Dokter tempDokter = daftarDokter.get(pilih - 1);
                                            System.out.println("Id: " + daftarDokter.get(pilih - 1).getIdDokter());
                                            System.out.println("Nama: " + daftarDokter.get(pilih - 1).getNama());
                                            System.out.println("Alamat: " + daftarDokter.get(pilih - 1).getAlamat());
                                            System.out.println("Jenis Kelamin: " + daftarDokter.get(pilih - 1).getJenisKelamin());
                                            System.out.println("Spesialis: " + daftarDokter.get(pilih - 1).getSpesialis());
                                            System.out.println("");
                                        }
                                        else{
                                            System.out.println("Maaf inputn salah");
                                        }
                                    }
                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 3:
                                back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    if (daftarDokter.isEmpty()) {
                                        System.out.println("Maaf data dokter belum diinputkan");
                                        break;
                                    } else {
                                        System.out.println("Edit Data Dokter");
                                        System.out.print("Masukkan Id Dokter yang ingin diedit: ");
                                        String idCari = inputString.nextLine();
                                        i = 0;
                                        while (i < daftarDokter.size()) {
                                            if (daftarDokter.get(i).getIdDokter().equals(idCari)) {
                                                System.out.print("nama: ");
                                                inNama = inputString.nextLine();
                                                System.out.print("Spesialis: ");
                                                inSpesialis = inputString.nextLine();
                                                System.out.print("Alamat: ");
                                                inAlamat = inputString.nextLine();
                                                System.out.print("No Hp: ");
                                                try {
                                                    inNoHp = inputLong.nextLong();
                                                } catch (Exception e) {
                                                    inputLong.next();
                                                    break;
                                                }
                                                System.out.print("Jenis Kelamin: ");
                                                inJenisKelamin = inputString.nextLine();
                                                Dokter tempDokter = daftarDokter.get(i);
                                                tempDokter.updateDokter(inNama, inAlamat, inNoHp, inJenisKelamin, inSpesialis);
                                                daftarDokter.set(i, tempDokter);
                                                i++;
                                            }
                                            i++;
                                        }
                                        if (i == daftarDokter.size()) {
                                            System.out.println("Maaf data dokter tidak ditemukan");
                                        }
                                        System.out.print("Kembali..? (y/n) ");
                                        sudah = inputString.nextLine();
                                        if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                            System.out.println("Maaf Inputan salah");
                                            sudah = "n";
                                        }
                                        back2_1 = sudah;
                                    }
                                }
                                break;
                            case 4:
                                back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    if (daftarDokter.isEmpty()) {
                                        System.out.println("Maaf data dokter belum diinputkan");
                                    } else {
                                        System.out.println("Delete Data Dokter");
                                        System.out.print("Masukkan Id Dokter yg ingin didelete: ");
                                        String idCari = inputString.nextLine();
                                        i = 0;
                                        while (i < daftarDokter.size()) {
                                            if (daftarDokter.get(i).getIdDokter().equals(idCari)) {
                                                daftarDokter.remove(i);
                                                System.out.println("Delete Berhasil");
                                            }
                                            i++;
                                        }
                                        if (i == daftarDokter.size()){
                                            System.out.println("Maaf data dokter tidak ditemukan");
                                        }

                                    }
                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 5:
                                back1 = "y";
                                back2 = "n";
                                break;
                            default:
                                System.out.println("maaf inputan salah");
                                break;
                        }

                    }
                    break;
                case 2:
                    String back3 = "y";
                    while (back3.equals("y") || back3.equals("Y")) {
                        menu_2();
                        System.out.print("Pilih: ");
                        try {
                            pilih = inputInteger.nextInt();
                        } catch (Exception e) {
                            pilih = 0;
                            inputInteger.next();
                        }
                        switch (pilih) {
                            case 1:
                                String back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    System.out.println("Input Data Pasien");
                                    System.out.print("nama: ");
                                    inNama = inputString.nextLine();
                                    System.out.print("Alamat: ");
                                    inAlamat = inputString.nextLine();
                                    System.out.print("No Hp: ");
                                    try {
                                        inNoHp = inputLong.nextLong();
                                    } catch (Exception e) {
                                        inputLong.next();
                                        break;
                                    }
                                    System.out.print("Jenis Kelamin: ");
                                    inJenisKelamin = inputString.nextLine();
                                    System.out.print("Keluhan: ");
                                    inKeluhan = inputString.nextLine();
                                    addPasien(inNama, inAlamat, inNoHp, inJenisKelamin, inKeluhan);
                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 2:
                                back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    menu_2_2();
                                    if (daftarPasien.isEmpty() == false) {
                                        System.out.print("Pilih: ");
                                        try {
                                            pilih = inputInteger.nextInt();
                                        } catch (Exception e) {
                                            inputInteger.next();
                                        }
                                        if (pilih < daftarPasien.size() + 1 && pilih > 0) {
                                            Pasien tempPasien = daftarPasien.get(pilih - 1);
                                            System.out.println("Id: " + daftarPasien.get(pilih - 1).getIdPasien());
                                            System.out.println("Nama: " + daftarPasien.get(pilih - 1).getNama());
                                            System.out.println("Alamat: " + daftarPasien.get(pilih - 1).getAlamat());
                                            System.out.println("Jenis Kelamin: " + daftarPasien.get(pilih - 1).getJenisKelamin());
                                            int j = 0;
                                            System.out.println("Riwayat Penyakit: ");
                                            while (j < daftarPasien.get(pilih - 1).getDaftarRiwayatPenyakit().size()) {
                                                System.out.print((j + 1) + ". ");
                                                System.out.println(daftarPasien.get(pilih - 1).getRiwayatPenyakit(j));
                                                j++;
                                            }
                                        } else {
                                            System.out.println("Maaf inputn salah");
                                        }
                                    }
                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 3:
                                back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    System.out.println("Edit Data Pasien");
                                    System.out.print("Masukkan Id pasien yang ingin diedit: ");
                                    String idCari = inputString.nextLine();
                                    i = 0;
                                    while (i < daftarPasien.size()) {
                                        if (daftarPasien.get(i).getIdPasien().equals(idCari)) {
                                            System.out.print("nama: ");
                                            inNama = inputString.nextLine();
                                            System.out.print("Alamat: ");
                                            inAlamat = inputString.nextLine();
                                            System.out.print("No Hp: ");
                                            try {
                                                inNoHp = inputLong.nextLong();
                                            } catch (Exception e) {
                                                inputLong.next();
                                                break;
                                            }
                                            System.out.print("Jenis Kelamin: ");
                                            inJenisKelamin = inputString.nextLine();
                                            Pasien tempPasien = daftarPasien.get(i);
                                            tempPasien.updatePasien(inNama, inAlamat, inNoHp, inJenisKelamin);
                                            daftarPasien.set(i, tempPasien);
                                            i++;
                                        }
                                        i++;
                                    }
                                    if (i == daftarPasien.size()) {
                                        System.out.println("Maaf data pasien tidak ditemukan");
                                    }

                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 4:
                                back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    if (daftarPasien.isEmpty()) {
                                        System.out.println("Maaf data pasien belum diinputkan");
                                    } else {
                                        System.out.println("Delete Data Pasien");
                                        System.out.print("Masukkan Id Pasien yg ingin didelete: ");
                                        String idCari = inputString.nextLine();
                                        i = 0;
                                        while (i < daftarPasien.size()) {
                                            if (daftarPasien.get(i).getIdPasien().equals(idCari)) {
                                                daftarPasien.remove(i);
                                                System.out.println("Delete Berhasil");
                                            }
                                            i++;
                                        }
                                        if (i == daftarPasien.size()){
                                            System.out.println("Maaf data pasien tidak ditemukan");
                                        }

                                    }
                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 5:
                                back1 = "y";
                                back3 = "n";
                                break;
                            default:
                                System.out.println("maaf inputan salah");
                                break;
                        }
                    }
                    break;
                case 3:
                    String back4 = "y";
                    while (back4.equals("y") || back4.equals("Y")) {
                        menu_3();
                        System.out.print("Pilih: ");
                        try {
                            pilih = inputInteger.nextInt();
                        } catch (Exception e) {
                            pilih = 0;
                            inputInteger.next();
                        }
                        switch (pilih) {
                            case 1:
                                String back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    System.out.println("Input Data Ruangan");
                                    System.out.print("nama: ");
                                    inNama = inputString.nextLine();
                                    System.out.print("Jumlah Pasien Inap: ");
                                    try {
                                        inJmlPasienInap = inputInteger.nextInt();
                                    } catch (Exception e) {
                                        inputInteger.next();
                                        break;
                                    }
                                    addRuangan(inJmlPasienInap, inNama);
                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 2:
                                back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    menu_3_2();
                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 3:
                                back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    System.out.println("Edit Data Ruangan");
                                    System.out.print("Masukkan no ruangan yang ingin diedit: ");
                                    String idCari = inputString.nextLine();
                                    i = 0;
                                    while (i < daftarRuangan.size()) {
                                        if (daftarRuangan.get(i).getNomorRuangan().equals(idCari)) {
                                            System.out.print("nama: ");
                                            inNama = inputString.nextLine();
                                            System.out.print("Jumlah Pasien Inap: ");
                                            try {
                                                inJmlPasienInap = inputInteger.nextInt();
                                            } catch (Exception e) {
                                                inputInteger.next();
                                                break;
                                            }
                                            Ruangan tempRuangan = daftarRuangan.get(i);
                                            tempRuangan.updateRuangan(inJmlPasienInap, inNama);
                                            daftarRuangan.set(i, tempRuangan);
                                            i++;
                                        }
                                        i++;
                                    }
                                    if (i == daftarRuangan.size()) {
                                        System.out.println("Maaf data Ruangan tidak ditemukan");
                                    }

                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 4:
                                back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    if (daftarRuangan.isEmpty()) {
                                        System.out.println("Maaf data ruangan belum diinputkan");
                                    } else {
                                        System.out.println("Delete Data Ruangan");
                                        System.out.print("Masukkan No Ruangan yg ingin didelete: ");
                                        String idCari = inputString.nextLine();
                                        i = 0;
                                        while (i < daftarRuangan.size()) {
                                            if (daftarRuangan.get(i).getNomorRuangan().equals(idCari)) {
                                                daftarRuangan.remove(i);
                                                System.out.println("Delete Berhasil");
                                            }
                                            i++;
                                        }
                                    }
                                        if (i == daftarRuangan.size()){
                                            System.out.println("Maaf data ruangan tidak ditemukan");
                                        }
                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 5:
                                back1 = "y";
                                back4 = "n";
                                break;
                            default:
                                System.out.println("maaf inputan salah");
                                break;
                        }
                    }
                    break;
                case 4:
                    String back5 = "y";
                    while (back5.equals("y") || back5.equals("Y")) {
                        System.out.println("Pasien Inap");
                        System.out.println("1. Tambah Pasien Inap");
                        System.out.println("2. Hapus Pasien Inap");
                        System.out.println("3. Cek Ruangan Tersedia");
                        System.out.println("4. Lihat Pasien Inap");
                        System.out.println("5. Kembali");
                        System.out.print("Pilih: ");
                        try {
                            pilih = inputInteger.nextInt();
                        } catch (Exception e) {
                            pilih = 0;
                            inputInteger.next();
                        }
                        switch (pilih){
                            case 1:
                                String back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    Ruangan tempRuangan = null;
                                    Pasien tempPasien = null;
                                    Dokter tempDokter = null;

                                    if (daftarRuangan.isEmpty()) {
                                        System.out.println("Maaf Ruangan Belum diinputkan");
                                    } else {
                                        System.out.print("Masukkan No Ruangan: ");
                                        inNoRuangan = inputString.nextLine();
                                        i = 0;
                                        while (i < daftarRuangan.size() - 1 && daftarRuangan.get(i).getNomorRuangan().equals(inNoRuangan) == false) {
                                            i++;
                                        }
                                        if (daftarRuangan.get(i).getNomorRuangan().equals(inNoRuangan)) {
                                            tempRuangan = daftarRuangan.get(i);
                                            System.out.print("Masukkan Id Pasien: ");
                                            inIdPasien = inputString.nextLine();
                                            if (daftarPasien.isEmpty()) {
                                                System.out.println("Maaf Data Pasien Belum diinputkan");
                                            } else {
                                                int j = 0;
                                                while (j < daftarPasien.size() - 1 && daftarPasien.get(i).getIdPasien().equals(inIdPasien) == false) {
                                                    j++;
                                                }
                                                if (daftarPasien.get(j).getIdPasien().equals(inIdPasien)) {
                                                    tempPasien = daftarPasien.get(j);
                                                    System.out.print("Masukkan Id Dokter: ");
                                                    inIdDokter = inputString.nextLine();
                                                    if (daftarDokter.isEmpty()) {
                                                        System.out.println("Maaf Data Dokter Belum diinputkan");
                                                    } else {
                                                        int k = 0;
                                                        while (k < daftarDokter.size() - 1 && daftarDokter.get(k).getIdDokter().equals(inIdDokter) == false) {
                                                            k++;
                                                        }
                                                        if (daftarDokter.get(i).getIdDokter().equals(inIdDokter)) {
                                                            tempDokter = daftarDokter.get(k);
                                                        } else {
                                                            System.out.println("Maaf Data Dokter Tidak ditemukan");
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("Maaf Data Pasien Tidak ditemukan");
                                                }
                                            }
                                        } else {
                                            System.out.println("Maaf Data Ruangan Tidak Ditemukan");
                                        }
                                    }
                                    if (tempRuangan != null && tempPasien != null && tempDokter != null) {
                                        daftarRuangan.get(i).tambahPasienInap(tempPasien, tempDokter);
                                    }
                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 2:
                                back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    System.out.println("Masukkan Nomor Ruangan: ");
                                    inNoRuangan = inputString.nextLine();
                                    if (daftarRuangan.isEmpty()){
                                        System.out.println("Maaf Ruangan belum diinputkan");
                                    }
                                    else{
                                        System.out.print("Masukkan id Pasien yang ingin dihapus: ");
                                        
                                        i = 0;
                                        while (i < daftarRuangan.size() && daftarRuangan.get(i).getNomorRuangan().equals(inNoRuangan) == false){
                                            i++;
                                        }
                                        if (daftarRuangan.get(i).getNomorRuangan().equals(inNoRuangan)){
                                            System.out.print("Masukkan Id Pasien: ");
                                            inIdPasien = inputString.nextLine();
                                            if (daftarRuangan.isEmpty()){
                                                System.out.println("Maaf Pasien belum diinputkan");
                                            }
                                            else {
                                                int j = 0;
                                                while (i < daftarPasien.size() && daftarPasien.get(j).getIdPasien().equals(inIdPasien)) {
                                                    j++;
                                                }
                                                if (daftarPasien.get(j).getIdPasien().equals(inIdPasien)){
                                                    daftarRuangan.get(i).removePasienInap(j);
                                                }
                                                else{
                                                    System.out.println("Maaf Id Pasien tidak ditemukan");
                                                }
                                            }
                                        }
                                        else{
                                            System.out.println("Maaf data ruangan tidak ditemukan");
                                        }
                                    }
                                    
                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 3:
                                
                                back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    if (daftarRuangan.isEmpty()){
                                        System.out.println("Maaf Data Ruangan Belum diinputkan");
                                    }else{
                                    i = 0;
                                    while (i < daftarRuangan.size()){
                                        if (daftarRuangan.get(i).getDaftarpasien().size() != daftarRuangan.get(i).getJumlahPasienInap()){
                                            System.out.println((i+1)+". ");
                                            System.out.println("Nomor: "+daftarRuangan.get(i).getNomorRuangan());
                                            System.out.println("Nama: "+daftarRuangan.get(i).getNamaRuangan());
                                            System.out.println("Kapasitas: "+daftarRuangan.get(i).getJumlahPasienInap());
                                            System.out.println("Tersisa: "+(daftarRuangan.get(i).getJumlahPasienInap() - daftarRuangan.get(i).getDaftarpasien().size()));
                                            i++;
                                        }
                                    }
                                    }
                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 4:
                                
                                back2_1 = "n";
                                while (back2_1.equals("n") || back2_1.equals("N")) {
                                    
                                    if (daftarRuangan.isEmpty()){
                                        System.out.println("Maaf Data Ruangan Belum diinputkan");
                                    }else{
                                    i = 0;
                                    while (i < daftarRuangan.size()){
                                        if (daftarRuangan.get(i).getDaftarpasien().size() != daftarRuangan.get(i).getJumlahPasienInap()){
                                            System.out.println((i+1)+". ");
                                            System.out.println("Nomor: "+daftarRuangan.get(i).getNomorRuangan());
                                            System.out.println("Nama: "+daftarRuangan.get(i).getNamaRuangan());
                                            int j = 0;
                                            while(j < daftarRuangan.get(i).getJumlahPasienInap()){
                                                System.out.println((j+1)+". "+daftarRuangan.get(i).getDaftarpasien().get(j));
                                                j++;
                                            }
                                        }
                                    }
                                    }
                                    System.out.print("Kembali..? (y/n) ");
                                    sudah = inputString.nextLine();
                                    if (sudah.equals("y") == false && sudah.equals("Y") == false && sudah.equals("n") == false && sudah.equals("N") == false) {
                                        System.out.println("Maaf Inputan salah");
                                        sudah = "n";
                                    }
                                    back2_1 = sudah;
                                }
                                break;
                            case 5:
                                back1 = "y";
                                back5 = "n";
                                break;
                            default:
                                System.out.println("maaf inputan salah");
                                break;
                        }
                    }
                break;
                case 5:
                    System.exit(pilih);
                    break;
                default:
                    System.out.println("Maaf inputan salah");
                    back1 = "y";
                    break;
            }
        }
    }
}
