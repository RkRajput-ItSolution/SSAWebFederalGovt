<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SSN Enrollment</title>

<!-- autocomplete="off" -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style type="text/css">
/* table {
      align:justify;
	border-collapse: collapse;
	border: 5px solid black;
	 border-radius: 25px;
	 */
}
table {
	border-radius: 25px;
	border: 30px solid black;
	background-position: left top;
	background-repeat: repeat;
	padding: 20px;
	border-collapse: collapse;
	width: 200px;
	height: 150px;
}

th, td {
	padding: 15px;
	text-align: left;
}

.error {
	color: #FF0000;
	display: block;
	font-size: 16px;
}

.errors {
	display: none;
}

.tablebg {
	background: #f4f4f4;
	color: #333;
	padding: 10px;
}

.bgimage {
	background:
		url(https://thumbs.dreamstime.com/b/gradient-blue-white-light-abstract-template-banner-display-ba-background-design-127378544.jpg);
	padding: 10px;
}
</style>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

<script>
	$(function() {

		$('form[id="ssnForm"]').validate({
			rules : {
				firstName : 'required',
				lastName : 'required',
				dob : 'required',
				gender : 'required',
				state : 'required',
				phoneNo : 'required',
			},
			messages : {
				firstName : 'Please enter first name',
				lastName : 'please enter last name',
				dob : 'Please Enter Date of Birth',
				gender : 'Please Select Gender',
				state : 'Please Select state',
				phoneNo : 'please enter Phone Number',
			},
			submitHandler : function(form) {
				form.submit();
			}
		});

		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			maxDate : new Date(),
			dateFormat : 'dd/mm/yy'
		});
	});
</script>
</head>
<body>
	<div align="center"
		style="text align: center; color: white; background-color: orange; margin-top: 20px;">
		<header>
			<font style="color: green; font-size: 30px">${enrollSuccess}</font> <font
				color='red'>${enrollFailure}</font>


			<h2 style="font-size: 30px;">Enrollment For SSN(Social Security
				Number)</h2>
		</header>
	</div>
	<div class="bgimage" align="center"
		style="text align: center; font-size: 25px; color: white; background-color: lightblue; margin-top: 30px;">

		<form:form action="registration_ssn" method="POST"
			modelAttribute="ssnModel" enctype="multipart/form-data" id="ssnForm"
			autocomplete="off">
			<table class="tablebg">
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" /> 
					<form:errors path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /> <form:errors
							path="lastName" /></td>
				</tr>
				<tr>
					<td>Date Of Birth:</td>
					<td><form:input path="dob" id="datepicker" /></td>
				</tr>
				<tr>
					<td>Gender:</td>
					<td><form:radiobuttons path="gender" items="${gendersList }" /></td>
				</tr>
				<tr>
					<td>Phno:</td>
					<td><form:input path="phoneNo" />
						<form:errors path="phoneNo" /></td>
				</tr>

				<tr>
					<td>Select State:</td>
					<td><form:select path="state" items="${statesList}" /></td>
				</tr>
				<tr>
					<td>Select Photo:</td>
					<td><form:input type="file" path="photo" /></td>
				</tr>

				<tr>
					</td>
					<td><input type="reset" value="Reset" /></td>
					<td><input type="Submit" value="Submit" /></td>
				</tr>

			</table>


		</form:form>
		<a href="report" style="color: #ece306;"><b>View All Record</b></a>
	</div>
	<div align="center"
		style="text align: center; font-size: 30px; color: white; background-color: green; margin-top: 20px;">
		<footer>@copy All Rights Reserved. </footer>
	</div>
</body>
</html>