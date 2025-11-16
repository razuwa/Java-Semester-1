// Import library yang dibutuhkan
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

/**
 * Kelas untuk merepresentasikan satu item barang
 */
class Barang {
    String kode;
    String nama;
    double harga;
    int stok;

    public Barang(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    // Setter
    public void setStok(int stok) {
        this.stok = stok;
    }
}

/**
 * Kelas untuk merepresentasikan barang yang ada di keranjang belanja
 */
class ItemBelanja {
    Barang barang;
    int jumlah;

    public ItemBelanja(Barang barang, int jumlah) {
        this.barang = barang;
        this.jumlah = jumlah;
    }

    public Barang getBarang() { return barang; }
    public int getJumlah() { return jumlah; }

    public double getSubtotal() {
        return barang.getHarga() * jumlah;
    }
}

/**
 * Kelas untuk mengelola daftar inventaris barang
 */
class DaftarBarang {
    // Menggunakan HashMap agar pencarian berdasarkan kode barang (String) cepat
    private HashMap<String, Barang> petaBarang;

    public DaftarBarang() {
        petaBarang = new HashMap<>();
    }

    /**
     * Menambahkan barang baru ke inventaris
     */
    public void tambahBarangBaru(Barang barang) {
        petaBarang.put(barang.getKode(), barang);
    }

    /**
     * Menambahkan stok ke barang yang sudah ada
     */
    public void tambahStok(String kode, int jumlahTambah) {
        Barang barang = petaBarang.get(kode);
        if (barang != null) {
            barang.setStok(barang.getStok() + jumlahTambah);
            System.out.println("Stok " + barang.getNama() + " berhasil ditambah. Stok sekarang: " + barang.getStok());
        } else {
            System.out.println("Error: Barang dengan kode " + kode + " tidak ditemukan.");
        }
    }

    /**
     * Mendapatkan objek Barang berdasarkan kodenya
     */
    public Barang getBarang(String kode) {
        return petaBarang.get(kode);
    }

    /**
     * Cek apakah barang ada
     */
    public boolean adaBarang(String kode) {
        return petaBarang.containsKey(kode);
    }

    /**
     * Menampilkan seluruh daftar barang
     */
    public void tampilkanDaftar() {
        System.out.println("\n--- Daftar Barang ---");
        System.out.println("==========================================================");
        System.out.printf("| %-5s | %-20s | %-15s | %-5s |\n", "Kode", "Nama Barang", "Harga Satuan", "Stok");
        System.out.println("==========================================================");
        
        if (petaBarang.isEmpty()) {
            System.out.println("|                      Data Kosong                      |");
        } else {
            for (Barang b : petaBarang.values()) {
                System.out.printf("| %-5s | %-20s | Rp %-12.0f | %-5d |\n", 
                    b.getKode(), b.getNama(), b.getHarga(), b.getStok());
            }
        }
        System.out.println("==========================================================");
    }
}


/**
 * Kelas Utama Program Kasir
 */
public class ProgramKasir {

    // Variabel global untuk aplikasi kasir
    private Scanner scanner;
    private DaftarBarang daftarBarang;
    private String namaKasir;
    private String tanggalLengkap;
    private int tanggalHari; // Hanya angka tanggal untuk diskon ganjil/genap
    private double totalPendapatanHarian;
    private int nomorPelanggan;

    // Constructor
    public ProgramKasir() {
        scanner = new Scanner(System.in);
        daftarBarang = new DaftarBarang();
        totalPendapatanHarian = 0;
        nomorPelanggan = 0;
    }

    // --- METODE UTAMA ---
    public static void main(String[] args) {
        ProgramKasir kasir = new ProgramKasir();
        kasir.run();
    }

    public void run() {
        setupAwal();
        isiDataBarangAwal();
        menuUtama();
    }

    /**
     * 1. Setup Awal: Meminta nama kasir dan tanggal
     */
    private void setupAwal() {
        System.out.println("--- Selamat Datang di Program Kasir ---");
        System.out.print("Masukkan Nama Kasir: ");
        this.namaKasir = scanner.nextLine();
        
        System.out.print("Masukkan Tanggal Hari Ini (misal: 7 November 2025): ");
        this.tanggalLengkap = scanner.nextLine();

        // Loop validasi untuk meminta angka tanggal
        while (true) {
            try {
                System.out.print("Masukkan Tanggal (HANYA ANGKA, 1-31): ");
                this.tanggalHari = Integer.parseInt(scanner.nextLine());
                if (this.tanggalHari >= 1 && this.tanggalHari <= 31) {
                    break; // Angka valid, keluar loop
                } else {
                    System.out.println("Tanggal tidak valid. Harap masukkan antara 1 dan 31.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka saja.");
            }
        }
        System.out.println("\nSetup Selesai. Selamat bekerja, " + this.namaKasir + "!");
    }

    /**
     * Mengisi 10 data barang awal (sesuai permintaan)
     */
    private void isiDataBarangAwal() {
        daftarBarang.tambahBarangBaru(new Barang("001", "Buku Tulis", 5000, 100));
        daftarBarang.tambahBarangBaru(new Barang("002", "Pulpen Pilot", 3000, 150));
        daftarBarang.tambahBarangBaru(new Barang("003", "Pensil 2B", 2500, 200));
        daftarBarang.tambahBarangBaru(new Barang("004", "Penghapus", 1500, 300));
        daftarBarang.tambahBarangBaru(new Barang("005", "Penggaris 30cm", 4000, 80));
        daftarBarang.tambahBarangBaru(new Barang("006", "Tipe-X", 5000, 50));
        daftarBarang.tambahBarangBaru(new Barang("007", "Spidol Hitam", 8000, 75));
        daftarBarang.tambahBarangBaru(new Barang("008", "Sticky Notes", 6000, 120));
        daftarBarang.tambahBarangBaru(new Barang("009", "Stapler", 15000, 40));
        daftarBarang.tambahBarangBaru(new Barang("010", "Isi Stapler", 3500, 100));
    }


    /**
     * 2. Tampilan Menu Utama
     */
    private void menuUtama() {
        boolean selesaiBekerja = false;
        while (!selesaiBekerja) {
            System.out.println("\n--- Menu Utama ---");
            System.out.println("Kasir: " + this.namaKasir + " | Tanggal: " + this.tanggalLengkap);
            System.out.println("1. Melayani Pembeli");
            System.out.println("2. Lihat & Kelola Daftar Barang");
            System.out.println("3. Selesai Bekerja");
            System.out.print("Pilih opsi (1-3): ");

            try {
                int pilihan = Integer.parseInt(scanner.nextLine());
                switch (pilihan) {
                    case 1:
                        melayaniPelanggan();
                        break;
                    case 2:
                        manajemenBarang();
                        break;
                    case 3:
                        selesaiBekerja = true;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
            }
        }
        rekapHarian();
    }

    /**
     * 3. Logika untuk Melayani Pelanggan
     */
    private void melayaniPelanggan() {
        this.nomorPelanggan++;
        System.out.println("\n--- Melayani Pelanggan ke-" + this.nomorPelanggan + " ---");
        ArrayList<ItemBelanja> keranjang = new ArrayList<>();
        
        while (true) {
            System.out.print("Masukkan Kode Barang (atau ketik 'selesai' untuk checkout): ");
            String kode = scanner.nextLine();

            if (kode.equalsIgnoreCase("selesai")) {
                if (keranjang.isEmpty()) {
                    System.out.println("Pelanggan tidak membeli apapun.");
                    this.nomorPelanggan--; // Batalkan increment nomor pelanggan
                    return; // Kembali ke menu utama
                }
                break; // Lanjut ke checkout
            }

            Barang barang = daftarBarang.getBarang(kode);
            if (barang == null) {
                System.out.println("Kode barang tidak ditemukan. Coba lagi.");
                continue;
            }

            // Input jumlah dan validasi stok
            int jumlah = 0;
            while (true) {
                try {
                    System.out.print("Masukkan Jumlah: ");
                    jumlah = Integer.parseInt(scanner.nextLine());
                    if (jumlah <= 0) {
                        System.out.println("Jumlah harus lebih dari 0.");
                    } else if (jumlah > barang.getStok()) {
                        System.out.println("Stok tidak mencukupi. Stok tersisa: " + barang.getStok());
                    } else {
                        break; // Jumlah valid
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input jumlah tidak valid.");
                }
            }

            // Tambah ke keranjang
            keranjang.add(new ItemBelanja(barang, jumlah));
            
            // Kurangi stok (langsung di objek Barang)
            barang.setStok(barang.getStok() - jumlah);

            System.out.printf("Ditambahkan: %s (%d) - Subtotal: Rp %.0f\n", 
                barang.getNama(), jumlah, (barang.getHarga() * jumlah));
        }

        // Lanjut ke proses checkout
        prosesCheckout(keranjang);
    }

    /**
     * 3b. Proses Checkout (Total, Diskon, Bayar, Struk)
     */
    private void prosesCheckout(ArrayList<ItemBelanja> keranjang) {
        System.out.println("\n--- Proses Checkout ---");
        double totalBelanja = 0;
        
        // Hitung total belanja
        for (ItemBelanja item : keranjang) {
            totalBelanja += item.getSubtotal();
        }
        System.out.printf("Total Belanja: Rp %.0f\n", totalBelanja);

        // Terapkan diskon ganjil/genap
        double persentaseDiskon = (this.tanggalHari % 2 == 0) ? 0.10 : 0.05; // Genap 10%, Ganjil 5%
        double nilaiDiskon = totalBelanja * persentaseDiskon;
        double totalSetelahDiskon = totalBelanja - nilaiDiskon;

        System.out.printf("Diskon Tanggal (%d%%): -Rp %.0f\n", (int)(persentaseDiskon * 100), nilaiDiskon);
        System.out.printf("Total Setelah Diskon: Rp %.0f\n", totalSetelahDiskon);

        // Metode Pembayaran
        double biayaAdmin = 0;
        double kembalian = 0;
        double totalFinal = totalSetelahDiskon;
        String metodeBayarStr = "";

        while (true) {
            System.out.print("Metode Pembayaran (1. Tunai / 2. Non-Tunai): ");
            try {
                int metode = Integer.parseInt(scanner.nextLine());
                
                if (metode == 1) { // Tunai
                    metodeBayarStr = "Tunai";
                    System.out.print("Masukkan Uang Tunai: Rp ");
                    double uangBayar = Double.parseDouble(scanner.nextLine());
                    
                    if (uangBayar < totalSetelahDiskon) {
                        System.out.println("Uang tunai kurang. Transaksi dibatalkan.");
                        // Batalkan checkout, kembalikan stok
                        kembalikanStok(keranjang);
                        return; // Kembali ke menu utama
                    }
                    kembalian = uangBayar - totalSetelahDiskon;
                    this.totalPendapatanHarian += totalSetelahDiskon; // Pendapatan adalah total setelah diskon
                    System.out.printf("Kembalian: Rp %.0f\n", kembalian);
                    break;

                } else if (metode == 2) { // Non-Tunai
                    metodeBayarStr = "Non-Tunai";
                    biayaAdmin = 1000;
                    totalFinal = totalSetelahDiskon + biayaAdmin;
                    System.out.printf("Biaya Admin: Rp %.0f\n", biayaAdmin);
                    System.out.printf("Total Final: Rp %.0f\n", totalFinal);
                    System.out.println("Pembayaran Non-Tunai diterima.");
                    
                    // Pendapatan adalah total setelah diskon + biaya admin
                    this.totalPendapatanHarian += totalFinal; 
                    break;
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid.");
            }
        }

        // Cetak Struk
        cetakStruk(keranjang, totalBelanja, nilaiDiskon, totalSetelahDiskon, biayaAdmin, kembalian, metodeBayarStr);
    }
    
    /**
     * 3c. Cetak Struk
     */
    private void cetakStruk(ArrayList<ItemBelanja> keranjang, double total, double diskon, 
                            double totalSetelahDiskon, double admin, double kembalian, String metodeBayar) {
        
        System.out.println("\n==========================================");
        System.out.println("             STRUK PEMBELIAN");
        System.out.println("==========================================");
        System.out.println("Kasir    : " + this.namaKasir);
        System.out.println("Tanggal  : " + this.tanggalLengkap);
        System.out.println("Pelanggan: " + this.nomorPelanggan);
        System.out.println("------------------------------------------");

        // Daftar Belanjaan
        for (ItemBelanja item : keranjang) {
            System.out.printf("%s (%d x %.0f)\n", 
                item.getBarang().getNama(), 
                item.getJumlah(), 
                item.getBarang().getHarga());
            System.out.printf("  %-30s Rp %.0f\n", 
                "[" + item.getBarang().getKode() + "]", 
                item.getSubtotal());
        }

        System.out.println("------------------------------------------");
        System.out.printf("%-20s: Rp %.0f\n", "Subtotal", total);
        System.out.printf("%-20s: -Rp %.0f\n", "Diskon", diskon);
        System.out.printf("%-20s: Rp %.0f\n", "Total", totalSetelahDiskon);
        
        if (admin > 0) {
            System.out.printf("%-20s: Rp %.0f\n", "Biaya Admin", admin);
            System.out.printf("%-20s: Rp %.0f\n", "GRAND TOTAL", totalSetelahDiskon + admin);
        }
        
        System.out.println("------------------------------------------");
        System.out.printf("%-20s: %s\n", "Metode Bayar", metodeBayar);
        
        if (kembalian > 0) {
            System.out.printf("%-20s: Rp %.0f\n", "Kembalian", kembalian);
        }
        
        System.out.println("==========================================");
        System.out.println("        Terima Kasih Telah Berbelanja!");
        System.out.println("==========================================");
    }
    
    /**
     * 3d. Mengembalikan stok jika transaksi tunai dibatalkan
     */
    private void kembalikanStok(ArrayList<ItemBelanja> keranjang) {
        System.out.println("Mengembalikan stok barang ke sistem...");
        for (ItemBelanja item : keranjang) {
            Barang b = item.getBarang();
            b.setStok(b.getStok() + item.getJumlah());
        }
    }


    /**
     * 4. Logika untuk Manajemen Barang
     */
    private void manajemenBarang() {
        while (true) {
            System.out.println("\n--- Manajemen Daftar Barang ---");
            System.out.println("1. Lihat Daftar Barang");
            System.out.println("2. Tambah Barang Baru");
            System.out.println("3. Tambah Stok Barang");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Pilih opsi (1-4): ");

            try {
                int pilihan = Integer.parseInt(scanner.nextLine());
                switch (pilihan) {
                    case 1:
                        daftarBarang.tampilkanDaftar();
                        break;
                    case 2:
                        tambahBarangBaru();
                        break;
                    case 3:
                        tambahStokBarang();
                        break;
                    case 4:
                        return; // Kembali ke menu utama
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
            }
        }
    }

    /**
     * 4a. Tambah Barang Baru ke Inventaris
     */
    private void tambahBarangBaru() {
        System.out.println("\n--- Tambah Barang Baru ---");
        String kode;
        while (true) {
            System.out.print("Masukkan Kode Barang (3 digit, misal: 011): ");
            kode = scanner.nextLine();
            if (kode.length() != 3) {
                System.out.println("Kode harus 3 digit.");
            } else if (daftarBarang.adaBarang(kode)) {
                System.out.println("Kode barang sudah ada. Gunakan kode lain.");
            } else {
                break;
            }
        }

        System.out.print("Masukkan Nama Barang: ");
        String nama = scanner.nextLine();

        double harga = 0;
        while (harga <= 0) {
            try {
                System.out.print("Masukkan Harga Satuan: ");
                harga = Double.parseDouble(scanner.nextLine());
                if (harga <= 0) System.out.println("Harga harus positif.");
            } catch (NumberFormatException e) {
                System.out.println("Input harga tidak valid.");
            }
        }

        int stok = -1;
        while (stok < 0) {
            try {
                System.out.print("Masukkan Stok Awal: ");
                stok = Integer.parseInt(scanner.nextLine());
                if (stok < 0) System.out.println("Stok tidak boleh negatif.");
            } catch (NumberFormatException e) {
                System.out.println("Input stok tidak valid.");
            }
        }

        Barang barangBaru = new Barang(kode, nama, harga, stok);
        daftarBarang.tambahBarangBaru(barangBaru);
        System.out.println("Barang baru '" + nama + "' berhasil ditambahkan!");
    }

    /**
     * 4b. Tambah Stok ke Barang yang Ada
     */
    private void tambahStokBarang() {
        System.out.println("\n--- Tambah Stok Barang ---");
        System.out.print("Masukkan Kode Barang: ");
        String kode = scanner.nextLine();

        if (!daftarBarang.adaBarang(kode)) {
            System.out.println("Barang dengan kode " + kode + " tidak ditemukan.");
            return;
        }

        int jumlahTambah = 0;
        while (jumlahTambah <= 0) {
            try {
                System.out.print("Masukkan Jumlah Stok Tambahan: ");
                jumlahTambah = Integer.parseInt(scanner.nextLine());
                if (jumlahTambah <= 0) System.out.println("Jumlah tambahan harus positif.");
            } catch (NumberFormatException e) {
                System.out.println("Input jumlah tidak valid.");
            }
        }
        
        daftarBarang.tambahStok(kode, jumlahTambah);
    }

    /**
     * 5. Selesai Bekerja dan Rekap Harian
     */
    private void rekapHarian() {
        System.out.println("\n--- Selesai Bekerja ---");
        System.out.println("Sesi untuk kasir " + this.namaKasir + " telah berakhir.");
        System.out.println("Total pelanggan dilayani: " + this.nomorPelanggan);
        System.out.printf("Total Pendapatan Harian: Rp %.0f\n", this.totalPendapatanHarian);
        System.out.println("Terima kasih dan sampai jumpa!");
        scanner.close();
    }
}