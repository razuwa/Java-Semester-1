import java.util.Scanner;
public class SigmaBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jumlah, bil; int total = 0; int kali = 1;
        System.out.print("Inputkan jumlah perulangan: ");
        jumlah = scanner.nextInt();
        int i = 1; //nilai awal
        while (i <= jumlah){
            System.out.print("Masukkan bilangan ke-"+i+":");
            bil = scanner.nextInt();
            total = total + bil;
            kali = kali * bil;
            i++;
            //System.out.println("Jumlah total sementara:"+total);
        }
        System.out.println("Total jumlah bilangan: " + total);
        System.out.println("Total jumlah kali bilangan: " + kali);
    }
}
