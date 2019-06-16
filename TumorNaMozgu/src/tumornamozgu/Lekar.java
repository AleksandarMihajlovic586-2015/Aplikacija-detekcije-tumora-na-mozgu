
package tumornamozgu;

public class Lekar {
   private String imeL;
   private String prezimeL;
   public Lekar(String imeL, String prezimeL) {
		 this.setIme(imeL);
		 this.setPrezime(prezimeL);
		 }
	public String getIme() {
		return imeL;
	}
   public void setIme(String ime) {
		this.imeL = ime;
	}

	public String getPrezime() {
		return prezimeL;
	}

	public void setPrezime(String prezime) {
		this.prezimeL = prezime;
	}
  
}
