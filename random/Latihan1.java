import java.util.Scanner;

public class Latihan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nilai ujian: ");
        int nilai = scanner.nextInt();

        if (nilai >= 60) {
            System.out.println("Lulus");
        } else {
            System.out.println("Tidak Lulus");
        }

        scanner.close();
    }
}
