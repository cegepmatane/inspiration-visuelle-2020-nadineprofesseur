import java.util.Iterator;
import java.util.List;

import accesseur.PenseeDAO;
import modele.Pensee;
import outils.Journal;

public class App {

	public static void main(String[] parametres) {

		//Journal.activer();
		Journal.activerNiveau(0);
				
		VueInspirationVisuelle.launch(VueInspirationVisuelle.class, parametres);
		
		
	}

}
