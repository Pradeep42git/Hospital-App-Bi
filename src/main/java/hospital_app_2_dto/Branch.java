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
import jakarta.persistence.OneToOne;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String specialty;
	private String branch_head;
	@ManyToOne
	@JoinColumn(name="hospital_id")
	private Hospital hospital;
	@OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	@JoinColumn(name="address_id")
	private Address address;
	@OneToMany(mappedBy = "branch",cascade = CascadeType.REMOVE)
	private List<Encounter> encounter;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getBranch_head() {
		return branch_head;
	}
	public void setBranch_head(String branch_head) {
		this.branch_head = branch_head;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Encounter> getEncounter() {
		return encounter;
	}
	public void setEncounter(List<Encounter> encounter) {
		this.encounter = encounter;
	}
	

}
