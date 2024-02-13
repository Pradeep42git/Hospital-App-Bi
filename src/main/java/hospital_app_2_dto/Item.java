package hospital_app_2_dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "id_seq")
	@SequenceGenerator(name="id_seq",initialValue = 100,allocationSize = 1)
	private int id;
	private String item1;
	private String item2;
	private String item3;
	private String item4;
	@ManyToMany(mappedBy = "items",cascade = CascadeType.REMOVE)
	private List<MedOrders>medOrders;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem1() {
		return item1;
	}
	public void setItem1(String item1) {
		this.item1 = item1;
	}
	public String getItem2() {
		return item2;
	}
	public void setItem2(String item2) {
		this.item2 = item2;
	}
	public String getItem3() {
		return item3;
	}
	public void setItem3(String item3) {
		this.item3 = item3;
	}
	public String getItem4() {
		return item4;
	}
	public void setItem4(String item4) {
		this.item4 = item4;
	}
	public List<MedOrders> getMedOrders() {
		return medOrders;
	}
	public void setMedOrders(List<MedOrders> medOrders) {
		this.medOrders = medOrders;
	}
	@Override
	public String toString() {
		return "\nItem [id=" + id + ", item1=" + item1 + ", item2=" + item2 + ", item3=" + item3 + ", item4=" + item4
				+ "]";
	}
	
	

}
