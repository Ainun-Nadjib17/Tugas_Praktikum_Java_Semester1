# Pretest — Modul 7: Array 1 Dimensi (Java)

**1. Apa yang dimaksud dengan array dalam pemrograman?**

Array adalah struktur data yang menyimpan sekumpulan elemen dengan tipe data yang sama
dalam satu blok memori yang berurutan. Setiap elemen menempati satu "slot" dan diberi
nomor indeks. Pada Java, indeks array selalu dimulai dari `0`, sehingga array berukuran
`n` memiliki indeks `0` sampai `n - 1`. Contoh:

```java
int[] angka = {10, 20, 30, 40, 50}; // 5 elemen: indeks 0..4
```

**2. Mengapa kita menggunakan array dibandingkan dengan variabel biasa?**

- **Efisien dan ringkas.** Menyimpan 100 nilai ujian cukup dengan satu variabel
  `int[] nilai = new int[100]`, bukan 100 variabel terpisah.
- **Mudah diproses dengan perulangan.** Elemen bisa diakses berurutan lewat `for`
  atau `for-each`, sehingga operasi seperti mencari nilai terbesar, menjumlahkan,
  atau mengurutkan cukup ditulis sekali.
- **Ukuran terkelola.** Jumlah elemen diketahui lewat `array.length`, jadi program
  tetap benar walaupun ukuran data berubah.
- **Mendukung pengelompokan data yang berhubungan** (daftar nama, nilai, harga)
  dalam satu kesatuan yang bisa dipindahkan atau diberikan ke method.

Dengan variabel biasa, penambahan data baru berarti menambah deklarasi dan baris
kode, serta tidak bisa diproses secara otomatis dengan perulangan.

**3. Bagaimana cara mengakses elemen dalam array?**

Elemen diakses dengan menulis nama array diikuti indeks di dalam kurung siku:
`namaArray[indeks]`. Indeks dapat berupa literal, variabel, atau hasil ekspresi.

```java
int[] angka = {10, 20, 30, 40, 50};

System.out.println(angka[0]); // 10, elemen pertama
System.out.println(angka[2]); // 30, elemen ketiga

angka[2] = 35;                // mengubah nilai elemen indeks 2
System.out.println(angka[2]); // 35

for (int i = 0; i < angka.length; i++) {  // akses semua elemen
    System.out.println(angka[i]);
}
```

**4. Apa yang terjadi jika kita mengakses elemen array di luar batas indeksnya?**

Java melakukan pemeriksaan batas saat runtime dan melempar
`ArrayIndexOutOfBoundsException`. Program berhenti pada baris tersebut kecuali
exception-nya ditangani. Contoh pada array berukuran 5 (indeks valid `0..4`):

```java
int[] angka = new int[5];
System.out.println(angka[5]); // ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
System.out.println(angka[-1]); // juga error, indeks negatif
```

Karena itu perulangan sebaiknya memakai `i < array.length` (bukan angka tetap
seperti `i <= 5`) agar tidak melewati batas akhir array.

**5. Sebutkan contoh kasus di mana penggunaan array sangat berguna.**

- **Pengolahan nilai mahasiswa:** menyimpan nilai ujian sekelas, lalu menghitung
  rata-rata, nilai tertinggi/terendah, dan jumlah yang lulus.
- **Menampilkan daftar data:** daftar nama barang, nomor absen, atau daftar kontak
  yang ditampilkan berurutan dengan perulangan.
- **Operasi statistik sederhana:** total, rata-rata, median, atau pencarian nilai
  tertentu dalam sekumpulan data.
- **Tabel / struktur data dasar:** array dipakai sebagai fondasi untuk stack, queue,
  tabel hash, dan matriks (array 2 dimensi).
- **Buffering / pengumpulan sementara:** misalnya menyimpan semua input pengguna
  sebelum diolah atau diurutkan di akhir program.
