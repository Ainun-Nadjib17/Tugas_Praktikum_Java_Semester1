# Modul 6 — Perulangan Bersarang pada Java

**Mata Kuliah:** Praktikum Algoritma & Pemrograman
**Program Studi:** Teknik Informatika UIN Maliki Malang
**Sumber:** `Modul 6. Perulangan Bersarang pada Java.pdf`

> **Catatan:** Pada PDF modul hanya tersedia **Latihan 1** dan **Postest** (tidak ada Latihan 2 & 3).
> Dokumen ini mengerjakan **Pretest**, **Latihan 1** (versi dasar + versi modifikasi), dan **Postest**.

---

## Struktur File

```
.
├── src/
│   ├── TabelPerkalian.java            → Latihan 1 (versi dasar)
│   ├── TabelPerkalianRapi.java        → Latihan 1 (versi modifikasi, lebih rapi)
│   ├── PiramidaBintang.java           → Postest (sesuai contoh soal)
│   └── PiramidaBintangSimetris.java   → Postest (pengembangan, opsional)
├── penjelasan.md                      → dokumen ini
└── Modul 6. Perulangan Bersarang pada Java.pdf
```

**Cara compile & run:**

```bash
javac -d out src/*.java                 # compile semua file ke folder "out"
java -cp out TabelPerkalian             # jalankan Latihan 1 versi dasar
java -cp out TabelPerkalianRapi         # jalankan Latihan 1 versi rapi
java -cp out PiramidaBintang            # jalankan Postest
java -cp out PiramidaBintangSimetris    # jalankan versi pengembangan
```

_Disusun & diuji dengan JDK 21._

---

## C. Pretest

### 1. Apa yang dimaksud dengan perulangan bersarang dalam pemrograman?

**Jawaban:** Perulangan bersarang (*nested loop*) adalah perulangan yang berada **di dalam** perulangan lain.
Perulangan yang ada di luar disebut **perulangan luar (*outer loop*)**, sedangkan yang di dalam disebut
**perulangan dalam (*inner loop*)**.

Cara kerjanya: perulangan luar mengambil **satu** iterasi, lalu perulangan dalam dijalankan **seluruhnya dari awal sampai akhir**.
Setelah perulangan dalam selesai, perulangan luar maju ke iterasi berikutnya, dan perulangan dalam diulang lagi dari awal.

Akibatnya total iterasi = (jumlah iterasi luar) × (jumlah iterasi dalam).

```java
for (int i = 1; i <= 5; i++) {        // perulangan luar
    for (int j = 1; j <= 5; j++) {    // perulangan dalam
        System.out.print(i * j + " ");
    }
    System.out.println();
}
```

### 2. Kapan kita membutuhkan perulangan bersarang dalam suatu program?

**Jawaban:** Ketika pekerjaan yang dihadapi bersifat **dua dimensi atau berlapis**, yaitu saat setiap langkah
pada satu tingkat pengulangan masih harus dipecah lagi menjadi beberapa langkah pengulangan.

Indikatornya:

- Data diproses dalam bentuk **baris dan kolom** (tabel, matriks, grid).
- Ada kalimat seperti *"untuk setiap X, lakukan untuk setiap Y"* — misalnya *"untuk setiap baris, cetak semua kolomnya"*.
- Jumlah total pekerjaan adalah hasil kali dari dua (atau lebih) ukuran, misalnya 5 baris × 5 kolom = 25 kali proses.

Kalau masalahnya cuma satu dimensi (misalnya menjumlahkan 10 angka), cukup pakai **satu** perulangan — perulangan bersarang hanya menambah kompleksitas tanpa manfaat.

### 3. Sebutkan beberapa kasus di mana perulangan bersarang berguna.

**Jawaban:**

| Kasus | Keterangan |
|---|---|
| **Tabel perkalian / tabel data** | baris × kolom → inilah Latihan 1 di modul ini |
| **Pola bintang / piramida** | mengatur spasi dan bintang per baris → inilah Postest di modul ini |
| **Operasi matriks** | penjumlahan, perkalian, transpose matriks (baris × kolom) |
| **Pencarian & pengurutan** | *bubble sort*, *selection sort*, mencari duplikat, mencari pasangan |
| **Mencari kombinasi/pasangan** | membandingkan setiap elemen dengan elemen lain |
| **Permainan papan (grid)** | papan catur, *tic-tac-toe*, Minesweeper (baris × kolom) |
| **Generate data & laporan** | membuat jadwal, kalender, *invoice*, atau tabel laporan |
| **Animasi/grafis berbasis grid** | menggambar piksel atau karakter pada posisi (x, y) |

### 4. Apa yang terjadi jika tidak ada batasan pada perulangan bersarang?

**Jawaban:** Terjadi **_infinite loop_ (perulangan tak berujung)**.

Karena perulangan dalam harus selesai lebih dulu sebelum perulangan luar bisa maju, satu saja kondisi yang
tidak pernah bernilai `false` bisa membuat program **menggantung (hang)**: tampilan diam, aplikasi tidak merespons,
CPU terpakai ~100% pada satu inti, dan memori bisa ikut penuh bila di dalamnya ada penambahan data
(misalnya `list.add(...)`).

Contoh yang salah — nilai `i` tidak pernah berubah, jadi kondisi `i <= 5` selalu `true`:

```java
for (int i = 1; i <= 5; ) {      // ❌ TIDAK ADA i++ → nilai i selalu 1
    for (int j = 1; j <= 5; j++) {
        System.out.println(i + " x " + j);
    }
}
```

Selain itu, perulangan bersarang yang **ada batasnya tapi terlalu besar** tetap bermasalah dari sisi kinerja:
total iterasi bertumbuh secara **kuadratik (kuadrat)** atau lebih. Contoh: 1.000 × 1.000 = 1.000.000 iterasi,
dan bila ditambah satu tingkat lagi menjadi 1.000³ = 1.000.000.000 iterasi.

### 5. Bagaimana cara kita mengontrol jumlah iterasi dalam perulangan bersarang?

**Jawaban:**

1. **Pastikan setiap perulangan punya 3 komponen lengkap** — inisialisasi, kondisi berhenti, dan perubahan nilai (*increment/decrement*). Ini kesalahan paling sering pada perulangan bersarang.
2. **Kondisi berhenti harus pasti bisa tercapai.** Pastikan arah perubahan nilainya benar (`i++` untuk kondisi `i <= n`) sehingga perulangan akan berakhir.
3. **Gunakan *counter* terpisah** untuk setiap tingkat — jangan memakai variabel yang sama (`i` untuk luar, `j` untuk dalam), supaya keduanya tidak saling merusak.
4. **Batasi jumlah iterasi dari luar** — misalnya jadikan perulangan dalam bergantung pada nilai perulangan luar (`for (int j = 1; j <= i; j++)`), seperti pada pola bintang Postest.
5. **Kendalikan alur dengan `break` dan `continue`** — `break` menghentikan perulangan saat kondisi tertentu terpenuhi, `continue` melewati iterasi tertentu. Hati-hati: `break`/`continue` hanya memengaruhi perulangan tempat ia berada.
6. **Ambil nilai batas dari ukuran data**, misalnya `array.length`, bukan angka yang ditulis manual, agar tidak ada iterasi berlebih atau kurang.
7. **Hitung total iterasi sebelum menulis kode.** Untuk perulangan bersarang, total = perkalian semua batas. Kalau hasilnya terlalu besar, pikirkan algoritma yang lebih efisien.

---

## E. Latihan Praktikum

### Latihan 1: Membuat Tabel Perkalian

**Instruksi:**
1. Buat program yang mencetak tabel perkalian 1 hingga 5 menggunakan perulangan bersarang.
2. Modifikasi program untuk menampilkan tabel dalam format yang lebih rapi.

#### Versi 1 — Program Dasar

**File:** `src/TabelPerkalian.java`

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

**Output:**

```
1	2	3	4	5
2	4	6	8	10
3	6	9	12	15
4	8	12	16	20
5	10	15	20	25
```

**Penjelasan kode:**

| Baris | Penjelasan |
|---|---|
| `for (int i = 1; i <= 5; i++)` | **Perulangan luar.** Variabel `i` mewakili **baris** sekaligus **angka pertama** pada perkalian. Nilainya berjalan 1, 2, 3, 4, 5. |
| `for (int j = 1; j <= 5; j++)` | **Perulangan dalam.** Variabel `j` mewakili **kolom** sekaligus **angka kedua**. Untuk **setiap** nilai `i`, `j` akan berjalan penuh dari 1 sampai 5. |
| `System.out.print(i * j + "\t")` | Menghitung `i * j` lalu mencetaknya. Memakai `print` (bukan `println`) agar hasilnya menyambung dalam **satu baris**. `"\t"` = karakter *tab* yang berfungsi sebagai pemisah antar kolom. |
| `System.out.println()` | Dipanggil **setelah perulangan dalam selesai**, jadi tepat 1 kali per baris. Fungsinya turun ke baris baru. Tanpa ini, seluruh 25 angka akan tercetak dalam satu baris panjang. |

**Alur eksekusi (total 5 × 5 = 25 iterasi):**

| Iterasi luar (`i`) | Yang terjadi di perulangan dalam (`j`) | Hasil satu baris |
|---|---|---|
| `i = 1` | `j` = 1 → 5 | `1 2 3 4 5` |
| `i = 2` | `j` = 1 → 5 | `2 4 6 8 10` |
| `i = 3` | `j` = 1 → 5 | `3 6 9 12 15` |
| `i = 4` | `j` = 1 → 5 | `4 8 12 16 20` |
| `i = 5` | `j` = 1 → 5 | `5 10 15 20 25` |

Poin pentingnya: **perulangan luar tidak menunggu, ia baru maju setelah perulangan dalam tamat.**
Jadi satu kali putaran `i` = lima kali putaran `j`.

#### Versi 2 — Modifikasi (Format Lebih Rapi)

**Masalah versi pertama:** pemisah `"\t"` membuat lebar kolom **tidak konsisten**. Tab hanya melebar sampai
*tab stop* berikutnya, sehingga angka 1 digit (`1`) dan 2 digit (`10`) bisa menggeser kolom dan tabel jadi terlihat miring.

**Solusi:** gunakan `System.out.printf()` dengan **lebar kolom tetap** `%4d` (rata kanan, lebar 4 karakter),
ditambah **header kolom** dan **garis pemisah** supaya terbaca seperti tabel sungguhan.

**File:** `src/TabelPerkalianRapi.java`

```java
public class TabelPerkalianRapi {

    public static void main(String[] args) {
        final int BATAS = 5; // ubah nilai ini untuk memperbesar tabel

        // ---- Header kolom ----
        System.out.printf("%4s", "x"); // sudut kiri atas
        for (int j = 1; j <= BATAS; j++) {
            System.out.printf("%4d", j); // judul kolom 1..BATAS
        }
        System.out.println();

        // ---- Garis pemisah ----
        for (int k = 0; k <= BATAS; k++) {
            System.out.print("----"); // 4 tanda hubung per kolom
        }
        System.out.println();

        // ---- Isi tabel ----
        for (int i = 1; i <= BATAS; i++) {          // perulangan luar = baris
            System.out.printf("%4d", i);            // label baris
            for (int j = 1; j <= BATAS; j++) {      // perulangan dalam = kolom
                System.out.printf("%4d", i * j);    // hasil perkalian, lebar tetap 4
            }
            System.out.println();
        }
    }
}
```

**Output:**

```
   x   1   2   3   4   5
------------------------
   1   1   2   3   4   5
   2   2   4   6   8  10
   3   3   6   9  12  15
   4   4   8  12  16  20
   5   5  10  15  20  25
```

**Penjelasan perubahan:**

| Bagian | Penjelasan |
|---|---|
| `System.out.printf("%4d", ...)` | Mencetak angka dengan **lebar minimum 4 karakter, rata kanan**. Angka `5` dicetak sebagai `"   5"`, angka `25` sebagai `"  25"`. Karena lebarnya sama semua, kolom tidak pernah bergeser — inilah kunci tabel yang rapi. |
| `System.out.printf("%4s", "x")` | Cukup 3 kolom perulangan **tambahan** di luar tabel inti: header (`x` + 1..5), garis pemisah, dan label baris. Perulangan bersarang untuk **isi tabel** tetap seperti versi dasar. |
| `final int BATAS = 5` | Nilai batas dijadikan satu variabel konstan. Untuk membuat tabel 10×10 cukup ubah menjadi `10` di satu tempat saja, tanpa menyentuh logika perulangan. |
| `for (int k = 0; k <= BATAS; k++)` | Perulangan ketiga yang khusus mencetak garis `----` sebanyak `BATAS + 1` kolom (1 kolom label + 5 kolom data = 24 karakter tanda hubung). |
| `for (int i = 1; i <= BATAS; i++)` di paling luar | Sama seperti versi dasar: perulangan luar = baris, perulangan dalam = kolom. Struktur bersarangnya tidak berubah, **yang diubah hanya cara mencetaknya**. |

**Kesimpulan latihan:** perulangan bersarang menangani **struktur** tabel (5 baris × 5 kolom),
sedangkan `printf` menangani **tampilan**-nya. Memisahkan dua hal ini adalah kebiasaan yang baik:
logika perhitungan tetap bersih, dan format bisa diperbaiki tanpa mengotak-atik algoritma.

---

## F. Postest

### Soal

Buat program yang mencetak pola piramida bintang dengan tinggi yang ditentukan oleh pengguna.
Contoh hasil jika inputan 5:

```
*
**
***
****
*****
```

### Jawaban

**File:** `src/PiramidaBintang.java`

```java
import java.util.Scanner;

public class PiramidaBintang {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan tinggi piramida: ");
        int tinggi = input.nextInt();

        // Perulangan LUAR -> menentukan berapa baris yang dicetak
        for (int baris = 1; baris <= tinggi; baris++) {

            // Perulangan DALAM -> mencetak bintang sebanyak nomor baris
            for (int bintang = 1; bintang <= baris; bintang++) {
                System.out.print("*");
            }

            System.out.println(); // ganti baris setelah satu baris selesai
        }

        input.close();
    }
}
```

**Output (input `5`):**

```
Masukkan tinggi piramida: 5
*
**
***
****
*****
```

**Penjelasan kode:**

| Baris | Penjelasan |
|---|---|
| `import java.util.Scanner;` | Mengimpor kelas `Scanner` dari pustaka Java untuk membaca input dari keyboard. |
| `Scanner input = new Scanner(System.in);` | Membuat objek `Scanner` yang membaca dari **standard input** (keyboard). |
| `int tinggi = input.nextInt();` | Membaca angka bulat yang diketik pengguna dan menyimpannya di variabel `tinggi`. Nilai inilah yang jadi batas perulangan luar. |
| `for (int baris = 1; baris <= tinggi; baris++)` | **Perulangan luar.** Kalau `tinggi = 5`, perulangan ini berjalan 5 kali → menghasilkan 5 baris. |
| `for (int bintang = 1; bintang <= baris; bintang++)` | **Perulangan dalam.** Batasnya bukan angka tetap, tapi **nilai `baris` saat itu**. Jadi baris ke-1 mencetak 1 bintang, baris ke-2 mencetak 2 bintang, dan seterusnya. |
| `System.out.print("*")` | Mencetak **satu** bintang tanpa pindah baris, sehingga bintang dalam satu baris menempel rapat (`**` bukan `* *`). |
| `System.out.println()` | Dipanggil sekali per baris untuk turun ke baris berikutnya. |
| `input.close()` | Menutup `Scanner` untuk melepaskan sumber daya yang dipakai. |

**Tabel jalannya program (input `tinggi = 5`):**

| Baris (`baris`) | Nilai `bintang` | Bintang yang dicetak | Hasil baris |
|---|---|---|---|
| 1 | 1 | 1 kali | `*` |
| 2 | 1, 2 | 2 kali | `**` |
| 3 | 1, 2, 3 | 3 kali | `***` |
| 4 | 1, 2, 3, 4 | 4 kali | `****` |
| 5 | 1, 2, 3, 4, 5 | 5 kali | `*****` |

Total bintang = 1 + 2 + 3 + 4 + 5 = **15**. Perhatikan bahwa jumlah iterasinya bukan `5 × 5 = 25`
seperti pada tabel perkalian, melainkan **segitiga** — karena batas perulangan dalam berubah mengikuti
perulangan luar. Inilah teknik yang membuat pola bertingkat bisa dibentuk.

**Kunci polanya:** perulangan luar menentukan **tinggi**, perulangan dalam menentukan **isi tiap baris**,
dan **hubungan** antara keduanya (`bintang <= baris`) yang menentukan bentuk akhirnya.

### Pengembangan (Opsional) — Piramida Simetris

Contoh di modul sebenarnya berbentuk **segitiga siku rata kiri**. Kalau ingin bentuk piramida yang
**simetris di tengah**, tambahkan satu perulangan lagi untuk mencetak spasi di depan.

**File:** `src/PiramidaBintangSimetris.java`

```java
import java.util.Scanner;

public class PiramidaBintangSimetris {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan tinggi piramida: ");
        int tinggi = input.nextInt();

        for (int baris = 1; baris <= tinggi; baris++) {

            // Perulangan 1: mencetak SPASI (semakin ke bawah semakin sedikit)
            for (int spasi = 1; spasi <= tinggi - baris; spasi++) {
                System.out.print(" ");
            }

            // Perulangan 2: mencetak BINTANG (bilangan ganjil: 1, 3, 5, ...)
            for (int bintang = 1; bintang <= (2 * baris - 1); bintang++) {
                System.out.print("*");
            }

            System.out.println();
        }

        input.close();
    }
}
```

**Output (input `5`):**

```
    *
   ***
  *****
 *******
*********
```

**Penjelasan tambahan:**

- Perulangan spasi `spasi <= tinggi - baris` → baris pertama butuh paling banyak spasi (`5 - 1 = 4`),
  baris terakhir tidak butuh spasi (`5 - 5 = 0`). Ini yang membuat bintang "terdorong" ke tengah.
- Perulangan bintang `bintang <= (2 * baris - 1)` menghasilkan jumlah bintang **ganjil**:
  1, 3, 5, 7, 9. Jumlah ganjil membuat piramida **simetris** terhadap garis tengah (ada satu bintang puncak).
- Perhatikan sekarang ada **dua perulangan dalam** di dalam satu perulangan luar. Perulangan bersarang
  bisa terdiri dari lebih dari dua tingkat, dan urutan pencetakannya (spasi dulu, baru bintang) sangat menentukan hasil akhir.

---

## Rangkuman

**1. Definisi.** Perulangan bersarang adalah perulangan di dalam perulangan. Perulangan luar berjalan satu kali,
lalu perulangan dalam menyelesaikan seluruh iterasinya, baru perulangan luar maju ke iterasi berikutnya.

**2. Total iterasi = hasil kali semua batas.** Perulangan luar 5 × perulangan dalam 5 = 25 iterasi
(tabel perkalian). Tapi bila batas perulangan dalam **bergantung** pada perulangan luar
(`bintang <= baris`), hasilnya menjadi pola segitiga — totalnya 15, bukan 25.

**3. Pola pikir dua dimensi.** Setiap perulangan punya "tugas" berbeda:

| Perulangan | Mengontrol | Contoh di modul ini |
|---|---|---|
| Luar (`i`, `baris`) | **baris** / tinggi | `for (int i = 1; i <= 5; i++)` |
| Dalam (`j`, `bintang`) | **kolom** / isi tiap baris | `for (int j = 1; j <= 5; j++)` |

**4. Perubahan baris ada di luar perulangan dalam.** `System.out.println()` diletakkan **setelah**
perulangan dalam selesai. Kalau salah letak, semua output jadi satu baris panjang atau tiap karakter
turun baris.

**5. Cetak vs. baris baru.** `System.out.print()` untuk isi yang harus menyambung dalam satu baris;
`System.out.println()` untuk pindah baris. Kombinasi keduanya adalah inti pembentukan pola.

**6. Kinerja.** Kompleksitas meningkat secara berlipat seiring bertambahnya tingkat perulangan.
Dua tingkat dengan n iterasi = O(n²); tiga tingkat = O(n³). Perulangan bersarang hanya dipakai
saat memang perlu, dan batasnya harus sekecil mungkin.

**7. Kontrol iterasi.** Setiap tingkat perulangan wajib punya inisialisasi, kondisi berhenti, dan
perubahan counter yang lengkap dan **benar arahnya**. Tanpa kondisi berhenti yang bisa tercapai,
program akan *infinite loop* dan menggantung.

**8. Kerapian output.** `"\t"` (tab) praktis tapi lebarnya tidak konsisten. Untuk tabel yang harus lurus,
gunakan `System.out.printf()` dengan lebar kolom tetap seperti `%4d`. Pisahkan logika perhitungan dari
urusan tampilan.

**9. Ringkasan hasil praktikum modul ini:**

| Bagian | Program | Teknik utama |
|---|---|---|
| Latihan 1 (dasar) | `TabelPerkalian` | 2 perulangan `for` bersarang, batas tetap, pemisah `\t` |
| Latihan 1 (modifikasi) | `TabelPerkalianRapi` | `printf("%4d")` + header + garis pemisah |
| Postest | `PiramidaBintang` | Perulangan dalam dengan batas **mengikuti** perulangan luar |
| Postest (opsional) | `PiramidaBintangSimetris` | 2 perulangan dalam (spasi + bintang), jumlah bintang ganjil |

**Kesimpulan:** perulangan bersarang adalah alat untuk memecah masalah berlapis menjadi
"untuk setiap baris → lakukan pada setiap kolom". Yang perlu dikuasai bukan sekadar menulis dua `for`,
melainkan mengatur **batas**, **hubungan antar perulangan**, dan **peletakan `println()`** —
tiga hal itulah yang menentukan apakah hasilnya jadi tabel rapi, segitiga bintang, atau *infinite loop*.
