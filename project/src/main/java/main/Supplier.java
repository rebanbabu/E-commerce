package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name="SupplierDetails")
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Min(value=6)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@NotBlank(message="FIELDS REQUIRED")
	private String supplierName;
	@NotBlank(message="FIELDS REQUIRED")
	private String supplieraddress;
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplieraddress() {
		return supplieraddress;
	}
	public void setSupplieraddress(String supplieraddress) {
		this.supplieraddress = supplieraddress;
	}
	
	

}
