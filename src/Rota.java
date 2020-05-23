
public class Rota{

	private String varisYeri;
	private String kalkisYeri;
	private String kalkisZamani;
	private String varisZamani;
	private String model;
	private int ucusNo;
	private String sirket;
	private String durum="Bekleme";
	public static Thread t2;
	private String rotar="0";
	
	public String getRotar() {
		return rotar;
	}

	public void setRotar(String rotar) {
		this.rotar = rotar;
	}

	public Rota(String kalkisYeri, String varisYeri, String kalkisZamani, String varisZamani, String model, int ucusNo, String sirket) {
		this.varisYeri = varisYeri;
		this.kalkisYeri = kalkisYeri;
		this.kalkisZamani = kalkisZamani;
		this.varisZamani = varisZamani;
		this.model = model;
		this.ucusNo = ucusNo;
		this.sirket = sirket;
	}
	
	public String getDurum() {
		return durum;
	}

	public void setDurum(String durum) {
		this.durum = durum;
	}
	
	public void Uc() {
		t2 = new Thread() {
			public void run() {
					
				while(true) {
					int flag=1;
					int hour1=Arayuz.getHour(),min1=Arayuz.getMin();
					String zaman2 = getVarisZamani();
					String shour2 = (""+zaman2.charAt(0)+zaman2.charAt(1));
					String smin2 = (""+zaman2.charAt(3)+zaman2.charAt(4));
					
					if(Integer.parseInt(shour2)<10) {
						shour2 = (""+zaman2.charAt(1));
					}
					
					if(Integer.parseInt(smin2)<10) {
						smin2 = (""+zaman2.charAt(4));
					}
					if(min1==60) {
						min1=0;
						hour1++;
					}
					if(Integer.parseInt(shour2)==hour1 && Integer.parseInt(smin2)==min1){
						setDurum("Ýzin_Bekleniyor");
						flag=0;
					}
					
					if(flag==1) {
						String zaman = getKalkisZamani();
						String shour = (""+zaman.charAt(0)+zaman.charAt(1));
						String smin = (""+zaman.charAt(3)+zaman.charAt(4));
					
					if(Integer.parseInt(shour)<10) {
						shour = (""+zaman.charAt(1));
					}
					
					if(Integer.parseInt(smin)<10) {
						smin = (""+zaman.charAt(4));
					}
					if(min1==60) {
						min1=0;
						hour1++;
					}
					if(Integer.parseInt(shour)==(hour1) && Integer.parseInt(smin)==min1){
						setDurum("Ucusta");
					}
					}
					
				}		
			}
		};
		t2.start();
	}
	
	public int getUcusNo() {
		return ucusNo;
	}

	public void setUcusNo(int ucusNo) {
		this.ucusNo = ucusNo;
	}

	public String getSirket() {
		return sirket;
	}

	public void setSirket(String sirket) {
		this.sirket = sirket;
	}

	public String Yazdir() {
		return "KalkisY: "+ kalkisYeri + " | " + "VarýsY: " + varisYeri + " | " + "Kalkýs-Ýnis: " + kalkisZamani + "-" + varisZamani + " | " + "Ucak Modeli: " + model +
				" | " + "Ucus No: " + ucusNo + " | " + "Sirket: " + sirket + " | " + "Rotar: " + rotar + " | " ;
	}

	public String getVarisYeri() {
		return varisYeri;
	}
	public void setVarisYeri(String varisYeri) {
		this.varisYeri = varisYeri;
	}
	public String getKalkisYeri() {
		return kalkisYeri;
	}
	public void setKalkisYeri(String kalkisYeri) {
		this.kalkisYeri = kalkisYeri;
	}
	public String getKalkisZamani() {
		return kalkisZamani;
	}
	public void setKalkisZamani(String kalkisZamani) {
		this.kalkisZamani = kalkisZamani;
	}
	public String getVarisZamani() {
		return varisZamani;
	}
	public void setVarisZamani(String varisZamani) {
		this.varisZamani = varisZamani;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
}
