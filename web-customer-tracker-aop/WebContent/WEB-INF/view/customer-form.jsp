<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>
	<head>
		<title>List Customers</title>
		
		<!-- reference our style sheet -->
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
		
	</head>

	<body>
		
		<div class="container">
			<h2 class="mt-5">CRM - Customer Relationship Manager</h2>
			
			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			
			<!-- need to associate this data with customer id -->
			<form:hidden path="id"/>
			
			  <div class="form-group">
			    <label for="exampleInputEmail1">First Name</label>
			    <form:input path="firstName" type="text" class="form-control" placeholder="First Name" />
			    
			    <label for="exampleInputEmail1">Last Name</label>
			    <form:input path="lastName" type="text" class="form-control" placeholder="Last Name" />
			    
			    <label for="exampleInputEmail1">Email</label>
			    <form:input path="email" type="email" class="form-control" placeholder="Email" />			    
			  </div>			  
			  
			  <button type="submit" class="btn btn-primary">Enviar</button>
			</form:form>
			
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		
		</div>
		
		<script src="<c:url value="/resources/js/jquery-3.4.1.js" />"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
		
		
	</body>
</html>