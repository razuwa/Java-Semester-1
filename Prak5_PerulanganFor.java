import java.util.Scanner;
public class Prak5_PerulanganFor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int jumlah;
        System.out.print("Inputkan jumlah perulangan: ");
        jumlah = scanner.nextInt();

        // for (int i=1; i<= jumlah; i++){
        //     System.out.println("Perulangan ke-" + i);
        // }

        // for(int i=2; i<=10; i+=1)
        // {System.out.println(i);}
        // for(int i=1; i<=10; i++)
        // if (i % 2 == 0) {
        //     System.out.println(i + " adalah angka genap");}
        // else {System.out.println(i + " adalah angka ganjil");}

        int Un, Sn=0;
        for (int i=1; i<=jumlah; i++){
            Un=2*1-1;
            Sn=Sn+Un;
            System.out.println("Deret ke-"+i+": "+Un);
        }
        System.out.println("Deret ke-"+ jumlah +":"+Sn);
    }
}
