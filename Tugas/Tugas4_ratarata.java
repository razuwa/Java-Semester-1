import java.util.Scanner;
public class Tugas4_ratarata {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);

        double nilai_mat, nilai_algo, rata_rata_bobot;
        int sks_mat = 2;
        int sks_algo = 3;

        System.out.print("Masukkan nilai matematika: ");
        nilai_mat = data.nextInt(); data.nextLine();

        System.out.print("Masukkan nilai algoritma: ");
        nilai_algo = data.nextInt(); data.nextLine();

        rata_rata_bobot = (nilai_mat*2 + nilai_algo*3)/(sks_mat+sks_algo);
        
        System.out.println("Rata-rata nilai = " + rata_rata_bobot);
    }
}

