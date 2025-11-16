import java.util.Scanner;
public class Tugas6_Latihan2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, r, n;
        System.out.print("Masukkan suku pertama (a): ");
        a = scanner.nextInt();
        System.out.print("Masukkan rasio (r): ");
        r = scanner.nextInt();
        System.out.print("Masukkan jumlah suku (n): ");
        n = scanner.nextInt();

        int total = 0, sukusekarang = a;
        String deret = "";
        
        for (int i = 1; i <= n; i++){
            total += sukusekarang;
            deret += sukusekarang;
            if (i < n){
                deret += ", ";
            }
            sukusekarang = sukusekarang * r;
        }

        System.out.println("Deret: " + deret);
        System.out.println("Hasil penjumlahan: " + total);
        
    }
}
