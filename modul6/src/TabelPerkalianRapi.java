/**
 * Latihan 1 - Versi Modifikasi (lebih rapi)
 *
 * Perbedaan dengan versi dasar:
 * versi dasar memakai "\t" (tab) sehingga lebar kolom bergantung pada panjang
 * angka, akibatnya kolom tidak lurus. Versi ini memakai System.out.printf()
 * dengan lebar kolom TETAP (4 karakter, rata kanan) sehingga tabel selalu rapi
 * berapa pun besar angkanya.
 */
public class TabelPerkalianRapi {

    public static void main(String[] args) {
        final int BATAS = 5; // ubah nilai ini untuk memperbesar tabel

        // ---- Header kolom ----
        System.out.printf("%4s", "x"); // sudut kiri atas
        for (int j = 1; j <= BATAS; j++) {
            System.out.printf("%4d", j); // judul kolom 1..BATAS
        }
        System.out.println();

        // ---- Garis pemisah ----
        for (int k = 0; k <= BATAS; k++) {
            System.out.print("----"); // 4 tanda hubung per kolom
        }
        System.out.println();

        // ---- Isi tabel ----
        for (int i = 1; i <= BATAS; i++) {          // perulangan luar = baris
            System.out.printf("%4d", i);            // label baris
            for (int j = 1; j <= BATAS; j++) {      // perulangan dalam = kolom
                System.out.printf("%4d", i * j);    // hasil perkalian, lebar tetap 4
            }
            System.out.println();
        }
    }
}
