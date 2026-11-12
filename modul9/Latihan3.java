import java.util.Scanner;

public class Latihan3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan String pertama: ");
        String str1 = scanner.nextLine();

        System.out.print("Masukkan String kedua: ");
        String str2 = scanner.nextLine();

        // Menggabungkan String
        String gabungan = str1.concat(str2);
        System.out.println("String gabungan: " + gabungan);

        scanner.close();
    }
}
