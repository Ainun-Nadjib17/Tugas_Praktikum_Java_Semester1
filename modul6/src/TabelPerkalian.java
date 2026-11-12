/**
 * Latihan 1 - Versi Dasar
 * Mencetak tabel perkalian 1 sampai 5 menggunakan perulangan for bersarang.
 */
public class TabelPerkalian {

    public static void main(String[] args) {
        // Perulangan LUAR  -> mengontrol baris (angka pertama / i)
        for (int i = 1; i <= 5; i++) {

            // Perulangan DALAM -> mengontrol kolom (angka kedua / j)
            for (int j = 1; j <= 5; j++) {
                System.out.print(i * j + "\t"); // cetak hasil i * j, Tab sebagai pemisah
            }

            System.out.println(); // pindah ke baris berikutnya setelah 1 baris selesai
        }
    }
}
