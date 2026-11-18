package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, String boisson, int argent) {
		super(nom, "thé", argent);
	}

	
	public int seFaireExtorquer() {
		super.parler("J'ai tout perdu! Le monde est trop injuste...");
		int perte = getArgent();
		perdreArgent(getArgent());
		return perte;
	}
	
	public void recevoir(int argent) {
		parler(argent + " sous ! Je te remercie généreux donateur!");
		gagnerArgent(argent);
	}
}
