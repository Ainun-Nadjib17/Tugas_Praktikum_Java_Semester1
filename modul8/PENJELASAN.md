# 📘 Penjelasan Program Java — Modul 8: Array 2 Dimensi

Penjelasan sederhana untuk tiga program di proyek ini: **Latihan1.java**, **Latihan2.java**, dan **Postest.java**. Semuanya berhubungan dengan *matriks* (array 2 dimensi).

---

## 📄 Latihan1.java — Input & Tampilkan Matriks

Program kecil untuk **memasukkan angka lalu menampilkannya sebagai tabel**.

**Cara kerjanya:**
1. Bikin matriks **2x3** (2 baris, 3 kolom) — jadi cuma muat 6 angka.
2. Paksa pengguna isi satu per satu, dari baris 0 kolom 0 sampai baris 1 kolom 2 (pakai perulangan `for` bersarang).
3. Setelah semua terisi, tampilkan ulang dalam bentuk tabel rapi, dipisah spasi (`\t`).

**Analogi:** seperti mengisi nilai ke grid kecil (mirip sudoku) — isi kotak satu-satu, lalu tunjukkan isinya.

---

## 📄 Latihan2.java — Jumlah Diagonal Matriks

Sama seperti Latihan 1, tapi matriksnya **3x3** dan ada tambahan: **menjumlahkan angka di garis diagonal utama**.

**Apa itu diagonal utama?** Angka yang posisinya **baris == kolom**, yaitu `[0][0]`, `[1][1]`, dan `[2][2]` — garis miring dari kiri atas ke kanan bawah.

**Cara kerjanya:**
1. Isi matriks 3x3 → tampilkan dalam bentuk tabel (sama seperti Latihan 1).
2. Ambil `matriks[0][0] + matriks[1][1] + matriks[2][2]` (via perulangan `totalDiagonal += matriks[i][i]`).
3. Tampilkan hasil jumlahnya.

**Contoh:** kalau diagonal berisi 1, 5, 8 → hasilnya **14**.

---

## 📄 Postest.java — Penjumlahan Dua Matriks

Program paling lengkap di antara ketiganya: **menjumlahkan dua matriks A + B = C** dan ukurannya bisa bebas (pengguna tentukan sendiri, misal `n=3` berarti 3x3).

**Cara kerjanya:**
1. Tanya dulu: "mau ukuran berapa?" (angka `n`).
2. Buat 3 matriks berukuran n x n: **A**, **B**, dan **C** (tempat hasil).
3. Minta pengguna isi matriks A satu per satu, lalu matriks B.
4. Hitung penjumlahan: setiap kotak **C = angka A + angka B** di posisi yang sama.
5. Tampilkan ketiga matriks dalam bentuk tabel.

**Bonus:** di sini ada *method* bantu bernama `cetakMatriks()` — fungsi khusus untuk mencetak tabel, jadi tidak perlu menulis kode cetak 3x, cukup panggil 3x.

**Aturan matematikanya:** dua matriks hanya bisa dijumlah kalau ukurannya sama, dan hasilnya dijumlahkan posisi demi posisi:

```
A = [1 2]    B = [5 6]    C = A+B = [ 6  8]
    [3 4]        [7 8]              [10 12]
```

---

## 📊 Ringkasan Singkat

| File | Ukuran | Yang dilakukan |
|---|---|---|
| Latihan1 | 2x3 | Isi + tampilkan matriks |
| Latihan2 | 3x3 | Di atas + jumlah diagonal utama |
| Postest | n x n (bebas) | Jumlahkan dua matriks |
