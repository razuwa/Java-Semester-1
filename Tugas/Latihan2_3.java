import java.util.Scanner;
public class Latihan2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c, D;
        double x1, x2;
        String akar, syarat;

        // a. menentukan akar akar real, sama, atau imajiner (khayal)
        System.out.print("\nMasukkan nilai a: ");
        a = scanner.nextInt();
        System.out.print("Masukkan nilai b: ");
        b = scanner.nextInt();
        System.out.print("Masukkan nilai c: ");
        c = scanner.nextInt();

        System.out.println("\nDiketahui persamaan kuadrat dengan:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("\n--------a. Menentukan sifat akar--------");

        D = (b*b) - (4*a*c);

        if (a != 0){
            if (D > 0) {
            akar = "Akar-akar real";
            syarat = "D > 0";
        }
            else if (D == 0) {
            akar = "Akar-akar kembar";
            syarat = "D = 0";
        }
            else if (D < 0) {
            akar = "Akar-akar imajiner (khayal)";
            syarat = "D < 0";
        }
            else{
            akar = "tidak valid";
            syarat = "tidak valid";
        }

            System.out.println("Karena nilai D (Diskriminan) = "+D+", maka "+syarat+", maka "+akar);
        
            // b. menenutkan nilai akar jika akarnya real
            System.out.println("\n--------b. Menentukan nilai akar--------");
            x1 = (-b + Math.sqrt(D))/2*a;
            x2 = (-b - Math.sqrt(D))/2*a;
            if (D >= 0) {
                System.out.println("akar pertama = "+x1);
                System.out.println("akar kedua = "+x2);
            }
            else {
                System.out.println("Nilai akar-akar tidak bisa dihitung karena D<0 (akar-akar imajiner)");
            }
            
            // c. Menentukan apakah definit negatif atau positif
            System.out.println("\n--------c. Menentukan nilai definit--------");
            if (D < 0){
                if (a > 0){
                    System.out.println("Persamaan kuadrat ini memiliki definit positif");
                }
                else if (a < 0){
                    System.out.println("Persamaan kuadrat ini memiliki definit negatif");
                }
            }
            else{
                System.out.println("Definit tidak dapat ditentukan karena D>0 (akar-akar real)");
            }
            
        }

        else {
            System.out.println("Nilai a tidak boleh = 0 !");
        }

        System.out.println("\n********Akhir dari program********");
        
    }
}
