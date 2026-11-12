public class coba {

    public static void main(String[] args) {

        System.out.println(simpel());

        fungsivoid("apa pun");
        selamat("nadjib");
    }

private static void selamat( String nama){
    System.out.println("selamat pagi" + nama);
}

// fungsi atau method tanpa pengembalian
    private static void fungsivoid(String input){
System.out.println(input);
    }
     //fungsi atau method dengan pegembalian
     //sehingga menggunakan return untuk 
     //untuk mengembalikan nilai nya yaitu 10.0
    private static float simpel(){
        return 10.0f;
    }

}