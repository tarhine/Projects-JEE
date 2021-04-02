package metier;

import dao.IDao;

public class MetierImplementation implements IMetier {

	private IDao dao; //1. couplage faible

	@Override
	public double calcul() { // la 1er chose AJOUTER ou REDEFINIR LES METHODES QUI SONT DANS L'INTERFACE
								// IMetier
		double data = dao.getData();// la valeur de dao=null c par defaut 
		double resultat = data * 44;
		return resultat;
	}

	/**
	 * pour injecter dans la variable dao un objet 
	 * pour faire l'injection des dependances
	 * d'une classe qui implemente IDao
	 */
	public void setDao(IDao dao) { //2. pour faire l'injection des dependances //setter qui me permetre d'injecter une valeur au variable 'dao'
		this.dao = dao;
	}

}
