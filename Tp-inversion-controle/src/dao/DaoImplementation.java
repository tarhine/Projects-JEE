package dao;

public class DaoImplementation implements IDao { // creation d'une implementation de l'interface = c classe DaoImplementation 
	//la classe qui implemente les interface est créer par un developpeur

	@Override
	public double getData() {  // la 1er chose AJOUTER ou REDEFINIR LES METHODES QUI SONT DANS L'INTERFACE IDao
		System.out.println("Version base de donnes");
		//se connecter a la bd pour lire la valeur de data 
		double data=23;
		return data;
	}
	

}
