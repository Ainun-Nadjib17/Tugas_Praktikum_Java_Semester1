import java.util.Scanner;

/**
 * SOAL UTS No. 2 — Menentukan Bilangan Ganjil atau Genap
 *
 * Bilangan GENAP  -> habis dibagi 2 (sisa 0), contoh: 2, 4, 6, 8
 * Bilangan GANJIL -> tidak habis dibagi 2 (sisa 1), contoh: 1, 3, 5, 7
 *
 * Cek sisa bagi pakai operator modulo "%".
 * User menginput satu bilangan bulat.
 */
public class Soal2_GanjilGenap {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // User menginput bilangan bulat
        System.out.print("Masukkan sebuah bilangan bulat: ");
        int angka = input.nextInt();

        // Cek genap / ganjil
        if (angka % 2 == 0) {
            System.out.println(angka + " adalah bilangan GENAP");
        } else {
            System.out.println(angka + " adalah bilangan GANJIL");
        }

        input.close();
    }
}
