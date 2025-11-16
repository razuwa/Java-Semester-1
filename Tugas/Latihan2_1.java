import java.util.Scanner;
public class Latihan2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char gol;
        int gaji, gaji_bersih;
        String golongan;
        double pajak = 0.02;
        System.out.print("Masukkan golongan: ");
        gol = scanner.next().charAt(0);
        switch (gol) {
            case '1':
                gaji_bersih = 1000000;
                golongan = "Golongan 1";
                break;
            case '2':
                gaji_bersih = 2000000;
                golongan = "Golongan 2";
                break;
            case '3':
                gaji = 3000000;
                gaji_bersih = gaji - (int)(gaji*pajak);
                golongan = "Golongan 3";
                break;
            default:
                gaji_bersih = 0;
                golongan = "Tidak ada golongan " + gol;
                break;
        }
        System.out.println(golongan + ", Dengan gaji bersih: " + gaji_bersih);

    }
}
