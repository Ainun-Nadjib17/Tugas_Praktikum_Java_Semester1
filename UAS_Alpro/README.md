# Detective Mystery: Bukti Terakhir

Aplikasi konsol Java bertema investigasi kasus pembunuhan/pencurian fiktif. Project ini mengerjakan **PHASE 1 dan PHASE 2** sesuai `agents.md`. Phase berikutnya belum dikerjakan.

## Ruang Lingkup Phase

### PHASE 1 — Kerangka Project & Menu Utama
- Struktur project sederhana: `src/Main.java` + `README.md` (tanpa library eksternal).
- Menu utama **Bahasa Indonesia** dengan 6 pilihan.
- `do-while` supaya menu terus berjalan sampai user memilih **6. Keluar**.
- `switch-case` untuk navigasi menu.
- Penanganan input tidak valid: bukan angka, atau di luar rentang 1–6.

### PHASE 2 — Data Kasus & Investigasi Dasar
1. **Ringkasan Kasus** — judul kasus, korban, lokasi, waktu, cerita singkat, jumlah tersangka/bukti, dan progres interogasi.
2. **Daftar Tersangka** — nama, profesi, alibi, dan status interogasi (5 tersangka).
3. **Daftar Barang Bukti** — 6 barang bukti beserta keterangannya.
4. **Interogasi Tersangka** — pilih tersangka, tampilkan alibi + temuan baru; tiap tersangka hanya bisa diinterogasi sekali.
5. **Riwayat Investasi** — semua sesi interogasi pada sesi program berjalan (maksimal 10 sesi).

> Catatan: `agents.md` tidak mendefinisikan struktur folder maupun rincian Phase 1–2 secara detail, sehingga pembagian di atas dipakai sebagai acuan. Bila ada definisi resmi, implementasi bisa disesuaikan.

## Struktur Project

```text
DetectiveMystery/
│
├── agents.md          # instruksi project
├── README.md          # dokumentasi ini
│
├── src/
│   └── Main.java      # seluruh program (satu file, sesuai arahan)
│
└── out/               # hasil kompilasi (dibuat otomatis)
```

## Konsep Java yang Dipakai

| Modul | Topik | Penerapan di kode |
|-------|-------|-------------------|
| 3 | Input/Output | `Scanner`, `nextInt()`, `nextLine()`, `println()`, `printf()` |
| 4 | Conditional | `if`, `else-if`, `switch-case` untuk menu & validasi |
| 5 | Loops | `do-while` menu utama, `for` membaca array |
| 6 | Nested Loop | Mencetak tabel daftar tersangka & barang bukti |
| 7 | One-D Arrays | Data tersangka (nama/profesi/alibi/petunjuk), barang bukti, riwayat investigasi |

## Cara Compile & Run

Dari root project:

```bash
javac src/Main.java -d out
java -cp out Main
```

Atau dari folder `src`:

```bash
javac Main.java
java Main
```

## Contoh Tampilan Menu

```text
========================================
   DETECTIVE MYSTERY: BUKTI TERAKHIR
========================================
1. Ringkasan Kasus
2. Daftar Tersangka
3. Daftar Barang Bukti
4. Interogasi Tersangka
5. Riwayat Investigasi
6. Keluar
========================================
Pilih Menu (1-6): 4
```

## Data Kasus

| No | Tersangka | Profesi |
|----|----------------------|---------------------|
| 1 | Raka Pratama | Rekan bisnis korban |
| 2 | Sinta Maharani | Sekretaris korban |
| 3 | Bimo Saputra | Satpam galeri |
| 4 | Nadia Kusuma | Kurator galeri |
| 5 | Yusuf Alamsyah | Teknisi CCTV |

Barang bukti: rekaman CCTV koridor, kunci duplikat, surat ancaman, kuitansi kafe, serpihan kaca, log sistem CCTV.

## Batasan

- Hanya console, tanpa GUI.
- Tanpa database, file storage, atau library eksternal.
- Data hanya bertahan selama program berjalan.
- Phase 3 dan seterusnya **belum** dikerjakan (sesuai instruksi `agents.md`).
