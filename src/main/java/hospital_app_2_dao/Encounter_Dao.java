package hospital_app_2_dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;

import hospital_app_2_controller.Helper;
import hospital_app_2_dto.Branch;
import hospital_app_2_dto.Encounter;
import hospital_app_2_dto.MedOrders;
import hospital_app_2_dto.Person;
import jakarta.persistence.Query;

public class Encounter_Dao {
	public Encounter createEncounter() {
		Encounter encounter=null;
		System.out.println("Enter the Branch head name To add Encounter");
		String branchName=Helper.scanner.next();
		Query query = Helper.entityManager
				.createQuery("SELECT branch FROM Branch branch WHERE branch.branch_head='" + branchName + "'");
		Branch branch = (Branch)query.getResultList().get(0);
		if (!(branch == null)) {
			System.out.println("Enter the Person Name You want to Add Encounter");
			String personName=Helper.scanner.next();
			Query query1 = Helper.entityManager
					.createQuery("SELECT person FROM Person person WHERE person.name='" + personName + "'");
			Person person =(Person) query1.getResultList().get(0);
			if (!(person == null)) {
				encounter= new Encounter();
				System.out.println("Enter your weight in KiloGrams");
				encounter.setWeight(Helper.scanner.nextInt());
				System.out.println("Enter Your Blood Pressure");
				encounter.setBloodPressure(Helper.scanner.next());
				System.out.println("Enter Your Complaint");
				encounter.setComplaint(Helper.scanner.next());
				encounter.setBranch(branch);
				encounter.setPerson(person);
				List<Encounter>encounters= new ArrayList<Encounter>(); 
				List<MedOrders> list= new ArrayList();
				encounter.setMedOrders(list);
				person.setEncounter(encounters);
				Helper.entityTransaction.begin();
				Helper.entityManager.persist(encounter);
				Helper.entityTransaction.commit();
				System.out.println("Added Succesfully");
			} else {
				System.out.println("No Person ID Found");
			}

		} else {
			System.out.println("No branch were found");
		}
	
	return encounter;
	}
	public void updateEncounter() {
		System.out.println("Enter the Person name to update Encounter");
		String name=Helper.scanner.next();
		Query query = Helper.entityManager
				.createQuery("SELECT person FROM Person person WHERE person.name='" + name + "'");
		Person person = (Person)query.getResultList().get(0);
		if(!(person==null)) {
			System.out.println("Enter your choice");
			System.out.println("Press 1 : For complaint ");
			System.out.println("Press 2 : For Blood Pressure");
			int choice= Helper.scanner.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("Enter the new complaint");
				List<Encounter>encounters=person.getEncounter();
				for (Encounter encounter : encounters) {
					encounter.setComplaint(Helper.scanner.next());
					
					Helper.entityTransaction.begin();
					Helper.entityManager.merge(encounter);
					Helper.entityTransaction.commit();
					System.out.println("Uppdated Successfully");
				}
				break;
			}
			case 2:{
				System.out.println("Enter the new Blood Pressure");
				List<Encounter>encounters=person.getEncounter();
				for (Encounter encounter : encounters) {
					encounter.setBloodPressure(Helper.scanner.next());
					
					Helper.entityTransaction.begin();
					Helper.entityManager.merge(encounter);
					Helper.entityTransaction.commit();
					System.out.println("Updated Successfully");
				}
				break;
			}
				
			}
		}
		else {System.out.println("No Person ID found");}
		
	}
	
	public void deleteEncounter() {
		System.out.println("Enter the Person name to delete Encounter");
		String name=Helper.scanner.next();
		Query query = Helper.entityManager
				.createQuery("SELECT person FROM Person person WHERE person.name='" + name + "'");
		Person person = (Person)query.getResultList().get(0);
		if (person!=null) {
			List<Encounter> encounters= person.getEncounter();
			for (Encounter encounter : encounters) {
				System.out.println(encounter);
			}
			System.out.println("Enter the ID you want to delete");
			int id=Helper.scanner.nextInt();
			for (Encounter encounter : encounters) {
				if(id==encounter.getId()) {
					Person person1=encounter.getPerson();
					person1=null;
					Branch branch=encounter.getBranch();
					branch=null;
					Helper.entityTransaction.begin();
					Helper.entityManager.remove(encounter);
					Helper.entityTransaction.commit();
					System.out.println("Deleted successfully");
					break;
				}
			}
			
		} else {
			System.out.println("No Person Found");
		}
	}
}
