# Penjelasan Sederhana — Modul 7: Array 1 Dimensi (Java)

## 1. Array itu apa? (versi gampang)

Bayangkan **deretan loker** di sekolah. Semua loker bentuknya sama, ukurannya sama,
dan diberi nomor urut mulai dari **0**. Kalau kita bilang "loker nomor 2", kita langsung
tahu loker mana yang dimaksud.

Array = deretan loker itu. Isinya harus **sejenis** (semua angka, atau semua teks),
jumlahnya **tetap** setelah dibuat, dan penomorannya **mulai dari 0**.

```java
int[] nilai = new int[5];   // bikin 5 loker: nomor 0,1,2,3,4
```

| Istilah | Arti gampang |
|---|---|
| `int[]` | tipe isi loker (angka bulat) |
| `nilai` | nama deretan loker |
| `new int[5]` | bikin 5 loker baru |
| `nilai[0]` | isi loker nomor 0 |
| `nilai.length` | jumlah loker (5) |

Loker nomor 5 **tidak ada** kalau lokernya cuma 5 (0–4). Maksa buka nomor 5 →
error `ArrayIndexOutOfBoundsException`. Ibaratnya nyari loker nomor 5 di deretan
yang cuma sampai nomor 4.

## 2. Tiga hal yang selalu muncul

1. **Deklarasi** — bikin lokernya: `int[] nilai = new int[5];`
2. **Isi data** — masukkan nilai: `nilai[0] = 80;` atau langsung `int[] nilai = {80, 75, 90};`
3. **Baca data** — ambil nilainya: `System.out.println(nilai[0]);`

Biar tidak capek menulis satu-satu, kita pakai **perulangan**:

```java
for (int i = 0; i < nilai.length; i++) {   // i = 0,1,2,3,4
    System.out.println(nilai[i]);
}
```

`i` itu nomor loker yang berganti-ganti. `i < nilai.length` artinya "selama lokernya
masih ada", jadi tidak pernah kelebihan satu langkah.

Ada juga versi singkat kalau cuma mau baca semua isi:

```java
for (int isi : nilai) {        // "untuk setiap isi di dalam nilai"
    System.out.println(isi);
}
```

## 3. Alasan pakai array, bukan variabel biasa

Tanpa array, 100 nilai butuh 100 variabel (`nilai1`, `nilai2`, ...). Dengan array,
cukup satu variabel dan satu perulangan. Jadi kode lebih pendek, rapi, dan mudah
diubah kalau jumlah datanya beda.

## 4. Penjelasan `Latihan1.java` (maksimum & minimum)

Tujuan: cari nilai **terbesar** dan **terkecil** dari 5 angka yang diinput.

Alurnya:

1. **Siapkan alat input** → `Scanner scanner = new Scanner(System.in);`
2. **Buat 5 loker kosong** → `int[] angka = new int[5];`
3. **Isi loker satu per satu** → perulangan meminta `Masukkan nilai ke-1`, ke-2, dst.
   lalu menyimpannya dengan `angka[i] = scanner.nextInt();`
4. **Anggap nilai pertama adalah juara sementara** →
   ```java
   int max = angka[0];
   int min = angka[0];
   ```
   Kenapa bukan `0`? Karena kalau semua input negatif (`-5, -8, -2`), angka `0`
   lebih besar dari semuanya, jadi `max` bakal salah. Mulai dari data asli selalu aman.
5. **Bandingkan dengan sisa data lain** →
   ```java
   for (int i = 1; i < angka.length; i++) {
       if (angka[i] > max) max = angka[i];   // ada yang lebih besar? ganti juara
       if (angka[i] < min) min = angka[i];   // ada yang lebih kecil? ganti juara
   }
   ```
   Logikanya seperti pertandingan: pemegang rekor dikalahkan hanya kalau ada
   penantang yang lebih ekstrem.
6. **Tampilkan hasil** → `max` dan `min`.

Contoh: input `3, 80, 75, 90, 100`
- Mulai: max = 3, min = 3
- 80 → max = 80 · 75 → tetap · 90 → max = 90 · 100 → max = 100
- Hasil: **max 100, min 3**

## 5. Penjelasan `Postest.java` (total & rata-rata)

Tujuan: terima `n` nilai, tampilkan semuanya, lalu hitung total dan rata-rata.

Alurnya:

1. **Tanya jumlah data dulu** → `int n = scanner.nextInt();`
   Karena jumlahnya baru diketahui saat program jalan, array dibuat **setelah** n diketahui:
   `int[] nilai = new int[n];`
2. **Cek dulu, jangan langsung proses** →
   ```java
   if (n <= 0) { ... return; }
   ```
   Kalau n = 0, nanti terjadi pembagian dengan nol. Lebih baik ditolak dengan pesan jelas.
3. **Isi array** → sama seperti Latihan 1, pakai perulangan.
4. **Tampilkan semua nilai** → perulangan `for` supaya ada nomor urutnya
   (`Nilai ke-1`, `Nilai ke-2`, ...).
5. **Jumlahkan semua isi** →
   ```java
   int total = 0;
   for (int isi : nilai) total += isi;   // += artinya "tambahkan ke total"
   ```
6. **Hitung rata-rata** →
   ```java
   double rataRata = (double) total / nilai.length;
   ```
   `(double)` penting. Kalau `int / int`, hasilnya dibulatkan ke bawah
   (330/4 jadi 82, bukan 82.5). Dengan `double`, hasilnya desimal benar:
   **82.50** (ditampilkan 2 angka di belakang koma lewat `printf("%.2f")`).

Contoh: `n = 4`, input `80 75 90 85`
- total = 80 + 75 + 90 + 85 = **330**
- rata-rata = 330 / 4 = **82.50**

## 6. Kesalahan yang sering terjadi

| Salah | Kenapa salah | Benar |
|---|---|---|
| `for (i = 0; i <= 5; i++)` pada array 5 | indeks 5 tidak ada | `i < nilai.length` |
| `int rata = total / n;` | hasil dibulatkan, desimal hilang | `double rata = (double) total / n;` |
| `int max = 0;` saat input bisa negatif | 0 lebih besar dari semua nilai negatif | `int max = angka[0];` |
| array dibuat sebelum n diketahui | ukuran harus pasti saat dibuat | tanya `n` dulu, baru `new int[n]` |
| lupa `scanner.close()` | sumber daya tidak ditutup (kebiasaan baik) | tutup di akhir |

## 7. Ringkasan satu paragraf

Array adalah deretan kotak bernomor mulai dari 0 yang isinya sejenis. Kita mengisinya
dan membacanya lewat indeks, biasanya dengan perulangan supaya tidak menulis kode
berulang. Dengan pola dasar itu, mencari nilai terbesar/terkecil (Latihan 1) dan
menghitung total serta rata-rata (Postest) hanya perlu satu variabel pembantu
(`max`/`min` atau `total`) yang diperbarui di setiap putaran perulangan.
