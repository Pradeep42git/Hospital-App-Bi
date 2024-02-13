package hospital_app_2_dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "id_seq")
	@SequenceGenerator(name="id_seq", allocationSize = 1,initialValue = 100)
	private int id;
	private String name;
	private String chairMan;
	@OneToMany(mappedBy = "hospital")
	private List<Branch>branch;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChairMan() {
		return chairMan;
	}
	public void setChairMan(String chairMan) {
		this.chairMan = chairMan;
	}
	public List<Branch> getBranch() {
		return branch;
	}
	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}
	
	

}
