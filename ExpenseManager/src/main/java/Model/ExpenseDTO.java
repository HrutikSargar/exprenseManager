package Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ExpenseDTO implements Comparable<ExpenseDTO>{
	private int id;
	private double income;
	private double expense;
	private String category;
	private String paymentMethod;
	private String note;
	private String date; 
	private String time;
	private double totalIncome;
	private double totlaexpense;
	private double balance;
	
	private String startPoint;
	private String endpoint;
//	@Override
//	public int compareTo(Employee e1) {
//		if(empSalary==e1.getEmpSalary()) {
//			return 0;
//		}else if(empSalary>e1.getEmpSalary()) {
//			return 1;
//		}else
//			return -1;
//	}
	
	public int compareTo(ExpenseDTO e) {
		if (income==e.getIncome()) {
				return 0;
		}else if (income>e.getIncome()) {
				return 1;
		}else {
				return -1;
			}
		}
	
	
	
    public String getStartPoint() {
		return startPoint;
	}


	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}


	public String getEndpoint() {
		return endpoint;
	}


	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
    
    public ExpenseDTO() {
    	
    }
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getExpense() {
		return expense;
	}
	public void setExpense(double expense) {
		this.expense = expense;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}
	public double getTotlaexpense() {
		return totlaexpense;
	}
	public void setTotlaexpense(double totlaexpense) {
		this.totlaexpense = totlaexpense;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
