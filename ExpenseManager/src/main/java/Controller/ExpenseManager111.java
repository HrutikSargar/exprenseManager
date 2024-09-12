//package Controller;
////controller should only contain 
//import java.beans.Statement;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import Model.ExpenseDAO;
//import Model.ExpenseDTO;
//import Model.ServiceClass;
//
////@WebServlet(urlPatterns = {"/expenseManager1" ,"/addIncome" ,"/addExpense","/homePage"})
//public class ExpenseManager111 extends HttpServlet {
////	<a class="anc" href="ShowTransactions.jsp">  Show Transaction</a>
//	
//	 
//	 private static ExpenseDAO expenseDAO=new ExpenseDAO();
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String path=req.getServletPath();
//		String button=req.getParameter("expenseManager");
//		
//		switch(path) {
//		case "/expenseManager1":
//			if(button.equals("addIncome")) {
//			//	addIncome(req,resp);
//				RequestDispatcher rd=req.getRequestDispatcher("AddIncome.jsp");
//				rd.forward(req,resp);
////				displayData(req, resp);
//				}else if(button.equals("addExpense")) {
//					RequestDispatcher rd=req.getRequestDispatcher("AddExpense.jsp");
//					rd.forward(req,resp);				
//				
//				}else if(button.equals("transaction")) {
//					RequestDispatcher rd=req.getRequestDispatcher("ShowTransactions.jsp");
//					rd.forward(req,resp);
////					displayData(req, resp);
//			}
//			break;
//		case "/addIncome":
//			addIncome(req, resp);
//			
//			displayData(req, resp);
//			PrintWriter pw =resp.getWriter();
//			RequestDispatcher rd=req.getRequestDispatcher("expense.jsp");
//			
//			//rd.forward(req,resp);
//			
//			pw.print("<div align=center>data inserted successfully</div>");
//			rd.include(req, resp);
//			
//			break;
//			
//		case "/addExpense":
//			addExpensee(req, resp);
//			displayData(req, resp);
//			rd=req.getRequestDispatcher("expense.jsp");
//		    pw =resp.getWriter();
//			pw.print("<div align=center>data inserted successfully</div>");
//			rd.include(req,resp);
//			break;
//		case "/homePage":
//			displayData(req,resp);
//			break;
//		case "/transaction":
//			showTransaction(req,resp);
//			break;
//			
//	}
//	
//	
//	}
//
//	private void showTransaction(HttpServletRequest req, HttpServletResponse resp) {
//		try {
//			PrintWriter pw=resp.getWriter();
//			RequestDispatcher rd=req.getRequestDispatcher("transactions.jsp");
//			pw.print("<html><body>");
//			pw.print("<h1>hello world</h1>");
//			pw.print("</body></html>");
//			try {
//				rd.include(req, resp);
//			} catch (ServletException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//
//	private void displayData(HttpServletRequest req, HttpServletResponse resp) {
//		ServiceClass s1=new ServiceClass();
//		String startPoint=s1.startPoint();
//		String endPoint=s1.endPoint();
//		
//		String temp1=req.getParameter("startDate");
//		String temp2=req.getParameter("endPoint");
//		
//		if(temp1!=null && temp2!=null) {
//			startPoint=temp1;
//			endPoint=temp2;
//		}
//		
//		ExpenseDTO dto=new ExpenseDTO();
//		
//		dto.setStartPoint(startPoint);
//		dto.setEndpoint(endPoint);
//		
//		ExpenseDTO data=expenseDAO.displayData(dto);
//		
//		try {
//			//sending data to expense jsp page
//			req.setAttribute("data", data);	
//			RequestDispatcher rd=req.getRequestDispatcher("expense.jsp");
//			rd.forward(req, resp);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//
//	private void addExpensee(HttpServletRequest req, HttpServletResponse resp) {
//		
//		String expense=req.getParameter("expenseAmount");
//		
//		double expenseAmount=Double.parseDouble(expense);
//		String category=req.getParameter("expenseCategory");
//		String expenseType=req.getParameter("expensePaymentMethod");
//		String expenseAddNote=req.getParameter("expenseAddNote");
//		String expenseDate=req.getParameter("date");
//		String expenseTIme=req.getParameter("time");
//		
//		ExpenseDTO e1=new ExpenseDTO();
//		
//		e1.setExpense(expenseAmount);
//		e1.setCategory(category);
//		e1.setPaymentMethod(expenseType);
//		e1.setNote(expenseAddNote);
//		e1.setDate(expenseDate);
//		e1.setTime(expenseTIme);
//		
//		expenseDAO.addExpense(e1);
//	}
//
//	private void addIncome(HttpServletRequest req, HttpServletResponse resp) {
//		String income=req.getParameter("incomeAmount");
//		
//		double incomeAmount=Double.parseDouble(income);
//		String category=req.getParameter("incomeCategory");
//		String incomeType=req.getParameter("incomeType");
//		String incomeAddNote=req.getParameter("incomeAddNote");
//		String incomeDate =req.getParameter("incomeDate");
//		String incomeTime=req.getParameter("incomeTime");
//		
//		//dto class object created to send the values 
//		ExpenseDTO dto=new ExpenseDTO();
//		
//		dto.setIncome(incomeAmount);
//		dto.setCategory(category);
//		dto.setPaymentMethod(incomeType);
//		dto.setNote(incomeAddNote);
//		dto.setDate(incomeDate);
//		dto.setTime(incomeTime);
//		
//		expenseDAO.addIncome(dto);
//	}
//}
