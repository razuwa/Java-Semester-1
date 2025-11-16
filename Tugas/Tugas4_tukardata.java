import java.util.Scanner;
public class Tugas4_tukardata {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);

        int a, b;
        System.out.print("Masukkan nilai a: ");
        a = data.nextInt(); data.nextLine();
        System.out.print("Masukkan nilai b: ");
        b = data.nextInt(); data.nextLine();

        System.out.println("\n--- Sebelum ditukar ---");
        System.out.println("Nilai a: " + a);
        System.out.println("Nilai b: " + b);

        int temp = a;

        a = b;
        b = temp;

        System.out.println("\n--- Setelah Ditukar ---");
        System.out.println("Nilai a: " + a);
        System.out.println("Nilai b: " + b);
    }
}