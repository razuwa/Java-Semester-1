import java.util.Scanner;
public class Tugas6_Latihan1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char karakter = ' ';
        while (karakter != 'x' && karakter != 'X') {
            System.out.print("Masukkan karakter: ");
            karakter = scanner.next().charAt(0);

            if (karakter != 'x' && karakter != 'X') {
                System.out.println("Anda menginput: " + karakter);
            }
        }
        System.out.println("Anda menginputkan 'x' atau 'X', program berakhir");
    }
}
