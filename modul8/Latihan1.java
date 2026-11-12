import java.util.Scanner;

public class Latihan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriks = new int[2][3];

        // Meminta input dari pengguna
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[i].length; j++) {
                System.out.print("Masukkan nilai untuk baris " + i + ", kolom " + j + ": ");
                matriks[i][j] = scanner.nextInt();
            }
        }

        // Mencetak matriks dalam bentuk tabel
        System.out.println("\nMatriks yang dimasukkan:");
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[i].length; j++) {
                System.out.print(matriks[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}
