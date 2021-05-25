import java.util.Comparator;

public class itemBarang implements Cloneable{
	
	private String nama;
	private int harga;
	private int qty;
	
	public itemBarang(String nama, int qty) {
		this.nama= nama;
		this.qty = qty;
	}
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	public static Comparator<itemBarang> nameCompare = new Comparator<itemBarang>() {
		public int compare(itemBarang i1, itemBarang i2) {
			String name1 = i1.getNama().toUpperCase();
			   String name2 = i2.getNama().toUpperCase();

			   return name1.compareTo(name2);
		}
	};
	public static Comparator<itemBarang> priceCompare = new Comparator<itemBarang>() {
		public int compare(itemBarang p1, itemBarang p2) {
			int pro1 = p1.getHarga();
			   int pro2 = p2.getHarga();

			   return pro1 - pro2;
		}
	};

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		return "Item [nama=" + nama + ", harga=" + harga + ", qty=" + qty + "]";
	}
	
	
	
}
