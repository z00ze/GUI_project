package VitunGit;

/**Mallintaa yksittäistä näytöstä.
*/
import java.util.*;

final class Naytos {
	//Attr
	int salinumero;
	String elokuvanNimi;
	ArrayList<Varaus> varaukset = new ArrayList<Varaus>(0);
	Date Paiva;
	int naytoksenNro;
	
	public Naytos(){
		this.salinumero = 0;
		this.elokuvanNimi = "";
		this.Paiva = new Date();
		this.naytoksenNro = 0;
	}
	public Naytos(int sali, String elokuva, Date pv, int nro){
		this.salinumero = sali;
		this.elokuvanNimi = elokuva;
		this.Paiva = pv;
		this.naytoksenNro = nro;
	}
	/**
	*@.pre true
	*@.post RESULT(this.salinumero)
	*/
	public int getSalinumero() {
		return this.salinumero;
	}
	/**
	*@.pre true
	*@.post RESULT(this.elokuvanNimi)
	*/
	public String getElokuvanNimi() {
		return this.elokuvanNimi;
	}
	/**
	*@.pre true
	*@.post RESULT(this.varaukset)
	*/
	public ArrayList<Varaus> getVaraukset() {
		return this.varaukset;
	}
	/**
	*@.pre true
	*@.post RESULT(this.Paiva)
	*/
	public Date getPaiva() {
		return this.Paiva;
	}
	/**
	*@.pre true
	*@.post RESULT(this.naytoksenNro)
	*/
	public int getNaytoksenNro() {
		return this.naytoksenNro;
	}
	/**
	*@.pre PARAM salinumero != null
	*@.post RESULT(this.salinumero = salinumero)
	*/
	public void setSalinumero(int salinumero) {
		this.salinumero = salinumero;
	}
	/**
	*@.pre PARAM elokuvanNimi != null
	*@.post RESULT(this.elokuvanNimi = elokuvanNimi)
	*/
	public void setElokuvanNimi(String elokuvanNimi) {
		this.elokuvanNimi = elokuvanNimi;
	}
	/**
	*@.pre PARAM varaukset != null
	*@.post RESULT(this.varaukset = varaukset)
	*/
	public void setVaraukset(ArrayList<Varaus> varaukset) {
		this.varaukset = varaukset;
	}
	/**
	*@.pre PARAM paiva != null
	*@.post RESULT(this.paiva = paiva)
	*/
	public void setPaiva(Date paiva) {
		Paiva = paiva;
	}
	/**
	*@.pre PARAM naytoksenNro != null
	*@.post RESULT(this.naytoksenNro = naytoksenNro)
	*/
	public void setNaytoksenNro(int naytoksenNro) {
		this.naytoksenNro = naytoksenNro;
	}
	
}
