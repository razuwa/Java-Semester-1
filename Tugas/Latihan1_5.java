import java.util.Scanner;
public class Latihan1_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int angka;
        System.out.print("Masukkan Angka: ");
        angka = scanner.nextInt();
        if (angka<0) {}
        else if (angka % 2 == 0){
            System.out.println(angka + " Merupakan bilangan genap");
        }
        else {
            System.out.println(angka + " Merupakan bilangan ganjil");
        }
        System.out.println("Akhir dari program");
    }
}
