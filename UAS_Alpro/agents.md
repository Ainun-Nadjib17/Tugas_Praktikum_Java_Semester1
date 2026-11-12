# AGENTS.md
# DETECTIVE MYSTERY: BUKTI TERAKHIR

## 1. IDENTITAS PROJECT

Nama Project: Detective Mystery: Bukti Terakhir

Jenis Project: Game Investigasi Detektif

Bahasa Pemrograman: Java

Platform: CLI (Command Line Interface)

Mode Permainan: Single Player

Skala Project: Standard

Jumlah Kasus: 3 Kasus Berbeda

Target: Project Ujian Akhir Semester (UAS)

Project ini merupakan game investigasi berbasis terminal. Pemain berperan sebagai seorang detektif yang bertugas menyelesaikan tiga kasus misterius dengan cara mengumpulkan barang bukti, memeriksa tersangka, melakukan interogasi, menganalisis informasi, dan menentukan pelaku sebenarnya.

Project wajib menggunakan konsep pemrograman Java yang terdapat pada Modul 3, Modul 4, Modul 5, dan Modul 6.

---

## 2. TUJUAN PROJECT

Tujuan pengembangan project:

1. Membuat game CLI menggunakan bahasa Java.
2. Menerapkan materi Input dan Output pada Java.
3. Menerapkan struktur percabangan.
4. Menerapkan struktur perulangan.
5. Menerapkan nested loop.
6. Mengembangkan logika pemrograman melalui permainan investigasi.
7. Membuat program dengan struktur kode modular dan mudah dipahami.
8. Menghasilkan game yang dapat dimainkan dari awal sampai akhir.

Prioritaskan fungsi permainan, keterbacaan kode, dan kesesuaian dengan materi perkuliahan.

---

## 3. ATURAN TEKNOLOGI

Gunakan ketentuan berikut:

| Komponen | Ketentuan |
|---|---|
| Bahasa | Java |
| Versi | Java 11 atau lebih baru |
| Tampilan | CLI / Terminal |
| Input | Scanner |
| Output | System.out |
| Penyimpanan | Memori selama permainan |
| Database | Tidak diperlukan |
| GUI | Tidak diperbolehkan |
| Framework | Tidak diperlukan |
| Library eksternal | Tidak diperbolehkan |

Gunakan Java Standard Library saja.

Dilarang menggunakan:
- Java Swing.
- JavaFX.
- Spring Boot.
- Database eksternal.
- Framework game.
- Library pihak ketiga.
- HTML, CSS, dan JavaScript untuk antarmuka permainan.

---

## 4. KONSEP PERMAINAN

Pemain merupakan seorang detektif yang mendapatkan tugas menyelesaikan tiga kasus berbeda.

Setiap kasus memiliki:
- Cerita kasus.
- Lokasi kejadian.
- Daftar tersangka.
- Informasi alibi.
- Barang bukti.
- Kesaksian.
- Sistem investigasi.
- Analisis bukti.
- Penentuan pelaku.

Pemain harus mengumpulkan informasi sebanyak mungkin sebelum membuat tuduhan akhir.

Setiap kasus memiliki satu pelaku sebenarnya yang sudah ditentukan sejak awal.

Jangan menentukan pelaku secara acak karena seluruh barang bukti dan alibi harus memiliki hubungan logis dengan solusi kasus.

Pemain tidak boleh mengetahui identitas pelaku sebelum melakukan tuduhan akhir.

---

## 5. DAFTAR KASUS

Buat tiga kasus investigasi dengan tingkat kesulitan berbeda.

### KASUS 001 — Berlian yang Hilang

Tingkat Kesulitan: Mudah

Cerita:

Sebuah berlian berharga hilang dari ruang koleksi sebuah mansion. Kejadian tersebut berlangsung pada malam hari ketika beberapa orang masih berada di dalam gedung.

Pemain ditugaskan untuk menemukan siapa yang mengambil berlian tersebut.

Spesifikasi:
- 4 orang tersangka.
- 4 barang bukti.
- 4 informasi alibi.
- Beberapa lokasi pemeriksaan.
- Sistem interogasi.
- Satu pelaku sebenarnya.

### KASUS 002 — Dokumen yang Dicuri

Tingkat Kesulitan: Menengah

Cerita:

Sebuah dokumen penting milik perusahaan menghilang dari ruang arsip. Beberapa karyawan memiliki akses ke ruangan tersebut.

Pemain harus mencari tahu siapa yang mengambil dokumen dan bagaimana kejadian tersebut berlangsung.

Spesifikasi:
- 4 orang tersangka.
- 5 barang bukti.
- Informasi kesaksian yang berbeda.
- Pemeriksaan lokasi.
- Sistem interogasi.
- Analisis hubungan bukti.
- Satu pelaku sebenarnya.

### KASUS 003 — Saksi yang Menghilang

Tingkat Kesulitan: Sulit

Cerita:

Seorang saksi penting menghilang sebelum memberikan kesaksian dalam sebuah perkara. Beberapa orang diketahui memiliki hubungan dengan saksi tersebut.

Pemain harus mengungkap siapa yang bertanggung jawab atas hilangnya saksi.

Spesifikasi:
- 5 orang tersangka.
- 6 barang bukti.
- Informasi yang saling berkaitan.
- Alibi yang perlu diperiksa.
- Sistem interogasi.
- Analisis bukti yang lebih kompleks.
- Satu pelaku sebenarnya.

Ketentuan:
- Seluruh cerita harus bersifat fiktif.
- Setiap kasus harus memiliki solusi yang konsisten.
- Barang bukti harus mendukung penyelesaian kasus.
- Jangan memberikan petunjuk yang bertentangan dengan cerita.
- Tingkat kesulitan meningkat dari kasus pertama sampai ketiga.

---

## 6. MENU UTAMA

Buat menu utama dengan pilihan berikut:

1. Mulai Investigasi
2. Informasi Kasus
3. Statistik Detektif
4. Cara Bermain
5. Keluar

Gunakan switch-case untuk memproses pilihan pemain.

Menu harus terus ditampilkan sampai pemain memilih keluar.

Gunakan do-while untuk mengulang menu utama.

Contoh tampilan:

========================================
       DETECTIVE MYSTERY
          BUKTI TERAKHIR
========================================

       SELAMAT DATANG, DETEKTIF!

[1] Mulai Investigasi
[2] Informasi Kasus
[3] Statistik Detektif
[4] Cara Bermain
[5] Keluar

Masukkan pilihan:

---

## 7. FITUR PERMAINAN

### 7.1 Pemilihan Kasus

Pemain dapat memilih salah satu dari tiga kasus.

Tampilkan:
- Nomor kasus.
- Judul kasus.
- Tingkat kesulitan.
- Deskripsi singkat.
- Status penyelesaian.

### 7.2 Pemeriksaan Lokasi Kejadian

Pemain dapat memeriksa lokasi kejadian untuk mendapatkan informasi.

Setiap lokasi memiliki informasi yang berbeda.

Pemain dapat memilih objek atau bagian lokasi yang ingin diperiksa.

### 7.3 Daftar Tersangka

Tampilkan daftar seluruh tersangka pada kasus yang sedang dimainkan.

Setiap tersangka memiliki:
- ID tersangka.
- Nama.
- Pekerjaan.
- Deskripsi.
- Alibi.
- Status interogasi.

Gunakan perulangan for untuk menampilkan daftar tersangka.

### 7.4 Pengumpulan Barang Bukti

Pemain dapat menemukan dan mengumpulkan barang bukti.

Setiap barang bukti memiliki:
- ID bukti.
- Nama bukti.
- Deskripsi.
- Lokasi penemuan.
- Status pengumpulan.

Ketentuan:
- Bukti yang sudah dikumpulkan tidak dapat dikumpulkan kembali.
- Tampilkan pesan jika bukti sudah ditemukan.
- Bukti yang belum ditemukan tidak boleh masuk ke daftar bukti terkumpul.
- Setiap bukti baru memberikan poin.

### 7.5 Interogasi Tersangka

Pemain dapat melakukan interogasi terhadap tersangka.

Setiap interogasi menampilkan:
- Identitas tersangka.
- Pernyataan tersangka.
- Informasi tambahan.
- Keterangan yang relevan dengan kasus.

Ketentuan:
- Setiap tersangka dapat diinterogasi.
- Status interogasi harus disimpan.
- Poin hanya diberikan satu kali untuk setiap tersangka.
- Pernyataan tersangka harus konsisten dengan cerita.

### 7.6 Analisis Barang Bukti

Pemain dapat memeriksa kembali barang bukti yang sudah ditemukan.

Tampilkan:
- Daftar barang bukti.
- Informasi setiap bukti.
- Hubungan bukti dengan tersangka.
- Perbedaan informasi atau alibi.
- Ringkasan perkembangan investigasi.

Analisis harus membantu pemain menyimpulkan kasus tanpa langsung memberitahukan pelakunya.

### 7.7 Papan Investigasi

Buat papan investigasi menggunakan array dua dimensi.

Papan digunakan untuk menampilkan:
- Lokasi pemeriksaan.
- Posisi barang bukti.
- Lokasi yang sudah diperiksa.
- Lokasi yang belum diperiksa.

Gunakan nested loop untuk menampilkan papan.

Contoh:

char[][] board = {
    {'S', '.', '.', 'E'},
    {'.', '.', 'E', '.'},
    {'.', 'S', '.', '.'},
    {'E', '.', '.', 'X'}
};

Keterangan:
- S = Lokasi informasi tersangka.
- E = Lokasi barang bukti.
- X = Lokasi utama investigasi.
- . = Lokasi yang belum diperiksa.

Contoh ini merupakan ilustrasi awal. Sesuaikan papan dengan data kasus yang sebenarnya.

### 7.8 Tuduhan Akhir

Setelah melakukan investigasi, pemain dapat menentukan siapa pelaku sebenarnya.

Ketentuan:
- Pemain memilih salah satu tersangka.
- Sistem memeriksa jawaban pemain.
- Jika benar, kasus berhasil diselesaikan.
- Jika salah, tampilkan informasi bahwa tuduhan tidak tepat.
- Tampilkan hasil akhir investigasi.
- Hitung skor pemain.
- Simpan status penyelesaian kasus.

Sistem tidak boleh memberikan poin berulang kali dari penyelesaian kasus yang sama.

### 7.9 Statistik Detektif

Tampilkan statistik pemain:

- Jumlah kasus selesai.
- Jumlah tuduhan benar.
- Jumlah tuduhan salah.
- Total skor.
- Peringkat detektif.

Peringkat:

1. Detektif Pemula.
2. Detektif Junior.
3. Detektif Senior.
4. Detektif Master.

Gunakan kondisi if-else atau else-if untuk menentukan peringkat.

---

## 8. SISTEM PENILAIAN

Gunakan sistem skor berikut:

| Aktivitas | Poin |
|---|---:|
| Mengumpulkan satu bukti baru | 10 |
| Menginterogasi satu tersangka baru | 10 |
| Menyelesaikan analisis bukti | 20 |
| Tuduhan akhir benar | 50 |
| Tuduhan akhir salah | 0 |

Ketentuan:
- Setiap aktivitas hanya memberikan poin satu kali.
- Tidak boleh ada poin ganda dari aktivitas yang sama.
- Skor ditampilkan setelah kasus selesai.
- Statistik keseluruhan diperbarui setelah kasus selesai.

---

## 9. PENERAPAN MATERI MODUL 3–6

Seluruh materi wajib diterapkan secara nyata di dalam project.

### MODUL 3 — INPUT DAN OUTPUT JAVA

Gunakan Scanner untuk menerima input pemain.

Metode yang wajib digunakan:
- nextInt()
- nextLine()

Fungsi output:
- System.out.print()
- System.out.println()
- System.out.printf()

Penerapan:
- Memilih menu.
- Memilih kasus.
- Memilih tersangka.
- Memilih barang bukti.
- Menampilkan informasi investigasi.
- Menampilkan statistik dan skor.

Perhatikan penggunaan nextLine() setelah nextInt() agar input tidak terlewat karena karakter newline.

### MODUL 4 — PERCABANGAN JAVA

Gunakan:
- if
- if-else
- else-if
- switch-case

Penerapan:
- Validasi input.
- Memeriksa status barang bukti.
- Memeriksa status interogasi.
- Menentukan hasil tuduhan.
- Menentukan status investigasi.
- Menentukan peringkat detektif.
- Navigasi menu.

### MODUL 5 — PERULANGAN JAVA

Gunakan:
- for
- while
- do-while

Penerapan:

FOR:
- Menampilkan daftar tersangka.
- Menampilkan barang bukti.
- Mengakses data kasus.

WHILE:
- Menjalankan sesi investigasi selama kasus masih aktif.
- Memproses aktivitas investigasi sampai pemain selesai atau keluar.

DO-WHILE:
- Mengulang menu utama.
- Mengulang input selama pilihan tidak valid.

### MODUL 6 — PERULANGAN BERSARANG

Gunakan nested loop atau perulangan di dalam perulangan.

Penerapan:
- Membuat papan investigasi dua dimensi.
- Menampilkan tabel lokasi investigasi.
- Menampilkan susunan lokasi dan barang bukti.

Gunakan array dua dimensi untuk menyimpan representasi papan investigasi.

Nested loop harus memiliki fungsi yang jelas dan benar-benar digunakan dalam gameplay.

Jangan membuat perulangan bersarang yang tidak diperlukan hanya untuk memenuhi materi.

---

## 10. STRUKTUR FOLDER PROJECT

Gunakan struktur berikut:

DetectiveMystery/
│
├── src/
│   ├── Main.java
│   ├── Game.java
│   ├── CaseFile.java
│   ├── Suspect.java
│   ├── Evidence.java
│   └── Investigation.java
│
├── docs/
│   ├── gameplay.md
│   └── game-flow.md
│
├── README.md
└── agents.md

### PENJELASAN CLASS

Main.java

Tanggung jawab:
- Menjadi titik awal aplikasi.
- Membuat objek Scanner.
- Membuat objek Game.
- Menjalankan permainan.
- Menutup Scanner ketika permainan selesai.

Game.java

Tanggung jawab:
- Mengelola menu utama.
- Mengelola pemilihan kasus.
- Mengatur alur permainan.
- Menampilkan statistik detektif.
- Mengelola navigasi permainan.

CaseFile.java

Tanggung jawab:
- Menyimpan informasi kasus.
- Menyimpan deskripsi kasus.
- Menyimpan daftar tersangka.
- Menyimpan daftar barang bukti.
- Menyimpan identitas pelaku.
- Menyimpan status penyelesaian kasus.

Suspect.java

Tanggung jawab:
- Menyimpan informasi tersangka.
- Menyimpan pekerjaan.
- Menyimpan alibi.
- Menyimpan pernyataan.
- Menyimpan status interogasi.

Evidence.java

Tanggung jawab:
- Menyimpan informasi barang bukti.
- Menyimpan nama dan deskripsi bukti.
- Menyimpan lokasi penemuan.
- Mengelola status pengumpulan bukti.

Investigation.java

Tanggung jawab:
- Mengelola pemeriksaan lokasi.
- Mengelola pengumpulan bukti.
- Mengelola interogasi.
- Mengelola analisis bukti.
- Mengelola papan investigasi.
- Mengelola tuduhan akhir.
- Menghitung skor investigasi.

Hindari menempatkan seluruh logika permainan di Main.java.

---

## 11. STANDAR PENULISAN KODE

Ikuti aturan berikut:

1. Gunakan nama class yang jelas.
2. Gunakan PascalCase untuk nama class.
3. Gunakan camelCase untuk nama method dan variabel.
4. Gunakan konstanta untuk nilai tetap jika diperlukan.
5. Buat method berdasarkan tanggung jawab masing-masing.
6. Hindari duplikasi kode.
7. Tambahkan komentar pada logika penting.
8. Hindari abstraksi yang terlalu rumit.
9. Gunakan struktur Java dasar.
10. Pastikan kode mudah dipahami mahasiswa pemula.

Jangan:
- Membuat semua fitur dalam satu class.
- Menggunakan inheritance yang tidak diperlukan.
- Menggunakan design pattern yang terlalu kompleks.
- Menambahkan library eksternal.
- Menambahkan fitur di luar kebutuhan tanpa alasan jelas.

---

## 12. ATURAN BAHASA PROJECT

Seluruh project wajib menggunakan Bahasa Indonesia.

Ketentuan:

1. Semua teks terminal menggunakan Bahasa Indonesia.
2. Seluruh cerita kasus menggunakan Bahasa Indonesia.
3. Dialog tersangka menggunakan Bahasa Indonesia.
4. Alibi dan informasi barang bukti menggunakan Bahasa Indonesia.
5. Komentar kode menggunakan Bahasa Indonesia.
6. README.md menggunakan Bahasa Indonesia.
7. Dokumentasi dalam folder docs menggunakan Bahasa Indonesia.
8. Pesan kesalahan dan validasi input menggunakan Bahasa Indonesia.
9. Nama class, method, dan variabel tetap menggunakan Bahasa Inggris dengan standar Java.
10. Istilah teknis Java tidak perlu diterjemahkan.

Jangan mencampur Bahasa Indonesia dan Bahasa Inggris pada tampilan permainan, kecuali nama resmi game atau istilah teknis yang diperlukan.

---

## 13. VALIDASI INPUT

Program harus mampu menangani:

- Input menu kosong.
- Input berupa huruf ketika angka diperlukan.
- Nomor menu di luar pilihan.
- Pemilihan tersangka yang tidak tersedia.
- Pemilihan bukti yang tidak tersedia.
- Pengumpulan bukti berulang.
- Interogasi berulang.
- Tuduhan tanpa informasi yang cukup.

Program tidak boleh langsung berhenti ketika pemain memasukkan input yang salah.

Gunakan Scanner, if-else, dan perulangan untuk mengelola validasi.

---

## 14. ALUR PERMAINAN

Alur utama:

MULAI
  |
  v
MENU UTAMA
  |
  v
PILIH KASUS
  |
  v
INFORMASI KASUS
  |
  v
RUANG INVESTIGASI
  |
  +---- Periksa Lokasi
  |
  +---- Lihat Tersangka
  |
  +---- Kumpulkan Bukti
  |
  +---- Interogasi Tersangka
  |
  +---- Analisis Bukti
  |
  v
TUDUHAN AKHIR
  |
  v
HITUNG SKOR
  |
  v
HASIL INVESTIGASI
  |
  v
KEMBALI KE MENU UTAMA
  |
  v
KELUAR

Pemain dapat melihat kembali informasi yang sudah ditemukan tanpa kehilangan progres investigasi.

---

## 15. TAHAPAN PENGEMBANGAN

Pengembangan wajib dilakukan secara bertahap.

### PHASE 1 — INISIALISASI PROJECT

- Buat struktur folder.
- Buat seluruh file Java.
- Buat class Main.
- Buat class Game.
- Pastikan program dapat dikompilasi.
- Pastikan program dapat dijalankan.

### PHASE 2 — MENU UTAMA

- Buat tampilan menu.
- Implementasikan Scanner.
- Implementasikan switch-case.
- Implementasikan do-while.
- Buat validasi input.
- Uji seluruh menu.

### PHASE 3 — DATA KASUS

- Buat tiga data kasus.
- Buat data tersangka.
- Buat data barang bukti.
- Buat informasi alibi.
- Tentukan solusi masing-masing kasus.
- Uji pemilihan kasus.

### PHASE 4 — SISTEM INVESTIGASI

- Buat pemeriksaan lokasi.
- Buat sistem pengumpulan bukti.
- Buat daftar tersangka.
- Buat sistem interogasi.
- Buat status progres investigasi.

### PHASE 5 — ANALISIS BUKTI

- Buat fitur analisis bukti.
- Buat papan investigasi.
- Implementasikan array dua dimensi.
- Implementasikan nested loop.
- Uji tampilan papan investigasi.

### PHASE 6 — TUDUHAN DAN PENILAIAN

- Buat sistem tuduhan akhir.
- Buat evaluasi jawaban.
- Buat perhitungan skor.
- Buat statistik detektif.
- Buat sistem peringkat.
- Uji seluruh hasil permainan.

### PHASE 7 — PENGUJIAN DAN DOKUMENTASI

- Uji ketiga kasus.
- Uji seluruh menu.
- Uji input tidak valid.
- Uji sistem skor.
- Periksa penggunaan Modul 3–6.
- Buat README.md.
- Buat dokumentasi gameplay.md.
- Buat dokumentasi game-flow.md.

Jangan melanjutkan ke phase berikutnya sebelum phase saat ini berhasil diuji.

---

## 16. CHECKLIST PENGUJIAN

### Aplikasi
- [ ] Program berhasil dijalankan.
- [ ] Menu utama berfungsi.
- [ ] Semua pilihan menu bekerja.
- [ ] Menu keluar berfungsi.

### Kasus
- [ ] Kasus 001 dapat dimainkan.
- [ ] Kasus 002 dapat dimainkan.
- [ ] Kasus 003 dapat dimainkan.
- [ ] Setiap kasus memiliki cerita berbeda.
- [ ] Setiap kasus memiliki satu pelaku.
- [ ] Seluruh bukti konsisten dengan cerita.

### Investigasi
- [ ] Daftar tersangka tampil.
- [ ] Barang bukti dapat ditemukan.
- [ ] Pengumpulan bukti ganda dicegah.
- [ ] Interogasi berfungsi.
- [ ] Analisis bukti berfungsi.
- [ ] Tuduhan akhir berfungsi.

### Penilaian
- [ ] Skor dihitung dengan benar.
- [ ] Poin tidak diberikan berulang kali.
- [ ] Tuduhan benar mendapat poin.
- [ ] Statistik diperbarui.
- [ ] Peringkat detektif berfungsi.

### Materi Java
- [ ] Scanner digunakan.
- [ ] nextInt() digunakan.
- [ ] nextLine() digunakan.
- [ ] System.out.print() digunakan.
- [ ] System.out.println() digunakan.
- [ ] System.out.printf() digunakan.
- [ ] if digunakan.
- [ ] if-else digunakan.
- [ ] else-if digunakan.
- [ ] switch-case digunakan.
- [ ] for digunakan.
- [ ] while digunakan.
- [ ] do-while digunakan.
- [ ] Nested loop digunakan.
- [ ] Array dua dimensi digunakan.

---

## 17. DOKUMENTASI PROJECT

README.md harus berisi:

- Judul project.
- Deskripsi permainan.
- Tujuan project.
- Fitur permainan.
- Persyaratan menjalankan program.
- Cara kompilasi.
- Cara menjalankan.
- Struktur folder.
- Materi Java yang diterapkan.

docs/gameplay.md harus berisi:

- Pengenalan permainan.
- Peraturan permainan.
- Penjelasan menu.
- Cara melakukan investigasi.
- Cara mengumpulkan bukti.
- Cara melakukan interogasi.
- Sistem penilaian.
- Peringkat detektif.

docs/game-flow.md harus berisi:

- Alur aplikasi.
- Alur menu utama.
- Alur pemilihan kasus.
- Alur investigasi.
- Alur tuduhan akhir.
- Alur hasil permainan.

Seluruh dokumentasi wajib menggunakan Bahasa Indonesia.

---

## 18. INSTRUKSI UNTUK AI CODING AGENT

Sebelum melakukan perubahan:

1. Baca agents.md secara menyeluruh.
2. Periksa struktur project yang sudah tersedia.
3. Periksa kode yang sudah dibuat.
4. Jangan menghapus fitur yang sudah berfungsi.
5. Kerjakan satu phase dalam satu waktu.
6. Jangan membuat seluruh project sekaligus.
7. Jelaskan fungsi setiap class dan method penting.
8. Pastikan kode sesuai materi Modul 3–6.
9. Lakukan kompilasi dan pengujian setelah setiap phase.
10. Perbaiki error sebelum melanjutkan.
11. Jangan mengklaim fitur berhasil tanpa pengujian.
12. Minta persetujuan sebelum melakukan perubahan arsitektur besar.
13. Sesuaikan dokumentasi dengan implementasi sebenarnya.

Setelah menyelesaikan setiap phase, berikan laporan:

- File yang dibuat atau diubah.
- Fitur yang berhasil dibuat.
- Materi Java yang diterapkan.
- Hasil kompilasi.
- Hasil pengujian.
- Pekerjaan yang masih tersisa.

Jangan langsung melanjutkan phase berikutnya tanpa instruksi pengguna.

---

## 19. DEFINISI PROJECT SELESAI

Project dianggap selesai apabila:

1. Game dapat dimainkan sepenuhnya melalui terminal.
2. Terdapat tiga kasus investigasi berbeda.
3. Setiap kasus memiliki solusi yang konsisten.
4. Pemain dapat mengumpulkan barang bukti.
5. Pemain dapat menginterogasi tersangka.
6. Pemain dapat menganalisis informasi.
7. Pemain dapat membuat tuduhan akhir.
8. Sistem skor dan statistik berfungsi.
9. Seluruh materi Modul 3–6 diterapkan.
10. Tidak terdapat error kompilasi.
11. Validasi input berfungsi.
12. Dokumentasi project tersedia.

PRIORITAS PENGEMBANGAN:

1. Fungsionalitas.
2. Kesesuaian materi perkuliahan.
3. Keterbacaan kode.
4. Konsistensi cerita.
5. Pengalaman bermain.
6. Dokumentasi.

**NAMA PROJECT: DETECTIVE MYSTERY — BUKTI TERAKHIR**

**BAHASA: JAVA**

**PLATFORM: CLI / TERMINAL**

**PRINSIP: FUNGSI > KETERBACAAN > KOMPLEKSITAS**