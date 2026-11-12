import java.util.Scanner;

public class HitungLuas {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== PROGRAM HITUNG LUAS + GAMBAR BENTUK =====");
        System.out.println("1. Persegi Panjang");
        System.out.println("2. Segitiga");
        System.out.print("Pilih bentuk (1/2) : ");
        int pilih = input.nextInt();

        if (pilih == 1) {
            // ===== PERSEGI PANJANG =====
            System.out.print("Masukkan panjang : ");
            int panjang = input.nextInt();
            System.out.print("Masukkan lebar   : ");
            int lebar = input.nextInt();

            gambarPersegiPanjang(panjang, lebar);        // method void untuk menggambar
            System.out.println("Luas = " + hitungLuasPersegiPanjang(panjang, lebar)); // method return
        } else if (pilih == 2) {
            // ===== SEGITIGA =====
            System.out.print("Masukkan alas    : ");
            int alas = input.nextInt();
            System.out.print("Masukkan tinggi  : ");
            int tinggi = input.nextInt();

            gambarSegitiga(tinggi);                      // method void untuk menggambar
            System.out.println("Luas = " + hitungLuasSegitiga(alas, tinggi)); // method return
        } else {
            System.out.println("Pilihan tidak tersedia!");
        }

        input.close();
    }

    // ============ METHOD MENGHITUNG LUAS (dengan return) ============

    // hanya bertugas menghitung, lalu mengembalikan nilainya saja
    public static double hitungLuasPersegiPanjang(int panjang, int lebar) {
        return panjang * lebar;
    }

    // luas segitiga = 1/2 x alas x tinggi
    public static double hitungLuasSegitiga(int alas, int tinggi) {
        return 0.5 * alas * tinggi;
    }

    // ============ METHOD MENGGAMBAR BENTUK (void) ============

    // menggambar persegi panjang memakai tanda *
    public static void gambarPersegiPanjang(int panjang, int lebar) {
        System.out.println("\nBentuk persegi panjangnya:");
        for (int baris = 1; baris <= lebar; baris++) {
            for (int kolom = 1; kolom <= panjang; kolom++) {
                System.out.print("* ");
            }
            System.out.println(); // pindah baris
        }
    }

    // menggambar segitiga siku-siku memakai tanda *
    public static void gambarSegitiga(int tinggi) {
        System.out.println("\nBentuk segitiganya:");
        for (int baris = 1; baris <= tinggi; baris++) {
            for (int kolom = 1; kolom <= baris; kolom++) {
                System.out.print("* ");
            }
            System.out.println(); // pindah baris
        }
    }

}
