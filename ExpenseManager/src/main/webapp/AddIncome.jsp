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
<div align="center"   >
<h2 style="color:blue; margin-bottom:40px; margin-top:40px;">ADD INCOME</h2>
<div id="div-1" class="border border-secondary" style="border-radius:6px;"  >
<article class="card-body">
<form method="post" action="addIncome">
	<div class="form-row">
		<div class="col form-group">
		  	<input type="text" class="form-control" name="incomeAmount" placeholder="Enter Income Amount">
		</div> <!-- form-group end.// -->
	</div> <!-- form-row end.// -->
	<div class="form-row">
		
		<div class="form-group col-md-6">
		  <label>Select Category</label>
		  <select id="inputState" class="form-control" name="incomeCategory">
		      <option name="incomeCategory" value="Allowance">Allowance</option>
		      <option name="incomeCategory" value="Bonus">Bonus</option>
		      <option name="incomeCategory" value="Buziness">Business</option>
		      <option name="incomeCategory" value="Investment">Investment</option>
		      <option name="incomeCategory" value="Pension">Pension</option>
		      <option name="incomeCategory" value="Subsidy">Subsidy</option>
		  </select>
		</div> <!-- form-group end.// -->
	</div> <!-- form-row.// -->
	<div class="form-row">
		
		<div class="form-group col-md-6">
		  <label>Payment Method</label>
		  <select id="inputState" class="form-control" name="incomeType">
		  
		      <option name="incomeType" value="Bank">Bank</option>
		      <option name="incomeType" value="card">card</option>
		      <option name="incomeType" value="Cash">Cash</option>
		      <option name="incomeType" value="Other">Other</option>
		     
		  </select>
		</div> <!-- form-group end.// -->
	</div> <!-- form-row.// -->
	
	<div class="form-group">
		<input type="text" class="form-control" placeholder="Add Note" name="incomeAddNote">
	</div> <!-- form-group end.// -->
	<div class="form-group">
		<input type="date" class="form-control"  name="incomeDate">
	</div> <!-- form-group end.// -->
	<div class="form-group">
		<input type="time"  class="form-control" name="incomeTime">
	</div> <!-- form-group end.// -->
	<div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Add  </button>
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