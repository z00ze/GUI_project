package VitunGit;

/**Mallintaa elokuvateatterin salia.
*@.ClassInvariant (((rivit>0 && rivinPituus>0) && paikat!=null) && paikat.size==rivit*rivinPituus)
*/

class Sali {
	
	private int rivit;
	private int rivinPituus;
	private int numero;
	private Istuinpaikka[] paikat;
	
	/**
	*@.pre true
	*@.post RESULT(this!=null && rivit>0 && rivinPituus>0 && paikat!=null && paikat.size==rivit*rivinPituus)
	*/
	public Sali (int r, int p, int n) {
		rivit = r;
                rivinPituus = p;
                numero = n;
	}
	/**
	*@.pre true
	*@.post RESULT(this.rivit)
	*/
	public int getRivit() {
		return this.rivit;
	}
	/**
	*@.pre true
	*@.post RESULT(this.rivinPituus)
	*/
	public int getRivinPituus() {
		return this.rivinPituus;
	}

	/**
	*@.pre true
	*@.post RESULT(this.numero)
	*/
	public int getNumero() {
		return this.numero;
	}
	/**
	*@.pre true
	*@.post RESULT(this.paikat)
	*/
	public Istuinpaikka[] getPaikat() {
		return this.paikat;
	}
	/**
	*@.pre PARAM rivit != null
	*@.post RESULT(this.rivit = rivit)
	*/
	public void setRivit(int rivit) {
		this.rivit = rivit;
	}
	/**
	*@.pre PARAM rivinPituus != null
	*@.post RESULT(this.rivinPituus = rivinPituus)
	*/
	public void setRivinPituus(int rivinPituus) {
		this.rivinPituus = rivinPituus;
	}
	/**
	*@.pre PARAM numero != null
	*@.post RESULT(this.numero = numero)
	*/
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	*@.pre PARAM paikat != null
	*@.post RESULT(this.paikat = paikat)
	*/
	public void setPaikat(Istuinpaikka[] paikat) {
		this.paikat = paikat;
	}

	/**
	*@.pre true
	*@.post RESULT(this.rivit*this.rivinPituus)
	*/
	public int totaaliPaikkoja() {
		int kaikkiPaikat = this.rivit*this.rivinPituus;
		return kaikkiPaikat;
	}
	/**Sis�luokka istuinpaikkaa varten
	*/
	protected class Istuinpaikka {
		/**
		*@.ClassInvariant (paikannumero>0)
		*/
		
		//Attr
		private int paikanNumero;
		private boolean varaus = false;
		
		//Constructor
		public Istuinpaikka(){
			this.paikanNumero = 0;
		}
		//Constructor
		public Istuinpaikka(int nro){
			this.paikanNumero = nro;
		}
		/**
		*@.pre true
		*@.post RESULT(this.paikanNumero)
		*/
		public int getPaikanNumero() {
			return paikanNumero;
		}
		/**
		*@.pre true
		*@.post RESULT(this.varaus)
		*/
		public boolean isVaraus() {
			return varaus;
		}
		/**
		*@.pre PARAM paikanNumero != null
		*@.post RESULT(this.paikanNumero = paikanNumero)
		*/
		public void setPaikanNumero(int paikanNumero) {
			this.paikanNumero = paikanNumero;
		}
		/**
		*@.pre PARAM varaus != null
		*@.post RESULT(this.varaus = varaus)
		*/
		public void setVaraus(boolean varaus) {
			this.varaus = varaus;
		}
	}
}