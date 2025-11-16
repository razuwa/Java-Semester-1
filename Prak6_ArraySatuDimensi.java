import java.util.Scanner;
public class Prak6_ArraySatuDimensi {
    static Scanner data = new Scanner(System.in);
    public static void main(String[] args) {
        String nama [] = {"Adit","Budi","Caca","Dodi"};
        int[] nilaiAlgo = new int [4];
        int[] nilaiMath = new int [4]; int i;
        for (i = 0; i < nilaiAlgo.length; i++) {
            System.out.print("Masukkan nilai Algoritma "+ nama[i] + ": ");
            nilaiAlgo[i] = data.nextInt(); data.nextLine();
        }
        for (i = 0; i < nilaiMath.length; i++) {
            System.out.print("Masukkan nilai Matematika "+ nama[i] + ": ");
            nilaiMath[i] = data.nextInt(); data.nextLine();
        }
        // Proses hitung
        double jmlAlgo = 0, rataAlgo;
        for (i = 0; i < nilaiAlgo.length; i++) {
            jmlAlgo += nilaiAlgo[i];
        }
        rataAlgo = jmlAlgo / 4;

        double jmlMath = 0, rataMath;
        for (i = 0; i < nilaiMath.length; i++) {
            jmlMath += nilaiMath[i];
        }
        rataMath = jmlMath / 4;

        //Cetak data
        for (i = 0; i < nama.length; i++) {
            System.out.println("Nama Siswa ke-"+ (i+1)+": "+ nama[i]);
        }
        for (i = 0; i < nilaiAlgo.length; i++) {
            System.out.println("Nilai Algoritma "+ nama[i] + ": " + nilaiAlgo[i]);
        }
        for (i = 0; i < nilaiMath.length; i++) {
            System.out.println("Nilai Matematika "+ nama[i] + ": " + nilaiMath[i]);
        }
        System.out.println("Rata-rata Nilai Algoritma: " + rataAlgo);
        System.out.println("Rata-rata Nilai Matematika: " + rataMath);
    }
}
