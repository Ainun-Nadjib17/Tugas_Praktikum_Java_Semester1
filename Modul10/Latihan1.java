import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Latihan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Meminta input dari pengguna
        System.out.print("Masukkan teks yang ingin disimpan: ");
        String inputTeks = scanner.nextLine();

        // 2. Menulis input pengguna ke file
        try {
            FileWriter fileWriter = new FileWriter("teks_user.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(inputTeks);
            bufferedWriter.close();
            System.out.println("Teks berhasil disimpan ke file.\n");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis file: " + e.getMessage());
        }

        // Membaca kembali isi file dan menampilkannya
        try {
            FileReader fileReader = new FileReader("teks_user.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String baris;
            System.out.println("--- Isi file teks_user.txt ---");
            while ((baris = bufferedReader.readLine()) != null) {
                System.out.println(baris);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }
        
        scanner.close();
    }
}