import java.util.Scanner;


public class latihann {
    public static void main(String[] args) {
        final double PI = 3.14;
        Scanner input  = new Scanner(System.in);

        System.out.println("masukan jari jari:");
        double r = input.nextDouble();

        System.out.println("masukan Tinggi:");
        double t = input.nextDouble(); 

        double volume = PI * r * r * t;

        System.out.println("Hasil adalaha: \n" + volume);

        input.close();


    }
}
