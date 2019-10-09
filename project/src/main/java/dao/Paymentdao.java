package dao;

import main.Payment;

public interface Paymentdao {
	public boolean addPayment(Payment y);
	public Payment find(int id);
	public Payment updatePayment(Payment y);
	public boolean deletePayment(Payment y);
	public java.util.List<Payment>getAllPayments(String cartid);
	


}
