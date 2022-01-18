import java.util.Scanner;//untuk memanggil scanner       //edi

public class bandara {  
    //atribut (variabel diluar method yang bisa diakses seluruh bagian yang ada di class)
    static String Nama; 
    static String tujuan;
    static String jenispesawat;
    static int hargatiket;
    static int pembayaran;
    static String status;

    public bandara (String nama,String pergi, String jp, int ht, int bayar, String ver) {   //konstructor (method pada java yang dimana nama methodnya dengan nama class itu sendiri)
        Nama = nama;
        tujuan = pergi;
        jenispesawat = jp;
        hargatiket = ht;
        pembayaran = bayar;
        status = ver;
    }
    //tampilan pilihan menu
    public void displaymenu () {
        System.out.println("================================================");
        System.out.println("                      Menu                      ");
        System.out.println("================================================");
        System.out.println(" No Tujuan          Tujuan          Harga       ");
        System.out.println("    1               JOG              600        ");
        System.out.println("    2               SOLO             500        ");
        System.out.println("    3               JKT              800        ");
        System.out.println("    4               SUB              600        ");
        System.out.println("    5               SRG              700        ");
        System.out.println("================================================");
        System.out.println(" No Pesawat         Class           Harga       ");
        System.out.println("    1               First            150%       ");
        System.out.println("    2               Business         120%       ");
        System.out.println("    3               Economy          100%       ");
        System.out.println("││││││││││││││││││││││││││││││││││││││││││││││││");
    }
    //input string
    public String nama (String NM) {    //buat memepersingkat codingan
        Scanner nama = new Scanner(System.in);
        NM = nama.nextLine();
        return NM; 
    }
    //input integer
    public int BAYAR (int BYR) {
        Scanner bayar = new Scanner(System.in);
        System.out.print("Bayar :");
        BYR = bayar.nextInt();
        return BYR;
    }

    //pilih jenis pesawat
    public String pesawat (String Pilih) {      //kahfi
        jenispesawat = Pilih;
        switch (Pilih) {
            case "1":
                jenispesawat = "First";
                break;
            case "2":
                jenispesawat = "Business";
                break;
            case "3":
                jenispesawat = "Economy";
                break;
        }
        return jenispesawat;
    }
    //pilih tujuan
    public String go (String Pilih) {
        switch (Pilih) {
            case "1":tujuan = "JOG";
                break;
            case "2":tujuan = "SOLO";
                break;
            case "3":tujuan = "JKT";
                break;
            case "4":tujuan = "SUB";
                break;
            case "5":tujuan = "SRG";
                break;
        }
        return tujuan;
    }

    //menetapkan harga 
    public int Tiket (String pergi) {
    tujuan = pergi;
        switch (tujuan) {
            case "JOG": hargatiket = 600;
                break; 
            case "SOLO": hargatiket = 500;
                break;
            case "JKT": hargatiket = 800;
                break;
            case "SUB": hargatiket = 600;
                break;
            case "SRG": hargatiket = 700;
                break;
        }
        return hargatiket;
    }

    //Proses harga setelah pemilihan jenispesawat
    public int biaya(String total) {        //alan
    jenispesawat = total;
        if (jenispesawat == "First") {
            hargatiket = (int) (hargatiket *1.5);
        }  
        else if (jenispesawat == "Business"){
            hargatiket = (int) (hargatiket *1.2);
        }
        else if (jenispesawat == "Economy"){
            hargatiket = (int) (hargatiket *1.0);
        }
        return hargatiket;
    }

    //proses pembayaran
    public int Billing (int bil) {
        pembayaran = bil;   
        if (pembayaran < hargatiket) {
            System.out.println("Maaf Uang anda tidak Cukup");
            System.out.println("Harga tiket = "+ hargatiket);
            pembayaran = pembayaran - hargatiket;
            System.out.println("Pembayaran Kurang = "+ pembayaran);
        }
        else if (pembayaran == hargatiket){
            System.out.println("Pembayaran Lunas");
            System.out.println("Harga tiket = "+ hargatiket);
        }
        else if (pembayaran > hargatiket){
            pembayaran = pembayaran - hargatiket;
            System.out.println("Harga tiket = "+ hargatiket);
            System.out.println("Sisa Kembalian = "+ pembayaran);
            pembayaran = hargatiket;
        }
        return pembayaran;
    }

    //pemverifikasi pembayaran sudah terpenuhi
    public String verifikasi(int bill) {
        pembayaran = bill;
        if (pembayaran >hargatiket){
            status = "Terverifikasi";
        }
        else if (pembayaran == hargatiket){
            status = "Terverifikasi";
        }
        else {
            status = "Belum Terverifikasi";
        }
        return status;
    }

    //tampilan hasil proses
    public void Displayall (String nama, String pergi, String jp, int ht, int bayar, String ver) {      //faizal
        System.out.println("││││││││││││││││││││││││││││││││││││││││││││││││");
        System.out.println("================================================");
        System.out.println("   Terimakasih telah menggunakan layanan kami   ");
        System.out.println("================================================");
        System.out.println("                    Tiket Pesawat               ");
        System.out.println("================================================");
        System.out.println(" Nama Penumpang = "+ nama);
        System.out.println(" Tujuan kota = "+ pergi);
        System.out.println(" Jenis Pesawat = "+ jp);
        System.out.println(" Harga Tiket = "+ ht);
        System.out.println(" Pembayaran = "+ bayar);
        System.out.println(" Status Tiket = "+ ver);
        System.out.println("================================================");
    }
    public static void main(String[] args) {
        bandara Data = new bandara (Nama, tujuan, jenispesawat, hargatiket, pembayaran, status);//Membuat objek baru untuk program bandara
        
        Data.displaymenu();//Menampilkan Display menu
        
        System.out.print("Nama Penumpang :");
        String nama = Data.nama(Nama);//Mengambil input Nama penumpang
        
        System.out.print("No Tujuan Anda :");
        String pergi = Data.nama (tujuan);//Mengambil input No tujuan
        Data.go(pergi);//Data tujuan yang sudah diinput dicocokkan dengan kondisi switch yang ada di method go
        Data.Tiket(tujuan);//Data tujuan yang sudah diinput dicocokkan dengan kondisi switch untuk mendapatkan harga tiket tujuan yang ada di method tiket
        
        System.out.print("Jenis Pesawat :");
        String jp = Data.nama(jenispesawat);//Mengambil input jenispesawat
        Data.pesawat(jp);//Data pesawat yang sudah diinput dicocokkan dengan jenis pesawat yang ada di kondisi switch pada method jenispesawat
        Data.biaya(jenispesawat);//Data pesawat yang sudah diinput dicocokkan dengan kondisi switch untuk mendapatkan harga jenispesawat yang ada di method tiket
        
        int bayar = Data.BAYAR (pembayaran);//Mengambil input bayar
        Data.Billing(bayar);//Jumlah uang yang dibayar dicocokkan dengan kondisi switch untuk mendapatkan kondisi pembayaran tercukupi, berlebih, atau kurang
        System.out.println();
        
        Data.verifikasi(pembayaran);//Kondisi jumlah uang pembayaran dari method Billing diteruskan untuk verifikasi, billing akan terverifikasi apabila pembayaran cukup atau lebih
        
        Data.Displayall(nama, tujuan, jenispesawat, hargatiket, pembayaran, status);//Variabel data inputan dioper kedalam method Displayall untuk menampilkan data yang telah di update

    } 
}