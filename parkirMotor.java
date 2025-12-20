import java.util.Scanner;

public class parkirMotor {
    boolean isRunning = true;

    private int jumlahLantai = 2;
    private int jumlahSlot = 5;
    private boolean[][] statusParkir = new boolean[jumlahLantai][jumlahSlot];;
    private String[][] nomorPlat = new String[jumlahLantai][jumlahSlot];

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


    void menuPertama() {
        Scanner input = new Scanner(System.in);
        boolean isMenuPertamaRunning = true;

        while (isMenuPertamaRunning) {
            clearConsole.clear();
            System.out.println("======== SLOT PARKIR MOTOR ========");
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
            System.out.println("1. Tambah Motor Masuk");
            System.out.println("2. Keluarkan Motor");
            System.out.println("3. Lihat Detail Parkir");
            System.out.println("4. Kembali");
            System.out.print("Masukkan Pilihan Anda (1-4): ");

            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahMotor(input);
                    break;
                case 2:
                    hapusMotor(input);
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

    void tambahMotor(Scanner input) {
        for (int i = 0; i < jumlahLantai; i++) {
            for (int j = 0; j < jumlahSlot; j++) {
                if (!statusParkir[i][j]) {
                    System.out.print("\nMasukkan Nomor Plat: ");
                    nomorPlat[i][j] = input.nextLine();
                    statusParkir[i][j] = true;
                    System.out.println("Berhasil Parkir di Lantai " + (i + 1) + " Slot " + (j + 1));
                    pause(input);
                    return;
                }
            }
        }
        System.out.println("Parkiran Penuh!");
        pause(input);
    }

    void hapusMotor(Scanner input) {
        System.out.print("\nMasukkan Plat Motor Yang Akan Keluar: ");
        String platKeluar = input.nextLine();

        for (int i = 0; i < jumlahLantai; i++) {
            for (int j = 0; j < jumlahSlot; j++) {
                if (statusParkir[i][j] && nomorPlat[i][j].equals(platKeluar)) {
                    statusParkir[i][j] = false;
                    nomorPlat[i][j] = null;
                    System.out.println("Motor Dengan Plat " + platKeluar + " Telah Keluar Dari Parkiran.");
                    pause(input);
                    return;
                }
            }
        }
        System.out.println("Motor Dengan Plat " + platKeluar + " Tidak Ditemukan di Parkiran.");
        pause(input);
    }

    void detailParkir(Scanner input) {
        System.out.print("\nMasukkan Nomor Plat Motor yang Akan Dicek: ");
        String platDetail = input.nextLine();

        for (int i = 0; i < jumlahLantai; i++) {
            for (int j = 0; j < jumlahSlot; j++) {
                if (statusParkir[i][j] && nomorPlat[i][j].equals(platDetail)) {
                    System.out.println("Motor Dengan Plat " + platDetail + " Berada Di Lantai " + (i + 1) + " Slot " + (j + 1));
                    pause(input);
                    return;
                }
            }
        }
        System.out.println("Motor Dengan Plat " + platDetail + " Tidak Ditemukan di Parkiran.");
        pause(input);
        
    }

    void cekSlot(Scanner input){
        clearConsole.clear();
        System.out.println("======== SLOT PARKIR MOTOR ========");
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



    public void pilihanMenuMotor() {
    Scanner input = new Scanner(System.in);
    boolean runningMenuMotor = true;

    while (runningMenuMotor) {
        clearConsole.clear();
        System.out.println("======== MENU PARKIR MOTOR ========");
        garisBatas.garis();
        System.out.println("1. Parkir Motor");
        System.out.println("2. Cek Slot Parkir Motor");
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
                runningMenuMotor = false;
                break;
            default:
                System.out.println("Pilihan Tidak Valid, Coba Ulangi Lagi!");
                pause(input);
            }
        }
    }

}
