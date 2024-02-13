package hospital_app_2_dto;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class MedOrders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_seq")
	@SequenceGenerator(name = "id_seq", initialValue = 100, allocationSize = 1)
	private int id;
	private double bill;
	@CreationTimestamp
	LocalDateTime localDateTime;
	@ManyToOne
	@JoinColumn(name = "encounter_id")
	private Encounter encounter;
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(joinColumns = @JoinColumn(name = "medOrder_id"), 
	inverseJoinColumns = @JoinColumn(name = "item_id"))
	private List<Item> items;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	public Encounter getEncounter() {
		return encounter;
	}
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "\nMedOrders [id=" + id + ", bill=" + bill + ", localDateTime=" + localDateTime + ", items=" + items + "]";
	}
	
	

}
