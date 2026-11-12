# Penjelasan Soal UTS — Algorithm and Programming Practicum

**Dosen:** Ashri Shabrina Afrah, S.ST., M.T

Halo. Ini penjelasan soal UTS pakai bahasa paling gampang. Pelan-pelan ya, satu-satu. Anggap kita lagi ngobrol santai.

---

# Bagian Besar: Ada Berapa Soal?

Ada **2 soal**. Dua-duanya minta kita bikin **program** (suruh komputer kerja buat kita).

1. **Soal 1** = bikin program buat ngitung isi tabung (volume tabung).
2. **Soal 2** = bikin program buat nebak angka itu ganjil atau genap.

Itu saja. Nggak ada yang serem. Lanjut ya.

---

# Soal 1 — Program Hitung Volume Tabung

## Tabung itu apa sih?

Tabung itu benda yang bentuknya kayak **kaleng susu**, **gelas tinggi**, atau **drum minyak**. Bentuknya bulat memanjang.

Bayangin kaleng susu:
- Bagian atas = lingkaran
- Bagian bawah = lingkaran
- Badannya tinggi memanjang

## Rumus volume tabung

```
V = π × r × r × t
```

Biar gampang, baca begini: **pi kali jari-jari kali jari-jari kali tinggi**.

Sekarang tiap huruf artinya apa:

| Huruf | Artinya | Dibaca bayi-nya |
|-------|---------|-----------------|
| **V** | Volume | "Seberapa banyak isi/kapasitas tabungnya" (contoh satuan: cm³ atau liter) |
| **r** | jari-jari | Jarak dari **titik tengah lingkaran** ke **tepinya** |
| **t** | tinggi | Tinggi badan tabung dari bawah sampai atas |
| **π** | pi | Angka ajaib. Nilainya **3,14** atau **22/7** |

**Jadi gampangnya:** pi dikali jari-jari, dikali jari-jari lagi, dikali tinggi.

### Contoh biar makin ngerti

Misal:
- r = 7
- t = 10

Maka:

```
V = 3,14 × 7 × 7 × 10
V = 1538,6
```

Jadi isi tabungnya = **1538,6**.

## Yang diminta sama soal (poin a dan b)

- **a.** Hitung volume tabungnya pakai rumus di atas. Nilai π pakai yang standar (3,14 atau 22/7).
- **b.** Angka **jari-jari (r)** dan **tinggi (t)** itu **diisi oleh user** (orang yang pakai program). Jadi programmu harus **nanya dulu**, jangan langsung ditentukan sendiri.

## Inti jawabannya (langkah-langkah)

1. Program tanya: "Masukkan jari-jari (r)?" → user isi angka
2. Program tanya: "Masukkan tinggi (t)?" → user isi angka
3. Program hitung: `V = π × r × r × t`
4. Program tampilkan hasilnya ke layar

---

# Soal 2 — Program Cek Bilangan Ganjil atau Genap

## Genap dan ganjil itu apa?

- **Bilangan GENAP** = bilangan yang bisa dibagi 2 **tanpa sisa**.
  Contoh: `2, 4, 6, 8,  10, 12`
- **Bilangan GANJIL** = bilangan yang **tidak bisa** dibagi 2 (selalu sisa 1).
  Contoh: `1, 3, 5, 7, 9, 11`

Ibaratnya: kalau kelerengnya bisa dibagi rata ke 2 orang (nggak ada sisa) = **genap**. Kalau ada 1 kelereng nyisa = **ganjil**.

## Cara tahu genap atau ganjil

Bagi angka itu dengan 2, terus lihat **sisanya**:

- Sisa **0** → **GENAP**
- Sisa **1** → **GANJIL**

Di hampir semua bahasa pemrograman, "sisa bagi" ini ditulis pakai simbol **`%`** (dibaca: **modulo**).

Contoh:
- `7 % 2` hasilnya `1` → berarti **ganjil**
- `8 % 2` hasilnya `0` → berarti **genap**

## Yang diminta sama soal

- User **menginput** (mengisi) satu bilangan bulat.
- Program memberi tahu: bilangan itu **ganjil** atau **genap**.

## Inti jawabannya (langkah-langkah)

1. Program tanya: "Masukkan sebuah bilangan bulat?" → user isi angka
2. Program cek: kalau `angka % 2 == 0` → berarti **GENAP**
3. Kalau bukan (sisanya bukan 0) → berarti **GANJIL**
4. Program tampilkan hasilnya ke layar

---

# Kesamaan Dua Soal Ini

Sebenarnya dua soal ini **polanya sama**:

1. **Ambil input** dari user (Soal 1: 2 angka. Soal 2: 1 angka)
2. **Proses / hitung** (Soal 1: pakai rumus. Soal 2: cek sisa bagi)
3. **Cetak hasil** ke layar

Kalau paham satu soal, soal satunya jadi gampang.

---

# Kode Jawaban (Java)

Dua file sudah dibuat di folder ini:

- `Soal1_VolumeTabung.java`
- `Soal2_GanjilGenap.java`

## Soal 1 — Volume Tabung

```java
import java.util.Scanner;

public class Soal1_VolumeTabung {
    public static void main(String[] args) {
        final double PI = 3.14; // kalau soal minta 22/7, ganti jadi (22.0 / 7)

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jari-jari (r): ");
        double r = input.nextDouble();

        System.out.print("Masukkan tinggi (t): ");
        double t = input.nextDouble();

        double volume = PI * r * r * t; // a. rumus volume tabung

        System.out.println("Volume tabung = " + volume);

        input.close();
    }
}
```

**Contoh jalan** (r = 7, t = 10):

```
Masukkan jari-jari (r): 7
Masukkan tinggi (t): 10
Volume tabung = 1538.6000000000001
```

## Soal 2 — Ganjil / Genap

```java
import java.util.Scanner;

public class Soal2_GanjilGenap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan sebuah bilangan bulat: ");
        int angka = input.nextInt();

        if (angka % 2 == 0) {
            System.out.println(angka + " adalah bilangan GENAP");
        } else {
            System.out.println(angka + " adalah bilangan GANJIL");
        }

        input.close();
    }
}
```

**Contoh jalan** (input 7):

```
Masukkan sebuah bilangan bulat: 7
7 adalah bilangan GANJIL
```

## Cara Menjalankan

```bash
javac Soal1_VolumeTabung.java
java Soal1_VolumeTabung

javac Soal2_GanjilGenap.java
java Soal2_GanjilGenap
```

---

# Catatan Penting

- Di slide ada **gambar rumus**. Gambar itu tidak bisa kubuka, tapi rumus volume tabung sudah pasti **V = π × r × r × t**. Kalau di gambar ternyata mewajibkan π = 22/7, tinggal ganti `3.14` jadi `(22.0 / 7)`.

