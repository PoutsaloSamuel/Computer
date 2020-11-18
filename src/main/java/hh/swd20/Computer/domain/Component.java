package hh.swd20.Computer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Component {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ComponentId;

	private String model;
	private String brand;
	private int year;
	private String storelink;
	private int price;

	@ManyToOne
	@JsonIgnoreProperties("components")
	@JoinColumn(name = "categoryid")
	private Category category;

	public Component() {

	}

	public Component(String model, String brand, int year, String storelink, int price, Category category) {
		super();
		this.model = model;
		this.brand = brand;
		this.year = year;
		this.storelink = storelink;
		this.price = price;
		this.category = category;
	}

	public Long getComponentId() {
		return ComponentId;
	}

	public void setComponentId(Long ComponentId) {
		this.ComponentId = ComponentId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getStorelink() {
		return storelink;
	}

	public void setStorelink(String storelink) {
		this.storelink = storelink;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Component [id=" + ComponentId + ", model=" + model + ", brand=" + brand + ", year=" + year
					+ ", storelink=" + storelink + ", price=" + price + ", category=" + this.getCategory() + "]";
		else
			return "Book [id=" + ComponentId + ", model=" + model + ", brand=" + brand + ", year=" + year
					+ ", storelink=" + storelink + ", price=" + price + "]";
	}

}
