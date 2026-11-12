# Penjelasan Praktikum Modul 10: Try-Catch dan Operasi File

Dokumen ini berisi penjelasan logika dan konsep dari program **Latihan 1** dan **Postest** pada Modul 10 Praktikum Algoritma & Pemrograman (Java).

---

## 1. Latihan 1: Membaca dan Menulis File dengan Try-Catch

Program ini mendemonstrasikan operasi dasar I/O (Input/Output) file, di mana program meminta input dari pengguna, menyimpannya ke dalam file, dan kemudian membacanya kembali.

### Alur dan Konsep Kode:
1. **Input Pengguna (`Scanner`)**:
   - Program menggunakan `Scanner` untuk menangkap input teks dari pengguna melalui konsol.
2. **Menulis File (Write Operation)**:
   - **`FileWriter`**: Digunakan untuk membuka atau membuat file baru bernama `teks_user.txt`.
   - **`BufferedWriter`**: Membungkus `FileWriter` untuk melakukan penulisan secara *buffered*. Ini membuat proses penulisan lebih efisien karena data dikumpulkan di memori (buffer) sebelum ditulis ke disk.
   - **`write()` & `close()`**: Metode `write()` memasukkan teks ke dalam buffer, dan `close()` memastikan buffer di-*flush* (ditulis) ke file dan menutup koneksi.
   - **`try-catch (IOException)`**: Menangani potensi kesalahan I/O, seperti *permission denied* atau *disk full*.
3. **Membaca File (Read Operation)**:
   - **`FileReader`**: Membuka file `teks_user.txt` untuk dibaca.
   - **`BufferedReader`**: Membungkus `FileReader` untuk membaca data baris demi baris secara efisien menggunakan metode `readLine()`.
   - **Perulangan `while`**: Kondisi `(baris = bufferedReader.readLine()) != null` memastikan program terus membaca hingga mencapai akhir file (EOF).
   - **`try-catch (IOException)`**: Menangani kesalahan jika file tiba-tiba tidak ditemukan atau terhapus saat proses pembacaan.

---

## 2. Postest: Program Otorisasi / Login Sederhana

Program ini mengimplementasikan sistem autentikasi dasar dengan memvalidasi input pengguna terhadap data yang tersimpan di dalam file teks (`data_login.txt`).

### Alur dan Konsep Kode:
1. **Format Data File**:
   - File `data_login.txt` menggunakan format `username;password` (dipisahkan oleh titik koma `;`).
2. **Proses Parsing Data (`split`)**:
   - Saat membaca file baris demi baris, program menggunakan metode `split(";")` untuk memecah string menjadi sebuah *array*.
   - `data[0]` merepresentasikan **username**.
   - `data[1]` merepresentasikan **password**.
3. **Logika Validasi (Otorisasi)**:
   - Program membandingkan input pengguna (`inputUser` dan `inputPass`) dengan data dari file (`data[0]` dan `data[1]`) menggunakan metode `.equals()`.
   - Jika ditemukan kecocokan, variabel boolean `loginBerhasil` diubah menjadi `true`, dan perulangan dihentikan paksa menggunakan `break` untuk menghemat resource (tidak perlu membaca sisa baris file).
4. **Penanganan Exception**:
   - Blok `try-catch` digunakan untuk menangkap `IOException` jika file `data_login.txt` tidak ditemukan di direktori *project*, sehingga program akan memberikan pesan error yang ramah alih-alih *crash*.

> **Catatan Cyber Security:** 
> Sebagai catatan tambahan dari perspektif *Cyber Security*, penyimpanan password dalam format *plaintext* (teks biasa) di file `.txt` tidak aman untuk implementasi dunia nyata (seperti pada aplikasi Laravel/Python). Di lingkungan produksi, password harus di-*hash* menggunakan algoritma seperti Bcrypt atau Argon2. Namun, untuk tujuan pembelajaran logika dasar file I/O di Java, pendekatan ini sudah tepat. 👌🏻

---

## 3. Konsep Kunci: Exception Handling (Try-Catch)

Dalam operasi file di Java, *Exception Handling* adalah hal yang **wajib** karena operasi I/O sangat rentan terhadap faktor eksternal (file tidak ada, izin akses ditolak, dll).

- **`try`**: Berisi blok kode yang berisiko memunculkan *exception* (seperti inisialisasi `FileReader` atau `FileWriter`).
- **`catch (IOException e)`**: Menangkap error bertipe `IOException` (atau turunannya seperti `FileNotFoundException`). Blok ini mencegah program berhenti secara tiba-tiba (*crash*) dan memungkinkan kita memberikan pesan error yang informatif.
- **`finally`** *(Opsional)*: Blok yang akan **selalu** dieksekusi, baik terjadi exception maupun tidak. Biasanya digunakan untuk menutup koneksi file (`close()`) agar tidak terjadi *memory leak*. Pada kode di atas, penutupan file dilakukan di dalam blok `try` setelah operasi selesai.

---
*Dibuat untuk memenuhi tugas Praktikum Algoritma & Pemrograman Modul 10.*