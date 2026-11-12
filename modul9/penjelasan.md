# Penjelasan Modul 9 — String Method (Java)

Modul ini membahas String sebagai objek di Java beserta metode-metodenya. Setiap program di bawah sudah diuji dan berjalan sesuai output yang diharapkan.

---

## Konsep Dasar (ringkas materi modul)

**String di Java adalah objek** dari kelas `java.lang.String`, bukan tipe primitif. Sifat pentingnya:

- **Immutable** — isi String tidak bisa diubah setelah dibuat. Setiap operasi yang "mengubah" atau "menggabungkan" String sebenarnya membuat objek String **baru** di memori.
- Ada dua cara deklarasi:
  ```java
  String nama = "John";              // String literal (direkomendasikan)
  String namaLain = new String("Jane"); // objek String baru di heap
  ```
  String literal otomatis di-*intern* ke **String Pool**, sehingga dua literal dengan isi sama berbagi referensi. Operator `==` membandingkan **referensi**, sedangkan `equals()` membandingkan **nilai/isi** — makanya untuk membandingkan isi String selalu pakai `equals()`.

---

## Latihan 1: Menghitung Jumlah Karakter dalam String

### Soal
1. Program meminta pengguna memasukkan sebuah kalimat.
2. Hitung jumlah karakter kalimat tersebut, **termasuk spasi**.

### Kode (`Latihan1.java`)
```java
import java.util.Scanner;

public class Latihan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kalimat: ");
        String kalimat = scanner.nextLine();

        // Menghitung jumlah karakter
        int panjang = kalimat.length();
        System.out.println("Jumlah karakter: " + panjang);

        scanner.close();
    }
}
```

### Penjelasan Baris demi Baris
| Kode | Penjelasan |
|---|---|
| `import java.util.Scanner;` | Mengimpor kelas `Scanner` dari package `java.util` untuk membaca input dari keyboard (`System.in`). |
| `Scanner scanner = new Scanner(System.in);` | Membuat objek Scanner yang terhubung ke input standar (keyboard). |
| `scanner.nextLine()` | Membaca **satu baris** input sampai user menekan Enter. Dipilih `nextLine()` (bukan `next()`) supaya spasi di dalam kalimat tetap terbaca. |
| `kalimat.length()` | Metode bawaan `String` yang mengembalikan **jumlah karakter**, spasi dan tanda baca ikut dihitung. String `"Belajar Java itu menyenangkan!"` → 30 karakter. |
| `scanner.close();` | Menutup Scanner agar resource input tidak bocor (good practice). |

### Contoh Uji
```
Masukkan kalimat: Belajar Java itu menyenangkan!
Jumlah karakter: 30
```

---

## Latihan 2: Mengekstrak Substring dari String

### Soal
1. Program meminta pengguna memasukkan sebuah kalimat.
2. Minta dua indeks: indeks awal dan indeks akhir.
3. Ambil dan tampilkan substring berdasarkan indeks tersebut.

### Kode (`Latihan2.java`)
```java
import java.util.Scanner;

public class Latihan2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kalimat: ");
        String kalimat = scanner.nextLine();

        System.out.print("Masukkan indeks awal: ");
        int awal = scanner.nextInt();
        System.out.print("Masukkan indeks akhir: ");
        int akhir = scanner.nextInt();

        // Mengambil substring
        String subKalimat = kalimat.substring(awal, akhir);
        System.out.println("Substring: " + subKalimat);

        scanner.close();
    }
}
```

### Penjelasan Baris demi Baris
| Kode | Penjelasan |
|---|---|
| `scanner.nextInt()` | Membaca input berupa bilangan bulat (`int`). Digunakan berulang: untuk indeks awal dan akhir. |
| `kalimat.substring(awal, akhir)` | Mengambil potongan teks mulai indeks `awal` **hingga `akhir - 1`**. Karakter pada indeks `akhir` **tidak ikut** (eksklusif). Misal: `"Pemrograman Java".substring(12, 16)` → `"Java"`. |

### Catatan Penting
- **Indeks dimulai dari 0**: karakter pertama = indeks 0.
- **Sifat eksklusif**: `substring(awal, akhir)` mengambil karakter pada rentang `[awal, akhir-1]`, sehingga panjang hasil = `akhir - awal`.
- JVM dapat melempar `StringIndexOutOfBoundsException` jika `awal < 0`, `akhir > panjang kalimat`, atau `awal > akhir` — jadi indeks masukan harus valid.

### Contoh Uji
```
Masukkan kalimat: Pemrograman Java
Masukkan indeks awal: 12
Masukkan indeks akhir: 16
Substring: Java
```
(Indeks 12='J', 13='a', 14='v', 15='a'; indeks 16 tidak ikut.)

---

## Latihan 3: Menggabungkan Dua String

### Soal
1. Program meminta pengguna memasukkan dua String.
2. Gabungkan dan tampilkan hasilnya.

### Kode (`Latihan3.java`)
```java
import java.util.Scanner;

public class Latihan3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan String pertama: ");
        String str1 = scanner.nextLine();

        System.out.print("Masukkan String kedua: ");
        String str2 = scanner.nextLine();

        // Menggabungkan String
        String gabungan = str1.concat(str2);
        System.out.println("String gabungan: " + gabungan);

        scanner.close();
    }
}
```

### Penjelasan Baris demi Baris
| Kode | Penjelasan |
|---|---|
| `str1.concat(str2)` | Menggabungkan `str2` ke **belakang** `str1`. Karena sifat immutable, hasil gabungan ini adalah **objek String baru**, disimpan di variabel `gabungan`. |
| Alternatif | Hasil yang sama bisa pakai operator `+`: `String gabungan = str1 + str2;`. Bedanya, `concat()` hanya menerima satu argumen String, sedangkan `+` lebih fleksibel (bisa digabung dengan angka dll). |

### Contoh Uji
```
Masukkan String pertama: Belajar
Masukkan String kedua: Java
String gabungan: BelajarJava
```
*(jika user menambahkan spasi di belakang "Belajar ", hasilnya "Belajar Java")*

---

## Postest: Membalik Kata/Kalimat Menggunakan Perulangan

### Soal
Dengan **perulangan**, buat program untuk membalik kata atau kalimat yang diinput pengguna.

### Kode (`Postest.java`)
```java
import java.util.Scanner;

public class Postest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kata atau kalimat: ");
        String kalimat = scanner.nextLine();

        // Membalik kalimat menggunakan perulangan
        String dibalik = "";
        for (int i = kalimat.length() - 1; i >= 0; i--) {
            dibalik = dibalik + kalimat.charAt(i);
        }

        System.out.println("Hasil dibalik: " + dibalik);

        scanner.close();
    }
}
```

### Penjelasan Baris demi Baris
| Kode | Penjelasan |
|---|---|
| `String dibalik = "";` | String kosong sebagai penampung hasil. Diisikan karakter dibalik secara bertahap. |
| `for (int i = kalimat.length() - 1; i >= 0; i--)` | Perulangan **dari belakang ke depan**. Karena indeks terakhir = `length() - 1`, loop mulai dari sana dan berkurang 1 tiap iterasi sampai indeks 0. |
| `kalimat.charAt(i)` | Mengambil **satu karakter** pada indeks `i`. |
| `dibalik = dibalik + kalimat.charAt(i);` | Menempelkan karakter tadi ke belakang `dibalik`. Setiap penggabungan ini membuat objek String baru (karena immutable). Untuk string sangat panjang, `StringBuilder` + `append()` lebih efisien. |

### Cara Kerja (Ilustrasi)
Input: `"Praktikum Java"` (panjang 14)

| Iterasi (i) | charAt(i) | dibalik |
|---|---|---|
| 13 | 'a' | `a` |
| 12 | 'v' | `av` |
| 11 | 'a' | `ava` |
| ... | ... | ... |
| 0 | 'P' | `avaJ miktkarP` → **`avaJ mukitkarP`** |

### Contoh Uji
```
Masukkan kata atau kalimat: Praktikum Java
Hasil dibalik: avaJ mukitkarP
```

---

## Ringkasan Metode yang Dipakai

| Metode | Fungsi | Dipakai di |
|---|---|---|
| `length()` | Menghitung jumlah karakter (spasi & tanda baca ikut) | Latihan 1, Postest |
| `substring(awal, akhir)` | Mengambil potongan teks indeks `[awal, akhir-1]` | Latihan 2 |
| `concat(str)` | Menggabungkan dua String (hasil = objek baru) | Latihan 3 |
| `charAt(i)` | Mengambil karakter pada indeks tertentu | Postest |
| `nextLine()` / `nextInt()` | Membaca input baris / bilangan bulat dari `Scanner` | Semua latihan |

## Referensi
- Dokumentasi Java SE dari Oracle
- Buku *"Java: A Beginner's Guide"* oleh Herbert Schildt



# Penjelasan Fungsi String Java – Latihan 3

## 1. String

```java
String str1;
String str2;
String gabungan;
```

String merupakan tipe data Java yang digunakan untuk menyimpan teks atau kumpulan karakter.

## 2. concat()

```java
String gabungan = str1.concat(str2);
```

Berfungsi untuk menggabungkan dua buah String menjadi satu String baru.

Contoh:
```java
String str1 = "Ainun";
String str2 = "Nadjib";

String gabungan = str1.concat(str2);
```

Hasil:
```text
AinunNadjib
```

Catatan: concat() tidak otomatis memberikan spasi.

## 3. nextLine()

```java
String str1 = scanner.nextLine();
```

Berfungsi untuk membaca satu baris teks yang dimasukkan pengguna melalui keyboard, termasuk teks yang mengandung spasi.

Contoh input:
```text
Mokhamad Ainun Nadjib
```

## 4. print()

```java
System.out.print("Masukkan String pertama: ");
```

Berfungsi untuk menampilkan teks ke terminal tanpa berpindah ke baris berikutnya.

## 5. println()

```java
System.out.println("String gabungan: " + gabungan);
```

Berfungsi untuk menampilkan teks ke terminal dan kemudian berpindah ke baris berikutnya.

## 6. close()

```java
scanner.close();
```

Berfungsi untuk menutup objek Scanner setelah selesai digunakan.

## Kesimpulan

Fungsi yang digunakan dalam program Latihan3.java adalah:

| Fungsi | Kegunaan |
|---|---|
| `String` | Menyimpan data berupa teks. |
| `concat()` | Menggabungkan dua String. |
| `nextLine()` | Membaca satu baris input teks. |
| `print()` | Menampilkan teks tanpa pindah baris. |
| `println()` | Menampilkan teks dengan pindah baris. |
| `close()` | Menutup Scanner. |

Dengan fungsi-fungsi tersebut, program dapat menerima dua input teks, menggabungkannya, dan menampilkan hasilnya.