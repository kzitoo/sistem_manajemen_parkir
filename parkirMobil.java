// IMPORT LIBRARY //
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.util.Scanner;
// IMPORT LIBRARY END //

public class parkirMobil {
    // BUAT OBJEK BARU //
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    // BUAT OBJEK BARU END //

    // DEKLRASI VARIABEL GLOBAL //
    boolean isRunning = true;
    private int jumlahLantai = 2;
    private int jumlahSlot = 5;
    private String[][] noTiket = new String[jumlahLantai][jumlahSlot];
    private boolean[][] statusParkir = new boolean[jumlahLantai][jumlahSlot];;
    private String[][] nomorPlat = new String[jumlahLantai][jumlahSlot];
    private LocalDateTime[][] waktuMasuk = new LocalDateTime[jumlahLantai][jumlahSlot];
    private boolean isOn = true;
    // DEKLARASI VARIABEL GLOBAL END//

    public int getJumlahLantai() {
        return jumlahLantai; // Mengembalikan Value Variabel jumlahLantai //
    }

    public int getJumlahSlot() {
        return jumlahSlot; // Mengembalikan Value Variabel jumlahSlot //
    }

    public void setJumlahLantai(int lantai) {
        this.jumlahLantai = lantai;
        statusParkir = new boolean[jumlahLantai][jumlahSlot]; // Membuat Array Baru // 
        nomorPlat = new String[jumlahLantai][jumlahSlot]; // Membuat Array Baru // 
    }

    public void setJumlahSlot(int slot) {
        this.jumlahSlot = slot;
        statusParkir = new boolean[jumlahLantai][jumlahSlot]; // Membuat Array Baru // 
        nomorPlat = new String[jumlahLantai][jumlahSlot]; // Membuat Array Baru // 
    }

    // METHOD pause //
    void pause(Scanner input) {
        System.out.print("\nTekan ENTER untuk kembali ke menu...");
        input.nextLine();
    }
    // METHOD pause END //

    public boolean getStatusOn(){
        return isOn; // Mengembalikan Value Variabel isOn //
    }

    public void setAuto(boolean isOnParamter){
        this.isOn = isOnParamter; // Melakukan Assignment Ke Variabel Global isOn //
    }

    //METHOD menuPertama //
    void menuPertama() {
        Scanner input = new Scanner(System.in);  // Buat Object Scanner //
        boolean isMenuPertamaRunning = true; // Deklarasi Varibel isMenuPertamaRunning Dengan Value "True"; //

        while (isMenuPertamaRunning) { // Kode Dijalankan Selama Variabel isMenuPertamaRunning Bernilai "True" //
            clearConsole.clear();  // Memanggil Method clear di Class clearConsole //
            System.out.println("======== SLOT PARKIR MOBIL ========");
            garisBatas.garis(); // Memanggil Method garis di Class garisBatas //

            for (int i = 0; i < jumlahLantai; i++) { // Perulangan Dilakukan Hingga i Kurang Dari jumlahLantai // 
                System.out.println("Lantai " + (i + 1));
                System.out.print("|");
                for (int j = 0; j < jumlahSlot; j++) { // Perulangan Dilakukan Hingga j Kurang Dari jumlahSlot //
                    System.out.printf("%8s  |", !statusParkir[i][j] ? "Kosong" : nomorPlat[i][j]);
                }
                System.out.println("\n");
            }

            garisBatas.garis(); // Memanggil Method garis di Class garisBatas //
            System.out.println("1. Tambah Mobil Masuk");
            System.out.println("2. Keluarkan Mobil");
            System.out.println("3. Edit Data Kendaraan");
            System.out.println("4. Lihat Detail Parkir");
            System.out.println("5. Kembali");
            System.out.print("Masukkan Pilihan Anda (1-5): ");

            int pilihan = input.nextInt();  // Meminta Inputan Pilihan Menu //
            input.nextLine();

            switch (pilihan) {
                case 1:  // Jika Pilihan = 1 //
                    tambahMobil(input);  // Memanggil Method tambahMobil //
                    break;
                case 2:  // Jika Pilihan = 2 //
                    hapusMobil(input);  // Memanggil Method hapusMobil //
                    break;
                case 3:
                    editMobil(input);
                    break;
                case 4:  // Jika Pilihan = 3 //
                    detailParkir(input); // Memanggil Method detailParkir //
                    break;
                case 5:  // Jika Pilihan = 4 //
                    isMenuPertamaRunning = false; // Nilai Varibel isMenuPertamaRunning di Assign "False"
                    break;
                default: // Jika Pilihan Bukan 1-4 //
                    System.out.println("Pilihan Tidak Valid, Coba Ulangi Lagi!");
                    pause(input); //  // Memanggil Method pause //
            }
        }
    }

    void tambahMobil(Scanner input) {
        if(isOn){ // Kode Dijalankan Jika Variabel Global isOn Bernilai "True" //
            for (int i = 0; i < jumlahLantai; i++) { // Perulangan Dilakukan Hingga i Kurang Dari jumlahLantai // 
                for (int j = 0; j < jumlahSlot; j++) { // Perulangan Dilakukan Hingga j Kurang Dari jumlahSlot // 
                    if (!statusParkir[i][j]) { // Kode Dijalan Jika Array Global statusParkir[i][j] Bernilai = "False" //
                        System.out.print("\nMasukkan Nomor Plat: ");
                        String inputPlat = input.nextLine().toUpperCase(); // Meminta Inputan Nomor Plat dan Mengubahnya Menjadi UpperCase //

                        for (int x = 0; x < jumlahLantai; x++) { // Perulangan Dilakukan Hingga x Kurang Dari jumlahLantai // 
                            for (int y = 0; y < jumlahSlot; y++) { // Perulangan Dilakukan Hingga y Kurang Dari jumlahLantai // 
                                if (inputPlat.equals(nomorPlat[x][y])) { // Kode Dijalan Jika Array Global nomorPlat[x][y] Memiliki Nilai Yang Sama Dengan inputPlat //
                                    System.out.println("Error Duplikat Nomor Plat!");
                                    pause(input); // Memanggil Method pause //
                                    return; // Melakukan Return Maka Method tambahMobil Akan Berhenti //
                                }
                            }
                        }

                        nomorPlat[i][j] = inputPlat;
                        noTiket[i][j] = "L" + (i + 1) + "S" + (j + 1) + LocalDateTime.now().getYear();;
                        statusParkir[i][j] = true;
                        waktuMasuk[i][j] = LocalDateTime.now();

                        String waktuMasukStr = waktuMasuk[i][j].format(formatter);
                        cetakTiket.tiketMasuk(noTiket[i][j], nomorPlat[i][j], "Mobil", i + 1, j + 1, waktuMasukStr);
                        pause(input); // Memanggil Method pause //
                        return; // Melakukan Return Maka Method tambahMobil Akan Berhenti //
                    }
                }
            }
            System.out.println("Parkiran Penuh!");
            pause(input); // Memanggil Method pause //
        }else{  // Kode Dijalankan Jika Variabel Global isOn Bernilai "False" //
            System.out.println("\nMasukan Lantai dan Slot Yang Anda Pilih (contoh: L1 S1): ");
            String pilLantai = input.next();
            String pilSlot = input.next(); // Meminta Inputan pilLantai dan pilSlot
            input.nextLine();

            int lantai = 0;
            int slot = 0;

            if (pilLantai.startsWith("L")) { // Kode Dijalankan Jika pilLantai Dimulai Dari "L"
                lantai = Integer.parseInt(pilLantai.substring(1, 2)) - 1; // Melakukan Parse String pilLantai Ke Integer dan Memotong String Dari Index Ke 1 Hinga Ke 1 //
            } else if (pilLantai.startsWith("S")) {  // Kode Dijalankan Jika pilLantai Dimulai Dari "S"
                slot = Integer.parseInt(pilLantai.substring(1, 2)) - 1;  // Melakukan Parse String pilLantai Ke Integer dan Memotong String Dari Index Ke 1 Hinga Ke 1 //
            } else{
                System.out.println("Inputan Anda Tidak Valid!");
                return; // Melakukan Return Maka Method tambahMobil Akan Berhenti //
            }

            if (pilSlot.startsWith("L")) {  // Kode Dijalankan Jika pilSlot Dimulai Dari "L"
                lantai = Integer.parseInt(pilSlot.substring(1, 2)) - 1; // Melakukan Parse String pilSlot Ke Integer dan Memotong String Dari Index Ke 1 Hinga Ke 1 //
            } else if (pilSlot.startsWith("S")) {  // Kode Dijalankan Jika pilSlot Dimulai Dari "S"
                slot = Integer.parseInt(pilSlot.substring(1, 2)) - 1; // Melakukan Parse String pilSlot Ke Integer dan Memotong String Dari Index Ke 1 Hinga Ke 1 //
            } else{
                System.out.println("Inputan Anda Tidak Valid!");
                return; // Melakukan Return Maka Method tambahMobil Akan Berhenti //
            }

            if(lantai < 0 || slot < 0){ // Kode Dijalankan Jika Jumlah Lantai dan Slot Kurang Dari 0 //
                System.out.println("Slot Parkir Tidak Tersedia!");
                pause(input); // Memanggil Method pause //
                return; // Melakukan Return Maka Method tambahMobil Akan Berhenti //
            }

            if(statusParkir[lantai][slot]){ // Kode Dijalankan Jika Array Global statusParkir[lantai][slot] Berniilai = "True" //
                System.out.println("Slot Parkir Tidak Tersedia!");
                pause(input); // Memanggil Method pause //
                return; // Melakukan Return Maka Method tambahMobil Akan Berhenti //
            }

            System.out.print("Masukan Nomor Plat: ");
            String inputPlat = input.nextLine().toUpperCase();  // Meminta Inputan Nomor Plat dan Mengubahnya Menjadi UpperCase //
            for (int i = 0; i < getJumlahLantai(); i++) {  // Perulangan Dilakukan Hingga i Kurang Dari jumlahLantai // 
                for (int j = 0; j < getJumlahSlot(); j++) { // Perulangan Dilakukan Hingga j Kurang Dari jumlahLantai // 
                    if (inputPlat.equals(nomorPlat[i][j])) { // Kode Dijalan Jika Array Global nomorPlat[i][j] Memiliki Nilai Yang Sama Dengan inputPlay // 
                        System.out.println("Error Duplikat Nomor Plat!");
                        pause(input); // Memanggil Method pause //
                        return; // Melakukan Return Maka Method tambahMobil Akan Berhenti //
                    }
                }
            }

            nomorPlat[lantai][slot] = inputPlat;
            noTiket[lantai][slot] = "L" + (lantai + 1) + "S" + (slot + 1) + LocalDateTime.now().getYear();;
            statusParkir[lantai][slot] = true;
            waktuMasuk[lantai][slot] = LocalDateTime.now();

            String waktuMasukStr = waktuMasuk[lantai][slot].format(formatter);
            cetakTiket.tiketMasuk(noTiket[lantai][slot], nomorPlat[lantai][slot], "Mobil", lantai + 1, slot + 1, waktuMasukStr);
            pause(input); // Memanggil Method pause //
        }
    }

    void hapusMobil(Scanner input) {
        System.out.print("\nMasukkan Plat Mobil Yang Akan Keluar: ");
        String platKeluar = input.nextLine().toUpperCase();  // Meminta Inputan Nomor Plat dan Mengubahnya Menjadi UpperCase //

        for (int i = 0; i < jumlahLantai; i++) { // Perulangan Dilakukan Hingga i Kurang Dari jumlahLantai // 
            for (int j = 0; j < jumlahSlot; j++) { // Perulangan Dilakukan Hingga j Kurang Dari jumlahLantai // 
                if (statusParkir[i][j] && nomorPlat[i][j].equals(platKeluar)) { // Kode Dijalankan Jika statusParkir[i][j] Bernilai = "True" dan nomorPlat[i][j] Bernilai Sama Dengan Value platKeluar //
                    String waktuMasukStr = waktuMasuk[i][j].format(formatter);
                    String waktuKeluarStr = LocalDateTime.now().format(formatter);
                    Duration durasiParkir = Duration.between(waktuMasuk[i][j], LocalDateTime.now());
                    long durasiParkirInMinute = durasiParkir.toMinutes();
                    long totalJam = (durasiParkirInMinute + 59) / 60;

                    int totalTarif;
                    if (totalJam <= 1) {
                        totalTarif = 7000;
                    } else {
                        totalTarif = 7000 + (int)(totalJam - 1) * 5000;
                    }

                    cetakTiket.tiketKeluar(noTiket[i][j], nomorPlat[i][j], "Mobil", i + 1, j + 1, waktuMasukStr, waktuKeluarStr, totalTarif);

                    noTiket[i][j] = null;
                    statusParkir[i][j] = false;
                    nomorPlat[i][j] = null;
                    waktuMasuk[i][j] = null;
                    pause(input); // Memanggil Method pause // 
                    return; // Melakukan Return Maka Method hapusMobil Akan Berhenti //
                }
            }
        }
        System.out.println("Mobil Dengan Plat " + platKeluar + " Tidak Ditemukan di Parkiran.");
        pause(input);  // Memanggil Method pause // 
    }

    void editMobil(Scanner input){
        System.out.print("\nMasukan Nomor Plat Mobil Yang Akan DiEdit: ");
        String noPlat = input.nextLine().toUpperCase();

        for (int i = 0; i < jumlahLantai; i++) {
            for (int j = 0; j < jumlahSlot; j++) {
                if (statusParkir[i][j] && nomorPlat[i][j].equals(noPlat)){
                    System.out.print("Masukan Nomor Plat Mobil Yang Baru: ");
                    nomorPlat[i][j] = input.nextLine().toUpperCase();
                    System.out.println("\nNomor Plat Berhasil Diubah Menjadi " + nomorPlat[i][j]);
                    pause(input);
                    return;
                }
            }
        }
        System.out.println("Mobil Dengan Plat " + noPlat + " Tidak Ditemukan di Parkiran.");
        pause(input); // Memanggil Method pause //
    }

    void detailParkir(Scanner input) {
        System.out.print("\nMasukkan Nomor Plat Mobil Yang Akan Dicek: "); 
        String platDetail = input.nextLine().toUpperCase(); // Meminta Inputan Nomor Plat dan Mengubahnya Menjadi UpperCase //

        for (int i = 0; i < jumlahLantai; i++) {  // Perulangan Dilakukan Hingga i Kurang Dari jumlahLantai // 
            for (int j = 0; j < jumlahSlot; j++) {  // Perulangan Dilakukan Hingga j Kurang Dari jumlahLantai // 
                if (statusParkir[i][j] && nomorPlat[i][j].equals(platDetail)) {  // Kode Dijalankan Jika statusParkir[i][j] Bernilai = "True" dan nomorPlat[i][j] Bernilai Sama Dengan Value platKeluar //
                    String waktuMasukStr = waktuMasuk[i][j].format(formatter);
                    cetakTiket.tiketMasuk(noTiket[i][j], nomorPlat[i][j], "Mobil", i + 1, j + 1, waktuMasukStr);
                    pause(input); // Memanggil Method pause //
                    return;  // Melakukan Return Maka Method hapusMobil Akan Berhenti //
                }
            }
        }
        System.out.println("Mobil Dengan Plat " + platDetail + " Tidak Ditemukan di Parkiran.");
        pause(input); // Memanggil Method pause //
        
    }

    void cekSlot(Scanner input){
        clearConsole.clear(); // Memanggil Method clear di Class clearConsole //
        System.out.println("======== SLOT PARKIR MOBIL ========");
        garisBatas.garis(); // Memanggil Method garis di Class garisBatas //

        for (int i = 0; i < jumlahLantai; i++) { // Perulangan Dilakukan Hingga i Kurang Dari jumlahLantai // 
            System.out.println("Lantai " + (i + 1));
            System.out.print("|"); 
            for (int j = 0; j < jumlahSlot; j++) { // Perulangan Dilakukan Hingga j Kurang Dari jumlahLantai // 
                System.out.printf("%8s  |", !statusParkir[i][j] ? "Kosong" : nomorPlat[i][j]); 
            }
            System.out.println("\n");
        }
        pause(input); // Memanggil Method pause //
    }



    public void pilihanMenuMobil() {
    Scanner input = new Scanner(System.in); // Membuat Objek Scanner //
    boolean runningMenuMobil = true; 

    while (runningMenuMobil) { // Kode Dijalankan Selama Variabel isMenuPertamaRunning Bernilai "True" //
        clearConsole.clear();
        System.out.println("======== MENU PARKIR MOBIL ========");
        garisBatas.garis();
        System.out.println("1. Parkir Mobil");
        System.out.println("2. Cek Slot Parkir Mobil");
        System.out.println("3. Kembali ke Menu Utama");
        System.out.print("Masukan pilihan Anda (1-3): ");

        int pilihan = input.nextInt();
        input.nextLine();

        switch (pilihan) {
            case 1: // Jika Pilihan = 1 //
                menuPertama();
                break;
            case 2: // Jika Pilihan = 2 //
                cekSlot(input);
                break;
            case 3: // Jika Pilihan = 3 //
                runningMenuMobil = false;
                break;
            default: // Jika Pilihan Bukan 1-3 //
                System.out.println("Pilihan Tidak Valid, Coba Ulangi Lagi!");
                pause(input);
            }
        }
    }
}
