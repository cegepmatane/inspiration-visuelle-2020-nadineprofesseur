package accesseur;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import modele.DecodeurPenseesXML;
import modele.Pensee;
import outils.Journal;
import outils.JournalDesactivable;

public class PenseeDAO implements PenseeURL{

	protected DecodeurPenseesXML decodeur = new DecodeurPenseesXML();	
	
	public List<Pensee> listerPensees()
	{
		JournalDesactivable.ecrire("listerPensees()");			
		String xml = null;		
		
		try {
			URL urlListePensees = new URL(URL_LISTE_PENSEES);
			String derniereBalise = "</pensees>";
			InputStream flux = urlListePensees.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter(derniereBalise); 
			xml = lecteur.next() + derniereBalise;
			lecteur.close();
			Journal.ecrire(2, "xml : " + xml);			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(null == xml) return null;
		
		return decodeur.decoderListe(xml);
	}
	
}

/*
 * 
 
Code de r�ponse 200
ajouterPensee()
stdClass Object
(
    [auteur] => Rossetti
    [message] => Ce qui est plus triste qu�une �uvre inachev�e, c�est une �uvre jamais commenc�e.
    [annee] => 0
)
<?xml version="1.0" encoding="UTF-8"?><action>
	<type>ajouter</type>
	<moment>1523972018</moment>
	<succes>1</succes>
	<message>POST : Array
(
    [auteur] => Rossetti
    [message] => Ce qui est plus triste qu�une �uvre inachev�e, c�est une �uvre jamais commenc�e.
    [annee] => 0
)
</message>
</action>
 
 *
 */
