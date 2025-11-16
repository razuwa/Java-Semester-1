import java.util.Scanner;
public class Tugas6_Latihan1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nilai_1, nilai_2;   
        System.out.print("Masukkan angka pertama: ");
        nilai_1 = scanner.nextInt();
        System.out.print("Masukkan angka terakhir: ");
        nilai_2 = scanner.nextInt();

        while (nilai_1 <= nilai_2) {
            System.out.println("angka = " + nilai_1);
            nilai_1 = nilai_1 + 1;
        }
    }
    
    
}
