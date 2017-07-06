package VitunGit;

/**Itse elokuvateatteri.
*/
import java.util.*;

class Elokuvateatteri {
	
	protected static ArrayList<Elokuva> elokuvat = new ArrayList<Elokuva>(); //?? olisiko tämä hyvä paikka tallentaa kaikki näytettävät elokuvat? -J
	
	//Attr
	private int salienMaara;
	private ArrayList<Sali> salit = new ArrayList<Sali>(0);
	
	
	public Elokuvateatteri(){
		salienMaara = 0;
	}
	public Elokuvateatteri(int saleja){
		this.salienMaara = saleja;
	}
	/**
	*@.pre true
	*@.post RESULT(this.salienMaara)
	*/
	public int getSalienMaara() {
		return this.salienMaara;
	}
	/**
	*@.pre true
	*@.post RESULT(this.salit)
	*/
	public ArrayList<Sali> getSalit() {
		return this.salit;
	}
	/**
	*@.pre PARAM salienMaara != null
	*@.post RESULT(this.salienMaara = salienMaara)
	*/
	public void setSalienMaara(int salienMaara) {
		this.salienMaara = salienMaara;
	}
	/**
	*@.pre PARAM salit != null
	*@.post RESULT(this.salit = salit)
	*/
	public void setSalit(ArrayList<Sali> salit) {
		this.salit = salit;
	}
}