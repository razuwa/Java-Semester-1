import java.util.Scanner;
public class Tugas4_segitigasamakaki {
    public static void main(String[] args){
        Scanner data = new Scanner(System.in);

        double alas1, alas2, tinggi, sisi_miring, keliling, luas;

        System.out.print("Masukkan alas: ");
        alas1 = data.nextInt(); data.nextLine();

        System.out.print("Masukkan tinggi: ");
        tinggi = data.nextInt(); data.nextLine();

        alas2 = alas1/2;
        sisi_miring = Math.sqrt(alas2*alas2 + tinggi*tinggi);
        keliling = 2 * sisi_miring + alas1;
        luas = 0.5 * alas1 * tinggi;

        System.out.println("Sisi miring = " + sisi_miring);
        System.out.println("=========================");
        
        System.out.println("Keliling = " + keliling + " cm");
        System.out.println("Luas = " + luas + " cm²");


    }
}
