import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

import java.util.Scanner;

public class parkirMobil {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");


    boolean isRunning = true;

    private int jumlahLantai = 2;
    private int jumlahSlot = 5;
    private String[][] noTiket = new String[jumlahLantai][jumlahSlot];
    private boolean[][] statusParkir = new boolean[jumlahLantai][jumlahSlot];;
    private String[][] nomorPlat = new String[jumlahLantai][jumlahSlot];
    private LocalDateTime[][] waktuMasuk = new LocalDateTime[jumlahLantai][jumlahSlot];

    private boolean isOn = true;

    public int getJumlahLantai() {
        return jumlahLantai;
    }

    public int getJumlahSlot() {
        return jumlahSlot;
    }

    public void setJumlahLantai(int lantai) {
        this.jumlahLantai = lantai;
        statusParkir = new boolean[jumlahLantai][jumlahSlot];
        nomorPlat = new String[jumlahLantai][jumlahSlot];
    }

    public void setJumlahSlot(int slot) {
        this.jumlahSlot = slot;
        statusParkir = new boolean[jumlahLantai][jumlahSlot];
        nomorPlat = new String[jumlahLantai][jumlahSlot];
    }


    void pause(Scanner input) {
        System.out.print("\nTekan ENTER untuk kembali ke menu...");
        input.nextLine();
    }

    public boolean getStatusOn(){
        return isOn;
    }

    public void setAuto(boolean isOnParamter){
        this.isOn = isOnParamter;
    }

    void menuPertama() {
        Scanner input = new Scanner(System.in);
        boolean isMenuPertamaRunning = true;

        while (isMenuPertamaRunning) {
            clearConsole.clear();
            System.out.println("======== SLOT PARKIR MOBIL ========");
            garisBatas.garis();

            for (int i = 0; i < jumlahLantai; i++) {
                System.out.println("Lantai " + (i + 1));
                System.out.print("|");
                for (int j = 0; j < jumlahSlot; j++) {
                    System.out.printf("%8s  |", !statusParkir[i][j] ? "Kosong" : nomorPlat[i][j]);
                }
                System.out.println("\n");
            }

            garisBatas.garis();
            System.out.println("1. Tambah Mobil Masuk");
            System.out.println("2. Keluarkan Mobil");
            System.out.println("3. Lihat Detail Parkir");
            System.out.println("4. Kembali");
            System.out.print("Masukkan Pilihan Anda (1-4): ");

            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahMobil(input);
                    break;
                case 2:
                    hapusMobil(input);
                    break;
                case 3:
                    detailParkir(input);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Pilihan Tidak Valid, Coba Ulangi Lagi!");
                    pause(input);
            }
        }
    }

    void tambahMobil(Scanner input) {
        if(isOn){        
            for (int i = 0; i < jumlahLantai; i++) {
                for (int j = 0; j < jumlahSlot; j++) {
                    if (!statusParkir[i][j]) {
                        System.out.print("\nMasukkan Nomor Plat: ");
                        nomorPlat[i][j] = input.nextLine().toUpperCase();
                        noTiket[i][j] = "L" + (i + 1) + "S" + (j + 1) + LocalDateTime.now().getYear();;
                        statusParkir[i][j] = true;
                        waktuMasuk[i][j] = LocalDateTime.now();

                        String waktuMasukStr = waktuMasuk[i][j].format(formatter);
                        cetakTiket.tiketMasuk(noTiket[i][j], nomorPlat[i][j], "Mobil", i + 1, j + 1, waktuMasukStr);
                        pause(input);
                        return;
                    }
                }
            }
            System.out.println("Parkiran Penuh!");
            pause(input);
        }else{
            System.out.println("\nMasukan Lantai dan Slot Yang Anda Pilih (contoh: L1 S1): ");
            String pilLantai = input.next();
            String pilSlot = input.next();
            input.nextLine();

            int lantai = 0;
            int slot = 0;

            if (pilLantai.startsWith("L")) {
                lantai = Integer.parseInt(pilLantai.substring(1)) - 1;
            } else if (pilLantai.startsWith("S")) {
                slot = Integer.parseInt(pilLantai.substring(1)) - 1;
            }

            if (pilSlot.startsWith("L")) {
                lantai = Integer.parseInt(pilSlot.substring(1)) - 1;
            } else if (pilSlot.startsWith("S")) {
                slot = Integer.parseInt(pilSlot.substring(1)) - 1;
            }

            if(lantai < 0 || slot < 0){
                System.out.println("Slot Parkir Tidak Tersedia!");
                pause(input);
                return;
            }

            if(statusParkir[lantai][slot]){
                System.out.println("Slot Parkir Tidak Tersedia!");
                pause(input);
                return;
            }
            System.out.print("Masukan Nomor Plat: ");
            nomorPlat[lantai][slot] = input.nextLine().toUpperCase();
            noTiket[lantai][slot] = "L" + (lantai + 1) + "S" + (slot + 1) + LocalDateTime.now().getYear();;
            statusParkir[lantai][slot] = true;
            waktuMasuk[lantai][slot] = LocalDateTime.now();

            String waktuMasukStr = waktuMasuk[lantai][slot].format(formatter);
            cetakTiket.tiketMasuk(noTiket[lantai][slot], nomorPlat[lantai][slot], "Mobil", lantai + 1, slot + 1, waktuMasukStr);
            pause(input);
        }
    }

    void hapusMobil(Scanner input) {
        System.out.print("\nMasukkan Plat Mobil Yang Akan Keluar: ");
        String platKeluar = input.nextLine();

        for (int i = 0; i < jumlahLantai; i++) {
            for (int j = 0; j < jumlahSlot; j++) {
                if (statusParkir[i][j] && nomorPlat[i][j].equals(platKeluar)) {
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
                    pause(input);
                    return;
                }
            }
        }
        System.out.println("Mobil Dengan Plat " + platKeluar + " Tidak Ditemukan di Parkiran.");
        pause(input);
    }

    void detailParkir(Scanner input) {
        System.out.print("\nMasukkan Nomor Plat Mobil Yang Akan Dicek: ");
        String platDetail = input.nextLine().toUpperCase();

        for (int i = 0; i < jumlahLantai; i++) {
            for (int j = 0; j < jumlahSlot; j++) {
                if (statusParkir[i][j] && nomorPlat[i][j].equals(platDetail)) {
                    String waktuMasukStr = waktuMasuk[i][j].format(formatter);
                    cetakTiket.tiketMasuk(noTiket[i][j], nomorPlat[i][j], "Mobil", i + 1, j + 1, waktuMasukStr);
                    pause(input);
                    return;
                }
            }
        }
        System.out.println("Mobil Dengan Plat " + platDetail + " Tidak Ditemukan di Parkiran.");
        pause(input);
        
    }

    void cekSlot(Scanner input){
        clearConsole.clear();
        System.out.println("======== SLOT PARKIR MOBIL ========");
        garisBatas.garis();

        for (int i = 0; i < jumlahLantai; i++) {
            System.out.println("Lantai " + (i + 1));
            System.out.print("|");
            for (int j = 0; j < jumlahSlot; j++) {
                System.out.printf("%8s  |", !statusParkir[i][j] ? "Kosong" : nomorPlat[i][j]);
            }
            System.out.println("\n");
        }

        pause(input);
    }



    public void pilihanMenuMobil() {
    Scanner input = new Scanner(System.in);
    boolean runningMenuMobil = true;

    while (runningMenuMobil) {
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
            case 1:
                menuPertama();
                break;
            case 2:
                cekSlot(input);
                break;
            case 3:
                runningMenuMobil = false;
                break;
            default:
                System.out.println("Pilihan Tidak Valid, Coba Ulangi Lagi!");
                pause(input);
            }
        }
    }
}
