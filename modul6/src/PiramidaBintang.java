import java.util.Scanner;

/**
 * Postest - Pola Piramida Bintang
 *
 * Mencetak pola bintang bertingkat dengan tinggi sesuai input pengguna.
 * Contoh untuk tinggi = 5:
 *   *
 *   **
 *   ***
 *   ****
 *   *****
 */
public class PiramidaBintang {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan tinggi piramida: ");
        int tinggi = input.nextInt();

        // Perulangan LUAR -> menentukan berapa baris yang dicetak
        for (int baris = 1; baris <= tinggi; baris++) {

            // Perulangan DALAM -> mencetak bintang sebanyak nomor baris
            for (int bintang = 1; bintang <= baris; bintang++) {
                System.out.print("*");
            }

            System.out.println(); // ganti baris setelah satu baris selesai
        }

        input.close();
    }
}

