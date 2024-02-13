package hospital_app_2_dao;

import java.util.ArrayList;
import java.util.List;

import hospital_app_2_controller.Helper;
import hospital_app_2_dto.Encounter;
import hospital_app_2_dto.Item;
import hospital_app_2_dto.MedOrders;
import hospital_app_2_dto.Person;
import jakarta.persistence.Query;

public class Items_Dao {
	
	public Item saveItem() {
		Item item= new Item();
		System.out.println("Enter the medicine 1 ");
		item.setItem1(Helper.scanner.next());
		System.out.println("Enter the medicine 2 ");
		item.setItem2(Helper.scanner.next());
		System.out.println("Enter the medicine 3 ");
		item.setItem3(Helper.scanner.next());
		System.out.println("Enter the medicine 4 ");
		item.setItem4(Helper.scanner.next());
		List<MedOrders> list= new ArrayList<MedOrders>();
		item.setMedOrders(list);
		
		Helper.entityTransaction.begin();
		Helper.entityManager.persist(item);
		Helper.entityTransaction.commit();
		
		System.out.println("Item Saved Successfully");
		return item;
	}
	
	public void deleteItem() {
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
				System.out.println("Enter MedOrder ID  to show items");
				int id = Helper.scanner.nextInt();
				
				for (MedOrders medorder : medorders) {
					if(medorder.getId()==id) {
						List<Item>items=medorder.getItems();
						//displaying items
						for (Item item : items) {
							System.out.println(item);
						}
						System.out.println("ENter the Item ID");
						int item_id= Helper.scanner.nextInt();
						for (Item item : items) {
							if(item.getId()==item_id) {
								List<MedOrders>medorderrs=item.getMedOrders();
								for (MedOrders medorderr : medorderrs) {
									medorderr=null;
								}
								Helper.entityTransaction.begin();
								Helper.entityManager.remove(item);
								Helper.entityTransaction.commit();
								System.out.println("items Deleted successfully");
							}
						}
					}
				}
			}
	}
	}
}
