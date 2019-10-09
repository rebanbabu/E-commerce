package dao;

import java.util.List;

import main.Supplier;

public interface Supplierdao {
	public boolean addSupplier(Supplier w);
	public Supplier find(int id);
	public Supplier updateSupplier(Supplier w);
	public boolean deleteSupplier(Supplier w);
	public java.util.List<Supplier>getAllSuppliers();
	

}
