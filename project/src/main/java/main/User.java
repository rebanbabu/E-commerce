package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="UserDetails")
public class User {
	@Id
	@NotBlank(message="MAIL ID REQUIRED")
	@Email(message="Enter valid email id")
	private String email;
	@NotBlank(message="USERNAME REQUIRED")
	private String userName;
	@NotBlank(message="PASSWORD REQUIRED")
	@Min(value=8)
	private String password;
	@Min(value=8,message="CONFIRMPASSWORD REQUIRED")
	private String confirmpassword;
	@NotBlank(message="USER_ROLE REQUIRED")
	private String user_role;
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
}
