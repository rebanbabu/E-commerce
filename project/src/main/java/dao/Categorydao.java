package dao;

import main.Category;

public interface Categorydao {
	public boolean addCategory(Category q);
	public Category find(int id);
	public Category updateCategory(Category q);
	public boolean deleteCategory(Category q);
	public java.util.List<Category>getAllCategorys(); 



}
