import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class transactionNya {
	
	private ArrayList<itemBarang> itemList =new ArrayList<>();
	private ArrayList<pulsaNya> pulsaList =new ArrayList<>();
	Date date = new Date();
	DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
	String str6 = df6.format(date);
	
	public transactionNya(ArrayList<itemBarang> itemList, ArrayList<pulsaNya> pulsaList) {
		Iterator<pulsaNya> iterator = pulsaList.iterator();
		Iterator<itemBarang> iterator1 = itemList.iterator();
		while(iterator.hasNext()) {
			try {
				this.pulsaList.add((pulsaNya) iterator.next().clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(iterator1.hasNext()) {
			try {
				this.itemList.add((itemBarang) iterator1.next().clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

	}
	
public void view() {
	System.out.println("PULSA");
	System.out.println("=====");
	for(pulsaNya pul : this.pulsaList) {
		System.out.println(pul);
	}
	System.out.println("ITEM");
	for(itemBarang item : itemList) {
		System.out.println(item);
	}
}

}
