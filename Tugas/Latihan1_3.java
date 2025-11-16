import java.util.Scanner;
public class Latihan1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data1, data2;
        System.out.print("Masukkan data 1: ");
        data1 = scanner.nextInt();
        System.out.print("Masukkan data 2: ");
        data2 = scanner.nextInt();
        if (data1>data2) { //jika data 1 lebih besar dari data 2
            int temp = data1; //maka dilakukan pertukaran
            data1 = data2; //supaya hasilnya tetap dari kecil ke besar (ascending)
            data2 = temp;
        }
        System.out.println("data 1 = " + data1 + " data 2 = " + data2);

    }
}
