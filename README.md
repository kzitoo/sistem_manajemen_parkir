# 🚗 Sistem Manajemen Parkir

Aplikasi manajemen parkir berbasis **Command Line Interface (CLI)** yang dibuat menggunakan **Java**. Program ini memudahkan pengelolaan parkir kendaraan roda dua (motor) dan roda empat (mobil) secara terorganisir.

---

## ✨ Fitur

- **Parkir Mobil** — Kelola kendaraan roda empat yang masuk dan keluar
- **Parkir Motor** — Kelola kendaraan roda dua yang masuk dan keluar
- **Cetak Tiket** — Mencetak tiket parkir untuk setiap kendaraan
- **Pengaturan Parkir** — Konfigurasi tarif dan pengaturan sistem parkir
- **Tampilan Bersih** — Console otomatis dibersihkan antar menu untuk pengalaman yang nyaman

---

## 🖥️ Tampilan Menu Utama

```
===== SISTEM MANAJEMEN PARKIR =====
==================================
1. Parkir Mobil
2. Parkir Motor
3. Pengaturan Parkir
4. Keluar
Masukan Pilihan Anda (1-4):
```

---

## 🚀 Cara Menjalankan

### Prasyarat
- **Java JDK 8** atau lebih baru sudah terinstall
- Pastikan `java` dan `javac` bisa diakses dari terminal

### Langkah-langkah

1. Clone repository ini:
   ```bash
   git clone https://github.com/kzitoo/sistem_manajemen_parkir.git
   cd sistem_manajemen_parkir
   ```

2. Compile semua file Java:
   ```bash
   javac *.java
   ```

3. Jalankan program:
   ```bash
   java SistemManajemenParkir
   ```

---

## 📁 Struktur File

| File | Deskripsi |
|------|-----------|
| `SistemManajemenParkir.java` | File utama, entry point program & menu utama |
| `parkirMobil.java` | Logika dan menu manajemen parkir mobil |
| `parkirMotor.java` | Logika dan menu manajemen parkir motor |
| `pengaturan.java` | Pengaturan tarif dan konfigurasi parkir |
| `cetakTiket.java` | Fitur cetak tiket parkir |
| `clearConsole.java` | Utility untuk membersihkan tampilan console |
| `garisBatas.java` | Utility untuk menampilkan garis pemisah |

---

## 🛠️ Teknologi

- **Bahasa:** Java (100%)
- **Tipe Aplikasi:** CLI (Command Line Interface)
- **Library:** `java.util.Scanner` (input pengguna)

---

## 👨‍💻 Developer

Dibuat oleh **[Evan Oktavianus](https://github.com/kzitoo)**
