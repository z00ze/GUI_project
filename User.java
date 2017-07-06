package VitunGit;

/** Eri käyttäjätyyppien yliluokka
 * @author Juhani Vähä-Mäkilä
 * @version 1.0
*/
abstract class User {
	/**Lisää uuden Asiakkaan.
	 * @param nimi Nimi
	 * @param uname Asiakkaan username. 
	 * @return Uusi Asiakas olio. Staattinen tyyppi == User.
	*@.pre true
	*@.post
	*/
	public static User addUser(String nimi, String uname) {
		return new Asiakas(nimi, uname);
	}
	/**Lisää uuden Adminin.
	 * 
	 * @param nimi Uuden adminin nimi.
	 * @return Uusi Admin olio. Staattinen tyyppi == User.
	 */
	public static User addUser(String nimi) {
		return new Admin(nimi);
	}

	
	
}