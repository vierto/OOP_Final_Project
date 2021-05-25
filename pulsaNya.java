import java.util.Comparator;

public class pulsaNya implements Cloneable{
	
	private String number;
	private String provider;
	private int nominal;
	
	public pulsaNya(String number, int nominal) {
		this.number = number;
		String firstFourChar = number.substring(2,4);
		checkProvider(firstFourChar);
		this.nominal=nominal;
	}
	public void checkProvider(String n) {
		if(n.contains("11")||n.contains("12")||n.contains("13")||n.contains("21")||n.contains("22")||n.contains("23")||n.contains("51")||n.contains("52")||n.contains("53")) {
			setProvider("TELKOMSEL");
		}else if(n.contains("14")||n.contains("15")||n.contains("16")||n.contains("55")||n.contains("56")||n.contains("57")||n.contains("58")) {
			setProvider("INDOSAT");
		}else if(n.contains("17")||n.contains("18")||n.contains("19")||n.contains("59")||n.contains("77")||n.contains("78")||n.contains("79")) {
			setProvider("XL");
		}else if(n.contains("95")||n.contains("96")||n.contains("97")||n.contains("98")||n.contains("99")) {
			setProvider("THREE");
		}else if(n.contains("81")||n.contains("82")||n.contains("83")||n.contains("84")||n.contains("85")||n.contains("86")||n.contains("87")||n.contains("88")||n.contains("89")) {
			setProvider("SMARTFREN");
		}else if(n.contains("31")||n.contains("32")||n.contains("33")||n.contains("38")) {
			setProvider("AXIS");
		}
	}
	public static String checkProvider1(String number) {
		String n = number.substring(2,4);
		if(n.contains("11")||n.contains("12")||n.contains("13")||n.contains("21")||n.contains("22")||n.contains("23")||n.contains("51")||n.contains("52")||n.contains("53")) {
			return "TELKOMSEL";
		}else if(n.contains("14")||n.contains("15")||n.contains("16")||n.contains("55")||n.contains("56")||n.contains("57")||n.contains("58")) {
			return "INDOSAT";
		}else if(n.contains("17")||n.contains("18")||n.contains("19")||n.contains("59")||n.contains("77")||n.contains("78")||n.contains("79")) {
			return "XL";
		}else if(n.contains("95")||n.contains("96")||n.contains("97")||n.contains("98")||n.contains("99")) {
			return"THREE";
		}else if(n.contains("81")||n.contains("82")||n.contains("83")||n.contains("84")||n.contains("85")||n.contains("86")||n.contains("87")||n.contains("88")||n.contains("89")) {
			return "SMARTFREN";
		}else if(n.contains("31")||n.contains("32")||n.contains("33")||n.contains("38")) {
			return "AXIS";
		}
		return "";
	}
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public int getNominal() {
		return nominal;
	}

	public void setNominal(int nominal) {
		this.nominal = nominal;
	}
	
	public static Comparator<pulsaNya> providerCompare = new Comparator<pulsaNya>() {
		public int compare(pulsaNya p1, pulsaNya p2) {
			String pro1 = p1.getProvider().toUpperCase();
			   String pro2 = p2.getProvider().toUpperCase();

			   return pro1.compareTo(pro2);
		}
	};
	public static Comparator<pulsaNya> priceCompare = new Comparator<pulsaNya>() {
		public int compare(pulsaNya p1, pulsaNya p2) {
			int pro1 = p1.getNominal();
			   int pro2 = p2.getNominal();

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
		return "Pulsa [number=" + number + ", provider=" + provider + ", nominal=" + nominal + "]";
	}
}
