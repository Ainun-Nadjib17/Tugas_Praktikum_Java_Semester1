import java.util.Scanner;

/**
 * SOAL UTS No. 1 — Menghitung Volume Tabung
 *
 * Rumus:  V = π × r × r × t
 *   V = volume tabung
 *   r = jari-jari
 *   t = tinggi
 *   π = 3,14
 *
 * User menginput nilai r dan t.
 */
public class Soal1_VolumeTabung {

    public static void main(String[] args) {
        // Nilai π. Kalau soal minta 22/7, ganti jadi: (22.0 / 7). Bisa juga pakai Math.PI.
        final double PI = 3.14;

        Scanner input = new Scanner(System.in);

        // b. User menginput jari-jari dan tinggi
        System.out.print("Masukkan jari-jari (r): ");
        double r = input.nextDouble();

        System.out.print("Masukkan tinggi (t): ");
        double t = input.nextDouble();

        // a. Hitung volume dengan persamaan V = π × r × r × t
        double volume = PI * r * r * t;

        // Tampilkan hasil
        System.out.println("Volume tabung = " + volume);

        input.close();
    }
}
