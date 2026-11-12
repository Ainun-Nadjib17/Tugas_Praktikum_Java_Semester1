import java.util.Scanner;

public class Postest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kata atau kalimat: ");
        String kalimat = scanner.nextLine();

        // Membalik kalimat menggunakan perulangan
        String dibalik = "";
        for (int i = kalimat.length() - 1; i >= 0; i--) {
            dibalik = dibalik + kalimat.charAt(i);
        }

        System.out.println("Hasil dibalik: " + dibalik);

        scanner.close();
    }
}
