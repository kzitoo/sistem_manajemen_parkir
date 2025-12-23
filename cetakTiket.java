public class cetakTiket {
    public static void tiketMasuk(String noTiket, String noPlat, String jenisKendaraan, int lantaiParkir, int slotParkir, String waktuMasuk){
        System.out.println("╔════════════════════════════════════╗");
        System.out.printf("║         TIKET PARKIR %-5s         ║%n", jenisKendaraan.toUpperCase());
        System.out.println("╠════════════════════════════════════╣");

        System.out.printf("║ %-10s : %-21s ║%n", "Tiket", noTiket);
        System.out.printf("║ %-10s : %-21s ║%n", "Plat", noPlat);
        System.out.printf("║ %-10s : %-21s ║%n", "Kendaraan", jenisKendaraan);

        System.out.println("║------------------------------------║");

        System.out.printf("║ %-10s : %-21s ║%n", "Lantai", "L" + lantaiParkir);
        System.out.printf("║ %-10s : %-21s ║%n", "Slot", "S" + slotParkir);

        System.out.println("║------------------------------------║");

        System.out.printf("║ %-10s : %-21s ║%n", "Masuk", waktuMasuk);

        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║           Terima Kasih!!!          ║");
        System.out.println("╚════════════════════════════════════╝");

    }

    public static void tiketKeluar(String noTiket, String noPlat, String jenisKendaraan, int lantaiParkir, int slotParkir, String waktuMasuk, String waktuKeluar, int totalTarif){
        System.out.println("╔════════════════════════════════════╗");
        System.out.printf("║         TIKET KELUAR %-5s         ║%n", jenisKendaraan.toUpperCase());
        System.out.println("╠════════════════════════════════════╣");

        System.out.printf("║ %-10s : %-21s ║%n", "Tiket", noTiket);
        System.out.printf("║ %-10s : %-21s ║%n", "Plat", noPlat);
        System.out.printf("║ %-10s : %-21s ║%n", "Kendaraan", jenisKendaraan);

        System.out.println("║------------------------------------║");

        System.out.printf("║ %-10s : %-21s ║%n", "Lantai", "L" + lantaiParkir);
        System.out.printf("║ %-10s : %-21s ║%n", "Slot", "S" + slotParkir);

        System.out.println("║------------------------------------║");

        System.out.printf("║ %-11s : %-20s ║%n", "Masuk", waktuMasuk);
        System.out.printf("║ %-11s : %-20s ║%n", "Keluar", waktuKeluar);
        System.out.printf("║ %-11s : Rp.%-17s ║%n", "Total Tarif", totalTarif);

        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║           Terima Kasih!!!          ║");
        System.out.println("╚════════════════════════════════════╝");

    }
}
