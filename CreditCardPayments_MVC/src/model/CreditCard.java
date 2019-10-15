/**
 * 
 */
package model;

import java.text.NumberFormat;

/**
 * @author Ty Burns
 *
 */
public class CreditCard {

	private String fName;
	private String lName;
	private int accountNumber;
	private double currentBalance;
	private double balance;
	private double payment;
	private double payoffRate;
	private double interest;
	private int month = 1;
	/**
	 * 
	 */
	public CreditCard() {
		this.fName = "";
		this.lName = "";
		this.accountNumber = 1;
		this.currentBalance = 10;
		this.payoffRate = 10;
	}
	/**
	 * @param fName
	 * @param lName
	 * @param accountNumber
	 * @param currentBalance
	 * @param balance
	 * @param payoffRate
	 * @param interest
	 * @param month
	 */
	public CreditCard(String fName, String lName, int accountNumber, double currentBalance, double payoffRate) {
		this.fName = fName;
		this.lName = lName;
		this.accountNumber = accountNumber;
		this.currentBalance = currentBalance;
		this.payoffRate = payoffRate;
		
	}
	/**
	 * @return the fName
	 */
	public String getfName() {
		return fName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	/**
	 * @return the lName
	 */
	public String getlName() {
		return lName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the currentBalance
	 */
	public double getCurrentBalance() {
		return currentBalance;
	}
	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the payoffRate
	 */
	public double getPayoffRate() {
		return payoffRate;
	}
	/**
	 * @param payoffRate the payoffRate to set
	 */
	public void setPayoffRate(double payoffRate) {
		this.payoffRate = payoffRate;
	}
	/**
	 * @return the interest
	 */
	public double getInterest() {
		return interest;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(double interest) {
		this.interest = interest;
	}
	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	
	public String calculate() {
		String intro = "<p>Customer: " + fName + " " + lName +"</p>";
		intro += "<p>Account #: " + accountNumber + "</p>";
		intro += "<p>Balance: " + currentBalance + "</p><br>";
		
		String html = "";
		html += intro;
		
		
		String table = "<table border=1>";
		
		NumberFormat f = NumberFormat.getNumberInstance();
		f.setMaximumFractionDigits(2);
		
		table += "<tr><td>Month</td><td>Interest</td><td>Payment</td><td>Balance</td></tr>";
		
		int month = 1;
		payoffRate = payoffRate / 100;
		double balance = currentBalance;
		double firstPayment = (balance * payoffRate);
		double payment = 0;
		while(balance > 0) {
			table += "<tr>";
			table +="<td>" + month + "</td>";
			interest = .015 * balance;
			balance = interest + balance;
			if(balance < firstPayment) {
				payment = balance;
			}
			else {
				payment = (payoffRate * balance);
			}
			table += "<td>$" + f.format(interest) + "</td>";
			table += "<td>$" + f.format(payment) + "</td>";
			balance = balance - payment;
			table += "<td>$" + f.format(balance) + "</td>";
			table += "</tr>";
			month++;
		}
		
		table+= "</table>";
		html += table;
		
		return html;
		
	}
}
