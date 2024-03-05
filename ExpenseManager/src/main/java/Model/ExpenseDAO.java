package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExpenseDAO {

	private static Connection connection=CreateConnection.createConnection();
	
	private static String addIncome="insert into expense values(?,?,?,?,?,?,?,?,?,?,?)";
	
	private static String total="SELECT total_income,balance,total_expense FROM expense ORDER BY id DESC LIMIT 1";
	
	private static String addExpense="insert into expense values(?,?,?,?,?,?,?,?,?,?,?)";
	
	private static String displayData="SELECT total_income, total_expense, balance FROM expense WHERE payment_date BETWEEN ? AND ? ORDER BY id DESC LIMIT 1";
	
	 private static  String showAllTransactions="select * from expense";
	
	//this variables will hold latest total_income and balance
	private static double totalIncomeLatest=0,balance=0,totalExpense=0;
	
	static ArrayList<ExpenseDTO> data=null;
	
	private void fetchTotalIncomeAndBalance() {
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(total);
			ResultSet rs=preparedStatement.executeQuery();
			
			if(rs.next()) {
				totalIncomeLatest=rs.getDouble(1);
				balance=rs.getDouble(2);
				totalExpense=rs.getDouble(3);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addIncome(ExpenseDTO dto) {
		fetchTotalIncomeAndBalance();
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(addIncome);
			pstmt.setInt(1,dto.getId());
			pstmt.setDouble(2, dto.getIncome());
			pstmt.setDouble(3, dto.getExpense());
			pstmt.setString(4, dto.getCategory());
			pstmt.setString(5,dto.getPaymentMethod());
			pstmt.setString(6, dto.getNote());
			pstmt.setString(7,dto.getDate());
			pstmt.setString(8, dto.getTime());
			
				pstmt.setDouble(9, totalIncomeLatest+dto.getIncome());
			
			pstmt.setDouble(10, dto.getExpense());
			pstmt.setDouble(11, dto.getIncome()+balance);
			
			int count=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addExpense(ExpenseDTO e1) {
		fetchTotalIncomeAndBalance();
		PreparedStatement pstmt;
		try {
			pstmt=connection.prepareStatement(addExpense);
			pstmt.setInt(1, e1.getId());
			pstmt.setDouble(2, e1.getIncome());
			pstmt.setDouble(3, e1.getExpense());
			pstmt.setString(4, e1.getCategory());
			pstmt.setString(5, e1.getPaymentMethod());
			pstmt.setString(6, e1.getNote());
			pstmt.setString(7, e1.getDate());
			pstmt.setString(8, e1.getTime());
			pstmt.setDouble(9, e1.getIncome()+totalIncomeLatest);	
			pstmt.setDouble(10, totalExpense+e1.getExpense());
			
			pstmt.setDouble(11, totalIncomeLatest-(totalExpense+e1.getExpense()));
			
			int count=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ExpenseDTO displayData(ExpenseDTO dto) {
		ExpenseDTO temp=null;
		try {
			PreparedStatement pstmt =connection.prepareStatement(displayData);
			pstmt.setString(1, dto.getStartPoint());
			pstmt.setString(2, dto.getEndpoint());
			
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				temp=new ExpenseDTO();
				temp.setTotalIncome(rs.getDouble(1));
				temp.setTotlaexpense(rs.getDouble(2));
				temp.setBalance(rs.getDouble(3));
				
				return temp;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
		
	}

	public ArrayList<ExpenseDTO> showTransactions() {
		 data=new ArrayList<ExpenseDTO>();
		ExpenseDTO temp=null;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(showAllTransactions);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next()){
				temp=new ExpenseDTO();
				temp.setId(rs.getInt(1));
				temp.setIncome(rs.getDouble(2));
				temp.setExpense(rs.getDouble(3));
				temp.setCategory(rs.getString(4));
				temp.setPaymentMethod(rs.getString(5));
				temp.setNote(rs.getString(6));
				temp.setDate(rs.getString(7));
				temp.setTime(rs.getString(8));
				temp.setTotalIncome(rs.getDouble(9));
				temp.setTotlaexpense(rs.getDouble(10));
				temp.setBalance(rs.getDouble(11));
				
				data.add(temp);	
			}		
			return data;
			}
			
			catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}
}
