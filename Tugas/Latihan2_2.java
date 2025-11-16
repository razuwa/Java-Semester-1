import java.util.Scanner;

public class Latihan2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double nilai;
        String status, konversi;
        System.out.print("Masukkan nilai: ");
        nilai = scanner.nextDouble();
        if (nilai >= 0 && nilai <= 100) {
            if (nilai < 60) {
                status = "Tidak lulus";
            } else {
                status = "Lulus";
            }

            if (nilai >= 60 && nilai < 70) {
                konversi = "Cukup";
            } else if (nilai >= 70 && nilai < 80) {
                konversi = "Baik";
            } else if (nilai >= 80 && nilai <= 100) {
                konversi = "Sangat Baik";
            } else {
                konversi = "Kurang";
            }
            System.out.println("Mahasiswa dinyatakan " + status + ", dengan nilai: " + nilai);
            System.out.println("dengan kriteria kelulusan: " + konversi);
        } else {
            System.out.println("Nilai yang anda masukkan tidak valid");
            System.out.println("Kelulusan dan kriteria tidak akan dihitung");
        }

    }
}
