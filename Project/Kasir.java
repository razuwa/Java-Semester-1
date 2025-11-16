package Project;

import java.util.Scanner;
import java.util.ArrayList;

public class Kasir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        char konfirmasi;
        double totalBelanja = 0.0;
        ArrayList<String> namaBarang = new ArrayList<>();
        ArrayList<Double> jumlahBarang = new ArrayList<>();
        ArrayList<Double> hargaBarang = new ArrayList<>();
        char lanjut = 'y';
        do {
            System.out.println("Pilih Menu: 1. Tambah Barang 2. Hitung Total");
            System.out.print("Masukkan pilihan: ");
            char pilih = scanner.next().charAt(0);

            switch (pilih) {
                case '1':
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.next();
                    System.out.print("Masukkan jumlah barang: ");
                    double jumlah = scanner.nextDouble();
                    System.out.print("Masukkan harga per barang: ");
                    double harga = scanner.nextDouble();

                    namaBarang.add(nama);
                    jumlahBarang.add(jumlah);
                    hargaBarang.add(harga);
                    i++;
                    break;
                case '2':
                    System.out.println("Daftar Belanja:");
                    for (int j = 0; j < i; j++) {
                        double subtotal = jumlahBarang.get(j) * hargaBarang.get(j);
                        System.out.println((j + 1) + ". " + namaBarang.get(j) + " - Jumlah: " + jumlahBarang.get(j) + ", Harga: " + hargaBarang.get(j) + ", Subtotal: " + subtotal);
                        totalBelanja += subtotal;
                    }
                    System.out.println("Total Belanja: " + totalBelanja);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (lanjut == 'y');
    }
}
