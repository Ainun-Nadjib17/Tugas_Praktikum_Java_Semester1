import java.util.Scanner;

public class Latihan2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kalimat: ");
        String kalimat = scanner.nextLine();

        System.out.print("Masukkan indeks awal: ");
        int awal = scanner.nextInt();
        System.out.print("Masukkan indeks akhir: ");
        int akhir = scanner.nextInt();

        // Mengambil substring
        String subKalimat = kalimat.substring(awal, akhir);
        System.out.println("Substring: " + subKalimat);

        scanner.close();
    }
}
