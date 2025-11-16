import java.util.Scanner;
public class Tugas6_Latihan1_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a, b, n;
        System.out.print("\nMasukkan suku pertama (a): ");
        a = scanner.nextInt();
        System.out.print("Masukkan nilai beda (b): ");
        b = scanner.nextInt();
        System.out.print("Masukkan banyaknya suku (n): ");
        n = scanner.nextInt();
        System.out.println(" ");

        int total = 0, sukusekarang = a;

        for(int i = 1; i <= n; i++){
            total += sukusekarang;
            System.out.println("Suku saat ini: " + sukusekarang);
            sukusekarang += b;
        }
        System.out.println("------------------- +");
        System.out.println("Jumlah deret = " + total);
    }
}
