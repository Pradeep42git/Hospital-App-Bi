package hospital_app_2_dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "id_seq")
	@SequenceGenerator(name="id_seq",initialValue = 100,allocationSize = 1)
	private int id;
	private String bloodPressure;
	private int weight;
	private String complaint;
	@ManyToOne
	@JoinColumn(name="branch_id")
	private Branch branch;
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="person_id")
	private Person person;
	@OneToMany(mappedBy = "encounter",cascade = CascadeType.REMOVE)
	private List<MedOrders>medOrders;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getComplaint() {
		return complaint;
	}
	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<MedOrders> getMedOrders() {
		return medOrders;
	}
	public void setMedOrders(List<MedOrders> medOrders) {
		this.medOrders = medOrders;
	}
	@Override
	public String toString() {
		return "\nEncounter [id=" + id + ", bloodPressure=" + bloodPressure + ", weight=" + weight + ", complaint="
				+ complaint + "]";
	}
	
	

}
