import java.util.Scanner;
public class Tugas6_Latihan2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int basis, pangkat, total = 1;
        System.out.print("Masukkan nilai basis: ");
        basis = scanner.nextInt();
        System.out.print("Masukkan nilai pangkat: ");
        pangkat = scanner.nextInt();
        String pkt = "";

        for(int i = 1; i <= pangkat; i++){
            //System.out.println(i);
            //System.out.print(bas);
            total = total * basis;

            if (i == 1) {
                pkt += basis;
            }
            else {
                pkt += " * " + basis;
            }
        }
        System.out.println(pkt + " = " + total);
        //System.out.println(total);
    }
}
