package VitunGit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


/**Main luokka
*/

public class GuiHarkka {

	public static void main(String[] args) {
            UI kayttoliittyma = new UI();
            kayttoliittyma.luoUI();
	}

}