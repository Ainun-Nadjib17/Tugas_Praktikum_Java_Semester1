import java.util.Scanner;

public class Latihan2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matriks = new int[3][3];
        int totalDiagonal = 0;

        // Meminta input dari pengguna
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[i].length; j++) {
                System.out.print("Masukkan nilai untuk baris " + i + ", kolom " + j + ": ");
                matriks[i][j] = scanner.nextInt();
            }
        }

        // Menampilkan matriks
        System.out.println("\nMatriks yang dimasukkan:");
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[i].length; j++) {
                System.out.print(matriks[i][j] + "\t");
            }
            System.out.println();
        }

        // Menghitung jumlah elemen diagonal utama (indeks [i][i])
        for (int i = 0; i < matriks.length; i++) {
            totalDiagonal += matriks[i][i];
        }

        System.out.println("Jumlah elemen diagonal utama: " + totalDiagonal);

        scanner.close();
    }
}
