import java.util.Scanner;

public class CekKelulusan {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== PROGRAM CEK KELULUSAN =====");
        System.out.print("Masukkan nama mahasiswa : ");
        String nama = input.nextLine();

        System.out.print("Masukkan nilai mahasiswa : ");
        int nilai = input.nextInt();

        System.out.println("\n===== HASIL =====");
        tampilkanHasil(nama, cekKelulusan(nilai));

        input.close();
    }

    // fungsi/method dengan pengembalian nilai (return berupa boolean)
    // berisi logika untuk mengecek lulus atau tidak
    public static boolean cekKelulusan(int nilai) {
        int batasLulus = 75; // nilai minimal untuk lulus

        if (nilai >= batasLulus) {
            return true; // berarti LULUS
        } else {
            return false; // berarti TIDAK LULUS
        }
    }

    // fungsi/method tanpa pengembalian nilai (void)
    // hanya bertugas menampilkan hasilnya ke layar
    public static void tampilkanHasil(String nama, boolean status) {
        if (status) {
            System.out.println("Nama  : " + nama);
            System.out.println("Status: LULUS");
        } else {
            System.out.println("Nama  : " + nama);
            System.out.println("Status: TIDAK LULUS");
        }
    }

}
