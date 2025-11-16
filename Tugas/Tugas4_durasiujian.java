import java.util.Scanner;

public class Tugas4_durasiujian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        int jam_mulai, menit_mulai, detik_mulai, jam_selesai, menit_selesai, detik_selesai;

        System.out.println("Masukkan waktu mulai ujian:");
        System.out.print("Pukul mulai   : ");
        jam_mulai = input.nextInt();
        System.out.print("Menit mulai : ");
        menit_mulai = input.nextInt();
        System.out.print("Detik mulai : ");
        detik_mulai = input.nextInt();

        System.out.println("\nMasukkan waktu selesai ujian:");
        System.out.print("Pukul selesai   : ");
        jam_selesai = input.nextInt();
        System.out.print("Menit selesai : ");
        menit_selesai = input.nextInt();
        System.out.print("Detik selesai : ");
        detik_selesai = input.nextInt();

        int total_mulai = (jam_mulai * 3600) + (menit_mulai * 60) + detik_mulai;
        int total_selesai = (jam_selesai * 3600) + (menit_selesai * 60) + detik_selesai;

        int durasi_detik = total_selesai - total_mulai;

        int jam = durasi_detik / 3600;
        int sisa = durasi_detik % 3600;
        int menit = sisa / 60;
        int detik = sisa % 60;

        System.out.println("\nDurasi ujian adalah: " + jam + " jam, " + menit + " menit, dan " + detik + " detik.");

        input.close();
    }
} 
    
