import java.util.Scanner;

public class Tugas6_Latihan2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bil1, bil2;
        System.out.print("Masukkan angka pertama: ");
        bil1 = scanner.nextInt();
        System.out.print("Masukkan angka kedua: ");
        bil2 = scanner.nextInt();

        int min;
        if (bil1<bil2) {
            min = bil1;
        }
        else {
            min = bil2;
        }

        int fpb = 1;

        for (int i = min; i >= 1; i--){
            if (bil1 % i == 0 && bil2 % i == 0) {
                fpb = i;
                break;
            }
        }

        System.out.println("FPB dari " + bil1 + " dan " + bil2 + " = " + fpb);

    }
}
