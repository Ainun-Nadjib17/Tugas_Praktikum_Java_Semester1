// ============================================================
// MATERI: FUNGSI / METHOD DI JAVA
// Method = blok kode yang diberi nama, ditulis sekali,
//          lalu bisa dipanggil berkali-kali.
// ============================================================
public class Main {

    // main() = method KHUSUS yang jadi pintu masuk program.
    // Saat program dijalankan ("java Main"), Java selalu
    // mulai mengerjakan isi method main() ini terlebih dahulu.
    public static void main(String[] args) {

        // siapkan 2 variabel kosong bertipe int (bilangan bulat)
        int x, y;

        // percobaan pertama: x diisi 10
        x = 10;
        // method hitung() dipanggil, x dikirim sebagai "parameter".
        // hasil kembaliannya (return) ditampung di variabel y.
        y = hitung(x);
        // cetak isi x dan y: kalau x = 10, y = (10*2)*10 = 200
        System.out.println("x = " + x + ", y = " + y);

        // percobaan kedua: nilai x diganti 20, panggil ulang method yang sama.
        // inilah gunanya method: tulis sekali, pakai berkali-kali.
        x = 20;
        y = hitung(x);
        // kalau x = 20, y = (20*2)*20 = 800
        System.out.println("x = " + x + ", y = " + y);

        // program selesai di sini
    }

    // ==========================================================
    // PENJELASAN JUDUL METHOD: static int hitung(int input)
    // ----------------------------------------------------------
    // static     -> method ini bisa dipanggil tanpa membuat objek,
    //               yaitu langsung dari main() yang juga static.
    // int        -> (sebelum nama method) = TIPE NILAI KEMBALIAN.
    //               artinya method ini WAJIB mengembalikan sesuatu
    //               yang bertipe int lewat kata "return".
    // hitung     -> nama method, dipakai saat memanggil.
    // int input  -> PARAMETER: nilai yang dikirim dari pemanggil.
    //               di sini diisi x (10 atau 20).
    // ==========================================================
    static int hitung(int input) {
        // siapkan wadah hasil perhitungan
        int hasil;

        // rumus yang dikerjakan method ini tiap kali dipanggil:
        // input di-kali-2 dulu, lalu di-kali input-nya lagi
        // contoh: input 10  -> (10*2)*10 = 200
        //         input 20  -> (20*2)*20 = 800
        hasil = (input * 2) * input;

        // return = mengembalikan nilai hasil ke pemanggil
        // (nilai ini yang nanti diterima dan disimpan ke variabel y)
        return hasil;
    }

}
