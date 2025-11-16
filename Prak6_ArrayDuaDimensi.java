import java.util.Scanner;
public class Prak6_ArrayDuaDimensi {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);
        int max = 3;
        int i, j;
        int A[][] = new int [max][max];
        int B[][] = new int [max][max];
        System.out.println("Masukkan Matriks A: ");
        for (i = 0; i < max; i++) {
            for (j = 0; j < max; j++) {
                System.out.print("Elemen A[" + i + "][" + j + "]: ");
                A[i][j] = data.nextInt(); data.nextLine();
            }
        }
        System.out.println("Matrix A: ");
        for (i = 0; i < max; i++) {
            for (j = 0; j < max; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.print("");
            System.out.print("\n");
        }
    }
}
