import java.util.Scanner;
import java.util.Random;

public class TebakKata {

    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    static String[][] daftarKata = {
        {"BUKU", "Benda untuk membaca"},
        {"KOPI", "Minuman berwarna hitam"},
        {"MEJA", "Tempat meletakkan barang"},
        {"KOMPUTER", "Alat elektronik untuk mengolah data"},
        {"JARINGAN", "Menghubungkan beberapa komputer"},
        {"ALGORITMA", "Langkah-langkah menyelesaikan masalah"},
        {"ARTIFICIAL", "Istilah bahasa Inggris untuk buatan"},
        {"KRIPTOGRAFI", "Ilmu mengamankan informasi"},
        {"KECERDASAN", "Kemampuan berpikir dan memahami"},
        {"NETWORK", "Sistem yang menghubungkan komputer"},
        {"PROGRAM", "Instruksi untuk komputer"},
        {"SOFWARE", "Aplikasi yang dijalankan komputer"},
        {"HARDWARE", "Komponen fisik komputer"},
        {"PASSWORD", "Kata sandi untuk akses"},
        {"FIREWALL", "Pengaman jaringan"},
        {"BACKUP", "Salinan data cadangan"},
        {"VIRUS", "Program berbahaya pada komputer"},
        {"KUBIK", "Bentuk ruang tiga dimensi"},
        {"KARET", "Benda tulis untuk menggambar"},
        {"LAPTOP", "Komputer portabel"},
        {"CLOUD", "Penyimpanan data jarak jauh"},
        {"CRYPT", "Alat untuk mengamankan data"},
        {"LOGIC", "Aliran berpikir yang runtut"},
        {"CODE", "Bahasa untuk memerintah komputer"},
        {"DATA", "Informasi yang diproses"},
        {"SYSTEM", "Kumpulan bagian yang bekerja bersama"},
        {"SERVER", "Mesin yang melayani permintaan"},
        {"PORT", "Lokasi akses jaringan"},
        {"BITS", "Satuan informasi terkecil"},
        {"DIGITAL", "Data dalam bentuk angka"},
                {"MONITOR", "Layar untuk menampilkan output komputer"},
        {"KEYBOARD", "Papan ketik untuk memasukkan data"},
        {"MOUSE", "Alat penunjuk dan pengklik"},
        {"PRINTER", "Alat untuk mencetak dokumen"},
        {"SCANNER", "Alat untuk memindai dokumen fisik"},
        {"ROUTER", "Perangkat pengarah paket jaringan"},
        {"MODEM", "Perangkat mengubah sinyal digital dan analog"},
        {"SWITCH", "Penghubung antar perangkat dalam jaringan"},
        {"HUB", "Perangkat penghubung jaringan sederhana"},
        {"BROWSER", "Aplikasi untuk menjelajahi internet"},
        {"DATABASE", "Kumpulan data yang terstruktur"},
        {"QUERY", "Perintah untuk mengambil data dari database"},
        {"VARIABLE", "Wadah untuk menyimpan nilai dalam program"},
        {"FUNCTION", "Blok kode yang dapat dipanggil kembali"},
        {"LOOP", "Perulangan instruksi dalam pemrograman"},
        {"ARRAY", "Kumpulan data dengan tipe yang sama"},
        {"OBJECT", "Entitas yang memiliki properti dan metode"},
        {"CLASS", "Cetak biru untuk membuat objek"},
        {"INHERITANCE", "Pewarisan sifat dalam pemrograman berorientasi objek"},
        {"POLYMORPHISM", "Kemampuan objek memiliki banyak bentuk"},
        {"ENCAPSULATION", "Penyembunyian detail implementasi objek"},
        {"DEBUGGING", "Proses mencari dan memperbaiki kesalahan kode"},
        {"COMPILER", "Penerjemah kode sumber ke bahasa mesin"},
        {"INTERPRETER", "Penerjemah kode baris per baris"},
        {"SYNTAX", "Aturan penulisan dalam bahasa pemrograman"},
        {"BUG", "Kesalahan atau cacat dalam program"},
        {"PATCH", "Pembaruan untuk memperbaiki bug"},
        {"UPDATE", "Pembaruan versi perangkat lunak"},
        {"INSTALL", "Proses pemasangan perangkat lunak"},
        {"UNINSTALL", "Proses penghapusan perangkat lunak"},
        {"FOLDER", "Wadah untuk mengelompokkan file"},
        {"FILE", "Kumpulan data yang disimpan dengan nama tertentu"},
        {"EXTENSION", "Akhiran nama file yang menunjukkan jenisnya"},
        {"FORMAT", "Susunan atau tata letak data"},
        {"RESOLUTION", "Tingkat ketajaman tampilan layar"},
        {"PIXEL", "Titik terkecil penyusun gambar digital"},
        {"RENDER", "Proses menghasilkan gambar dari model"},
        {"ANIMATION", "Ilusi gerakan dari gambar statis"},
        {"FRAME", "Satu gambar dalam rangkaian animasi"},
        {"BITMAP", "Gambar yang tersusun dari pixel"},
        {"VECTOR", "Gambar yang tersusun dari jalur matematis"},
        {"ENCRYPTION", "Proses mengubah data menjadi kode rahasia"},
        {"DECRYPTION", "Proses mengembalikan data terenkripsi ke bentuk asli"},
        {"HASH", "Fungsi matematis untuk memetakan data"},
        {"TOKEN", "Kode akses sementara untuk autentikasi"},
        {"SESSION", "Periode interaksi antara pengguna dan sistem"},
        {"COOKIE", "Data kecil yang disimpan browser"},
        {"CACHE", "Penyimpanan sementara untuk akses cepat"},
        {"BANDWIDTH", "Kapasitas maksimum transfer data"},
        {"LATENCY", "Waktu tunda dalam pengiriman data"},
        {"PING", "Perintah untuk menguji koneksi jaringan"},
        {"IP", "Alamat unik perangkat dalam jaringan"},
        {"MAC", "Alamat fisik perangkat jaringan"},
        {"DNS", "Sistem penerjemah nama domain ke IP"},
        {"DOMAIN", "Nama unik untuk mengidentifikasi server"},
        {"HOSTING", "Layanan penyewaan ruang server"},
        {"UPLOAD", "Proses mengirim data ke server"},
        {"DOWNLOAD", "Proses menerima data dari server"},
        {"STREAMING", "Proses mentransmisikan data secara berkelanjutan"},
        {"BROADBAND", "Koneksi internet berkecepatan tinggi"}
    };

    public static void main(String[] args) {

        int skor = 0;
        int level = 1;
        boolean bermain = true;

        System.out.println("================================");
        System.out.println("       GAME TEBAK KATA");
        System.out.println("================================");

        System.out.print("Masukkan nama pemain: ");
        String nama = input.nextLine();

        while (bermain && level <= daftarKata.length) {

            String kata = daftarKata[level - 1][0];
            String petunjuk = daftarKata[level - 1][1];

            int kesempatan = Math.max(3, 8 - level);
            boolean benar = false;

            System.out.println("\n================================");
            System.out.println("Pemain      : " + nama);
            System.out.println("Level       : " + level);
            System.out.println("Skor        : " + skor);
            System.out.println("Kesempatan  : " + kesempatan);
            System.out.println("================================");

            // Mengacak posisi huruf
            char[] huruf = kata.toCharArray();

            for (int i = huruf.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);

                char temp = huruf[i];
                huruf[i] = huruf[j];
                huruf[j] = temp;
            }

            String acakan = new String(huruf);

            System.out.println("Tebak kata berikut: " + acakan);
            System.out.println("Jumlah huruf: " + kata.length());

            while (kesempatan > 0 && !benar) {

                System.out.print("\nJawaban kamu: ");
                String jawaban = input.nextLine().toUpperCase();

                if (jawaban.equals("HINT")) {
                    System.out.println("Petunjuk: " + petunjuk);
                    continue;
                }

                if (jawaban.equals(kata)) {
                    System.out.println("BENAR! Kamu berhasil!");
                    skor += level * 100;
                    benar = true;
                } else {
                    kesempatan--;
                    System.out.println("SALAH! Coba lagi.");
                    System.out.println("Sisa kesempatan: " + kesempatan);
                }
            }

            if (benar) {
                level++;
                System.out.println("Skor sementara: " + skor);
            } else {
                System.out.println("\nGAME OVER!");
                System.out.println("Jawaban yang benar: " + kata);
                bermain = false;
            }

            if (level > daftarKata.length) {
                System.out.println("\nSELAMAT! KAMU MENYELESAIKAN SEMUA LEVEL!");
                bermain = false;
            }
        }

        System.out.println("\n================================");
        System.out.println("          HASIL AKHIR");
        System.out.println("================================");
        System.out.println("Nama pemain : " + nama);
        System.out.println("Level akhir : " + level);
        System.out.println("Total skor  : " + skor);
        System.out.println("================================");

        System.out.println("Terima kasih sudah bermain!");

        input.close();
    }
}
