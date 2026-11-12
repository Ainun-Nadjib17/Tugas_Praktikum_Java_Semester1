import java.util.Scanner;

public class Postest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int angka;

        // Minta input hingga pengguna memasukkan bilangan bulat non-negatif
        while (true) {
            System.out.print("Masukkan bilangan bulat non-negatif: ");
            if (scanner.hasNextInt()) {
                angka = scanner.nextInt();
                if (angka >= 0) {
                    break;
                }
                System.out.println("Input tidak valid! Bilangan tidak boleh negatif.");
            } else {
                System.out.println("Input tidak valid! Masukkan bilangan bulat.");
                scanner.next(); // buang input yang bukan angka
            }
        }

        // Hitung faktorial menggunakan perulangan for
        long faktorial = 1;
        String proses = "";
        for (int i = 1; i <= angka; i++) {
            faktorial *= i;
            proses += (i == 1) ? i : " x " + i;
        }

        // Tampilkan hasil
        if (angka == 0) {
            System.out.println(angka + "! = " + faktorial);
        } else {
            System.out.println(angka + "! = " + proses + " = " + faktorial);
        }

        scanner.close();
    }
}
