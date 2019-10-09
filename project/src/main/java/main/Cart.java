package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="CartDetails")
public class Cart {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)

private int id;


private String email;

private int productid;

private float price;

private String cartid;

public int getid() {
	return id;
}
public void setid(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getCartid() {
	return cartid;
}
public void setCartid(String cartid) {
	this.cartid = cartid;
}
}









