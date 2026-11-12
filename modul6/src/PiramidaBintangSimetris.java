import java.util.Scanner;

/**
 * Postest - Pengembangan (OPSIONAL)
 *
 * Versi piramida yang benar-benar "piramida" / simetris: setiap baris
 * didahului spasi agar bintang berada tepat di tengah.
 * Contoh untuk tinggi = 5:
 *       *
 *      ***
 *     *****
 *    *******
 *   *********
 */
public class PiramidaBintangSimetris {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan tinggi piramida: ");
        int tinggi = input.nextInt();

        for (int baris = 1; baris <= tinggi; baris++) {

            // Perulangan 1: mencetak SPASI (semakin ke bawah semakin sedikit)
            for (int spasi = 1; spasi <= tinggi - baris; spasi++) {
                System.out.print(" ");
            }

            // Perulangan 2: mencetak BINTANG (bilangan ganjil: 1, 3, 5, ...)
            for (int bintang = 1; bintang <= (2 * baris - 1); bintang++) {
                System.out.print("*");
            }

            System.out.println();
        }

        input.close();
    }
}
