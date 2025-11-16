import java.util.Scanner;
public class Tugas6_Latihan1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float N, total = 0;
        float rata = 0;
        System.out.print("Masukkan bilangan yang akan dihitung: ");
        N = scanner.nextFloat();

        for(int i = 1; i <= N; i++ ){
            total += i;
            rata = total / i ;
        }
        
        System.out.println("Jumlah suku ke-" + (int)N + " = " + (int)total);
        System.out.println("rata-ratanya = " + rata);
       
    }
}
