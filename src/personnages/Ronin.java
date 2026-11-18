package personnages;

public class Ronin extends Humain {
	
	private int honneur = 1;

	public Ronin(String nom, String boisson, int argent) {
		super(nom, boisson, argent);
	}
	
	
	public void donner(Commercant beneficiaire) {
		int don = getArgent()/10;
		parler(beneficiaire.getNom() + " prends ces " + don + " sous.");
		perdreArgent(don);
		beneficiaire.recevoir(don);
	}
	
	
	public void provoquer(Yakuza adversaire) {
		int force = 2*honneur;
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
			parler("Je t'ai eu petit yakusa!");
			gagnerArgent(adversaire.perdre());
			honneur+=1;
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont vraiment pris un coup.");
			adversaire.gagner(getArgent());
			perdreArgent(getArgent());
			honneur-=1;
		}
	}

}
