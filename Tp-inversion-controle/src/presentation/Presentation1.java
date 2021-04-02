package presentation;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;
import dao.IDao;
import metier.IMetier;


public class Presentation1 {

	public static void main(String[] args) throws Exception {
		System.out.println("---------------------------injection des dependances par instanciation statique--------------------------------------------------");
		/*
		 * 
		 * 1er etape : injection des dependances par instanciation statique => c a d on a utilise le ' new ' 
		 * 	crer un objer DaoImplementation , 2 apres objet MetierImplement , 3 apres on fait le Set 
		 *  on fait l'injection des dependances pour les associser
		 * */
//	DaoImplementation dao=new DaoImplementation();
//	MetierImplementation metier = new MetierImplementation();
//	metier.setDao(dao); => l'injection des dependances , c a d invoquer la methode setDao de l'objet metier , et je transmet comme parametre c dao 
//	System.out.println(metier.calcul());
	
	System.out.println("---------------------------injection des dependances par instanciation dynamique--------------------------------------------------");
	
	//si on veut pas utiliser le new ==>  1er etape :creer fichier de configuration nomme config.txt
	/*
	 * 1/ charger les classe en memoire 'Classe.forName' => declarer un objet de type Class
	 * 2/ creer une instance d'une classe par = 'newInstance' ==> il retourne un objet de type Object mais on connait que l'interface c IDao
	  */

		Scanner scanner = new Scanner(new File("config.txt"));
		
		String daoClassName=scanner.nextLine(); //je lie le 1er ligne du fichier config.txt
		Class cDao=Class.forName(daoClassName);	// je charge la class en memoire 
		IDao dao =(IDao) cDao.newInstance(); //je cree un objet de la classe mais je conais que l'interface Idao
		
		String metierClassName=scanner.nextLine(); //je lie le 2eme ligne du fichier config.txt
		Class cMetier=Class.forName(metierClassName); // je charge la class en memoire 
		IMetier metier=(IMetier) cMetier.newInstance(); //je cree un objet de la classe mais je conais que l'interface IMetier
		
		Method m=cMetier.getMethod("setDao", IDao.class);
		m.invoke(metier, dao);   //invoquer la methode 'm' sur objet 'metier' et je lui donne comme parametre 'dao' 
		
		System.out.println(dao.getData());
		//System.out.println(metier.calcul());
	

	}

}
