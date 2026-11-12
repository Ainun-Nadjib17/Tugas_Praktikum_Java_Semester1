import java.util.Scanner;

public class Latihan2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int angka = 0;

        while (angka >= 0) {
            System.out.print("Masukkan angka: ");
            angka = scanner.nextInt();
        }

        System.out.println("Anda memasukkan angka negatif. Program selesai.");
        scanner.close();
    }
}
