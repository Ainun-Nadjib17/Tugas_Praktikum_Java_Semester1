import java.util.Scanner;

public class Postest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ukuran matriks (n): ");
        int n = scanner.nextInt();

        int[][] matriksA = new int[n][n];
        int[][] matriksB = new int[n][n];
        int[][] matriksC = new int[n][n];

        // Input matriks A
        System.out.println("\nMasukkan elemen matriks A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                matriksA[i][j] = scanner.nextInt();
            }
        }

        // Input matriks B
        System.out.println("\nMasukkan elemen matriks B:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                matriksB[i][j] = scanner.nextInt();
            }
        }

        // Penjumlahan matriks A + B = C
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriksC[i][j] = matriksA[i][j] + matriksB[i][j];
            }
        }

        // Menampilkan hasil
        System.out.println("\nMatriks A:");
        cetakMatriks(matriksA);

        System.out.println("\nMatriks B:");
        cetakMatriks(matriksB);

        System.out.println("\nHasil penjumlahan (C = A + B):");
        cetakMatriks(matriksC);

        scanner.close();
    }

    // Method bantu untuk mencetak matriks dalam bentuk tabel
    static void cetakMatriks(int[][] matriks) {
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[i].length; j++) {
                System.out.print(matriks[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
