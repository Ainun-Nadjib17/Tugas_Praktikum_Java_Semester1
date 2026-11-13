import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class TebakKata {

    // Objek Scanner untuk menerima input teks dari pengguna melalui terminal
    static Scanner input = new Scanner(System.in);
    
    // Objek Random untuk menghasilkan angka acak (digunakan saat mengacak huruf)
    static Random random = new Random();

    // Array 2 dimensi untuk menyimpan pasangan [kata, petunjuk] yang dimuat dari file
    static String[][] daftarKata;

    /**
     * Method untuk membaca daftar kata dan petunjuk dari file teks eksternal.
     * Mendukung pemisah titik koma (;) maupun koma (,).
     *
     * @param namaFile nama file teks yang akan dibaca
     * @return array 2 dimensi berisi [kata, petunjuk]
     */
    static String[][] muatDaftarKata(String namaFile) {
        File file = new File(namaFile);
        
        // Fallback: jika program dijalankan dari direktori induk, periksa folder Project_Alpro
        if (!file.exists()) {
            file = new File("Project_Alpro/" + namaFile);
        }

        // Menggunakan ArrayList karena jumlah kata di file bersifat dinamis (tidak diketahui di awal)
        List<String[]> list = new ArrayList<>();

        // Membaca file baris demi baris menggunakan BufferedReader (Try-with-resources untuk auto-close)
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String baris;
            while ((baris = reader.readLine()) != null) {
                baris = baris.trim();
                
                // Lewati baris kosong atau baris komentar yang diawali tanda pagar (#)
                if (baris.isEmpty() || baris.startsWith("#")) {
                    continue;
                }
                
                // Mendeteksi delimiter: utamakan titik koma (;), jika tidak ada gunakan koma (,)
                String pemisah = baris.contains(";") ? ";" : ",";
                String[] data = baris.split(pemisah, 2);
                
                // Pastikan format valid: memiliki 2 bagian (kata dan petunjuk)
                if (data.length == 2) {
                    // Simpan kata dalam huruf kapital dan petunjuk tanpa spasi berlebih
                    list.add(new String[]{data[0].trim().toUpperCase(), data[1].trim()});
                }
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }

        // Konversi ArrayList dinamis menjadi array 2 dimensi String[][]
        return list.toArray(new String[0][0]);
    }

    public static void main(String[] args) {

        // Inisialisasi variabel status permainan
        int skor = 0;              // Menyimpan akumulasi skor pemain
        int level = 1;             // Level awal permainan
        boolean bermain = true;    // Flag kontrol loop utama permainan

        // Menampilkan judul header permainan
        System.out.println("================================");
        System.out.println("       GAME TEBAK KATA");
        System.out.println("================================");

        // Meminta input nama pemain
        System.out.print("Masukkan nama pemain: ");
        String nama = input.nextLine();

        // Memuat data kata dari file eksternal "daftar_kata.txt"
        daftarKata = muatDaftarKata("daftar_kata.txt");
        
        // Validasi: jika file tidak ditemukan atau isinya kosong, hentikan program
        if (daftarKata.length == 0) {
            System.out.println("Gagal memuat kata. Pastikan file 'daftar_kata.txt' tersedia dan tidak kosong.");
            return;
        }

        // Loop utama permainan: berjalan selama pemain tidak kalah dan level belum habis
        while (bermain && level <= daftarKata.length) {

            // Mengambil target kata dan petunjuk untuk level saat ini (indeks level - 1)
            String kata = daftarKata[level - 1][0];
            String petunjuk = daftarKata[level - 1][1];

            // Menghitung jumlah kesempatan: semakin tinggi level semakin sedikit, minimal 3 kali
            int kesempatan = Math.max(3, 8 - level);
            boolean benar = false; // Flag penanda apakah tebakan level ini berhasil

            // Menampilkan informasi status level pemain
            System.out.println("\n================================");
            System.out.println("Pemain      : " + nama);
            System.out.println("Level       : " + level);
            System.out.println("Skor        : " + skor);
            System.out.println("Kesempatan  : " + kesempatan);
            System.out.println("================================");

            // Mengonversi kata menjadi array karakter untuk diacak
            char[] huruf = kata.toCharArray();

            // Algoritma Fisher-Yates Shuffle untuk mengacak posisi karakter
            for (int i = huruf.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1); // Memilih indeks acak antara 0 hingga i

                // Menukar huruf ke-i dengan huruf ke-j
                char temp = huruf[i];
                huruf[i] = huruf[j];
                huruf[j] = temp;
            }

            // Mengubah kembali array karakter yang telah teracak menjadi String
            String acakan = new String(huruf);

            // Menampilkan kata acak dan informasi panjang huruf
            System.out.println("Tebak kata berikut: " + acakan);
            System.out.println("Jumlah huruf: " + kata.length());

            // Loop tebakan: berulang selama kesempatan masih ada dan jawaban belum benar
            while (kesempatan > 0 && !benar) {

                System.out.print("\nJawaban kamu: ");
                String jawaban = input.nextLine().toUpperCase(); // Konversi input ke huruf kapital

                // Fitur bantuan: jika pemain mengetik "HINT", tampilkan petunjuk tanpa mengurangi kesempatan
                if (jawaban.equals("HINT")) {
                    System.out.println("Petunjuk: " + petunjuk);
                    continue;
                }

                // Validasi tebakan dengan kata target
                if (jawaban.equals(kata)) {
                    System.out.println("BENAR! Kamu berhasil!");
                    skor += level * 100; // Skor bertambah proporsional dengan tingkatan level
                    benar = true;        // Menandai tebakan benar untuk keluar dari loop tebakan
                } else {
                    kesempatan--; // Kurangi kesempatan jika tebakan salah
                    System.out.println("SALAH! Coba lagi.");
                    System.out.println("Sisa kesempatan: " + kesempatan);
                }
            }

            // Evaluasi akhir tiap level
            if (benar) {
                level++; // Naik ke level berikutnya jika jawaban benar
                System.out.println("Skor sementara: " + skor);
            } else {
                // Jika kesempatan habis sebelum menjawab benar, permainan berakhir (Game Over)
                System.out.println("\nGAME OVER!");
                System.out.println("Jawaban yang benar: " + kata);
                bermain = false; // Menghentikan loop utama
            }

            // Pengecekan kemenangan akhir: jika semua kata dalam daftar sudah berhasil diselesaikan
            if (level > daftarKata.length) {
                System.out.println("\nSELAMAT! KAMU MENYELESAIKAN SEMUA LEVEL!");
                bermain = false;
            }
        }

        // Menampilkan ringkasan hasil akhir permainan
        System.out.println("\n================================");
        System.out.println("          HASIL AKHIR");
        System.out.println("================================");
        System.out.println("Nama pemain : " + nama);
        System.out.println("Level akhir : " + level);
        System.out.println("Total skor  : " + skor);
        System.out.println("================================");

        System.out.println("Terima kasih sudah bermain!");

        // Menutup Scanner untuk mencegah kebocoran resource
        input.close();
    }
}
