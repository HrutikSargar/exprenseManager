<%@page import="Model.ExpenseDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Transactions</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


</head>
<body>
<h1 align="center" style=" margin-top:40px ;  margin-right:330px">TRANSACTION HISTORY</h1>
<label>Filter</label>
 <select name id>
            <option value></option>
            <option value>Asc Date</option>
            <option value>Desc Date</option>
 </select>
 <form action="compare" method="post">
 <!-- <a href="ascDate" value="Asc Date">Ascending by Income</a>  -->
  <input type="submit" name="ascDate" value="Ascending by Income"> 
 </form>

 
<div id="div1" style="width:400px; align:center;margin-left:20px " >
<% Object data=request.getAttribute("AllData");
	 ArrayList<ExpenseDTO> allData = (ArrayList<ExpenseDTO>) data;%>
	 <% if(!allData.isEmpty()){%>
		 <table class="table">
         <thead>
             <tr>
                 <th scope="col">ID</th>
                 <th scope="col">INCOME</th>
                 <th scope="col">EXPENSE</th>
                 <th scope="col">CATEGORY</th>
                  <th scope="col">PAYMENTMETHOD</th>
                 <th scope="col">NOTE</th>
                 <th scope="col">PAYMETNDATE</th>
                 <th scope="col">PAYMENTTIME</th>
                  <th scope="col">TOTALINCOME</th>
                 <th scope="col">TOTALEXPENSE</th>
                 <th scope="col">BALANCE</th>
             </tr>
         </thead>
          
<% 
	for(ExpenseDTO e1: allData){%>
           <tbody class="table-group-divider" style="overflow: scroll;">
                <tr>
                    <th scope="row"><%= e1.getId() %></th>
                    <td><%= e1.getIncome() %></td>
                    <td><%= e1.getExpense() %></td>
                    <td><%= e1.getCategory()%></td>
                    <td><%= e1.getPaymentMethod() %></td>
                    <td><%= e1.getNote()%></td>
                    <td><%= e1.getDate()%></td>
                    <td><%= e1.getTime()%></td>
                    <td><%= e1.getTotalIncome()%></td>
                    <td><%= e1.getTotlaexpense()%></td>
                    <td><%= e1.getBalance()%></td>               
                </tr>
                
            </tbody>
       
		
	<% }} else{%>
		<h1>Something went wrong</h1>
<%} %>
</div>
 </table>
<a href="expense.jsp">Home Page</a>

</body>
</html>