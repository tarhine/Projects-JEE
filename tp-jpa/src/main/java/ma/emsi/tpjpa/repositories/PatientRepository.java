package ma.emsi.tpjpa.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import ma.emsi.tpjpa.entities.Patient;


public interface PatientRepository extends JpaRepository<Patient, Long> {
	public List<Patient> findByNomContains(String name); //declarer une methode pour recuperer les Patient par son nom ou bien par un lettre
	public List<Patient> findByMalade(boolean b); //une methode pour recuperer tous les Patients qui sont malade ou nn 
	public List<Patient> findByNomContainsAndMalade(String name, boolean b );//"recherche a 2 criteres"une methode qui cherche par nom et par  maladie 
	
}
