public class PresentasiFungsi {

    public static void main(String[] args) {

        System.out.println("--- DEMO 1: method VOID (tidak mengembalikan nilai) ---");
        sapa("Nadjib");                          // memanggil method, nama dikirim sebagai parameter

        System.out.println("\n--- DEMO 2: method dengan RETURN ---");
        int hasil = tambah(7, 5);                // hasil dari method ditampung di variabel
        System.out.println("7 + 5 = " + hasil);

        System.out.println("\n--- DEMO 3: method return dipakai langsung ---");
        System.out.println("10 + 20 = " + tambah(10, 20)); // bisa juga langsung dicetak tanpa ditampung
    }

    // METHOD VOID : tidak ada "return", tugasnya hanya menjalankan sesuatu
    static void sapa(String nama) {
        System.out.println("Halo, " + nama + "! Selamat datang di presentasi.");
    }

    // METHOD RETURN : menerima 2 parameter, mengembalikan hasilnya dengan "return"
    static int tambah(int a, int b) {
        return a + b;
    }

}
