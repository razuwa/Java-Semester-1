import java.util.Scanner;
public class Prak4_PercabanganSwitch {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        char pilih;
        System.out.println("Pilih menu: 1. Mi ayam, 2. Bakso, 3. Mi ayam bakso");
        System.out.print("Masukkan pilihan anda: ");
        pilih = scanner.next().charAt(0);
        System.out.println("Pilihan: " + pilih);
        String namamenu; int harga;
        switch(pilih){
            case '1' :namamenu = "Mi ayam"; harga = 10000; break;
            case '2' :namamenu = "Bakso"; harga = 20000; break;
            case '3' :namamenu = "Mi ayam bakso"; harga = 15000; break;
            default : namamenu = "Tidak memilih"; harga = 0;
        }
        System.out.println("Menu: " + namamenu + " harga: " + harga);
    }
}
