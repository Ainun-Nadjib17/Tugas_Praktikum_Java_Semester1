Karena  i  diam selama satu baris dicetak, sedangkan  j  berjalan 1→5:

┌───────────┬──────────────────────────────────┬───────────────┐
│ i (baris) │ Isi sel: i×1, i×2, i×3, i×4, i×5 │ Hasil         │
├───────────┼──────────────────────────────────┼───────────────┤
│ 1         │ 1×1, 1×2, 1×3, 1×4, 1×5          │ 1 2 3 4 5     │
│ 2         │ 2×1, 2×2, 2×3, 2×4, 2×5          │ 2 4 6 8 10    │
│ 3         │ 3×1 … 3×5                        │ 3 6 9 12 15   │
│ 4         │ 4×1 … 4×5                        │ 4 8 12 16 20  │
│ 5         │ 5×1 … 5×5                        │ 5 10 15 20 25 │
└───────────┴──────────────────────────────────┴───────────────┘








# Penjelasan Kode — `TabelPerkalian.java`

Dokumen ini membahas **satu file saja**: `src/TabelPerkalian.java` (Latihan 1 modul 6 — versi dasar).
Isinya program yang mencetak tabel perkalian 1 sampai 5 memakai **perulangan `for` bersarang**.

---

## 1. Kode Lengkap

```java
public class TabelPerkalian {

    public static void main(String[] args) {
        // Perulangan LUAR  -> mengontrol baris (angka pertama / i)
        for (int i = 1; i <= 5; i++) {

            // Perulangan DALAM -> mengontrol kolom (angka kedua / j)
            for (int j = 1; j <= 5; j++) {
                System.out.print(i * j + "\t"); // cetak hasil i * j, Tab sebagai pemisah
            }

            System.out.println(); // pindah ke baris berikutnya setelah 1 baris selesai
        }
    }
}
```

---

## 2. Struktur Program

Secara garis besar ada tiga lapisan:

| Lapisan | Bagian dalam kode | Tugas |
|---|---|---|
| Wadah program | `public class TabelPerkalian { ... }` | Nama kelas. Karena `public`, nama file **wajib** `TabelPerkalian.java`. |
| Titik awal | `public static void main(String[] args)` | Pintu masuk program; dijalankan pertama kali oleh JVM. |
| Inti logika | Dua `for` bersarang + `print`/`println` | Membentuk dan mencetak tabel 5 × 5. |

---

## 3. Penjelasan Baris per Baris

| Kode | Penjelasan |
|---|---|
| `public class TabelPerkalian` | Mendeklarasikan kelas bernama `TabelPerkalian`. Satu file Java boleh berisi beberapa kelas, tetapi hanya boleh ada **satu** kelas `public` dan namanya harus sama dengan nama file. |
| `public static void main(String[] args)` | Metode utama. `public` = bisa dipanggil dari luar, `static` = tidak perlu membuat objek dulu, `void` = tidak mengembalikan nilai. Tanpa metode ini program tidak bisa dijalankan. |
| `for (int i = 1; i <= 5; i++)` | **Perulangan luar (outer loop).** Variabel `i` mewakili **baris** sekaligus **angka pertama** pada perkalian. Nilainya berjalan `1, 2, 3, 4, 5`. |
| `for (int j = 1; j <= 5; j++)` | **Perulangan dalam (inner loop).** Variabel `j` mewakili **kolom** sekaligus **angka kedua**. Untuk **setiap** nilai `i`, `j` berjalan penuh dari `1` sampai `5`. |
| `System.out.print(i * j + "\t")` | Menghitung `i * j` lalu mencetaknya. Memakai `print` (bukan `println`) agar hasilnya **menyambung dalam satu baris**. `"\t"` adalah karakter *tab* sebagai pemisah antar kolom. Ekspresi `i * j + "\t"` bekerja karena salah satu operand bertipe `String`, sehingga hasil kali ikut diubah ke teks. |
| `System.out.println()` | Dipanggil **setelah** perulangan dalam tamat, jadi tepat **1 kali per baris**. Fungsinya pindah ke baris baru. Tanpa baris ini, seluruh 25 angka akan tercetak dalam satu baris panjang. |

### Arti tiga komponen `for`

Setiap `for` di kode ini punya tiga bagian yang lengkap:

```java
for ( int i = 1 ;  i <= 5 ;  i++ )
      ↑            ↑        ↑
  inisialisasi   kondisi   perubahan
  (mulai dari 1) (berhenti  (naik 1
                  saat i>5)  tiap putaran)
```

Kalau salah satu bagian hilang atau salah arah (misalnya lupa `i++`), perulangan bisa tidak pernah berhenti (*infinite loop*).

---

## 4. Cara Kerja Perulangan Bersarang

Aturan pentingnya:

> **Perulangan luar tidak menunggu. Ia baru maju ke iterasi berikutnya setelah perulangan dalam selesai seluruhnya.**

Jadi alurnya:

1. `i = 1` → `j` dijalankan **penuh** dari 1 sampai 5 → `println()` → baris 1 selesai.
2. `i = 2` → `j` dijalankan **lagi dari awal** 1 sampai 5 → `println()` → baris 2 selesai.
3. Ulangi sampai `i = 5`.

Karena itu jumlah total iterasi perulangan dalam = **5 × 5 = 25 kali**.

### Tabel jalannya program

| Iterasi luar (`i`) | Yang terjadi di perulangan dalam (`j`) | Hasil satu baris |
|---|---|---|
| `i = 1` | `j` = 1 → 5 | `1   2   3   4   5` |
| `i = 2` | `j` = 1 → 5 | `2   4   6   8   10` |
| `i = 3` | `j` = 1 → 5 | `3   6   9   12  15` |
| `i = 4` | `j` = 1 → 5 | `4   8   12  16  20` |
| `i = 5` | `j` = 1 → 5 | `5   10  15  20  25` |

---

## 5. Output Program

Di jalankan dengan JDK 21, program menghasilkan:

```
1	2	3	4	5
2	4	6	8	10
3	6	9	12	15
4	8	12	16	20
5	10	15	20	25
```

Antar kolom dipisahkan **karakter tab** (`\t`), bukan spasi biasa. Hasilnya:
baris ke-`i` berisi hasil `i × 1`, `i × 2`, … `i × 5`.

### Cara menjalankan

```bash
javac -d out src/TabelPerkalian.java   # kompilasi
java  -cp out TabelPerkalian           # jalankan
```

---

## 6. Kenapa `print`, bukan `println`?

Ini inti pembentukan tabel:

- `System.out.print(...)` → mencetak **tanpa** pindah baris, sehingga angka-angka satu baris menempel.
- `System.out.println()` → hanya dipakai di **luar** perulangan dalam, sekali per baris.

Kalau keduanya tertukar, hasilnya kacau:

| Kesalahan | Akibat |
|---|---|
| Pakai `println` di dalam perulangan dalam | Setiap angka turun ke baris baru → 25 baris berisi 1 angka. |
| Lupa `System.out.println()` sama sekali | Semua 25 angka berbaris dalam **satu baris** panjang tanpa pemisah baris. |

---

## 7. Kelebihan dan Kekurangan Versi Ini

**Kelebihan**

- Sangat sederhana dan mudah dipahami — cocok sebagai contoh pertama perulangan bersarang.
- Logika perhitungan bersih: struktur tabel ditangani oleh `for`, bukan oleh manipulasi teks.

**Kekurangan**

- Pemisah `"\t"` membuat lebar kolom **tidak konsisten**. Tab hanya melebar sampai *tab stop* berikutnya, sehingga angka 1 digit (`1`) dan 2 digit (`10`) bisa menggeser kolom dan tabel terlihat miring di lebar layar tertentu.
- Batas `5` ditulis langsung di dua tempat (`i <= 5` dan `j <= 5`). Kalau ingin tabel 10 × 10, harus diubah manual dan rawan ada yang tertinggal.

**Cara memperbaikinya** ada di `src/TabelPerkalianRapi.java`: gunakan `System.out.printf("%4d", ...)` untuk **lebar kolom tetap**, simpan batas pada satu variabel `final int BATAS`, serta tambahkan header dan garis pemisah.

---

## 8. Konsep yang Dilatih

| Konsep | Di mana terlihat |
|---|---|
| Kelas dan metode `main` | Kerangka wajib program Java |
| Perulangan `for` | Dua `for` di dalam `main` |
| **Perulangan bersarang** | `for` dalam berada di dalam `for` luar |
| Variabel counter terpisah | `i` untuk baris, `j` untuk kolom |
| `print` vs `println` | Menyambung isi baris vs pindah baris |
| Karakter escape `\t` | Pemisah kolom |
| Kompleksitas O(n²) | 2 tingkat perulangan × 5 = 25 iterasi |

**Kesimpulan:** perulangan luar menentukan **baris**, perulangan dalam menentukan **kolom**, dan peletakan `println()` menentukan kapan pindah baris. Tiga hal inilah yang mengubah 25 kali perkalian sederhana menjadi sebuah tabel 5 × 5 yang terbaca.
