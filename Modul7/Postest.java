import java.util.Scanner;


public class Postest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah nilai (n): ");
        int n = scanner.nextInt();

        // Validasi: jumlah data harus minimal 1 agar rata-rata bisa dihitung
        if (n <= 0) {
            System.out.println("Jumlah nilai harus lebih dari 0.");
            scanner.close();
            return;
        }

        int[] nilai = new int[n];

        // Mengisi array dengan input pengguna
        for (int i = 0; i < nilai.length; i++) {
            System.out.print("Masukkan nilai ke-" + (i + 1) + ": ");
            nilai[i] = scanner.nextInt();
        }

        // Menampilkan semua nilai yang telah diinput
        System.out.println("\n=== Daftar Nilai ===");
        for (int i = 0; i < nilai.length; i++) {
            System.out.println("Nilai ke-" + (i + 1) + ": " + nilai[i]);
        }

        // Menghitung total dan rata-rata
        int total = 0;
        for (int elemen : nilai) {
            total += elemen;
        }
        double rataRata = (double) total / nilai.length;

        System.out.println("\n=== Hasil ===");
        System.out.println("Jumlah nilai   : " + nilai.length);
        System.out.println("Total nilai    : " + total);
        System.out.printf("Rata-rata nilai: %.2f%n", rataRata);

        scanner.close();
    }
}
