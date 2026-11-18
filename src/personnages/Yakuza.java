package personnages;

public class Yakuza extends Humain {

	private String clan;
	private int reputation = 0;
	
	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom, boisson, argent);
		this.clan = clan;
	}


	protected int getReputation() {
		return reputation;
	}


	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi juste ta bourse !");
		int argent_vole = victime.seFaireExtorquer();
		int total = gagnerArgent(argent_vole);
		parler("J'ai piqué les " + argent_vole + " sous de " + victime.getNom() + ", ce qui  me fait " + total + " sous dans ma poche. Hi ! Hi !");
		reputation = reputation + 1;
	}
	
	
	protected int perdre() {
		int argent = getArgent();
		parler("J'ai perdu mon duel et mes " + getArgent() + " sous, snif... J'ai déshonoré le clan de " + clan + ".");
		perdreArgent(getArgent());
		reputation-=1;
		return argent;
		
	}
	
	
	protected void gagner(int gain) {
		int argent = getArgent();
		argent = gagnerArgent(gain);
		reputation += 1;
		parler("Ce ronin pensait vraiment pouvoir battre " + getNom() + " du clan " + clan + " ?" + " Je l'ai dépouillé de ses " + gain + " sous.");
	}

}
