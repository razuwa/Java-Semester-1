import java.util.Scanner;

public class Tugas6_Latihan2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bil1, bil2;
        System.out.print("Masukkan angka pertama: ");
        bil1 = scanner.nextInt();
        System.out.print("Masukkan angka kedua: ");
        bil2 = scanner.nextInt();

        int maks, min;
        if (bil1>bil2) {
            maks = bil1;
            min = bil2;
        }
        else {
            maks = bil2;
            min = bil1;
        }

        int kpk = maks;

        while (true) {
            if (kpk % min == 0) {
                System.out.println("KPK dari " + bil1 + " dan " + bil2 + " = " + kpk);
                break;
            }
            kpk = kpk + maks;
        }
    }
}
