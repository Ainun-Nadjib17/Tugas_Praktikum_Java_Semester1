import java.util.Scanner;

public class Latihan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kalimat: ");
        String kalimat = scanner.nextLine();

        // Menghitung jumlah karakter
        int panjang = kalimat.length();
        System.out.println("Jumlah karakter: " + panjang);

        scanner.close();
    }
}
