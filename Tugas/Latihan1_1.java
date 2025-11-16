import java.util.Scanner;
public class Latihan1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalbelanja, hargasetelahdiskon;
        double diskon5 = 0.05, diskon10 = 0.1;
        System.out.print("Masukkan total belanja: ");
        totalbelanja = scanner.nextInt();
        if (totalbelanja >= 100000) {
            hargasetelahdiskon = totalbelanja - (int)(totalbelanja * diskon10);
            System.out.println("Anda belanja di atas 100.000, Anda mendapatkan diskon 10%");
            System.out.println("Harga setelah diskon 10%: " + hargasetelahdiskon);
        } else if (totalbelanja >= 50000) {
            hargasetelahdiskon = totalbelanja - (int)(totalbelanja * diskon5);
            System.out.println("Anda belanja di atas 50.000, Anda mendapatkan diskon 5%");
            System.out.println("Harga setelah diskon 5%: " + hargasetelahdiskon);
        } else {
            System.out.println("Tidak ada diskon. Total belanja: " + totalbelanja);
        }
    }
}
