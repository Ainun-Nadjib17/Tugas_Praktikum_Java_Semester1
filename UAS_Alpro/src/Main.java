import java.util.Scanner;

// ============================================================
// DETECTIVE MYSTERY: BUKTI TERAKHIR
// Aplikasi konsol Java - PHASE 1 dan PHASE 2
//
// PHASE 1 - Kerangka project & menu utama
//   - Menu utama Bahasa Indonesia (6 pilihan)
//   - do-while agar menu terus berjalan sampai user memilih Keluar
//   - switch-case untuk navigasi menu
//   - Validasi input (bukan angka / di luar rentang)
//
// PHASE 2 - Data kasus & investigasi dasar
//   - Ringkasan kasus
//   - Daftar tersangka (nama, profesi, alibi)
//   - Daftar barang bukti (nama, keterangan)
//   - Interogasi tersangka + petunjuk yang didapat
//   - Riwayat investigasi (maksimal 10 sesi)
//
// Konsep Java yang dipakai (Modul 3-8):
//   Modul 3: Scanner, nextLine(), nextInt(), println(), printf()
//   Modul 4: if, else-if, switch-case
//   Modul 5: do-while, for, while
//   Modul 6: nested loop untuk tabel
//   Modul 7: array satu dimensi
// ============================================================
public class Main {

    // ---------------- DATA KASUS (Modul 7: array/variabel) ----------------
    static String judulKasus  = "BUKTI TERAKHIR";
    static String namaKorban  = "Pak Hendra Wijaya";
    static String lokasiKasus = "Galeri Seni Nusantara, Jakarta";
    static String waktuKasus  = "22:30 WIB";
    static String ceritaKasus = "Lukisan terakhir Pak Hendra hilang dari ruang pameran. "
            + "Pintu galeri tidak rusak, jadi pelaku kemungkinan besar orang dalam.";

    // ---------------- DATA TERSANGKA (parallel arrays) ----------------
    static String[] namaTersangka = {
        "Raka Pratama",
        "Sinta Maharani",
        "Bimo Saputra",
        "Nadia Kusuma",
        "Yusuf Alamsyah"
    };
    static String[] profesiTersangka = {
        "Rekan bisnis korban",
        "Sekretaris korban",
        "Satpam galeri",
        "Kurator galeri",
        "Teknisi CCTV"
    };
    static String[] alibiTersangka = {
        "Mengaku di kafe sebelah galeri sampai pukul 23:00.",
        "Mengaku pulang lebih awal pukul 20:00.",
        "Mengaku berpatroli di lantai dua galeri.",
        "Mengaku mengunci ruang arsip lalu pulang.",
        "Mengaku memperbaiki kamera di ruang kontrol."
    };
    static String[] petunjukTersangka = {
        "Kuitansi kafe yang ia tunjukkan bertanggal kemarin, bukan malam kejadian.",
        "Kartu aksesnya tercatat membuka pintu arsip pukul 22:10.",
        "Log patroli lantai dua bolong antara pukul 22:15 sampai 22:40.",
        "Serpihan kaca di sepatunya sama dengan kaca etalase yang pecah.",
        "Kamera koridor mati tiga menit sebelum kejadian, tepat saat ia login ke sistem."
    };

    // ---------------- DATA BARANG BUKTI ----------------
    static String[] namaBukti = {
        "Rekaman CCTV koridor",
        "Kunci duplikat",
        "Surat ancaman",
        "Kuitansi kafe",
        "Serpihan kaca",
        "Log sistem CCTV"
    };
    static String[] keteranganBukti = {
        "Sosok berjaket gelap masuk pukul 22:15, wajah tertutup hoodie.",
        "Ditemukan di pot bunga dekat pintu belakang galeri.",
        "Dikirim ke korban tiga hari sebelum kejadian, ditulis tangan.",
        "Ada di saku tersangka Raka, bertanggal sehari sebelum kejadian.",
        "Ditemukan di ruang pameran, cocok dengan etalase lukisan yang pecah.",
        "Menunjukkan login terakhir oleh akun teknisi pukul 22:12."
    };

    // Status interogasi tiap tersangka (false = belum, true = sudah)
    static boolean[] sudahDiinterogasi = new boolean[5];

    // ---------------- RIWAYAT INVESTIGASI (Modul 7: array 1D) ----------------
    static final int MAX_RIWAYAT = 10;
    static String[] riwayatNama   = new String[MAX_RIWAYAT];
    static String[] riwayatTemuan = new String[MAX_RIWAYAT];
    static int jumlahRiwayat = 0;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Modul 5: do-while -> menu terus jalan sampai user memilih Keluar (6)
        int pilihan;
        do {
            System.out.println("\n========================================");
            System.out.println("   DETECTIVE MYSTERY: BUKTI TERAKHIR");
            System.out.println("========================================");
            System.out.println("1. Ringkasan Kasus");
            System.out.println("2. Daftar Tersangka");
            System.out.println("3. Daftar Barang Bukti");
            System.out.println("4. Interogasi Tersangka");
            System.out.println("5. Riwayat Investigasi");
            System.out.println("6. Keluar");
            System.out.println("========================================");
            pilihan = bacaAngka("Pilih Menu (1-6): ", 1, 6);

            // bacaAngka sudah menampilkan pesan bila input tidak valid (-1),
            // jadi switch hanya dijalankan untuk pilihan yang benar
            if (pilihan != -1) {
                // Modul 4: switch-case untuk navigasi menu
                switch (pilihan) {
                    case 1: tampilkanRingkasanKasus(); break;
                    case 2: tampilkanDaftarTersangka(); break;
                    case 3: tampilkanDaftarBukti(); break;
                    case 4: interogasiTersangka(); break;
                    case 5: tampilkanRiwayat(); break;
                    case 6: System.out.println("\nKasus ditutup sementara. Terima kasih, Detektif!");
                            break;
                    default: System.out.println("Pilihan menu tidak valid! Masukkan angka 1-6.");
                }
            }
        } while (pilihan != 6);

        input.close();
    }

    // ---------------- MENU 1: RINGKASAN KASUS (Phase 2) ----------------
    static void tampilkanRingkasanKasus() {
        System.out.println("\n========== RINGKASAN KASUS ==========");
        System.out.println("Judul Kasus : " + judulKasus);
        System.out.println("Korban      : " + namaKorban);
        System.out.println("Lokasi      : " + lokasiKasus);
        System.out.println("Waktu       : " + waktuKasus);
        System.out.println("-------------------------------------");
        System.out.println("Cerita      : " + ceritaKasus);
        System.out.println("-------------------------------------");

        // Modul 5 + 7: loop array untuk menghitung progres investigasi
        int terinterogasi = 0;
        for (int i = 0; i < sudahDiinterogasi.length; i++) {
            if (sudahDiinterogasi[i]) {
                terinterogasi++;
            }
        }
        System.out.printf("Tersangka   : %d orang%n", namaTersangka.length);
        System.out.printf("Barang bukti: %d item%n", namaBukti.length);
        System.out.printf("Progres     : %d/%d tersangka sudah diinterogasi%n",
                terinterogasi, namaTersangka.length);
    }

    // ---------------- MENU 2: DAFTAR TERSANGKA (Phase 2) ----------------
    static void tampilkanDaftarTersangka() {
        System.out.println("\n========== DAFTAR TERSANGKA ==========");
        // Modul 6: nested loop untuk mencetak tabel
        for (int i = 0; i < namaTersangka.length; i++) {
            System.out.printf("%d. %-16s (%s)%n", i + 1, namaTersangka[i], profesiTersangka[i]);
            System.out.println("   Alibi    : " + alibiTersangka[i]);
            System.out.println("   Status   : "
                    + (sudahDiinterogasi[i] ? "Sudah diinterogasi" : "Belum diinterogasi"));
            System.out.println();
        }
    }

    // ---------------- MENU 3: DAFTAR BARANG BUKTI (Phase 2) ----------------
    static void tampilkanDaftarBukti() {
        System.out.println("\n====== DAFTAR BARANG BUKTI ======");
        System.out.printf("%-3s %-22s %s%n", "No", "Barang Bukti", "Keterangan");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < namaBukti.length; i++) {   // Modul 5 + 7
            System.out.printf("%-3d %-22s %s%n", i + 1, namaBukti[i], keteranganBukti[i]);
        }
    }

    // ---------------- MENU 4: INTEROGASI (Phase 2) ----------------
    static void interogasiTersangka() {
        // Riwayat penuh? tolak sesi baru (array berukuran tetap)
        if (jumlahRiwayat >= MAX_RIWAYAT) {
            System.out.println("Riwayat investigasi penuh! Tidak bisa interogasi lagi.");
            return;
        }

        tampilkanDaftarTersangka();
        int pilih = bacaAngka("Pilih tersangka (1-5): ", 1, namaTersangka.length);
        if (pilih == -1) {
            return;                                   // input tidak valid -> kembali ke menu
        }

        int index = pilih - 1;

        // Modul 4: cegah interogasi ganda
        if (sudahDiinterogasi[index]) {
            System.out.println(namaTersangka[index] + " sudah diinterogasi sebelumnya.");
            return;
        }

        System.out.println("\n----- SESI INTEROGASI -----");
        System.out.println("Nama    : " + namaTersangka[index]);
        System.out.println("Profesi : " + profesiTersangka[index]);
        System.out.println("Alibi   : " + alibiTersangka[index]);
        System.out.println("Detektif menekan lebih dalam...");
        System.out.println("Temuan  : " + petunjukTersangka[index]);

        // Tandai sudah diinterogasi & simpan ke riwayat (Modul 7)
        sudahDiinterogasi[index] = true;
        riwayatNama[jumlahRiwayat]   = namaTersangka[index];
        riwayatTemuan[jumlahRiwayat] = petunjukTersangka[index];
        jumlahRiwayat++;

        System.out.println("[" + jumlahRiwayat + "/" + MAX_RIWAYAT + "] Sesi dicatat di riwayat.");
    }

    // ---------------- MENU 5: RIWAYAT INVESTIGASI (Phase 2) ----------------
    static void tampilkanRiwayat() {
        System.out.println("\n========= RIWAYAT INVESTIGASI =========");
        if (jumlahRiwayat == 0) {
            System.out.println("Belum ada interogasi. Mulai dari menu 4.");
            return;
        }
        for (int i = 0; i < jumlahRiwayat; i++) {      // Modul 5 + 7
            System.out.printf("Sesi #%d - %s%n", i + 1, riwayatNama[i]);
            System.out.println("   Temuan: " + riwayatTemuan[i]);
        }
    }

    // ---------------- HELPER: input angka + validasi (Modul 3 & 4) ----------------
    // Hanya menerima angka dalam rentang [min, max]. Return -1 bila tidak valid.
    static int bacaAngka(String prompt, int min, int max) {
        System.out.print(prompt);

        // Modul 3: hasNextInt() mengecek apakah token berikutnya angka
        if (!input.hasNextInt()) {
            input.nextLine();                          // buang input salah
            System.out.println("Input tidak valid! Masukkan angka.");
            return -1;
        }
        int nilai = input.nextInt();
        input.nextLine();                              // buang sisa baris

        // Modul 4: cek rentang nilai
        if (nilai < min || nilai > max) {
            System.out.println("Input tidak valid! Masukkan angka " + min + "-" + max + ".");
            return -1;
        }
        return nilai;
    }
}
