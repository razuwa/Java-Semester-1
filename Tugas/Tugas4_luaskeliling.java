import java.util.Scanner;
public class Tugas4_luaskeliling {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);

        double jarijari, luas1, luas2, keliling;
        double phi = 3.14;

        System.out.print("Masukkan jari-jari: ");
        jarijari = data.nextInt(); data.nextLine();

        luas1 = jarijari * jarijari * (22/7);
        keliling = 2 * (22/7) * jarijari;
        
        System.out.println("Jari-jari: " + jarijari);
        System.out.println("Luas Lingkaran: " + luas1);
        System.out.println("Keliling Lingkaran: " + keliling);

    }
}
