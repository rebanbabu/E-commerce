package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="ProductDetails")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  int productid;
	@NotBlank(message="fields required")
	private String productName;
	@Min(value=60000)
	private float price;
	
	
	
	@Min(value=6)
	private int quantity;
	@NotBlank(message="FIELDS REQUIRED")
	private String description;
	@Min(value=6)
	private int categoryid;
	@Min(value=6)
	private int supplierid;
	
	@Transient
	private MultipartFile image;
	
	public MultipartFile getImage()  {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
		
		
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
	
	
 
