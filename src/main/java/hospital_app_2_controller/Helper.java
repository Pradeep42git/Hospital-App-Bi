package hospital_app_2_controller;
import java.util.List;
import java.util.Scanner;

import hospital_app_2_dao.Address_Dao;
import hospital_app_2_dao.Branch_Dao;
import hospital_app_2_dao.Encounter_Dao;
import hospital_app_2_dao.Hospital_dao;
import hospital_app_2_dao.Items_Dao;
import hospital_app_2_dao.MedOrders_Dao;
import hospital_app_2_dao.Person_Dao;
import hospital_app_2_dto.Hospital;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Helper {
	public static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	public static EntityManager entityManager=entityManagerFactory.createEntityManager();
	public static EntityTransaction entityTransaction=entityManager.getTransaction();
	public static Scanner scanner= new Scanner(System.in);
	public static Hospital_dao hospital= new Hospital_dao();
	public static Branch_Dao branch= new Branch_Dao();
	public static Encounter_Dao encounter= new Encounter_Dao();
	public static Address_Dao address= new Address_Dao();
	public static MedOrders_Dao medorders= new MedOrders_Dao();
	public static Items_Dao item= new Items_Dao();
	public static Person_Dao person= new Person_Dao();
	
	
	public static int choice() {
		System.out.println("Press 1 : Hospital");
		System.out.println("Press 2 : Branch");
		System.out.println("Press 3 : Person");
		System.out.println("Press 4 : Encounter");
		System.out.println("Press 5 : MedOrders ");
		System.out.println("Press 6 : Items");
		System.out.println("Press 7 : Exit");
		int choice=Helper.scanner.nextInt();
		return choice;
	}
	
	public static void createHospital() {
		Query query = Helper.entityManager.createQuery("SELECT hospital FROM Hospital hospital WHERE hospital.name=?1");
		query.setParameter(1, "RPK_Advanced_Care");
		List<Hospital> hospital =query.getResultList();
		if(hospital==null) {
			Hospital_dao create= new Hospital_dao();
			create.createHospital();
		}
	}
	public static int hospitalchoice(){
		System.out.println("Press 1 : Update Hospital");
		System.out.println("Press 2 : Exit");
		int choice= scanner.nextInt();
		return choice;
		
	}
	public static int branchChoice() {
		System.out.println("Press 1 : Add Branch");
		System.out.println("Press 2 : Update Branch");
		System.out.println("Press 3 : Delete Branch");
		System.out.println("Press 4 : Exit");
		int choice= scanner.nextInt();
		return choice;
	}
	public static int personChoice() {
		System.out.println("Press 1 : Add Person");
		System.out.println("Press 2 : Update Person");
		System.out.println("Press 3 : Delete Person");
		System.out.println("Press 4 : Exit");
		int choice= scanner.nextInt();
		return choice;
	}
	public static int encounterChoice() {
		System.out.println("Press 1 : Add Encounter");
		System.out.println("Press 2 : Update Encounter");
		System.out.println("Press 3 : Delete Encounter");
		System.out.println("Press 4 : Exit");
		int choice= scanner.nextInt();
		return choice;
		
	}
	public static int MedOrdersChoice() {
		System.out.println("Press 1 : Add MedOrders");
		System.out.println("Press 2 : Update MedOrders");
		System.out.println("Press 3 : Delete MedOrders");
		System.out.println("Press 4 : Exit");
		int choice= scanner.nextInt();
		return choice;	
	}
	public static int itemChoice() {
		System.out.println("Press 1 : Delete Item");
		System.out.println("Press 2 : Exit ");
		int choice= scanner.nextInt();
		return choice;	
	}
	public static void defaultChoice() {
		System.out.println("Invalid Input Try Aagin");
	}
}
