import java.util.Scanner;
public class Tugas6_Latihan2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, total = 1;
        System.out.print("Masukkan n faktorial: ");
        n = scanner.nextInt();

        for (int i = n; i >= 1; i-- ){
            //System.out.println("tes"+i);
            total = total * i;
            System.out.print(i);
            if (i > 1) {
                System.out.print(" * ");
            }
            if (i == 1){
                System.out.println(" = " + total);
            }
        }
    }
}
