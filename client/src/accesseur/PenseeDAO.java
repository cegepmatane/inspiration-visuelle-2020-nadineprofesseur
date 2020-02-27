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
		if(null == xml) return null;
		
		//return decodeur.decoderListe(xml);
		return null;
	}
	
	public void ajouterPensee(Pensee pensee)
	{
		Journal.ecrire(1, "ajouterPensee()");			
		String xml = "";
		//decodeur.decoderReponseAction(xml);
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
