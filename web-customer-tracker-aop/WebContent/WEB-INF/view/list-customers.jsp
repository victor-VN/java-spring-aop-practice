<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
			<div class="col">
			
			<!-- put new button: add customer -->
			<input type="button" value="Add customer" 
				onclick="window.location.href='showFormForAdd'; return false;"
				class="btn btn-primary float-left mb-3 mt-3">
			
		
			
				<!-- add our html table here -->
				
				<table class="table mt-5">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var="tempCustomer" items="${customers}">
						
						<!-- construct an update link with customer id -->
						
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						
						
						<!-- construct an delete link with customer id -->
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						
						<tr>
							<td> ${tempCustomer.firstName} </td>
							<td> ${tempCustomer.lastName} </td>
							<td> ${tempCustomer.email} </td>
							<td> 
								<a href="${updateLink}">Update</a> 
								|						
								<a href="${deleteLink}"
									onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a> 
							</td>
						</tr>
						
					</c:forEach>
				</table>
				
			</div>
		</div>
		
		<script src="<c:url value="/resources/js/jquery-3.4.1.js" />"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
		
		
	</body>
</html>