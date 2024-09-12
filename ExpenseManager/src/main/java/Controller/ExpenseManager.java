package Controller;
//controller should only contain 
import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ExpenseDAO;
import Model.ExpenseDTO;
import Model.ServiceClass;

@WebServlet(urlPatterns = {"/expenseManager" ,"/addIncome" ,"/addExpense","/homePage","/transactionShow" ,"/compare" })
public class ExpenseManager extends HttpServlet {
	 private static ExpenseDAO expenseDAO=new ExpenseDAO();
		static ArrayList<ExpenseDTO> data=null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getServletPath();
		String exp=req.getParameter("expenseManager");
		
	
		String compareValueString=req.getParameter("compare");
			switch(path) {
			case "/transactionShow":
				showTransaction(req,resp);
				displayData(req, resp);
				break;
			case "/addIncome":
				displayData(req, resp);
				addIncome(req, resp);
				
//				PrintWriter pw =resp.getWriter();
//				RequestDispatcher rd=req.getRequestDispatcher("AddIncome.jsp");
//				pw.print("<div align=center>data inserted successfully</div>");
//				rd.include(req, resp);
//				
				break;
			case "/addExpense":
				displayData(req, resp);
				addExpensee(req, resp);
				
//				rd=req.getRequestDispatcher("expense.jsp");
//			    pw =resp.getWriter();
//				pw.print("<div align=center>data inserted successfully</div>");
//				rd.include(req,resp);
				break;
			case "/homePage":
				displayData(req,resp);
				break;
			case "/transaction":
				showTransaction(req,resp);
				break;
			case "/compare":
				Collections.sort(data);
				showTransaction(req, resp);
				break;
			
		}
	}

	private void showTransaction(HttpServletRequest req, HttpServletResponse resp) {
		try {
			PrintWriter pw=resp.getWriter();
			try {
			data=expenseDAO.showTransactions();
				req.setAttribute("AllData", data);
				RequestDispatcher rd=req.getRequestDispatcher("ShowTransactions.jsp");
				rd.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void displayData(HttpServletRequest req, HttpServletResponse resp) {
		ServiceClass s1=new ServiceClass();
		String startPoint=s1.startPoint();
		String endPoint=s1.endPoint();
		
		String temp1=req.getParameter("startDate");
		String temp2=req.getParameter("endDate");
		
		if(temp1!=null && temp2!=null) {
			startPoint=temp1;
			endPoint=temp2;
		}
		
		ExpenseDTO dto=new ExpenseDTO();
		
		dto.setStartPoint(startPoint);
		dto.setEndpoint(endPoint);
		
		ExpenseDTO data=expenseDAO.displayData(dto);
		
		try {
			//sending data to expense jsp page
			req.setAttribute("data", data);	
			RequestDispatcher rd=req.getRequestDispatcher("expense.jsp");
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void addExpensee(HttpServletRequest req, HttpServletResponse resp) {
		
		String expense=req.getParameter("expenseAmount");
		
		double expenseAmount=Double.parseDouble(expense);
		String category=req.getParameter("expenseCategory");
		String expenseType=req.getParameter("expensePaymentMethod");
		String expenseAddNote=req.getParameter("expenseAddNote");
		String expenseDate=req.getParameter("date");
		String expenseTIme=req.getParameter("time");
		
		ExpenseDTO e1=new ExpenseDTO();
		
		e1.setExpense(expenseAmount);
		e1.setCategory(category);
		e1.setPaymentMethod(expenseType);
		e1.setNote(expenseAddNote);
		e1.setDate(expenseDate);
		e1.setTime(expenseTIme);
		
		int count=expenseDAO.addExpense(e1);
		System.out.println(count+" coount this");
		
//		RequestDispatcher rd=req.getRequestDispatcher("addIncome.html");
//		PrintWriter pw=resp.getWriter();
//		pw.print("<h1 align='center'>Income details added successfully</h1>");
//		rd.include(req, resp);
		
		if (count>=0) {
			PrintWriter pw;
			try {
				RequestDispatcher rd=req.getRequestDispatcher("AddIncome.jsp");
				pw = resp.getWriter();
				
				pw.print("<div align=center>data inserted successfully</div>");
				rd.include(req, resp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private void addIncome(HttpServletRequest req, HttpServletResponse resp) {
		String income=req.getParameter("incomeAmount");
		
		double incomeAmount=Double.parseDouble(income);
		String category=req.getParameter("incomeCategory");
		String incomeType=req.getParameter("incomeType");
		String incomeAddNote=req.getParameter("incomeAddNote");
		String incomeDate =req.getParameter("incomeDate");
		String incomeTime=req.getParameter("incomeTime");
		
		//dto class object created to send the values 
		ExpenseDTO dto=new ExpenseDTO();
		
		dto.setIncome(incomeAmount);
		dto.setCategory(category);
		dto.setPaymentMethod(incomeType);
		dto.setNote(incomeAddNote);
		dto.setDate(incomeDate);
		dto.setTime(incomeTime);
		
		int count=expenseDAO.addIncome(dto);
		
		if (count>=0) {
		
			try {
				RequestDispatcher rd=req.getRequestDispatcher("expense.jsp");
			    PrintWriter pw =resp.getWriter();
				pw.print("<div align=center>data inserted successfully</div>");
				rd.include(req,resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
