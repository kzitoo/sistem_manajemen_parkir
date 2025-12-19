import java.util.Scanner;
public class SistemManajemenParkir {
    static parkirMobil parkirMobil = new parkirMobil();
    static parkirMotor parkirMotor = new parkirMotor();
    static pengaturan p = new pengaturan(parkirMobil, parkirMotor);

    static void pause(Scanner input) {
        System.out.print("\nTekan ENTER untuk kembali ke menu...");
        input.nextLine();
    }


    public static void main(String[] args) {
        menuUtama();
    }

    static void menuUtama() {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            clearConsole.clear();
            System.out.println("===== SISTEM MANAJEMEN PARKIR =====");
            garisBatas.garis();
            System.out.println("1. Parkir Mobil");
            System.out.println("2. Parkir Motor");
            System.out.println("3. Pengaturan Parkir");
            System.out.println("4. Keluar");
            System.out.print("Masukan Pilihan Anda (1-4): ");

            int pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    parkirMobil.pilihanMenuMobil();
                    break;
                case 2:
                    parkirMotor.pilihanMenuMotor();
                    break;
                case 3:
                    p.pengaturanParkir();
                    break;
                case 4:
                    running = false;
                    System.out.println("Terima kasih Telah Menggunakan Sistem Manajemen Parkir!");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid, Coba Ulangi Lagi!");
                    pause(input);
            }
        }input.close();
    }
}
