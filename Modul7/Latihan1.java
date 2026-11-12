import java.util.Scanner;


public class Latihan1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] angka = new int[5];

        // Mengisi array dengan input pengguna
        for (int i = 0; i < angka.length; i++) {
            System.out.print("Masukkan nilai ke-" + (i + 1) + ": ");
            angka[i] = scanner.nextInt();
        }

        // Inisialisasi dengan elemen pertama, bukan 0, agar tetap benar
        // walaupun semua nilai yang diinput bernilai negatif.
        int max = angka[0];
        int min = angka[0];

        // Menentukan nilai maksimum dan minimum
        for (int i = 1; i < angka.length; i++) {
            if (angka[i] > max) {
                max = angka[i];
            }
            if (angka[i] < min) {
                min = angka[i];
            }
        }

        // Menampilkan kembali data agar hasil mudah diperiksa
        System.out.print("Data yang diinput: ");
        for (int i = 0; i < angka.length; i++) {
            System.out.print(angka[i] + (i < angka.length - 1 ? ", " : "\n"));
        }

        System.out.println("Nilai maksimum: " + max);
        System.out.println("Nilai minimum: " + min);

        scanner.close();
    }
}
