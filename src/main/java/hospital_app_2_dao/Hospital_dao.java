package hospital_app_2_dao;

import java.util.List;

import hospital_app_2_controller.Helper;
import hospital_app_2_dto.Hospital;
import jakarta.persistence.Query;

public class Hospital_dao {

	public Hospital createHospital() {
		Hospital hospital = new Hospital();
		hospital.setName("RPK_Advanced_Care");
		hospital.setChairMan("Pradeep kumar");
		Helper.entityTransaction.begin();
		Helper.entityManager.persist(hospital);
		Helper.entityTransaction.commit();
		System.out.println("Hospital Saved Successfully");
		return hospital;
	}

	public void updateHospital() {
		System.out.println("Enter Hospital Name");
		Query query = Helper.entityManager
				.createQuery("SELECT hospital FROM Hospital hospital WHERE hospital.name='" + Helper.scanner.next() + "'");
		List<Hospital> list = query.getResultList();
		if (!(list == null)) {
			System.out.println("Enter the new chairman name ");
			String name = Helper.scanner.next();

			for (Hospital hospital : list) {
				hospital.setChairMan(name);
				Helper.entityTransaction.begin();
				Helper.entityManager.merge(hospital);
				Helper.entityTransaction.commit();
			}
		}else {System.out.println("No Hospital ID found");}
	}

	public void deleteHospital() {
		System.out.println("Enter Hospital Name");
		Query query = Helper.entityManager.createQuery("DELETE FROM Hospital hospital WHERE hospital.name=?1");
		query.setParameter(1, Helper.scanner.next());
		Helper.entityTransaction.begin();
		int count = query.executeUpdate();
		Helper.entityTransaction.commit();
		
		if (count == 1) {
			System.out.println("Deleted succesfully");
		} else {
			System.out.println("Not Able to Delete");
		}
	}

}
