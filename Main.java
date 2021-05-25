import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
public class Main {

	Scanner scan = new Scanner(System.in);
	ArrayList<itemBarang> itemList =new ArrayList<>();
	ArrayList<pulsaNya> pulsaList =new ArrayList<>();
	ArrayList<transactionNya> transactionList =new ArrayList<>();
	
	int choose1, choose2, choose3;
	private void cls(){
		for(int i = 0; i < 50; i++){
			System.out.println("");
		}
	}
	public void addPulsa() {
		String number;
		Integer nominal=0;
//		INPUT NOMOR
		do {
			System.out.println("Isi nomor telepon yang ingin diisi [10-13 digit]: ");
			number = scan.nextLine();
		} while(number.charAt(0)!= '0'||number.charAt(1)!='8'||number.length() <10 || number.length() > 13);
		
		do {
			System.out.println("Pilih nominal Top-Up pulsa yang Anda inginkan: ");
			System.out.println();
			System.out.println("Provider Anda : "+ pulsaNya.checkProvider1(number));
			System.out.println("             |5.000|          |10.000|");
			System.out.println("             Rp 5.500        Rp 11.000");
			System.out.println();
			System.out.println("             |20.000|         |25.000|");
			System.out.println("             Rp 22.000       Rp 27.500");
			System.out.println();
			System.out.println("             |50.000|         |100.000|");
			System.out.println("             Rp 55.000       Rp 110.000");
			System.out.println("*harga tertera sudah termasuk PPN");
			System.out.println(" ");
			System.out.println("Jika Anda Ingin Membatalkan Transaksi ini, Tekan '9'......");
			System.out.println(" ");
			System.out.println("Silahkan pilih nominal....");
			System.out.print(">>> ");
			nominal = scan.nextInt(); scan.nextLine();
			System.out.println(nominal);
		} while (nominal!=5000 && nominal!=10000 && nominal!=20000 && nominal!=25000 && nominal!=50000 && nominal!=100000 && nominal!=9);
		
		if(nominal != 9) {
			pulsaNya newPulsa = new pulsaNya(number, nominal);
			pulsaList.add(newPulsa);
			System.out.println("Lanjutkan pembayaran di menu Transaksi"); scan.nextLine();
			}
	
	}
	public void addBarang() {
		String barang;
		int jumlah=0;
		int choose=0;
		Calendar cal = Calendar.getInstance();
		int hour=cal.get(cal.HOUR);
		System.out.println(hour);
		if(hour>=1 && hour<12) {
			System.out.println("Halo Selamat Pagi, Silahkan tambahkan barang yang ingin Anda beli");
		}else if(hour>=12 && hour<15) {
			System.out.println("Halo Selamat Siang, Silahkan tambahkan barang yang ingin Anda beli");
		}else if(hour>=15 && hour<=17) {
			System.out.println("Halo Selamat Sore, Silahkan tambahkan barang yang ingin Anda beli");
		}else if(hour>=18 && hour<=24){
			System.out.println("Halo Selamat Malam, Silahkan tambahkan barang yang ingin Anda beli");
		}
		System.out.println();
		
		do {
			System.out.print("Input nama barang : ");
			barang = scan.nextLine();
			System.out.print("Input jumlah barang :");
			try {
				jumlah = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				System.out.println("Input angka");
			}
			
			System.out.println("1. Masukkan keranjang");
			System.out.println("2. Batalkan dan lanjut belanja");
			System.out.println("3. Kembali ke menu utama");
			choose=scan.nextInt(); scan.nextLine();
			
			if(choose ==1) {
				itemBarang newItem = new itemBarang(barang, jumlah);
				itemList.add(newItem);
				System.out.println("1. Lanjutkan belanja");
				System.out.println("2. Kembali ke menu utama");
				choose=scan.nextInt(); scan.nextLine();
				if(choose == 2)break;
			}
			
		} while (choose!=3);
	}
	
	public Main() {
		do {
			Date dt = new Date();
			System.out.println(dt);
			cls();
			System.out.println("Selamat Datang di BukapediaMall");
			System.out.println("==============================");
			System.out.println("1. Melakukan Pembelian");
			System.out.println("2. Histori Pembelian");
			System.out.println("3. Lihat Keranjang");
			System.out.println("4. Transaksi / Checkout");
			System.out.println("5. Keluar");
			System.out.println(" ");
			System.out.println("Silahkan Anda Memilih Opsi....");
			System.out.print(">>> ");
			choose1 = scan.nextInt(); scan.nextLine();
			
			if(choose1 == 1) {
				do {
					System.out.println("1. Pulsa");
					System.out.println("2. Barang");
					System.out.println("3. Kembali Ke Menu Utama");
					System.out.println(" ");
					System.out.println("Silahkan Anda Memilih Opsi....");
					System.out.print(">>> ");
					choose2 = scan.nextInt(); scan.nextLine();
				} while (choose2 >3 && choose2 <1);
				switch(choose2) {
				case 1: addPulsa();
						break;
				case 2: addBarang();
						break;
				default: break;
					
				}
			}else if(choose1 == 2) {
				cls();
				System.out.println("Histori Pembelian :");
				for(int i=0; i<transactionList.size(); i++) {
					System.out.println((i+1)+". " + transactionList.get(i).str6);
				}
				System.out.print("Pilih tanggal Transaksi >> "); 
				choose3 = scan.nextInt(); scan.nextLine();
				transactionList.get(choose3-1).view();
				scan.nextLine();
				
			}else if(choose1 == 3) {
				cls();
				System.out.println("1. Sort Berdasarkan Nama");
				System.out.println("1. Sort Berdasarkan Harga");
				System.out.print(">>");
				choose2=scan.nextInt(); scan.nextLine();
				if(choose2==1) {
					Collections.sort(pulsaList, pulsaNya.providerCompare);
					Collections.sort(itemList, itemBarang.nameCompare);
					System.out.println("PULSA");
					System.out.println("=====");
					for(pulsaNya pul : pulsaList) {
						System.out.println(pul);
					}
					System.out.println("ITEM");
					for(itemBarang item : itemList) {
						System.out.println(item);
					}
				
				}else if(choose2 == 2) {
					Collections.sort(pulsaList, pulsaNya.priceCompare);
					Collections.sort(itemList, itemBarang.priceCompare);
					System.out.println("PULSA");
					System.out.println("=====");
					System.out.println("ITEM");
					System.out.println("====");
				}
				scan.nextLine();
			}else if(choose1 == 4) {
				System.out.println("PULSA");
				System.out.println("=====");
				for(pulsaNya pul : pulsaList) {
					System.out.println(pul);
				}
				System.out.println("ITEM");
				for(itemBarang item : itemList) {
					System.out.println(item);
				}
				System.out.println("TEKAN ENTER UNTUK BAYAR");//scan.nextLine();
				transactionNya newtrans=new transactionNya(itemList, pulsaList);
				transactionList.add(newtrans);
				pulsaList.clear();
				itemList.clear();
				scan.nextLine();
				
			}else if(choose1 == 5) {
				cls();
				System.out.println("Terima Kasih Sudah Mengunjungi Store Kami...");
				System.out.println(" ");
				System.out.println("est. 2020");
				System.exit(0);
			}
		} while (choose1 < 5 && choose1 >= 1);
	}
	

	public static void main(String[] args) {
		new Main();
	}
}

// Aplikasi Ini Dibuat Oleh:
// 1. Nicholas Mario Tanamas - 2301898512
// 2. Arief Darvin - 2301853615
//	3. Kelvinsent - 2301901356
//	4. Vendly - 2301858345
//	5. Silvia Candra - 2301873270
//	6. Reinard Ferdinand Tanex - 2301857790