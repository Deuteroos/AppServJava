package Document;

import Abonne.Abonne;

public class Livre implements Document{
	
	private int num;
	private String titre;
	private Abonne emprunteur;
	private Abonne reserveur;
	
	public Livre (int num, String s) {
		this.num = num;
		this.titre = s;
		emprunteur = null;
		reserveur = null;
	}	

	@Override
	public int numero() {
		// TODO Auto-generated method stub
		return num;
	}

	@Override
	public void reserver(Abonne ab) throws PasLibreException {
		// TODO Auto-generated method stub
		if(!estLibre()) 
			 throw new PasLibreException();
		reserveur = ab;
	}

	@Override
	public void emprunter(Abonne ab) throws PasLibreException {
		// TODO Auto-generated method stub		
		if(!estLibre()) {
			if(emprunteur!= null)
				throw new PasLibreException();
			else 
				if(!ab.equals(reserveur)) 
					throw new PasLibreException();			
		}
		emprunteur = ab;
		reserveur = null;
	}
	
	public boolean estLibre() {
		return (reserveur==null) && (emprunteur == null);
	}

	@Override
	public void retour() {
		// TODO Auto-generated method stub
		emprunteur = null;
		reserveur = null;
	}
	
	public String toString() {
		return titre;		
	}

}
