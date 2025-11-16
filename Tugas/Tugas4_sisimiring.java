import java.util.Scanner;
public class Tugas4_sisimiring {
    public static void main(String[] args){
        Scanner data = new Scanner(System.in);

        double alas, sisi_miring, tinggi;

        System.out.print("Masukkan alas: ");
        alas = data.nextInt(); data.nextLine();

        System.out.print("Masukkan tinggi: ");
        tinggi = data.nextInt(); data.nextLine();

        sisi_miring = Math.sqrt(alas*alas + tinggi*tinggi);
        
        System.out.println("Sisi miring: " + sisi_miring);
        
    }
}
