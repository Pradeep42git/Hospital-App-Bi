package hospital_app_2_controller;



public class Controller {
	static {
		Helper.createHospital();
	}	
	public static void main(String[] args) {
		while(true) {
		switch(Helper.choice()) {
			case 1:{
				boolean loop=true;
				while(loop) {
					switch(Helper.hospitalchoice()) {
					case 1 : Helper.hospital.updateHospital();break;
					case 2 : loop=false;break; 		
					default: Helper.defaultChoice();
					}
				
				}
				break;
			}
			
			case 2:{
				boolean loop=true;
				while(loop){
					switch(Helper.branchChoice()) {
					case 1 :Helper.branch.saveBranch();break;
					case 2 :Helper.branch.updateBranch();break;
					case 3 :Helper.branch.deleteBranch();break;
					case 4 :loop=false;break;
					default: Helper.defaultChoice();
					}
				}
				break;
			}
			case 3:{
				boolean loop=true;
				while(loop) {
					switch(Helper.personChoice()) {
					case 1 :Helper.person.savePerson();break;
					case 2 :Helper.person.updatePerson();break;
					case 3 :Helper.person.deletePerson();break;
					case 4 :loop=false;break;
					default: Helper.defaultChoice();
					}
				}
				break;
			}
			case 4:{
				boolean loop=true;
				while(loop) {
					switch(Helper.encounterChoice()) {
					case 1:Helper.encounter.createEncounter();break;
					case 2:Helper.encounter.updateEncounter();break;
					case 3:Helper.encounter.deleteEncounter();break;
					case 4:loop=false;break;
					default: Helper.defaultChoice();
					
					}
				}	
				break;
			}
			case 5:{
				boolean loop=true;
				while(loop) {
					switch(Helper.MedOrdersChoice()) {
					case 1:Helper.medorders.saveMedOrders();break;
					case 2:Helper.medorders.updateMedOrders();;break;
					case 3:Helper.medorders.deleteMedOrders();;break;
					case 4:loop=false;break;
					default: Helper.defaultChoice();
					}
					
				}
				break;
			}
			case 6:{
				boolean loop=true;
				while(loop) {
					switch(Helper.itemChoice()) {
					case 1:Helper.item.deleteItem();break;
					case 2:loop=false;break;
					default: Helper.defaultChoice();
					}
				}
				break;
			}
			case 7:return;
			default: Helper.defaultChoice();
		
			}
		}
		
	}

}
