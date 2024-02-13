package hospital_app_2_dao;

import java.util.ArrayList;
import java.util.List;

import hospital_app_2_controller.Helper;
import hospital_app_2_dto.Encounter;
import hospital_app_2_dto.Item;
import hospital_app_2_dto.MedOrders;
import hospital_app_2_dto.Person;
import jakarta.persistence.Query;

public class MedOrders_Dao {

	public MedOrders saveMedOrders() {
		MedOrders medOrders = new MedOrders();
		System.out.println("Enter the Person Name you want to choose encounters");
		Query query = Helper.entityManager.createQuery("SELECT person FROM Person person WHERE person.name=?1");
		query.setParameter(1, Helper.scanner.next());
		Person person = (Person) query.getResultList().get(0);
		List<Encounter> encounters = person.getEncounter();
		for (Encounter encounter : encounters) {
			System.out.println(encounter);
		}
		System.out.println("Enter Encounter ID");
		int encounter_id = Helper.scanner.nextInt();
		for (Encounter encounter : encounters) {
			if (encounter.getId() == encounter_id) {
				Items_Dao item = new Items_Dao();
				List<Item> items = new ArrayList<Item>();
				items.add(item.saveItem());
				System.out.println("Enter the Medicine Bill");
				medOrders.setBill(Helper.scanner.nextDouble());
				medOrders.setEncounter(encounter);
				medOrders.setItems(items);

				Helper.entityTransaction.begin();
				Helper.entityManager.persist(medOrders);
				Helper.entityTransaction.commit();
				System.out.println("MedOrders saves Successfully");

			}
		}
		return medOrders;
	}

	public void updateMedOrders() {
		System.out.println("Enter the Person Name you want to choose encounters");
		Query query = Helper.entityManager.createQuery("SELECT person FROM Person person WHERE person.name=?1");
		query.setParameter(1, Helper.scanner.next());
		Person person = (Person) query.getResultList().get(0);
		List<Encounter> encounters = person.getEncounter();
		
//		displaying encounter to select encounter id
		for (Encounter encounter : encounters) {
			System.out.println(encounter);
		}

		System.out.println("Enter Encounter ID");
		int encounter_id = Helper.scanner.nextInt();
		for (Encounter encounter : encounters) {
			if (encounter.getId() == encounter_id) {
				List<MedOrders> medorders = encounter.getMedOrders();
				//displaying medOrders to select medorders id
				for (MedOrders medorder : medorders) {
					System.out.println(medorder);
				}
				System.out.println("Enter MedOrder ID  to update Bill");
				int id = Helper.scanner.nextInt();
				//traverse medorders to update 
				for (MedOrders medorder : medorders) {
					if (medorder.getId() == id) {
						System.out.println("Enter the new Bill");
						medorder.setBill(Helper.scanner.nextDouble());
						Helper.entityTransaction.begin();
						Helper.entityManager.merge(medorder);
						Helper.entityTransaction.commit();
						System.out.println("Updated Successfully");
						break;
					}
				}
			}
		}
	}
	
	public void deleteMedOrders() {
		System.out.println("Enter the Person Name you want to choose encounters");
		Query query = Helper.entityManager.createQuery("SELECT person FROM Person person WHERE person.name=?1");
		query.setParameter(1, Helper.scanner.next());
		Person person = (Person) query.getResultList().get(0);
		List<Encounter> encounters = person.getEncounter();
		
//		displaying encounter to select encounter id
		for (Encounter encounter : encounters) {
			System.out.println(encounter);
		}

		System.out.println("Enter Encounter ID");
		int encounter_id = Helper.scanner.nextInt();
		for (Encounter encounter : encounters) {
			if (encounter.getId() == encounter_id) {
				List<MedOrders> medorders = encounter.getMedOrders();
				//displaying medOrders to select medorders id
				for (MedOrders medorder : medorders) {
					System.out.println(medorder);
				}
				System.out.println("Enter MedOrder ID  to delete");
				int id = Helper.scanner.nextInt();
				//traverse medorders to delete
				for (MedOrders medorder : medorders) {
					if (medorder.getId() == id) {
						
						Helper.entityTransaction.begin();
						Helper.entityManager.remove(medorder);
						Helper.entityTransaction.commit();
						System.out.println("Deleted Successfully");
						break;
					}
				}
			}
		}
	}

		
	

}
