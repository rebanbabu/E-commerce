package main;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;
@Entity
@Table(name="CategoryDetails")

public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Min(value=6)
	private  int categoryid;
	@NotBlank(message="FIELDS REQUIRED")
	private String categoryName;
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
