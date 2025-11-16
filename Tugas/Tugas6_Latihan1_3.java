import java.util.Scanner;
public class Tugas6_Latihan1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, total = 0;
        System.out.print("Masukkan jumlah suku ke-n: ");
        N = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            total += i;
            System.out.print(i);
            if (N>i) {
                System.out.print(" + ");
            }
        }

        System.out.println(" = " + total);
    }
}
