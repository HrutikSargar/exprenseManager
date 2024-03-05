<%@page import="Model.ExpenseDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.anc{
	color:white;
	text-decoration:none;
	}
	
	#main-div{
	margin-top:100px;
	}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>
<div id="main-div">

<div id="div-1" align="center" >
<h1 style=" margin-bottom:20px; margin-top:40px;" >EXPENSE MANAGER</h1>
<form action="expenseManager1" method="post">
<div id="div-2" style="margin-bottom:20px; gap:10px;">


<button type="submit" value="add Income" class="btn btn-primary" name="addIncome"><a class="anc" href="AddIncome.jsp">  +Add Income</a></button>
<button type="submit" value="add Expense" class="btn btn-danger" name="addExpense"> <a class="anc" href="AddExpense.jsp">  -Add Expense</a></button>

</div>

<div>
 </form>
 <form action="transactionShow" method="post">
 	<input type="submit" value="Transactions History"  class="btn btn-info" name="expenseManager">
 </form>
</div>

<div style="margin:30px">
<form action="homePage" method="post">
	<input type="date" name="startDate">
	<input type="date" name="endDate">
	<input type="submit" value="Generate">

</div>
<table style="border:1px solid black">
<tr>
<th>Total Income</th>
<th>Total Expense</th>
<th>Balance </th>
</tr>
<tr>

<% ExpenseDTO dto =(ExpenseDTO) request.getAttribute("data"); //do casting always  %>
<%if(dto!=null){ %>
<td><%=dto.getTotalIncome() %></td>
<td><%=dto.getTotlaexpense() %></td>
<td><%= dto.getBalance() %></td>
<%} else{%>
</tr>
<td>0.0</td>
<td>0.0</td>
<td>0.0</td>

<%} %>

</table>
</form>
</div>


</div>
</body>
</html>