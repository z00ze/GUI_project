package VitunGit;

/**Mallintaa varausta.
*/
import java.util.*;

class Varaus {

	//Attributes
	int varausNumero;
	int paikanNumero;
	Naytos naytos;
	
	public Varaus() {
		this.varausNumero = 0;
		this.paikanNumero = 0;
		this.naytos = new Naytos();
	}
	public Varaus(int varaus, int paikka, Naytos naytto) {
		this.varausNumero = varaus;
		this.paikanNumero = paikka;
		this.naytos = naytto;
	}
	/**
	*@.pre true
	*@.post RESULT(this.varausNumero)
	*/
	public int getVarausNumero() {
		return varausNumero;
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
	*@.post RESULT(this.naytos)
	*/
	public Naytos getNaytos() {
		return naytos;
	}
	/**
	*@.pre PARAM varausNumero != null
	*@.post RESULT(this.varausNumero = varausNumero)
	*/
	public void setVarausNumero(int varausNumero) {
		this.varausNumero = varausNumero;
	}
	/**
	*@.pre PARAM paikanNumero != null
	*@.post RESULT(this.paikanNumero = paikanNumero)
	*/
	public void setPaikanNumero(int paikanNumero) {
		this.paikanNumero = paikanNumero;
	}
	/**
	*@.pre PARAM naytos != null
	*@.post RESULT(this.naytos = naytos)
	*/
	public void setNaytos(Naytos naytos) {
		this.naytos = naytos;
	}
}