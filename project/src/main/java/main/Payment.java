package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="PaymentDetails")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Min(value=6)
	private int id;
	@NotBlank(message="PAYMENT METHOD REQUIRED")
	private String paymentmethod;
	@NotBlank(message="CART ID REQUIRED")
	private String cartid;
	@NotBlank(message="SHIPPINGADDRESS REQUIRED")
	@Column(name="shippingaddress")
	private String shippingaddress;
	

	public String getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	public void setId(int id) {
		this.id = id;
	}
public int getId()
{
	return id;
}
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
}
