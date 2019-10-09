package dao;

import java.util.List;

import main.Cart;

public interface Cartdao {
	boolean addCart(Cart t);
	boolean deletecart(Cart t);
	Cart find(int id);
	Cart updateCart(Cart t);
	//java.util.List<Cart> getAllCarts(String t);
	public int totalelements(String cartid);
	List<Cart> getAllCarts(String cartid);
	//Cart finditem(String cart);
	
	
}
