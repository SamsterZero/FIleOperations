package in.vvm.FileOperations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pincode")
public class Pincode {

	@Id
	private int pincode;
	private String state;
	private String district;
	private String city;

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Pincode [district=" + district + ", state=" + state + ", city=" + city + ", pincode=" + pincode + "]";
	}

	public Pincode(String district, String state, String city, int pincode) {
		super();
		this.district = district;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}

	public Pincode() {
		super();
	}

}