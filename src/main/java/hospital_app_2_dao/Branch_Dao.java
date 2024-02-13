package hospital_app_2_dao;

import java.util.ArrayList;
import java.util.List;

import hospital_app_2_controller.Helper;
import hospital_app_2_dto.Address;
import hospital_app_2_dto.Branch;
import hospital_app_2_dto.Hospital;
import jakarta.persistence.Query;

public class Branch_Dao {

	public Branch saveBranch() {
		Branch branch = null;
		System.out.println("Enter Hospital Name you want to save Branch");
		String name=Helper.scanner.next() ;
		Query query = Helper.entityManager
				.createQuery("SELECT hospital FROM Hospital hospital WHERE hospital.name='" + name+ "'");
		List<Hospital> list = query.getResultList();
		if (!(list == null)) {
			branch = new Branch();
			System.out.println("Enter the Branch Head");
			branch.setBranch_head(Helper.scanner.next());
			System.out.println("Enter the Speciality");
			branch.setSpecialty(Helper.scanner.next());
			for (Hospital hospital : list) {
				if(hospital.getName().equals(name))
					branch.setHospital(hospital);
			}

			Address address = new Address();
			System.out.println("Enter Your area");
			address.setArea(Helper.scanner.next());
			System.out.println("Enter Your City");
			address.setCity(Helper.scanner.next());
			System.out.println("Enter your contact");
			address.setContact(Helper.scanner.nextLong());
			
			List<Branch>branches= new ArrayList<Branch>();
			branches.add(branch);
			branch.setAddress(address);
			address.setBranch(branch);
			
			Helper.entityTransaction.begin();
			Helper.entityManager.persist(branch);
			Helper.entityTransaction.commit();
			System.out.println("Branch And Address Saved Successfully");

		} else {
			System.out.println("No Hospital Found");
		}
		return branch;
	}

	public void updateBranch() {
		System.out.println("Enter Hospital Name you want to update Branch");
		Query query = Helper.entityManager
				.createQuery("SELECT hospital FROM Hospital hospital WHERE hospital.name='" + Helper.scanner.next() + "'");
		List<Hospital> list = query.getResultList();
		if(!(list==null)) {
			System.out.println("Enter Branch Head name to update branch details");
			Query query1 = Helper.entityManager
					.createQuery("SELECT branch FROM Branch branch WHERE branch.branch_head='" + Helper.scanner.next() + "'");
			List<Branch> branches = query1.getResultList();
			if(!(branches==null)) {
			System.out.println("Enter the choice");
			System.out.println("Press 1 : For Branch Head");
			System.out.println("Press 2 : For Speciality");
			int choice =Helper.scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("Enter the new Branch Head");
				for (Branch branch : branches) {
					branch.setBranch_head(Helper.scanner.next());
					Helper.entityTransaction.begin();
					Helper.entityManager.merge(branch);
					Helper.entityTransaction.commit();
					System.out.println("Branch Head Updated Successfully");
					break;
				}
			}
			case 2:{
				System.out.println("Enter the new Speciality");
				for (Branch branch : branches) {
					branch.setSpecialty(Helper.scanner.next());
					Helper.entityTransaction.begin();
					Helper.entityManager.merge(branch);
					Helper.entityTransaction.commit();
					System.out.println("Branch Head Updated Successfully");
				}
			}
		}
			}else {System.out.println("No Branches Found");}
	}
		else {System.out.println("No Hospital Found");}
	}
	public void deleteBranch() {
		
		System.out.println("Enter Branch head Name to delete Branch");
		Query query = Helper.entityManager.createQuery("SELECT branch FROM Branch branch WHERE branch.branch_head=?1");
		query.setParameter(1, Helper.scanner.next());
		Branch branches=(Branch)query.getResultList().get(0);
		
		Address add=branches.getAddress();
		add=null;
		
		
		Helper.entityTransaction.begin();
//		int count = query.executeUpdate();
		Helper.entityManager.remove(branches);
		Helper.entityTransaction.commit();
		System.out.println("Deleted Successfully");
	
		
	}
}
