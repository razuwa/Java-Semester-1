package Project;

import java.util.Scanner;
import java.util.ArrayList;

public class ManajemenStokdanKasir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> kodeBarang = new ArrayList<>();
        ArrayList<String> namaBarang = new ArrayList<>();
        ArrayList<Double> daftarHarga = new ArrayList<>();
        ArrayList<Double> daftarStok = new ArrayList<>();
        String namaKasir;
        int i = 0, tanggalHari, nomorPelanggan;
        double totalBelanja = 0.0, pendapatanHarian = 0.0;
        char konfirmasi;
        char lanjut = 'y';

        
        //Login Kasir
        System.out.println("=== Manajemen Stok dan Kasir ===");
            //Input nama
        System.out.print("Masukkan Nama Kasir: ");
        namaKasir = scanner.nextLine();
            //Input tanggal
        while (true) {
            System.out.print("Masukkan Tanggal Hari Ini (1-31): ");
                tanggalHari = scanner.nextInt();
                if (tanggalHari < 1 || tanggalHari > 31) {
                    System.out.println("Tanggal tidak valid. Silakan masukkan angka antara 1-31.");
                    continue;
                }
                break;
        }
        System.out.println("Login Berhasil. Selamat Bekerja, " + namaKasir + "!");

        //Stok Awal Barang
        kodeBarang.add("001"); namaBarang.add("Beras"); daftarHarga.add(15000.0); daftarStok.add(50.0);
        kodeBarang.add("002"); namaBarang.add("Gula"); daftarHarga.add(12000.0); daftarStok.add(30.0);
        kodeBarang.add("003"); namaBarang.add("Minyak Goreng"); daftarHarga.add(14000.0); daftarStok.add(20.0);
        kodeBarang.add("004"); namaBarang.add("Mi Instan"); daftarHarga.add(4000.0); daftarStok.add(120.0);
        kodeBarang.add("005"); namaBarang.add("Gas LPG"); daftarHarga.add(20000.0); daftarStok.add(10.0);

        //Menu Utama
        boolean bekerja = true;
        do {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Kasir");
            System.out.println("2. Kelola Stok Barang");
            System.out.println("3. Selesai bekerja");
            System.out.print("Pilih menu (1-3): ");
            int pilihMenu = scanner.nextInt();

            switch (pilihMenu) {
                case 1:
                    ArrayList<String> keranjangKode = new ArrayList<>();
                    ArrayList<String> keranjangNama = new ArrayList<>();
                    ArrayList<Integer> keranjangJumlah = new ArrayList<>();
                    ArrayList<Double> keranjangHargaSatuan = new ArrayList<>();
                    ArrayList<Double> keranjangSubtotal = new ArrayList<>();
            }
            
        } while (bekerja);





    }
}
