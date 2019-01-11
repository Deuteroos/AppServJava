package Document;

import java.util.ArrayList;
import java.util.Collection;

public final class Bibliotheque {
	private Collection<Document> Doc;
	
	private static Bibliotheque _instance = new Bibliotheque();
	
	private Bibliotheque(){
		Doc= new ArrayList<Document>();
	}
	
	public static synchronized Bibliotheque getInstance() {
		return _instance;
	}
	
	public Document getDocByNum(int i) {
		for(Document d : Doc) {
			if(d.numero() == i) {
				return d;
			}
		}
		throw new IllegalArgumentException();
	}
	
	public void ajoutDoc(Document d) {
		Doc.add(d);
	}
}
