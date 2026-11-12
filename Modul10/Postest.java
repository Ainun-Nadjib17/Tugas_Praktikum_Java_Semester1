import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Postest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loginBerhasil = false;
        String namaFile = "data_login.txt";

        System.out.println("=== SISTEM LOGIN SEDERHANA ===");
        System.out.print("Masukkan Username: ");
        String inputUser = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String inputPass = scanner.nextLine();
        System.out.println("================================");

        // Proses pembacaan file dan otorisasi
        try {
            FileReader fileReader = new FileReader(namaFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String baris;
            // Membaca file baris demi baris
            while ((baris = bufferedReader.readLine()) != null) {
                // Memisahkan data username dan password berdasarkan delimiter ";"
                String[] data = baris.split(";");
                
                // Pastikan format data valid (ada 2 bagian: user dan pass)
                if (data.length == 2) {
                    String userFile = data[0];
                    String passFile = data[1];

                    // Validasi kesamaan data input dengan data di file
                    if (inputUser.equals(userFile) && inputPass.equals(passFile)) {
                        loginBerhasil = true;
                        break; // Hentikan pembacaan jika sudah ditemukan kecocokan
                    }
                }
            }
            bufferedReader.close();
            
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }

        // Menampilkan hasil otorisasi
        if (loginBerhasil) {
            System.out.println("Login Berhasil! Selamat datang, " + inputUser + ".");
        } else {
            System.out.println("Login Gagal! Username atau Password salah.");
        }

        scanner.close();
    }
}