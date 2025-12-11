# Program Manajemen Stok dan Kasir Sederhana

Program ini adalah aplikasi berbasis konsol (CLI) yang dibangun menggunakan bahasa pemrograman **Java**. Aplikasi ini dirancang untuk mensimulasikan sistem Point of Sales (POS) sederhana yang mencakup fitur kasir, manajemen inventaris barang, serta pencatatan riwayat transaksi.

Program ini dibuat untuk memenuhi tugas mata kuliah Pemrograman Dasar dengan menerapkan konsep variabel dan operasi aritmatika/logika, Percabangan (if/switch), Perulangan (for/while/do While), Array / ArrayList, dan juga Method

## Fitur Utama

### 1. Sistem Kasir
* **Transaksi Belanja:** Memungkinkan user memilih barang berdasarkan kode, memasukkan jumlah, dan otomatis menghitung subtotal.
* **Sistem Diskon Otomatis (Ganjil-Genap):**
    * **Tanggal Ganjil:** Diskon 10%.
    * **Tanggal Genap:** Diskon 5%.
* **Cetak Struk:** Menampilkan detail belanja, total harga, diskon, dan total bayar ke layar.
* **Pengurangan Stok Otomatis:** Stok barang akan berkurang otomatis setelah transaksi berhasil.

### 2. Manajemen Stok
* **CRUD Sederhana:**
    * Menampilkan data dinamis.
    * Menambah barang baru.
    * Menambah dan mengurangi stok barang.
    * Mengurangi stok barang.
    * Update harga barang.
* **Pencarian Barang:** Mencari barang berdasarkan kata kunci (*keywords*) atau kode barang. Pencarian barang ini menggunakan algoritma *Linear Search*.

### 3. Riwayat & Laporan
* **Riwayat Transaksi:** Menyimpan data transaksi selama program berjalan. User bisa melihat ulang struk belanja lama dengan memasukkan nomor nota.
* **Laporan Pendapatan:** Menampilkan total pendapatan bersih kasir pada akhir sesi (saat keluar program).

### 4. Keamanan & Validasi
* **Anti-Crash:** Menggunakan blok `try-catch` pada setiap input angka. Program tidak akan *error* atau berhenti jika user tidak sengaja memasukkan huruf atau simbol.
* **Validasi Logika:** Mencegah input jumlah negatif, mencegah transaksi jika stok habis, dan validasi rentang tanggal (1-31).

---

## Struktur Kode & Konsep yang Digunakan

Program ini menerapkan konsep-konsep berikut:
1.  **Variabel & Tipe Data:** `String`, `int`, `double`, `boolean`.
2.  **Struktur Data:** Menggunakan `ArrayList` (Dynamic Array) untuk menyimpan data barang dan riwayat secara fleksibel.
3.  **Perulangan (Looping):** `do-while` untuk menu utama, `while` untuk validasi input, dan `for` untuk iterasi data barang.
4.  **Percabangan (Branching):** `switch-case` untuk menu, `if-else` untuk logika diskon dan stok.
5.  **Method (Fungsi):**
    * `menuKasir()`: Void method untuk operasional kasir.
    * `kelolaStokBarang()`: Void method untuk manajemen data.
    * `hitungNilaiDiskon(double, int)`: Non-void method dengan parameter untuk perhitungan logika diskon yang modular.

---

## Cara Menjalankan Program

### Prasyarat
Pastikan komputer Anda sudah terinstall **Java Development Kit (JDK)**.

### Langkah-langkah
1.  Simpan kode program dengan nama file: **`ManajemenStokdanKasir.java`**
2.  Buka terminal (CMD / PowerShell / Terminal).
3.  Arahkan ke folder tempat file disimpan.
4.  *Compile* kode dengan perintah:
    ```bash
    javac ManajemenStokdanKasir.java
    ```
5.  Jalankan program dengan perintah:
    ```bash
    java ManajemenStokdanKasir
    ```

---

## Panduan Penggunaan Singkat

1.  **Login:** Masukkan nama kasir.
2.  **Set Tanggal:** Masukkan tanggal hari ini (1-31). Tanggal ini menentukan besaran diskon.
3.  **Menu Utama:**
    * Pilih `1` untuk memulai transaksi belanja.
    * Pilih `2` untuk menambah barang atau update stok.
    * Pilih `3` untuk melihat riwayat nota sebelumnya.
    * Pilih `4` untuk melihat total pendapatan dan keluar.


---
*Dibuat dengan ❤️🥱😴😵‍💫 oleh kelompok 1 menggunakan Java.*
