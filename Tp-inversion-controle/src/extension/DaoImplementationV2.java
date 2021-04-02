package extension;

import dao.IDao;
//classe qui implement l'interface  
public class DaoImplementationV2 implements IDao{ //nouvelle version on me demande d'utiliser un web service 

	@Override
	public double getData() {
		// Version web service 
		System.out.println("version web service ");
		double data=12;
		return data;
	} 
	//alors derniere etape c de changer dans le fichier 'config.txt' 
	
	// ===> Voila une application  fermer a la modif et ouverte a l'extension 

}
