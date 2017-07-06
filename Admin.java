package GUI_project;

import java.util.Date;

/**Ylläpitäjää mallintava luokka.
*@.ClassInvariant this.nimi!=null
*@author Juhani Vähä-Mäkilä <3
*@version 0.1
*/

final class Admin extends User {
	
	private String nimi;
	/**
	*@param nimi 
	 * @.pre true
	*@.post this.nimi!=null
	*/
	public Admin(String nimi) {
		this.nimi=nimi;
	}
	//**************************
	//getterit ja setterit
	//**************************
	
	/**
	*@param nimi 
	 * @.pre true
	*@.post this.nimi!=null
	*/
	public void setNimi(String nimi) {
		this.nimi=nimi;
	}
	/**
	*@return Adminin nimi.
	 * @.pre true
	*@.post RESULT(this.nimi)
	*/
	public String getNimi() {
		return this.nimi;
	}
	//*************
	//muut
	//*************
	
	/**Lisää uuden elokuvan.
	 * @param nimi 
	 * @param vuosi 
	 * @.pre nimi!=null && (vuosi>1900 && vuosi<2017)
	*@.post 
	*/
	protected void addMovie(String nimi, int vuosi) {
		Elokuvateatteri.elokuvat.add(new Elokuva(nimi,vuosi));
	}
	
	/**
	 * 
	 * @param i
	 */
	protected void poistaElokuva(int i){
		Elokuvateatteri.elokuvat.remove(i);
	}
	
	/**
	 * 
	 * @param i
	 */
	void poistaNaytos(int i) {
		Elokuvateatteri.elokuvat.get(i).getNaytokset().remove(i);
	}
	
	/**
	 * 
	 * @param i
	 * @param sali
	 * @param elokuva
	 * @param pv
	 * @param nro
	 */
	void lisaaNaytos(int i, int sali, String elokuva, Date pv, int nro) {
		Elokuvateatteri.elokuvat.get(i).getNaytokset().add(new Naytos(sali, elokuva, pv, nro));
	}
	
	/**
	 * Antaa näytökselle uuden numeron.
	 * @param elokuva Elokuvan numero listassa.
	 * @param naytos Näytöksen numero.
	 * @param nro Näytöksen uusi numero.
	 */
	void muokkaaNaytos(int elokuva, int naytos, int nro){
		Elokuvateatteri.elokuvat.get(elokuva).getNaytokset().get(naytos).setNaytoksenNro(nro);
	}
	
	/**
	 * Asettaa näytökselle uuden päivämäärän.
	 * @param naytos Näytöksen numero.
	 * @param elokuva Elokuvan numero listassa.
	 * @param pv Uusi päivämäärä.
	 */
	void muokkaaNaytos(int elokuva, int naytos, Date pv){
		Elokuvateatteri.elokuvat.get(elokuva).getNaytokset().get(naytos).setPaiva(pv);
	}
	
	/**
	 * Muokkaa näytöksestä salin numeron.
	 * @param elokuva Elokuvan paikka listassa.
	 * @param naytos Näytöksen numero.
	 * @param sali Salin numero.
	 */
	void muokkaaNaytos(int elokuva, int naytos, short sali){
		Elokuvateatteri.elokuvat.get(elokuva).getNaytokset().get(naytos).setSalinumero(sali);
	}
	
	/**
	 * Muokkaa kaikkia näytöksen tietoja. Tekee saman kuin lisaaNaytos.
	 * @param i
	 * @param sali
	 * @param elokuva
	 * @param pv
	 * @param nro
	 */
	void muokkaaNaytos(int i, int sali, String elokuva, Date pv, int nro) {
		Elokuvateatteri.elokuvat.get(i).getNaytokset().set(nro,new Naytos(sali, elokuva, pv, nro));
	}
}
