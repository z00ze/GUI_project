package GUI_project;


import java.util.ArrayList;
import java.util.List;

/**Mallintaa asiakkaan.
*@.ClassInvariant this.userName!=null && this.nimi!=null
*@author Juhani Vähä-Mäkilä
*@version 0.1
*/

final class Asiakas extends User {
	
	private String nimi;
	private String userName;
	private List<Varaus> varaukset;
	
	/**
	*@param nimi 
	* @param uname 
	* @.pre true
	*@.post this.nimi!=null && this.userName!=null
	*/
	public Asiakas(String nimi, String uname) {
		this.nimi=nimi;
		this.userName=uname;
		this.varaukset=new ArrayList<Varaus>();
	}
	//*********************
	//getterit ja setterit
	//*********************
	/**
	*@return 
	 * @.pre true
	*@.post RESULT(this.nimi)
	*/
	public String getNimi() {
		return this.nimi;
	}
	/**
	*@return 
	*@.pre true
	*@.post RESULT(this.userName)
	*/
	public String getUserName() {
		return this.userName;
	}
	/**
	*@param nimi 
	 * @.pre true
	*@.post RESULT(this.nimi!=null && this.nimi==nimi) 
	*/
	public void setNimi(String nimi) {
		this.nimi=nimi;
	}
	/**
	*@param nimi 
	*@.pre true
	*@.post RESULT(this.userName!=null && this.nimi==nimi)
	*/
	public void setUserName(String nimi) {
		this.userName=nimi;
	}
	//*************
	//muut
	//*************
	/**Luo uuden varauksen.
	 * @param paikanNumero 
	 * @param varausNumero 
	 * @param näytös 
	*/
	protected void teeVaraus(int paikanNumero, int varausNumero, Naytos näytös) {
		this.varaukset.add(new Varaus(paikanNumero,varausNumero,näytös));
	}
	/**Muokkaa olemassa olevaa varausta. Varaukset ovat näytös-olion listassa.
	 * @param varausnumero 
	 * @param paikannumero 
	*@.pre varausnumero>0 && paikannumero>0
	*@.post (OLD(paikannumero)!=RESULT(paikannumero)) && (OLD(varausnumero)==RESULT(varausnumero))
	*/
	protected void muokkaaVarausta(int varausnumero, int paikannumero) {
		this.varaukset.set(varausnumero, new Varaus(varausnumero, paikannumero, this.varaukset.get(varausnumero).getNaytos()));
	}
	/**Poistaa varauksen. Varaukset ovat näytös-olion listassa.
	* @param varausnumero 
	*@.pre varausnumero>=0
	*/
	protected void poistaVaraus(int varausnumero){
		this.varaukset.remove(varausnumero);
		
	}

}
