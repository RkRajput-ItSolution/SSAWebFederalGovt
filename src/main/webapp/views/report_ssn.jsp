<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>SSN Enrollment</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<!-- // JQuery Reference, If you have added jQuery reference in your master page then ignore, 
// else include this too with the below reference
 -->

<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<style>
.btn-outline {
	border: 1px solid #a5a5a5;
	padding: 0px;
	font-size: 20px;
	margin-right: 20px;
}
</style>
<script type="text/javascript">
    $(document).ready(function () {
        $('#ssnTable').dataTable();
        searching: true
    });
</script>

</head>
<body>
	<div class="container">
		<div style="margin: 20px 0;">
			<h1 style="color: red; text-align: center">SSN ENROLL VIEW
				RECORD</h1>
			<h1 style="color: red; text-align: center">
				<a href="/">Back To Home</a>
			</h1>
			<hr>
			<%-- <table border="1" bgcolor="cyan" align="center" id="ssnTable">
	<tr>
		<th>SNo</th>
		<th>Ssn</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>DOB</th>
		<th>Gender</th>
		<th>State</th>
		<th>CreatedDate</th>
		<th>UpdatedDate</th>
		<th>Edit Or Delete</th>
	</tr>
	<c:forEach var="ssnModel" items="${listModels}" varStatus="index">
		<tr>
			<td><c:out value="${index.count}" /></td>
			<td><c:out value="${ssnModel.ssn}" /></td>

			<td><c:out value="${ssnModel.firstName}" /></td>
			<td><c:out value="${ssnModel.lastName}" /></td>
			<td><c:out value="${ssnModel.dob}" /></td>
			<td><c:out value="${ssnModel.gender}" /></td>
		</tr>
	</c:forEach>
</table> --%>
			<c:choose>
				<c:when test="${!empty listModels}">

					<table
						class="table table-bordered table-hover table-striped dataTable"
						id="ssnTable" width="100%">
						<thead>
							<tr class="success">
								<th>SNo</th>
								<th>Ssn</th>
								<th>FirstName</th>
								<th>LastName</th>
								<th>DOB</th>
								<th>Gender</th>
								<th>State</th>
								<th>CreatedDate</th>
								<th>UpdatedDate</th>
								<th>Edit Or Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="dto" items="${listModels}" varStatus="index">

								<tr>
									<td>${index.count}</td>
									<td>${dto.ssn}</td>
									<td>${dto.firstName}</td>
									<td>${dto.lastName}</td>
									<td>${dto.dob}</td>
									<td>${dto.gender}</td>
									<td>${dto.state}</td>
									<td>${dto.createDate}</td>
									<td>${dto.updateDate}</td>
									<td><a title="edit" class="btn-outline"
										href="edit_snn?sno=${dto.ssn}"><i class="fa fa-edit"></i>
									</a> <a class="btn-outline" title="delete"
										href="delete_snn?sno=${dto.ssn}"
										onclick="checkOnce(${dto.ssn})"><i class="fa fa-trash"></i></a></td>
								</tr>

							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<h1 style="color: red; text-align: center">No Data Found</h1>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>
<script>
    function checkOnce(sno){
      confirm("<b>Are u sure about deleting student with sno"+sno+"? </b>")
    }
 </script>

