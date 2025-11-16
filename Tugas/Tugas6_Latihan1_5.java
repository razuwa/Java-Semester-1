import java.util.Scanner;
public class Tugas6_Latihan1_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // int jumlah;
        // System.out.print("Masukkan jumlah perulangan: ");
        // jumlah = scanner.nextInt();
        int i = 0;
        char konfirmasi;
        float bilangan, total = 0, rata;
        konfirmasi = 'y';
        while (konfirmasi == 'y'){
            i ++;
            System.out.print("\nMasukkan bilangan: ");
            bilangan = scanner.nextFloat();
            total = bilangan + total;
            rata = total / i;
            System.out.println("jumlah bilangan saat ini = " + (int)total);
            System.out.println("rata-rata bilangan saat ini = " + rata);
            System.out.print("\nHitung lagi? (y/n): ");
            konfirmasi = scanner.next().charAt(0);
        }
        System.out.println("Program berakhir");
    }
}