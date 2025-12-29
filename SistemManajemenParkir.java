import java.util.Scanner; // Import Library Scanner //
public class SistemManajemenParkir {

    // BUAT OBJEK BARU //
    static parkirMobil parkirMobil = new parkirMobil();
    static parkirMotor parkirMotor = new parkirMotor();
    static pengaturan p = new pengaturan(parkirMobil, parkirMotor);
    // BUAT OBJEK BARU END //

    // METHOD pause //
    static void pause(Scanner input) {
        System.out.print("\nTekan ENTER untuk kembali ke menu...");
        input.nextLine();
    }
    // METHOD pause END//

    // METHOD menuUtama //
    static void menuUtama() {
        Scanner input = new Scanner(System.in); // Buat Object Scanner // 
        boolean running = true; // Deklarasi Varibel running Dengan Value "True"; //

        // PERULANGAN START //
        while (running) { // Kode Dijalankan Selama Variabel running Bernilai "True" //
            clearConsole.clear(); // Memanggil Method clear di Class clearConsole //
            System.out.println("===== SISTEM MANAJEMEN PARKIR =====");
            garisBatas.garis(); // Memanggil Method garis di Class garisBatas //
            System.out.println("1. Parkir Mobil");
            System.out.println("2. Parkir Motor");
            System.out.println("3. Pengaturan Parkir");
            System.out.println("4. Keluar");
            System.out.print("Masukan Pilihan Anda (1-4): ");

            int pilih = input.nextInt(); // Meminta Inputan Pilihan Menu //
            input.nextLine();

            switch (pilih) {
                case 1: // Jika Pilihan = 1 //
                    parkirMobil.pilihanMenuMobil(); // Memanggil method pilihanMenuMobil di Class parkirMobil //
                    break; 
                case 2: // Jika Pilihan = 2 //
                    parkirMotor.pilihanMenuMotor(); // Memanggil method pilihanMenuMotor di Class parkirMotor //
                    break;  
                case 3: // Jika Pilihan = 3 //
                    p.pengaturanParkir();  // Memanggil method pengaturanParkir di Class pengaturan //
                    break; 
                case 4: // Jika Pilihan = 4 //
                    running = false; // Nilai Varibel running di Assign "False" //
                    System.out.println("Terima kasih Telah Menggunakan Sistem Manajemen Parkir!");
                    break; 
                default: // Jika Pilihan Bukan 1-4 //
                    System.out.println("Pilihan Tidak Valid, Coba Ulangi Lagi!");
                    pause(input); // Memanggil Method pause //
            }
        }input.close();
        // PERULANGAN END //
    }
    // METHOD menuUtama END //

    // MAIN PROGRAM //
    public static void main(String[] args) {
        menuUtama(); // Memanggil Method menuUtama Untuk Dijalankan
    }
    // MAIN PROGRAM END //
}
