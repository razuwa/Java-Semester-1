import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ManajemenStokdanKasir {

    // variabel global
    static Scanner scanner = new Scanner(System.in);

    // list barang
    static ArrayList<String> kodeBarang = new ArrayList<>();
    static ArrayList<String> namaBarang = new ArrayList<>();
    static ArrayList<Double> daftarHarga = new ArrayList<>();
    static ArrayList<Double> jumlahStok = new ArrayList<>();

    // list riwayat pembelian
    static ArrayList<String> riwayatNoNota = new ArrayList<>();
    static ArrayList<String> riwayatNamaPembeli = new ArrayList<>();
    static ArrayList<Double> riwayatTotalBelanja = new ArrayList<>();
    static ArrayList<String> riwayatTanggal = new ArrayList<>();
    static ArrayList<String> riwayatStruk = new ArrayList<>();

    // variabel status kasir
    static String namaKasir;
    static int tanggalHari;
    static double pendapatanHarian = 0.0;
    static int nomorPelanggan = 1;

    public static void main(String[] args) {
        //proses login kasir
        System.out.println("=== Manajemen Stok dan Kasir ===");
        System.out.print("Masukkan Nama Kasir: ");
        namaKasir = scanner.nextLine();

        while (true) {
            System.out.print("Masukkan Tanggal Hari Ini (1-31): ");
            tanggalHari = scanner.nextInt();
            scanner.nextLine();
            if (tanggalHari < 1 || tanggalHari > 31) {
                System.out.println("Tanggal tidak valid. Silakan masukkan angka antara 1-31.");
                continue;
            }
            break;
        }
        System.out.println("Tanggal hari ini: " + tanggalHari);
        System.out.println("\nLogin Berhasil. Selamat Bekerja, " + namaKasir + "!");

        // isi stok awal
        isiStokAwal();

        //MENU UTAMA
        boolean bekerja = true;
        do {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Kasir");
            System.out.println("2. Kelola Stok Barang");
            System.out.println("3. Riwayat Pembelian");
            System.out.println("4. Selesai Bekerja");
            System.out.print("Pilih menu (1-4): ");
            int pilihMenu = scanner.nextInt();
            scanner.nextLine();

            switch (pilihMenu) {
                case 1:
                    menuKasir();
                    break;
                case 2:
                    kelolaStokBarang();
                    break;
                case 3:
                    lihatRiwayatPembelian();
                    break;
                case 4:
                    tampilkanPendapatanAkhir();
                    bekerja = false; 
                    break;
                default:
                    System.out.println("\nPilihan tidak valid. Silakan pilih 1-4.");
            }

        } while (bekerja);
    }

    // method stok awal
        public static void isiStokAwal() {
        kodeBarang.add("001"); namaBarang.add("Beras"); daftarHarga.add(15000.0); jumlahStok.add(50.0);
        kodeBarang.add("002"); namaBarang.add("Gula"); daftarHarga.add(12000.0); jumlahStok.add(30.0);
        kodeBarang.add("003"); namaBarang.add("Minyak Goreng"); daftarHarga.add(14000.0); jumlahStok.add(20.0);
        kodeBarang.add("004"); namaBarang.add("Mi Instan"); daftarHarga.add(4000.0); jumlahStok.add(120.0);
        kodeBarang.add("005"); namaBarang.add("Gas LPG"); daftarHarga.add(20000.0); jumlahStok.add(10.0);
    }

    //METHOD CASE 1: MENU KASIR
    public static void menuKasir() {
        System.out.println("\n=== Menu Kasir ===");

        System.out.print("Masukkan nama pembeli: ");
        String namaPembeli = scanner.nextLine();
        String nomorNota = "Nota-" + nomorPelanggan;

        // info diskon
        double diskon = 0.0;
        if (tanggalHari % 2 == 1) {
            System.out.println("INFO: Tanggal ganjil - Semua pembelian mendapat diskon 10%!");
            diskon = 0.1;
        } else {
            System.out.println("INFO: Tanggal genap - Semua pembelian mendapat diskon 5%!");
            diskon = 0.05;
        }

        // list keranjang belanja
        ArrayList<String> keranjangKode = new ArrayList<>();
        ArrayList<String> keranjangNama = new ArrayList<>();
        ArrayList<Integer> keranjangJumlah = new ArrayList<>();
        ArrayList<Double> keranjangHargaSatuan = new ArrayList<>();
        ArrayList<Double> keranjangSubtotal = new ArrayList<>();
        double totalBelanjaSesiIni = 0.0;

        while (true) {
            System.out.println("\n--- Daftar Barang Tersedia ---");
            System.out.printf("%-6s %-20s %-15s %-10s%n", "Kode", "Nama Barang", "Harga", "Stok");
            System.out.println("------------------------------------------------------");
            for (int i = 0; i < kodeBarang.size(); i++) {
                System.out.printf("%-6s %-20s Rp%-13.0f %-10.0f%n",
                        kodeBarang.get(i), namaBarang.get(i), daftarHarga.get(i), jumlahStok.get(i));
            }
            System.out.println("------------------------------------------------------");

            System.out.print("Masukkan Kode Barang (atau '0' untuk selesai): ");
            String kodeInput = scanner.nextLine();

            // checkout
            if (kodeInput.equals("0")) {
                if (keranjangKode.isEmpty()) {
                    System.out.println("Tidak ada barang yang dibeli.");
                    return;
                }
                break;
            }

            // cari barang
            int indeksDitemukan = -1;
            for (int i = 0; i < kodeBarang.size(); i++) {
                if (kodeBarang.get(i).equals(kodeInput)) {
                    indeksDitemukan = i;
                    break;
                }
            }

            if (indeksDitemukan == -1) {
                System.out.println("Kode barang tidak ditemukan.");
            } else {
                String namaBrg = namaBarang.get(indeksDitemukan);
                double hargaBrg = daftarHarga.get(indeksDitemukan);
                double stokBrg = jumlahStok.get(indeksDitemukan);

                if (stokBrg <= 0) {
                    System.out.println("Stok barang ini habis!");
                    continue;
                }

                int jumlahBeli;
                while (true) {
                    System.out.print("Masukkan jumlah beli: ");
                    jumlahBeli = scanner.nextInt();
                    scanner.nextLine();
                    if (jumlahBeli <= 0) {
                        System.out.println("Jumlah beli tidak boleh 0/negatif.");
                    } else if (jumlahBeli > stokBrg) {
                        System.out.println("Stok tidak cukup (Sisa: " + stokBrg + ")");
                    } else {
                        break;
                    }
                }

                // tambah ke keranjang
                keranjangKode.add(kodeInput);
                keranjangNama.add(namaBrg);
                keranjangJumlah.add(jumlahBeli);
                keranjangHargaSatuan.add(hargaBrg);
                keranjangSubtotal.add(hargaBrg * jumlahBeli);

                // kurangi stok global
                jumlahStok.set(indeksDitemukan, stokBrg - jumlahBeli);
                System.out.println("\n->" + namaBrg + " sebanyak " + jumlahBeli + " berhasil ditambahkan");
            }
        }

        // proses cetak struk & simpan riwayat
        StringBuilder strukBuilder = new StringBuilder();
        strukBuilder.append("\n=== Struk Belanja ===\n");
        strukBuilder.append("Nomor Nota: ").append(nomorNota).append("\n");
        strukBuilder.append("Nama Pembeli: ").append(namaPembeli).append("\n");
        strukBuilder.append("Tanggal: ").append(tanggalHari).append("\n");
        strukBuilder.append(
                String.format("%-6s %-20s %-8s %-15s %-15s%n", "Kode", "Nama Barang", "Jml", "Harga", "Subtotal"));
        strukBuilder.append("---------------------------------------------------------------------\n");

        for (int i = 0; i < keranjangKode.size(); i++) {
            strukBuilder.append(String.format("%-6s %-20s %-8d Rp%-13.0f Rp%-13.0f%n",
                    keranjangKode.get(i), keranjangNama.get(i), keranjangJumlah.get(i),
                    keranjangHargaSatuan.get(i), keranjangSubtotal.get(i)));
            totalBelanjaSesiIni += keranjangSubtotal.get(i);
        }

        strukBuilder.append("---------------------------------------------------------------------\n");
        strukBuilder.append(String.format("Total Belanja : Rp%.0f%n", totalBelanjaSesiIni));
        double jumlahDiskon = totalBelanjaSesiIni * diskon;
        strukBuilder.append(String.format("Diskon        : Rp%.0f%n", jumlahDiskon));
        strukBuilder.append(String.format("Total Bayar   : Rp%.0f%n", (totalBelanjaSesiIni - jumlahDiskon)));
        strukBuilder.append("=====================================\n");

        System.out.println(strukBuilder.toString());

        // simpan ke riwayat global
        riwayatNoNota.add(nomorNota);
        riwayatNamaPembeli.add(namaPembeli);
        riwayatTotalBelanja.add(totalBelanjaSesiIni - jumlahDiskon);
        riwayatTanggal.add(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        riwayatStruk.add(strukBuilder.toString());

        pendapatanHarian += (totalBelanjaSesiIni - jumlahDiskon);
        nomorPelanggan++;
    }

    // METHOD CASE 2: KELOLA STOK BARANG
    public static void kelolaStokBarang() {
        System.out.println("\n=== Kelola Stok Barang ===");
        // tampilkan barang
        System.out.println("\n--- Daftar Barang yang Tersedia ---");
        System.out.printf("%-6s %-20s %-15s %-10s%n", "Kode", "Nama Barang", "Harga", "Stok");
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < kodeBarang.size(); i++) {
            System.out.printf("%-6s %-20s Rp%-13.0f %-10.0f%n",
                    kodeBarang.get(i), namaBarang.get(i), daftarHarga.get(i), jumlahStok.get(i));
        }
        System.out.println("------------------------------------------------------");

        boolean submenuAktif = true;
        do {
            System.out.println("\n=== Submenu Kelola Stok ===");
            System.out.println("1. Tambahkan Barang Baru");
            System.out.println("2. Menambah Stok Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("4. Lihat Stok Barang");
            System.out.println("5. Update Harga Barang");
            System.out.println("6. Cari Barang");
            System.out.println("7. Kembali ke Menu Utama");
            System.out.print("Pilih submenu (1-7): ");
            int pilihSubmenu = scanner.nextInt();
            scanner.nextLine();

            switch (pilihSubmenu) {
                case 1: // Tambah Barang Baru
                    System.out.println("\n--- Tambah Barang Baru ---");
                    String kodeBaru;
                    while (true) {
                        System.out.print("Masukkan Kode Barang (unik): ");
                        kodeBaru = scanner.nextLine();
                        boolean kodeUnik = true;
                        for (String kode : kodeBarang) {
                            if (kode.equals(kodeBaru)) {
                                kodeUnik = false;
                                break;
                            }
                        }
                        if (!kodeUnik)
                            System.out.println("Kode sudah ada.");
                        else
                            break;
                    }
                    System.out.print("Masukkan Nama Barang: ");
                    String namaBaru = scanner.nextLine();

                    double hargaBaru;
                    while (true) {
                        System.out.print("Masukkan Harga: ");
                        hargaBaru = scanner.nextDouble();
                        scanner.nextLine();
                        if (hargaBaru > 0)
                            break;
                        System.out.println("Harga harus > 0");
                    }

                    double stokBaru;
                    while (true) {
                        System.out.print("Masukkan Stok Awal: ");
                        stokBaru = scanner.nextDouble();
                        scanner.nextLine();
                        if (stokBaru >= 0)
                            break;
                        System.out.println("Stok tidak boleh negatif.");
                    }
                    kodeBarang.add(kodeBaru);
                    namaBarang.add(namaBaru);
                    daftarHarga.add(hargaBaru);
                    jumlahStok.add(stokBaru);
                    System.out.println("Barang berhasil ditambahkan.");
                    break;

                case 2: // tambah stok
                    System.out.print("Masukkan Kode Barang: ");
                    String kodeAdd = scanner.nextLine();
                    int idxAdd = kodeBarang.indexOf(kodeAdd);
                    if (idxAdd != -1) {
                        System.out.println("Stok saat ini: " + jumlahStok.get(idxAdd));
                        System.out.print("Jumlah penambahan: ");
                        double jmlAdd = scanner.nextDouble();
                        scanner.nextLine();
                        if (jmlAdd > 0) {
                            jumlahStok.set(idxAdd, jumlahStok.get(idxAdd) + jmlAdd);
                            System.out.println("Stok berhasil ditambah.");
                        } else
                            System.out.println("Jumlah harus > 0");
                    } else
                        System.out.println("Kode tidak ditemukan.");
                    break;

                case 3: // kurang stok
                    System.out.print("Masukkan Kode Barang: ");
                    String kodeMin = scanner.nextLine();
                    int idxMin = kodeBarang.indexOf(kodeMin);
                    if (idxMin != -1) {
                        double curStok = jumlahStok.get(idxMin);
                        System.out.println("Stok saat ini: " + curStok);
                        System.out.print("Jumlah pengurangan: ");
                        double jmlMin = scanner.nextDouble();
                        scanner.nextLine();
                        if (jmlMin > 0 && jmlMin <= curStok) {
                            jumlahStok.set(idxMin, curStok - jmlMin);
                            System.out.println("Stok berhasil dikurangi.");
                        } else
                            System.out.println("Jumlah tidak valid.");
                    } else
                        System.out.println("Kode tidak ditemukan.");
                    break;

                case 4: // lihat stok
                    System.out.println("\n--- Daftar Stok Barang ---");
                    System.out.printf("%-6s %-20s %-15s %-10s%n", "Kode", "Nama Barang", "Harga", "Stok");
                    for (int i = 0; i < kodeBarang.size(); i++) {
                        System.out.printf("%-6s %-20s Rp%-13.0f %-10.0f%n",
                                kodeBarang.get(i), namaBarang.get(i), daftarHarga.get(i), jumlahStok.get(i));
                    }
                    break;

                case 5: // update harga
                    System.out.print("Masukkan Kode Barang: ");
                    String kodeUpd = scanner.nextLine();
                    int idxUpd = kodeBarang.indexOf(kodeUpd);
                    if (idxUpd != -1) {
                        System.out.println("Harga Lama: " + daftarHarga.get(idxUpd));
                        System.out.print("Harga Baru: ");
                        double hrgBaru = scanner.nextDouble();
                        scanner.nextLine();
                        if (hrgBaru > 0) {
                            daftarHarga.set(idxUpd, hrgBaru);
                            System.out.println("Harga berhasil diupdate.");
                        } else
                            System.out.println("Harga harus > 0");
                    } else
                        System.out.println("Barang tidak ditemukan.");
                    break;

                case 6: // cari barang
                    System.out.print("Masukkan kata kunci: ");
                    String keyword = scanner.nextLine().toLowerCase();
                    boolean found = false;
                    System.out.printf("%-6s %-20s %-15s %-10s%n", "Kode", "Nama Barang", "Harga", "Stok");
                    for (int i = 0; i < kodeBarang.size(); i++) {
                        if (kodeBarang.get(i).toLowerCase().equals(keyword) ||
                                namaBarang.get(i).toLowerCase().contains(keyword)) {
                            System.out.printf("%-6s %-20s Rp%-13.0f %-10.0f%n",
                                    kodeBarang.get(i), namaBarang.get(i), daftarHarga.get(i), jumlahStok.get(i));
                            found = true;
                        }
                    }
                    if (!found)
                        System.out.println("Tidak ditemukan.");
                    break;

                case 7: // kembali
                    submenuAktif = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (submenuAktif);
    }

    //METHOD CASE 3: RIWAYAT PEMBELIAN
    public static void lihatRiwayatPembelian() {
        boolean lihatRiwayat = true;
        while (lihatRiwayat) {
            System.out.println("\n=== Riwayat Pembelian ===");
            if (riwayatNoNota.isEmpty()) {
                System.out.println("Belum ada riwayat transaksi.");
                return;
            } else {
                System.out.printf("%-20s %-20s %-20s%n", "Nomor Transaksi", "Nama Pembeli", "Waktu");
                System.out.println("---------------------------------------------------------------------");
                for (int i = 0; i < riwayatNoNota.size(); i++) {
                    System.out.printf("%-20s %-20s %-20s%n",
                            riwayatNoNota.get(i), riwayatNamaPembeli.get(i), riwayatTanggal.get(i));
                }
                System.out.println("---------------------------------------------------------------------");

                System.out.print("Masukkan Nomor Transaksi (atau '0' untuk kembali): ");
                String inputNota = scanner.nextLine();
                if (inputNota.equals("0")) {
                    lihatRiwayat = false;
                } else {
                    int idx = riwayatNoNota.indexOf(inputNota);
                    if (idx != -1) {
                        System.out.println(riwayatStruk.get(idx));
                    } else {
                        System.out.println("Nomor transaksi tidak ditemukan.");
                    }
                }
            }
        }
    }

    // METHOD CASE 4: SELESAI BEKERJA
    public static void tampilkanPendapatanAkhir() {
        System.out.println("Selesai bekerja.");
        System.out.printf("Total Pendapatan Hari Ini: Rp%.0f%n", pendapatanHarian);
    }
}