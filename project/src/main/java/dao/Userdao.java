package dao;

import main.User;

public interface Userdao {
	boolean addUser(User r);
	boolean deleteUser(User r);
	User find(String email);
	User updateUser(User r);
	java.util.List<User> getAllUsers();
	

}
