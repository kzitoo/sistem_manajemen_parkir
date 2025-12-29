// IMPORT LIBRARY //
import java.util.Scanner;
// IMPORT LIBRARY END //

public class pengaturan {

    // DEKLARASI OBJEK CLASS PARKIR //
    parkirMobil parkirMobil;
    parkirMotor parkirMotor;
    // DEKLARASI OBJEK CLASS PARKIR END //

    // CONSTRUCTOR CLASS pengaturan //
    public pengaturan(parkirMobil parkirMobil, parkirMotor parkirMotor) {
        this.parkirMobil = parkirMobil; // Melakukan Assignment Ke Variabel Global parkirMobil //
        this.parkirMotor = parkirMotor; // Melakukan Assignment Ke Variabel Global parkirMotor //
    }
    // CONSTRUCTOR CLASS pengaturan END //

    // METHOD ubahLantaiMobil //
    void ubahLantaiMobil(Scanner input) {
        boolean runningPilihan1 = true; // Deklarasi Variabel runningPilihan1 Dengan Value "True" //
        while (runningPilihan1) { // Kode Dijalankan Selama Variabel runningPilihan1 Bernilai "True" //
            clearConsole.clear(); // Memanggil Method clear Di Class clearConsole //
            System.out.println("\n======== UBAH JUMLAH LANTAI PARKIR ========");
            garisBatas.garis(); // Memanggil Method garis Di Class garisBatas //
            System.out.println("1. Ubah Jumlah Lantai Parkir Mobil");
            System.out.println("2. Ubah Jumlah Lantai Parkir Motor");
            System.out.println("3. Kembali ke Menu Pengaturan");
            System.out.print("Masukkan Pilihan Anda (1-3): ");

            int pilihanMenu1 = input.nextInt(); // Meminta Inputan Pilihan Menu //
            input.nextLine();

            switch (pilihanMenu1) {
                case 1: // Jika Pilihan = 1 //
                    System.out.println("\nJumlah Lantai Mobil Saat Ini Adalah: " + parkirMobil.getJumlahLantai());
                    System.out.print("Masukkan Jumlah Lantai Baru: ");
                    int lantaiMobil = input.nextInt(); // Meminta Inputan Jumlah Lantai Mobil //
                    input.nextLine();
                    parkirMobil.setJumlahLantai(lantaiMobil); // Mengubah Jumlah Lantai Parkir Mobil //
                    System.out.println("Jumlah Lantai Parkir Mobil Berhasil Diubah!");
                    pause(input); // Memanggil Method pause //
                    break;

                case 2: // Jika Pilihan = 2 //
                    System.out.println("\nJumlah Lantai Motor Saat Ini Adalah: " + parkirMotor.getJumlahLantai());
                    System.out.print("Masukkan Jumlah Lantai Baru: ");
                    int lantaiMotor = input.nextInt(); // Meminta Inputan Jumlah Lantai Motor //
                    input.nextLine();
                    parkirMotor.setJumlahLantai(lantaiMotor); // Mengubah Jumlah Lantai Parkir Motor //
                    System.out.println("Jumlah Lantai Parkir Motor Berhasil Diubah!");
                    pause(input); // Memanggil Method pause //
                    break;

                case 3: // Jika Pilihan = 3 //
                    runningPilihan1 = false; // Menghentikan Perulangan //
                    break;

                default: // Jika Pilihan Bukan 1-3 //
                    System.out.println("Pilihan Tidak Valid, Coba Ulangi Lagi!");
                    pause(input); // Memanggil Method pause //
            }
        }
    }
    // METHOD ubahLantaiMobil END //

    // METHOD ubahSlotParkir //
    void ubahSlotParkir(Scanner input){
        boolean runningPilihan2 = true; // Deklarasi Variabel runningPilihan2 Dengan Value "True" //
        while (runningPilihan2) { // Kode Dijalankan Selama Variabel runningPilihan2 Bernilai "True" //
            clearConsole.clear(); // Memanggil Method clear Di Class clearConsole //
            System.out.println("\n======== UBAH JUMLAH LANTAI PARKIR ========");
            garisBatas.garis(); // Memanggil Method garis Di Class garisBatas //
            System.out.println("1. Ubah Jumlah Slot Parkir Mobil");
            System.out.println("2. Ubah Jumlah Slot Parkir Motor");
            System.out.println("3. Kembali ke Menu Pengaturan");
            System.out.print("Masukkan Pilihan Anda (1-3): ");

            int pilihanMenu1 = input.nextInt(); // Meminta Inputan Pilihan Menu //
            input.nextLine();

            switch (pilihanMenu1) {
                case 1: // Jika Pilihan = 1 //
                    System.out.println("\nJumlah Slot Mobil Saat Ini Adalah: " + parkirMobil.getJumlahSlot());
                    System.out.print("Masukkan Jumlah Lantai Baru: ");
                    int slotMobil = input.nextInt(); // Meminta Inputan Jumlah Slot Mobil //
                    input.nextLine();
                    parkirMobil.setJumlahSlot(slotMobil); // Mengubah Jumlah Slot Parkir Mobil //
                    System.out.println("Jumlah Slot Parkir Mobil Berhasil Diubah!");
                    pause(input); // Memanggil Method pause //
                    break;

                case 2: // Jika Pilihan = 2 //
                    System.out.println("\nJumlah Slot Motor Saat Ini Adalah: " + parkirMotor.getJumlahSlot());
                    System.out.print("Masukkan Jumlah Slot Baru: ");
                    int slotMotor = input.nextInt(); // Meminta Inputan Jumlah Slot Motor //
                    input.nextLine();
                    parkirMotor.setJumlahSlot(slotMotor); // Mengubah Jumlah Slot Parkir Motor //
                    System.out.println("Jumlah Slot Parkir Motor Berhasil Diubah!");
                    pause(input); // Memanggil Method pause //
                    break;

                case 3: // Jika Pilihan = 3 //
                    runningPilihan2 = false; // Menghentikan Perulangan //
                    break;

                default: // Jika Pilihan Bukan 1-3 //
                    System.out.println("Pilihan Tidak Valid, Coba Ulangi Lagi!");
                    pause(input); // Memanggil Method pause //
            }
        }
    }
    // METHOD ubahSlotParkir END //

    // METHOD autoParkir //
    void autoParkir(Scanner input){
        boolean runningPilihan3 = true; // Deklarasi Variabel runningPilihan3 Dengan Value "True" //
        boolean isOn = parkirMobil.getStatusOn(); // Mengambil Status Auto Parkir Saat Ini //

        while (runningPilihan3) { // Kode Dijalankan Selama Variabel runningPilihan3 Bernilai "True" //
            System.out.printf("\nFitur Auto Parkir Anda Saat Ini Sedang %s", isOn ? "Aktif" : "Nonaktif");
            System.out.printf("\nApakah Anda Ingin %s ? (y/n): ", isOn ? "Menonaktifkan-nya" : "Mengaktifkan-nya");

            char inputPilihan = input.next().charAt(0); // Meminta Inputan Pilihan y / n //
            input.nextLine();

            if(isOn){ // Kode Dijalankan Jika Auto Parkir Aktif //
                if(inputPilihan == 'y'){
                    isOn = false; // Mengubah Status Auto Parkir //
                    parkirMobil.setAuto(isOn); // Mengubah Status Auto Parkir Mobil //
                    System.out.printf("\nFitur Auto Parkir Anda Sudah %s", isOn ? "Aktif" : "Nonaktif");
                    runningPilihan3 = false; // Menghentikan Perulangan //
                }else{
                    pause(input); // Memanggil Method pause //
                    return; // Menghentikan Method autoParkir //
                }
            }else{ // Kode Dijalankan Jika Auto Parkir Nonaktif //
                if(inputPilihan == 'y'){
                    isOn = true; // Mengubah Status Auto Parkir //
                    parkirMobil.setAuto(isOn); // Mengubah Status Auto Parkir Mobil //
                    System.out.printf("\nFitur Auto Parkir Anda Sudah %s", isOn ? "Aktif" : "Nonaktif");
                    runningPilihan3 = false; // Menghentikan Perulangan //
                }else{
                    pause(input); // Memanggil Method pause //
                    return; // Menghentikan Method autoParkir //
                }
            }
        }
        pause(input); // Memanggil Method pause //
    }
    // METHOD autoParkir END //

    // METHOD pengaturanParkir //
    public void pengaturanParkir() {
        Scanner input = new Scanner(System.in); // Membuat Objek Scanner //
        boolean runningPengaturan = true; // Deklarasi Variabel runningPengaturan Dengan Value "True" //

        while (runningPengaturan) { // Kode Dijalankan Selama Variabel runningPengaturan Bernilai "True" //
            clearConsole.clear(); // Memanggil Method clear Di Class clearConsole //
            System.out.println("======== PENGATURAN PARKIR ========");
            garisBatas.garis(); // Memanggil Method garis Di Class garisBatas //
            System.out.println("1. Ubah Jumlah Lantai Parkir");
            System.out.println("2. Ubah Jumlah Slot Parkir per Lantai");
            System.out.println("3. Auto Parkir Kendaraan");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Masukkan Pilihan Anda (1-4): ");

            int pilihan = input.nextInt(); // Meminta Inputan Pilihan Menu //
            input.nextLine();

            switch (pilihan) {
                case 1: // Jika Pilihan = 1 //
                    ubahLantaiMobil(input); // Memanggil Method ubahLantaiMobil //
                    break;
                case 2: // Jika Pilihan = 2 //
                    ubahSlotParkir(input); // Memanggil Method ubahSlotParkir //
                    break;
                case 3: // Jika Pilihan = 3 //
                    autoParkir(input); // Memanggil Method autoParkir //
                    break;
                case 4: // Jika Pilihan = 4 //
                    runningPengaturan = false; // Menghentikan Menu Pengaturan //
                    break;
                default: // Jika Pilihan Bukan 1-4 //
                    System.out.println("Pilihan Tidak Valid, Coba Ulangi Lagi!");
                    pause(input); // Memanggil Method pause //
            }
        }
    }
    // METHOD pengaturanParkir END //

    // METHOD pause //
    void pause(Scanner input) {
        System.out.print("\nTekan ENTER untuk kembali...");
        input.nextLine();
    }
    // METHOD pause END //
}
