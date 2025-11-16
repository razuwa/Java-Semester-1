import java.util.Scanner;
public class Latihan1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double Celcius, Reamur, Fahrenheit, Kelvin;
        System.out.print("Masukkan suhu dalam Celcius: ");
        Celcius = scanner.nextDouble();
        Reamur = (4.0/5.0) * Celcius;
        Fahrenheit = ((9.0/5.0) * Celcius) + 32;
        Kelvin = Celcius + 273.15;
        System.out.println("Suhu dalam Reamur: " + Reamur);
        System.out.println("Suhu dalam Fahrenheit: " + Fahrenheit);
        System.out.println("Suhu dalam Kelvin: " + Kelvin);
        
    }
}
