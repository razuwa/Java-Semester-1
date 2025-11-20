package Project;

import java.util.Scanner;
import java.util.ArrayList;

public class ManajemenStokdanKasir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> kodeBarang = new ArrayList<>();
        ArrayList<String> namaBarang = new ArrayList<>();
        ArrayList<Double> daftarHarga = new ArrayList<>();
        ArrayList<Double> jumlahStok = new ArrayList<>();
        String namaKasir;
        int tanggalHari, nomorPelanggan;
        double totalBelanja = 0.0, pendapatanHarian = 0.0;

        
        //Login Kasir
        System.out.println("=== Manajemen Stok dan Kasir ===");
            //Input nama
        System.out.print("Masukkan Nama Kasir: ");
        namaKasir = scanner.nextLine();
            //Input tanggal
        while (true) {
            System.out.print("Masukkan Tanggal Hari Ini (1-31): ");
                tanggalHari = scanner.nextInt(); scanner.nextLine();
                if (tanggalHari < 1 || tanggalHari > 31) {
                    System.out.println("Tanggal tidak valid. Silakan masukkan angka antara 1-31.");
                    continue;
                }
                break;
        }
        System.out.println("Tanggal hari ini: " + tanggalHari);
        System.out.println("Login Berhasil. Selamat Bekerja, " + namaKasir + "!");

        //Stok Awal Barang
        kodeBarang.add("001"); namaBarang.add("Beras"); daftarHarga.add(15000.0); jumlahStok.add(50.0);
        kodeBarang.add("002"); namaBarang.add("Gula"); daftarHarga.add(12000.0); jumlahStok.add(30.0);
        kodeBarang.add("003"); namaBarang.add("Minyak Goreng"); daftarHarga.add(14000.0); jumlahStok.add(20.0);
        kodeBarang.add("004"); namaBarang.add("Mi Instan"); daftarHarga.add(4000.0); jumlahStok.add(120.0);
        kodeBarang.add("005"); namaBarang.add("Gas LPG"); daftarHarga.add(20000.0); jumlahStok.add(10.0);

        //Menu Utama
        boolean bekerja = true;
        do {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Kasir");
            System.out.println("2. Kelola Stok Barang");
            System.out.println("3. Riwayat Pembelian");
            System.out.println("4. Selesai Bekerja");
            System.out.print("Pilih menu (1-4): ");
            int pilihMenu = scanner.nextInt(); scanner.nextLine();

            switch (pilihMenu) {
                // KASIR
                case 1:
                    System.out.println("\n=== Menu Kasir ===");
                    //Buat arraylist baru untuk keranjang belanja
                    ArrayList<String> keranjangKode = new ArrayList<>();
                    ArrayList<String> keranjangNama = new ArrayList<>();
                    ArrayList<Integer> keranjangJumlah = new ArrayList<>();
                    ArrayList<Double> keranjangHargaSatuan = new ArrayList<>();
                    ArrayList<Double> keranjangSubtotal = new ArrayList<>();

                    //Looping transaksi tiap satu barang
                    while (true) {
                        System.out.print("Masukkan Kode Barang (atau '0' untuk selesai): ");
                        String kodeInput = scanner.nextLine();
                        
                        //Logika mencari barang dalam arraylist
                        int indeksDitemukan = -1;
                        for (int i = 0; i < kodeBarang.size(); i++) {
                            if (kodeBarang.get(i).equals(kodeInput)) {
                                indeksDitemukan = i;
                                break;
                            }
                        }
                        //Kalo barang ga ketemu
                        if (indeksDitemukan == -1) {
                            System.out.println("Kode barang tidak ditemukan.");
                            }

                            //Kalo barang ketemu
                        else{
                            //variabel ini dah pokoknya, ngambil dari arraylist based on indeksDitemukan
                            String namaBrg = namaBarang.get(indeksDitemukan);
                            double hargaBrg = daftarHarga.get(indeksDitemukan);
                            double stokBrg = jumlahStok.get(indeksDitemukan);

                            //Logika jumlah beli
                            int jumlahBeli = 0;
                            while(true){
                                System.out.print("Masukkan jumlah beli: ");
                                jumlahBeli = scanner.nextInt(); scanner.nextLine();
                                if (jumlahBeli <= 0) {
                                    System.out.println("Jumlah beli tidak boleh 0 ");
                                } else {
                                    break;
                                }
                            }

                            //Nambahin ke keranjang
                            keranjangKode.add(kodeInput);
                            keranjangNama.add(namaBrg);
                            keranjangJumlah.add(jumlahBeli);
                            keranjangHargaSatuan.add(hargaBrg);
                            keranjangSubtotal.add(hargaBrg * jumlahBeli);

                            System.out.println("\n" + namaBrg + " sebanyak " + jumlahBeli + " berhasil ditambahkan");
                        }
                        
                        //Setelah selesai belanja (checkout)
                        if (kodeInput.equals("0")) {
                            if (keranjangKode.isEmpty()) {
                                System.out.println("Tidak ada barang yang dibeli.");
                            } else {
                                System.out.println("\n=== Struk Belanja ===");
                                System.out.printf("%-10s %-20s %-10s %-15s %-10s%n", "Kode", "Nama Barang", "Jumlah", "Harga Satuan", "Subtotal");
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

                case 2:
                    System.out.println("\n=== Kelola Stok Barang ===");
                    break;
                case 3:
                    System.out.println("\n=== Riwayat Pembelian ===");
                    break;                    
                case 4:
                    System.out.println("Selesai bekerja.");
                    System.out.println("Total Pendapatan Hari Ini:" + pendapatanHarian);
                    bekerja = false;
                    break; 

            }
            
        } while (bekerja);





    }
}
