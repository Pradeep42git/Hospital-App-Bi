package hospital_app_2_dao;

import java.util.ArrayList;
import java.util.List;

import hospital_app_2_controller.Helper;
import hospital_app_2_dto.Encounter;
import hospital_app_2_dto.Person;
import jakarta.persistence.Query;

public class Person_Dao {
	public Person savePerson() {
		Person person = new Person();
		System.out.println("Enter the Name");
		person.setName(Helper.scanner.next());
		System.out.println("Enter the Blood Group");
		person.setBloodGroup(Helper.scanner.next());
		System.out.println("Enter the sex");
		person.setSex(Helper.scanner.next());
		System.out.println("Enter the Location");
		person.setLocation(Helper.scanner.next());
		List<Encounter>encounter= new ArrayList(); 
		person.setEncounter(encounter);

		Helper.entityTransaction.begin();
		Helper.entityManager.persist(person);
		Helper.entityTransaction.commit();
		System.out.println("Person details Created Sucessfully");
		return person;
	}

	public void updatePerson() {
		System.out.println("Enter Person Name you want to update");
		Query query = Helper.entityManager
				.createQuery("SELECT person FROM Person person WHERE person.name='" + Helper.scanner.next() + "'");
		List<Person> persons = query.getResultList();
		if (!(persons == null)) {
			System.out.println("Enter your choice");
			System.out.println("Press 1 :for Name");
			System.out.println("Press 2 :for Location");
			int choice = Helper.scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the new Name");
				for (Person person : persons) {
					person.setName(Helper.scanner.next());
					Helper.entityTransaction.begin();
					Helper.entityManager.merge(person);
					Helper.entityTransaction.commit();
					System.out.println("Updated Successfully");
					
				}
				break;
			}
			case 2: {
				System.out.println("Enter the new Location");
				for (Person person : persons) {
					person.setLocation(Helper.scanner.next());
					Helper.entityTransaction.begin();
					Helper.entityManager.merge(person);
					Helper.entityTransaction.commit();
					System.out.println("Updated Successfully");
					
				}
				break;
			}
		}
	} else {
			System.out.println("No Person ID found");
		}
	}
	
	public void deletePerson() {
		System.out.println("Enter Person Name");
		Query query = Helper.entityManager.createQuery("SELECT person FROM Person person WHERE person.name=?1");
		query.setParameter(1, Helper.scanner.next());
		Person person=(Person)query.getResultList().get(0);
		List<Encounter>list=person.getEncounter();
		for (Encounter encounter : list) {
			encounter.setPerson(null);
			encounter.setBranch(null);
		}
		Helper.entityTransaction.begin();
		Helper.entityManager.remove(person);
		Helper.entityTransaction.commit();
		
	}
	

}
