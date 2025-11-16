import java.util.Scanner;

public class Prak4_PercabanganIf{
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);
        int nilai;
        System.out.print("Masukkan nilai anda: ");
        nilai = data.nextInt();
        System.out.println("Nilai = " + nilai);
        if (nilai==0){
            System.out.println("Mahasiswa tidak mengikuti kuliah");
        }

        String kelulusan;
        if (nilai >= 60){
            kelulusan = "Lulus";
        }
        else {
            kelulusan = "Tidak lulus";
        }

        char konversi;
        if(nilai < 60){
            konversi = 'C';
        }
        else {
            if (nilai < 85){
                konversi = 'B';
            }
            else {
                konversi = 'A';
            }
        }
        System.out.println("Status kelulusan mahasiswa = " + kelulusan);
        System.out.println("Konversi nilai mahasiswa = " + konversi);

    }
}
