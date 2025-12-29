public class cetakTiket {

    // METHOD tiketMasuk //
    public static void tiketMasuk(String noTiket, String noPlat, String jenisKendaraan, int lantaiParkir, int slotParkir, String waktuMasuk){

        System.out.println("╔════════════════════════════════════╗"); // Menampilkan Garis Atas Tiket //

        System.out.printf("║         TIKET PARKIR %-5s         ║%n", jenisKendaraan.toUpperCase()); // Menampilkan Judul Tiket Parkir Berdasarkan Jenis Kendaraan //

        System.out.println("╠════════════════════════════════════╣"); // Menampilkan Garis Pemisah //

        System.out.printf("║ %-10s : %-21s ║%n", "Tiket", noTiket); // Menampilkan Nomor Tiket //
        System.out.printf("║ %-10s : %-21s ║%n", "Plat", noPlat); // Menampilkan Nomor Plat Kendaraan //
        System.out.printf("║ %-10s : %-21s ║%n", "Kendaraan", jenisKendaraan); // Menampilkan Jenis Kendaraan //

        System.out.println("║------------------------------------║"); // Menampilkan Garis Pemisah Informasi //

        System.out.printf("║ %-10s : %-21s ║%n", "Lantai", "L" + lantaiParkir); // Menampilkan Informasi Lantai Parkir //
        System.out.printf("║ %-10s : %-21s ║%n", "Slot", "S" + slotParkir); // Menampilkan Informasi Slot Parkir //

        System.out.println("║------------------------------------║"); // Menampilkan Garis Pemisah Informasi //

        System.out.printf("║ %-10s : %-21s ║%n", "Masuk", waktuMasuk); // Menampilkan Waktu Masuk Kendaraan //

        System.out.println("╠════════════════════════════════════╣"); // Menampilkan Garis Penutup Tiket //
        System.out.println("║           Terima Kasih!!!          ║"); // Menampilkan Pesan Penutup //
        System.out.println("╚════════════════════════════════════╝"); // Menampilkan Garis Bawah Tiket //
    }
    // METHOD tiketMasuk END //


    // METHOD tiketKeluar //
    public static void tiketKeluar(String noTiket, String noPlat, String jenisKendaraan, int lantaiParkir, int slotParkir, String waktuMasuk, String waktuKeluar, int totalTarif){

        System.out.println("╔════════════════════════════════════╗"); // Menampilkan Garis Atas Tiket //

        System.out.printf("║         TIKET KELUAR %-5s         ║%n", jenisKendaraan.toUpperCase()); // Menampilkan Judul Tiket Keluar Berdasarkan Jenis Kendaraan //

        System.out.println("╠════════════════════════════════════╣"); // Menampilkan Garis Pemisah //

        System.out.printf("║ %-10s : %-21s ║%n", "Tiket", noTiket); // Menampilkan Nomor Tiket //
        System.out.printf("║ %-10s : %-21s ║%n", "Plat", noPlat); // Menampilkan Nomor Plat Kendaraan //
        System.out.printf("║ %-10s : %-21s ║%n", "Kendaraan", jenisKendaraan); // Menampilkan Jenis Kendaraan //

        System.out.println("║------------------------------------║"); // Menampilkan Garis Pemisah Informasi //

        System.out.printf("║ %-10s : %-21s ║%n", "Lantai", "L" + lantaiParkir); // Menampilkan Informasi Lantai Parkir //
        System.out.printf("║ %-10s : %-21s ║%n", "Slot", "S" + slotParkir); // Menampilkan Informasi Slot Parkir //

        System.out.println("║------------------------------------║"); // Menampilkan Garis Pemisah Informasi //

        System.out.printf("║ %-11s : %-20s ║%n", "Masuk", waktuMasuk); // Menampilkan Waktu Masuk Kendaraan //
        System.out.printf("║ %-11s : %-20s ║%n", "Keluar", waktuKeluar); // Menampilkan Waktu Keluar Kendaraan //
        System.out.printf("║ %-11s : Rp.%-17s ║%n", "Total Tarif", totalTarif); // Menampilkan Total Tarif Parkir //

        System.out.println("╠════════════════════════════════════╣"); // Menampilkan Garis Penutup Tiket //
        System.out.println("║           Terima Kasih!!!          ║"); // Menampilkan Pesan Penutup //
        System.out.println("╚════════════════════════════════════╝"); // Menampilkan Garis Bawah Tiket //
    }
    // METHOD tiketKeluar END //
}