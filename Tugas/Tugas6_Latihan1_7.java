import java.util.Scanner;
public class Tugas6_Latihan1_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, total = 1;
        String kali = "";
        System.out.print("Masukkan n bilangan yang ingin dikalikan: ");
        n = scanner.nextInt();

        for (int i = 1; i <= n; i++ ) {
            //System.out.println("tes" + i);
            int angka;
            System.out.print("Masukkan angka ke-" + i + ": ");
            angka = scanner.nextInt();
            total = total * angka;

            if (i == 1) {
                kali = kali + angka;
            }
            else {
                kali = kali + "*" + angka;
            }
        }
        System.out.println(kali + " = " + total);
    }
}
