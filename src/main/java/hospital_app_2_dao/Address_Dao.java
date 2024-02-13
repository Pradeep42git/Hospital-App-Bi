package hospital_app_2_dao;

import java.util.List;

import hospital_app_2_controller.Helper;
import hospital_app_2_dto.Branch;
import jakarta.persistence.Query;

public class Address_Dao {
	public void updateAddress() {
		System.out.println("Enter Branch Name you want to update");
		Query query = Helper.entityManager
				.createQuery("SELECT branch FROM Branch branch WHERE branch.name='" + Helper.scanner.next() + "'");
		List<Branch> branches = query.getResultList();
		if (!(branches == null)) {
			System.out.println("Enter your choice");
			System.out.println("Press 1 :for Conatct");
			System.out.println("Press 2 :for Area");
			int choice = Helper.scanner.nextInt();
			switch (choice) {
			case 1: {
				for (Branch branch : branches) {
					System.out.println("Enter the New Contact Number");
					branch.getAddress().setContact(Helper.scanner.nextLong());
					Helper.entityTransaction.begin();
					Helper.entityManager.merge(branch);
					Helper.entityTransaction.commit();
					System.out.println("Contact Updated Successfully");
					break;
				}
			}
			case 2: {
				for (Branch branch : branches) {
					System.out.println("Enter the New Area");
					branch.getAddress().setArea(Helper.scanner.next());
					Helper.entityTransaction.begin();
					Helper.entityManager.merge(branch);
					Helper.entityTransaction.commit();
					System.out.println("Contact Updated Successfully");
					break;
				}
			}
		}
	} else {
			System.out.println("No Branches Found");
		}
	}

}
