<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#div-1{
	width:400px;
	 backdrop-filter: blur(200px);
  filter: blur();
  box-shadow: 0 3rem 5rem rgba(0, 0, 0, 0.25);
}
h2{
	color:"blue";
}
</style>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>

<body>
<div align="center"  >
<h2 style="color:Red; margin-bottom:40px; margin-top:40px;">ADD EXPENSE</h2>
<div id="div-1" class="border border-secondary" style="border-radius:6px;"  >
<article class="card-body">
<form method="post" action="addExpense">
	<div class="form-row">
		<div class="col form-group">
		  	<input type="text" class="form-control" name="expenseAmount" placeholder="Enter Expense Amount">
		</div> <!-- form-group end.// -->
	</div> <!-- form-row end.// -->
	<div class="form-row">
		
		<div class="form-group col-md-6">
		   <label>Select Category</label>
		  <select id="inputState" class="form-control" name="expenseCategory">
		      <option name="expenseCategory" value="Travelling">Travelling</option>
		      <option name="expenseCategory" value="CableTv">Cable Tv</option>
		      <option name="expenseCategory" value="Card Fee" >Card Fee</option>
		      <option name="expenseCategory" value="Cloths">Cloths</option>
		      <option name="expenseCategory" value="Education">Education</option>
		      <option name="expenseCategory" value="Electricity">Electricity</option>
		       <option name="expenseCategory" value="EMI">EMI</option>
		      <option name="expenseCategory" value="Entertainment">Entertainment</option>
		      <option name="expenseCategory" value="FastFood">Fast Food</option>
		      <option name="expenseCategory" value="Festivals">Festivals</option>
		      <option name="expenseCategory" value="Fitness">Fitness</option>
		      <option name="expenseCategory" value="Gas">Gas</option>
		     
		  </select>
		</div> <!-- form-group end.// -->
	</div> <!-- form-row.// -->
	<div class="form-row">
		
		<div class="form-group col-md-6">
		   <label >Payment Method</label>
		  <select id="inputState" class="form-control" name="expensePaymentMethod">
		    <optGroup>Payment Method</optGroup>
		      <option name="expensePaymentMethod" value="Bank">Bank</option>
		      <option name="expensePaymentMethod" value="Card">card</option>
		      <option  name="expensePaymentMethod" value="Cash">Cash</option>
		      <option name="expensePaymentMethod" value="Other">Other</option>
		     
		  </select>
		</div> <!-- form-group end.// -->
	</div> <!-- form-row.// -->
	
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Add Note" name="expenseAddNote">
	</div> <!-- form-group end.// -->
	<div class="form-group">
		<input type="date" class="form-control"  name="date" id="">
	</div> <!-- form-group end.// -->
	<div class="form-group">
		<input type="time"  class="form-control" name="time" id="">
	</div> <!-- form-group end.// -->
	<div class="form-group">
        <button type="submit" class="btn btn-danger btn-block" > Add Expense  </button>
    </div>
     <div class="form-group">
        <button  class="btn btn-secondary"> <a style="text-decoration:none; color:white"  href="expense.jsp">Home Page</a></button>
    </div>
</form>
</article> <!-- card-body end .// -->
</div>
</div>
</body>
</html>