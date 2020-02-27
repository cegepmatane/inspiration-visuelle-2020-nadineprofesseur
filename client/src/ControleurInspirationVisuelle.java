import java.util.Iterator;
import java.util.List;

import accesseur.PenseeDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import modele.Pensee;
import outils.Journal;

public class ControleurInspirationVisuelle {

	@FXML protected void trouverInspiration(ActionEvent evenement) {
    	
    	System.out.println("trouverInspiration( )");
    	
		PenseeDAO penseeDAO = new PenseeDAO();
		List<Pensee> listePensees = penseeDAO.listerPensees();

		for(Iterator<Pensee> visiteur = listePensees.iterator(); visiteur.hasNext(); )
		{
			Pensee pensee = visiteur.next();		
			Journal.ecrire(5, pensee.getMessage() + "(" + pensee.getAuteur() + ")");
		}
    	
    	// Singleton obligatoire car le framework de JavaFX cache l'instance
    	//VueInspirationVisuelle.getInstance().ecrireUnMessage("allo");
    	VueInspirationVisuelle.getInstance().afficherPensee(listePensees.get(0));
    }
	
}
