import java.util.Scanner;
public class Prak3_InputScanner {
    public static void main(String[] args) {
            Scanner data = new Scanner (System.in);
            int umur;
            double tinggi;
            String nama;
            char jk;
            boolean aktif;
        System.out.print("Masukkan umur anda: ");
        umur = data.nextInt(); data.nextLine();
        System.out.print("Masukkan nama anda: ");
        nama = data.nextLine();
        System.out.print("Masukkan tinggi anda: ");
        tinggi = data.nextDouble(); data.nextLine();
        System.out.print("Masukkan jenis kelamin (L/P): ");
        jk = data.next().charAt(0); data.nextLine();
        System.out.print("Aktif ? ");
        aktif = data.nextBoolean(); data.nextLine();
        System.out.println(nama + " Berumur " + umur + ", tinggi " + tinggi);
        System.out.println("Jenis Kelamin " + jk + " Status Aktif " + aktif);

    }
}
