package ma.emsi.tpjpa;
import java.util.Date;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ma.emsi.tpjpa.entities.Patient;
import ma.emsi.tpjpa.repositories.PatientRepository;

@SpringBootApplication
public class TpJpaApplication implements CommandLineRunner{
    @Autowired
	private PatientRepository patientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {    //ajout des Patient
		patientRepository.save(new Patient(null,"REDA",new Date(), 2300,false));
		patientRepository.save(new Patient(null,"TARHINE",new Date(), 5300,false));
		patientRepository.save(new Patient(null,"DRISS",new Date(), 8300,false));
		patientRepository.save(new Patient(null,"ILYAS",new Date(), 9300,true));
		patientRepository.save(new Patient(null,"ysf",new Date(), 62545,true));
		System.out.println("************Affiche da la liste des Patient**************");
		patientRepository.findAll().forEach(p->{     //afficher tous les patients
			System.out.println(p.toString());
		});
		System.out.println("**************************");
		Patient patient=patientRepository.findById(4L).get();        //chercher un patient dans le id=4
		System.out.println(patient.getNom()); //afficher juste son 'nom' 
		System.out.println(patient.getScore()); //et son score
		System.out.println("**************************");
		List<Patient> patients=patientRepository.findByNomContains("T");  //afficher juste les patient qui ont un 'T' dans son nom
		patients.forEach(p->{
			System.out.println(p.toString());
		});
		
		System.out.println("**************************");
		List<Patient> patients2=patientRepository.findByMalade(true);  //afficher juste les patient qui sont malade
		patients2.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("**************************");
		List<Patient> patients3=patientRepository.findByNomContainsAndMalade("S", false);  //afficher  les patient qui ont un 'S' dans son nom  qui ne sont pas  malade
		patients3.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("***********Suppression d'un Patient par son id ***************");
		patientRepository.deleteById(5L);//supprimer le patient de id=5

		System.out.println("*********** retourner les Patient apres la suppression ***************");
		patientRepository.findAll().forEach(p->{     //afficher tous les patients apres la suppression
			System.out.println(p.toString());
		});
		
		System.out.println("**************PAGINATION = retourner tous les patients mais que 3 patient  que je veux mais des la 1er page************");
		Page<Patient> pagePatient=patientRepository.findAll(PageRequest.of(0, 3));  //retourner tous les patients mais je veux que 3 des la 1er page , alors que la 2eme page il contient les 3 patients suivant
		pagePatient.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("************connaitre nombre des pages************************************");
		System.out.println("nombre des page"+pagePatient.getTotalPages());
		
 
		
	}

}
