package Project;

import java.util.Scanner;
import java.util.ArrayList;

public class ManajemenStokdanKasir {
    public static void main(String[] args) {
        // Scanner
        Scanner scanner = new Scanner(System.in);

        // Array untuk menyimpan barang
        ArrayList<String> kodeBarang = new ArrayList<>();
        ArrayList<String> namaBarang = new ArrayList<>();
        ArrayList<Double> daftarHarga = new ArrayList<>();
        ArrayList<Double> jumlahStok = new ArrayList<>();

        // Array untuk menyimpan Riwayat Pembelian
        ArrayList<String> riwayatNoNota = new ArrayList<>();
        ArrayList<String> riwayatNamaPembeli = new ArrayList<>();
        ArrayList<Double> riwayatTotalBelanja = new ArrayList<>();
        ArrayList<Double> riwayatDetailStruk = new ArrayList<>();

        // Deklarasi Variabel
        String namaKasir;
        int tanggalHari;
        double totalBelanja = 0.0, pendapatanHarian = 0.0;
        int nomorPelanggan = 1;

        // Login Kasir
        System.out.println("=== Manajemen Stok dan Kasir ===");
        // Input nama
        System.out.print("Masukkan Nama Kasir: ");
        namaKasir = scanner.nextLine();
        // Input tanggal
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

        // Stok Awal Barang
        kodeBarang.add("001");
        namaBarang.add("Beras");
        daftarHarga.add(15000.0);
        jumlahStok.add(50.0);

        kodeBarang.add("002");
        namaBarang.add("Gula");
        daftarHarga.add(12000.0);
        jumlahStok.add(30.0);

        kodeBarang.add("003");
        namaBarang.add("Minyak Goreng");
        daftarHarga.add(14000.0);
        jumlahStok.add(20.0);

        kodeBarang.add("004");
        namaBarang.add("Mi Instan");
        daftarHarga.add(4000.0);
        jumlahStok.add(120.0);

        kodeBarang.add("005");
        namaBarang.add("Gas LPG");
        daftarHarga.add(20000.0);
        jumlahStok.add(10.0);

        // Menu Utama
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
                // KASIR
                case 1:
                    System.out.println("\n=== Menu Kasir ===");

                    // Input nama pembeli
                    System.out.print("Masukkan nama pembeli: ");
                    String namaPembeli = scanner.nextLine();

                    // Nomor Nota
                    String nomorNota = "Nota-" + nomorPelanggan;

                    // Buat arraylist baru untuk keranjang belanja
                    ArrayList<String> keranjangKode = new ArrayList<>();
                    ArrayList<String> keranjangNama = new ArrayList<>();
                    ArrayList<Integer> keranjangJumlah = new ArrayList<>();
                    ArrayList<Double> keranjangHargaSatuan = new ArrayList<>();
                    ArrayList<Double> keranjangSubtotal = new ArrayList<>();

                    // Looping transaksi tiap satu barang
                    while (true) {
                        // Menampilkan daftar barang setiap mau menginputkan kode barang
                        System.out.println("\n--- Daftar Barang Tersedia ---");
                        System.out.printf("%-6s %-20s %-15s %-10s%n", "Kode", "Nama Barang", "Harga", "Stok");
                        System.out.println("------------------------------------------------------");
                        for (int i = 0; i < kodeBarang.size(); i++) {
                            System.out.printf("%-6s %-20s Rp%-13.0f %-10.0f%n",
                                    kodeBarang.get(i),
                                    namaBarang.get(i),
                                    daftarHarga.get(i),
                                    jumlahStok.get(i));
                        }
                        System.out.println("------------------------------------------------------");

                        // Input kode barang
                        System.out.print("Masukkan Kode Barang (atau '0' untuk selesai): ");
                        String kodeInput = scanner.nextLine();

                        // Logika mencari barang dalam arraylist
                        int indeksDitemukan = -1;
                        for (int i = 0; i < kodeBarang.size(); i++) {
                            if (kodeBarang.get(i).equals(kodeInput)) {
                                indeksDitemukan = i;
                                break;
                            }
                        }
                        // Kalo barang ga ketemu
                        if (indeksDitemukan == -1) {
                            System.out.println("Kode barang tidak ditemukan.");
                        }

                        // Kalo barang ketemu
                        else {
                            // variabel ini dah pokoknya, ngambil dari arraylist based on indeksDitemukan
                            String namaBrg = namaBarang.get(indeksDitemukan);
                            double hargaBrg = daftarHarga.get(indeksDitemukan);
                            double stokBrg = jumlahStok.get(indeksDitemukan);

                            // Kalo stok habis
                            if (stokBrg <= 0) {
                                System.out.println("Stok barang ini habis!");
                                continue;
                            }

                            // Logika jumlah beli
                            int jumlahBeli = 0;
                            while (true) {
                                System.out.print("Masukkan jumlah beli: ");
                                jumlahBeli = scanner.nextInt();
                                scanner.nextLine();

                                // Kalo jumlah belinya 0
                                if (jumlahBeli <= 0) {
                                    System.out.println("Jumlah beli tidak boleh 0 ");
                                } else {
                                    break;
                                }
                            }

                            // Nambahin ke keranjang
                            keranjangKode.add(kodeInput);
                            keranjangNama.add(namaBrg);
                            keranjangJumlah.add(jumlahBeli);
                            keranjangHargaSatuan.add(hargaBrg);
                            keranjangSubtotal.add(hargaBrg * jumlahBeli);

                            // Kurangi stok total
                            jumlahStok.set(indeksDitemukan, stokBrg - jumlahBeli);

                            // konfirmasi barang setelah ditambahkan ke keranjang
                            System.out.println("\n->" + namaBrg + " sebanyak " + jumlahBeli + " berhasil ditambahkan");
                        }

                        // Setelah selesai belanja (checkout)
                        if (kodeInput.equals("0")) {
                            if (keranjangKode.isEmpty()) {
                                System.out.println("Tidak ada barang yang dibeli.");
                            } else {
                                System.out.println("\n=== Struk Belanja ===");
                                System.out.printf("%-10s %-20s %-10s %-15s %-10s%n", "Kode", "Nama Barang", "Jumlah",
                                        "Harga Satuan", "Subtotal");
                                for (int i = 0; i < keranjangKode.size(); i++) {
                                    System.out.printf("%-10s %-20s %-10d %-15.2f %-10.2f%n",
                                            keranjangKode.get(i),
                                            keranjangNama.get(i),
                                            keranjangJumlah.get(i),
                                            keranjangHargaSatuan.get(i),
                                            keranjangSubtotal.get(i));
                                    totalBelanja += keranjangSubtotal.get(i);
                                }
                                System.out.printf("Total Belanja: %.2f%n", totalBelanja);
                                pendapatanHarian += totalBelanja;
                                totalBelanja = 0.0; // Reset total belanja
                            }
                            break;
                        }
                    }
                    break;

                // KELOLA STOK BARANG
                case 2:
                    System.out.println("\n=== Kelola Stok Barang ===");
                    //Menampilkan daftar barang awal
                    System.out.println("\n--- Daftar Barang yang Tersedia ---");
                    System.out.printf("%-6s %-20s %-15s %-10s%n", "Kode", "Nama Barang", "Harga", "Stok");
                    System.out.println("------------------------------------------------------");
                    for (int i = 0; i < kodeBarang.size(); i++) {
                        System.out.printf("%-6s %-20s Rp%-13.0f %-10.0f%n",
                                kodeBarang.get(i),
                                namaBarang.get(i),
                                daftarHarga.get(i),
                                jumlahStok.get(i));
                    }
                    System.out.println("------------------------------------------------------");

                    // Submenu Kelola Stok
                    boolean kelolaStok = true;
                    do {
                        System.out.println("\n=== Submenu Kelola Stok ===");
                        System.out.println("1. Tambahkan Barang Baru");
                        System.out.println("2. Menambah stok barang");
                        System.out.println("3. Kurangi Stok Barang");
                        System.out.println("4. Lihat Stok Barang");
                        System.out.println("5. Kembali ke Menu Utama");
                        System.out.print("Pilih submenu (1-5): ");
                        int pilihSubmenu = scanner.nextInt();
                        scanner.nextLine();
                        
                        // Switch case submenu
                        switch (pilihSubmenu) {
                            //Menambahkan barang baru
                            case 1:
                                System.out.println("\n--- Tambah Barang Baru ---");
                                String kodeBaru;
                                //Masukkan kode barang baru
                                while (true) {
                                    System.out.print("Masukkan Kode Barang (unik): ");
                                    kodeBaru = scanner.nextLine();
                                    // Cek apakah kode sudah dipakai
                                    boolean kodeUnik = true;
                                    for (String kode : kodeBarang) {
                                        if (kode.equals(kodeBaru)) {
                                            kodeUnik = false;
                                            break;
                                        }
                                    }
                                    //Minta input ulang kalo kode sudah dipakai
                                    if (!kodeUnik) {
                                        System.out.println("Kode barang sudah ada. Silakan masukkan kode yang berbeda.");
                                    } else {
                                        break;
                                    }
                                }
                                //Masukkan nama barang
                                System.out.print("Masukkan Nama Barang: ");
                                String namaBaru = scanner.nextLine();
                                double hargaBaru = 0.0;

                                //Masukkan harga barang
                                while (true) {
                                    System.out.print("Masukkan Harga Barang: ");
                                    hargaBaru = scanner.nextDouble();
                                    scanner.nextLine();

                                    //cek apakah harga valid
                                    if (hargaBaru <= 0) {
                                        System.out.println("Harga harus lebih dari 0.");
                                    } else {
                                        break;
                                    }
                                }

                                //Masukkan stok barang
                                double stokBaru = 0.0;
                                while (true) {
                                    System.out.print("Masukkan Jumlah Stok Awal: ");
                                    stokBaru = scanner.nextDouble();
                                    scanner.nextLine();

                                    //cek apakah stok valid
                                    if (stokBaru < 0) {
                                        System.out.println("Stok tidak boleh negatif.");
                                    } else {
                                        break;
                                    }
                                }

                                //menambahkan barang baru ke dalam arralylist
                                kodeBarang.add(kodeBaru);
                                namaBarang.add(namaBaru);
                                daftarHarga.add(hargaBaru);
                                jumlahStok.add(stokBaru);
                                System.out.println("Barang baru berhasil ditambahkan!");
                                break;
                            // Menambah Stok Barang
                            case 2: 
                                System.out.println("\n--- Menambah Stok Barang ---");
                                if (kodeBarang.isEmpty()) {
                                    System.out.println("Tidak ada barang di gudang.");
                                    break;
                                }
                                //Input kode barang yang akan ditambah stoknya
                                System.out.print("Masukkan Kode Barang: ");
                                String kodeTambah = scanner.nextLine();
                                int indeksTambah = -1;
                                for (int i = 0; i < kodeBarang.size(); i++) {
                                    if (kodeBarang.get(i).equals(kodeTambah)) {
                                        indeksTambah = i;
                                        break;
                                    }
                                }
                                //Cek apakah kode barang ditemukan
                                if (indeksTambah == -1) {
                                    System.out.println("Kode barang tidak ditemukan.");
                                //kalo barang ditemukan
                                } else {
                                    double stokSekarang = jumlahStok.get(indeksTambah);
                                    System.out.println("Stok saat ini: " + stokSekarang);
                                    double jumlahTambah = 0.0;
                                    //Input jumlah penambahan stok
                                    while (true) {
                                        System.out.print("Masukkan jumlah penambahan: ");
                                        jumlahTambah = scanner.nextDouble();
                                        scanner.nextLine();
                                        //Cek apakah jumlah penambahan valid
                                        if (jumlahTambah <= 0) {
                                            System.out.println("Jumlah penambahan harus lebih dari 0.");
                                        } else {
                                            break;
                                        }
                                    }
                                    //update stok barang yang telah ditambahkan ke dalam arraylist
                                    jumlahStok.set(indeksTambah, stokSekarang + jumlahTambah);
                                    System.out.println("Stok berhasil ditambahkan. Stok baru: " + jumlahStok.get(indeksTambah));
                                    System.out.println("Stok barang berhasil ditambahkan.");
                                }
                                break;
                            // Kurangi Stok Barang
                            case 3:
                                System.out.println("\n--- Kurangi Stok Barang ---");
                                if (kodeBarang.isEmpty()) {
                                    System.out.println("Tidak ada barang di gudang.");
                                    break;
                                }
                                //Input kode barang yang akan dikurangi stoknya
                                System.out.print("Masukkan Kode Barang: ");
                                String kodeKurang = scanner.nextLine();
                                int indeksKurang = -1;
                                for (int i = 0; i < kodeBarang.size(); i++) {
                                    if (kodeBarang.get(i).equals(kodeKurang)) {
                                        indeksKurang = i;
                                        break;
                                    }
                                }
                                //Cek apakah kode barang ditemukan
                                if (indeksKurang == -1) {
                                    System.out.println("Kode barang tidak ditemukan.");
                                //kalo barang ditemukan
                                } else {
                                    double stokSekarang = jumlahStok.get(indeksKurang);
                                    System.out.println("Stok saat ini: " + stokSekarang);
                                    double jumlahKurang = 0.0;
                                    //Input jumlah pengurangan stok
                                    while (true) {
                                        System.out.print("Masukkan jumlah pengurangan: ");
                                        jumlahKurang = scanner.nextDouble();
                                        scanner.nextLine();
                                        //Cek apakah jumlah pengurangan valid
                                        if (jumlahKurang <= 0) {
                                            System.out.println("Jumlah pengurangan harus lebih dari 0.");
                                        //Cek jumlah pengurangan agar stok tidak minus
                                        } else if (jumlahKurang > stokSekarang) {
                                            System.out.println("Jumlah pengurangan tidak boleh melebihi stok saat ini.");
                                        } else {
                                            break;
                                        }
                                    }
                                    //update stok barang yang telah dikurangi ke dalam arraylist
                                    jumlahStok.set(indeksKurang, stokSekarang - jumlahKurang);
                                    System.out.println(
                                            "Stok berhasil dikurangi. Stok baru: " + jumlahStok.get(indeksKurang));
                                }
                                break;

                            // Lihat Stok Barang
                            case 4: 
                                System.out.println("\n--- Daftar Stok Barang ---");
                                if (kodeBarang.isEmpty()) {
                                    System.out.println("Tidak ada barang di gudang.");
                                } else {
                                    System.out.printf("%-6s %-20s %-15s %-10s%n", "Kode", "Nama Barang", "Harga",
                                            "Stok");
                                    System.out.println("------------------------------------------------------");
                                    for (int i = 0; i < kodeBarang.size(); i++) {
                                        System.out.printf("%-6s %-20s Rp%-13.0f %-10.0f%n",
                                                kodeBarang.get(i),
                                                namaBarang.get(i),
                                                daftarHarga.get(i),
                                                jumlahStok.get(i));
                                    }
                                    System.out.println("------------------------------------------------------");
                                }
                                break;

                            case 5: // Kembali
                                kelolaStok = false;
                                break;

                            default:
                                System.out.println("\nPilihan tidak valid. Silakan pilih 1-5.");
                        }
                    } while (kelolaStok);
                    break;
                case 3:
                    System.out.println("\n=== Riwayat Pembelian ===");
                    break;
                case 4:
                    System.out.println("Selesai bekerja.");
                    System.out.println("Total Pendapatan Hari Ini:" + pendapatanHarian);
                    bekerja = false;
                    break;

                default:
                    System.out.println("\nPilihan tidak valid. Silakan pilih 1-4.");

            }

        } while (bekerja);

    }
}
