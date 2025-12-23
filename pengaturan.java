import java.lang.reflect.Parameter;
import java.util.Scanner;

public class pengaturan {
    parkirMobil parkirMobil;
    parkirMotor parkirMotor;

    public pengaturan(parkirMobil parkirMobil, parkirMotor parkirMotor) {
        this.parkirMobil = parkirMobil;
        this.parkirMotor = parkirMotor;
    }

    void ubahLantaiMobil(Scanner input) {
        boolean runningPilihan1 = true;
            while (runningPilihan1) {
                clearConsole.clear();
                System.out.println("\n======== UBAH JUMLAH LANTAI PARKIR ========");
                garisBatas.garis();
                System.out.println("1. Ubah Jumlah Lantai Parkir Mobil");
                System.out.println("2. Ubah Jumlah Lantai Parkir Motor");
                System.out.println("3. Kembali ke Menu Pengaturan");
                System.out.print("Masukkan Pilihan Anda (1-3): ");
                int pilihanMenu1 = input.nextInt();
                input.nextLine();
                switch (pilihanMenu1) {
                case 1:
                    System.out.println("\nJumlah Lantai Mobil Saat Ini Adalah: " + parkirMobil.getJumlahLantai());                    System.out.print("Masukkan Jumlah Lantai Baru: ");
                    int lantaiMobil = input.nextInt();
                    input.nextLine();
                    parkirMobil.setJumlahLantai(lantaiMobil);
                    System.out.println("Jumlah Lantai Parkir Mobil Berhasil Diubah!");
                    pause(input);
                    break;
                case 2:
                    System.out.println("\nJumlah Lantai Motor Saat Ini Adalah: " + parkirMotor.getJumlahLantai());
                    System.out.print("Masukkan Jumlah Lantai Baru: ");
                    int lantaiMotor = input.nextInt();
                    input.nextLine();
                    parkirMotor.setJumlahLantai(lantaiMotor);
                    System.out.println("Jumlah Lantai Parkir Motor Berhasil Diubah!");
                    pause(input);
                    break;
                case 3:
                    runningPilihan1 = false;
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid, Coba Ulangi Lagi!");
                    pause(input);
            }
        }
    }

    void ubahSlotParkir(Scanner input){
        boolean runningPilihan2 = true;
            while (runningPilihan2) {
                clearConsole.clear();
                System.out.println("\n======== UBAH JUMLAH LANTAI PARKIR ========");
                garisBatas.garis();
                System.out.println("1. Ubah Jumlah Slot Parkir Mobil");
                System.out.println("2. Ubah Jumlah Slot Parkir Motor");
                System.out.println("3. Kembali ke Menu Pengaturan");
                System.out.print("Masukkan Pilihan Anda (1-3): ");
                int pilihanMenu1 = input.nextInt();
                input.nextLine();
                switch (pilihanMenu1) {
                case 1:
                    System.out.println("\nJumlah Slot Mobil Saat Ini Adalah: " + parkirMobil.getJumlahSlot());                    System.out.print("Masukkan Jumlah Lantai Baru: ");
                    int slotMobil = input.nextInt();
                    input.nextLine();
                    parkirMobil.setJumlahSlot(slotMobil);
                    System.out.println("Jumlah Slot Parkir Mobil Berhasil Diubah!");
                    pause(input);
                    break;
                case 2:
                    System.out.println("\nJumlah Slot Motor Saat Ini Adalah: " + parkirMotor.getJumlahSlot());
                    System.out.print("Masukkan Jumlah Slot Baru: ");
                    int slotMotor = input.nextInt();
                    input.nextLine();
                    parkirMotor.setJumlahSlot(slotMotor);
                    System.out.println("Jumlah Slot Parkir Motor Berhasil Diubah!");
                    pause(input);
                    break;
                case 3:
                    runningPilihan2 = false;
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid, Coba Ulangi Lagi!");
                    pause(input);
            }
        }
    }

    void autoParkir(Scanner input){
        boolean runningPilihan3 = true;
        boolean isOn = parkirMobil.getStatusOn();
        while (runningPilihan3) {
            System.out.printf("\nFitur Auto Parkir Anda Saat Ini Sedang %s", isOn? "Aktif" : "Nonaktif");
            System.out.printf("\nApakah Anda Ingin %s ? (y/n): ", isOn? "Menonaktifkan-nya" : "Mengaktifkan-nya");

            char inputPilihan = input.next().charAt(0);
            input.nextLine();
            if(isOn){
                if(inputPilihan == 'y'){
                    isOn = false;
                    parkirMobil.setAuto(isOn);
                    System.out.printf("\nFitur Auto Parkir Anda Sudah %s", isOn? "Aktif" : "Nonaktif");
                    runningPilihan3 = false;
                }else{
                    pause(input);
                    return;
                }
            }else{
                if(inputPilihan == 'y'){
                    isOn = true;
                    parkirMobil.setAuto(isOn);
                    System.out.printf("\nFitur Auto Parkir Anda Sudah %s", isOn? "Aktif" : "Nonaktif");
                    runningPilihan3 = false;
                }else{
                    pause(input);
                    return;
                }
            }
        }
        pause(input);
    }

    public void pengaturanParkir() {
        Scanner input = new Scanner(System.in);
        boolean runningPengaturan = true;

        while (runningPengaturan) {
            clearConsole.clear();
            System.out.println("======== PENGATURAN PARKIR ========");
            garisBatas.garis();
            System.out.println("1. Ubah Jumlah Lantai Parkir");
            System.out.println("2. Ubah Jumlah Slot Parkir per Lantai");
            System.out.println("3. Auto Parkir Kendaraan");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Masukkan Pilihan Anda (1-4): ");

            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    ubahLantaiMobil(input);
                    break;
                case 2:
                    ubahSlotParkir(input);
                    break;
                case 3:
                    autoParkir(input);
                    break;
                case 4:
                    runningPengaturan = false;
                    break;

                default:
                    System.out.println("Pilihan Tidak Valid, Coba Ulangi Lagi!");
                    pause(input);
            }
        }
    }

    void pause(Scanner input) {
        System.out.print("\nTekan ENTER untuk kembali...");
        input.nextLine();
    }
}
