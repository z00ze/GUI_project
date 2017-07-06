package GUI_project;

/**Mallintaa elokuvaa
*/

import java.util.*;

final class Elokuva implements java.io.Serializable{

/**
*@.ClassInvariant (nimi!=null && valmistusvuosi>0)
*/
	private String nimi;
	private int valmistusvuosi;
	private ArrayList<Naytos> naytokset;
	
	/**
	*
	*/
	public Elokuva(){
		this.nimi = "";
		this.valmistusvuosi = 2017;
		this.naytokset = new ArrayList<Naytos>(0);
	}
	public Elokuva(String nimi, int vuosi) {
		this.nimi = nimi;
		this.valmistusvuosi = vuosi;
		this.naytokset = new ArrayList<Naytos>(0);
	}
	/**
	*@.pre true
	*@.post RESULT(this.numero)
	*/
	public String getNimi() {
		return nimi;
	}
	/**
	*@.pre true
	*@.post RESULT(this.numero)
	*/
	public int getValmistusvuosi() {
		return valmistusvuosi;
	}
	/**
	*@.pre true
	*@.post RESULT(this.numero)
	*/
	public ArrayList<Naytos> getNaytokset() {
		return naytokset;
	}
	/**
	*@.pre PARAM nimi != null
	*@.post RESULT(this.nimi = nimi)
	*/
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	/**
	*@.pre PARAM valmistusvuosi != null
	*@.post RESULT(this.valmistusvuosi = valmistusvuosi)
	*/
	public void setValmistusvuosi(int valmistusvuosi) {
		this.valmistusvuosi = valmistusvuosi;
	}
	/**
	*@.pre PARAM naytokset != null
	*@.post RESULT(this.naytokset = naytokset)
	*/
	public void setNaytokset(ArrayList<Naytos> naytokset) {
		this.naytokset = naytokset;
	}
	public void printInfo(){
		System.out.println("Nimi: " + nimi + "\nVuosi: " + valmistusvuosi);
	}
	public void printData(){
		System.out.println("1. " + nimi + "\n2." + valmistusvuosi + "\n3. varaukset");
	}
}
