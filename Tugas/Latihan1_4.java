import java.util.Scanner;

public class Latihan1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int data1, data2, data3, data_max;
        System.out.print("Masukkan data 1: ");
        data1 = scanner.nextInt();
        System.out.print("Masukkan data 2: ");
        data2 = scanner.nextInt();
        System.out.print("Masukkan data 3: ");
        data3 = scanner.nextInt();
        if (data1 >= data2 && data1 >= data3) {
            data_max = data1;
        } else if (data2 >= data1 && data2 >= data3) {
            data_max = data2;
        } else {
            data_max = data3;
        }
        System.out.println("Data terbesar = " + data_max);

    }
}
