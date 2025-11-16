import java.util.Scanner;
public class Prak5_PerulanganWhile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int jumlah;
        // System.out.print("Inputkan jumlah perulangan: ");
        // jumlah = scanner.nextInt();
        int i = 1; //nilai awal
        // while (i <= jumlah) {
        //     System.out.println("Perulangan ke-" + i);
        //     i++;
        // }

        // //hitung mundur
        // i = jumlah;
        // while (i >= 1) {
        //     System.out.println("Perulangan ke-" + i);
        //     i--;
        // }

        char konfirmasi;
        konfirmasi = 'y';
        i = 0;
        while (konfirmasi=='y'){
            i ++;
            System.out.println("Perulangan konfirmasi ke-" + i);
            System.out.print("Cetak lagi? (y/t): ");
            konfirmasi = scanner.next().charAt(0);
        }
    }
}
