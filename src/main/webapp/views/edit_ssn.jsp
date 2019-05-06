<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">Edit Student detials</h1>
   <script language="JavaScript" src="js/validation.js">
   </script>
   <link type="text/css" rel="stylesheet" href="css/style.css"/>

<form:form method="POST"  modelAttribute="stCmd" onsubmit="return validate(this)">
  Student number:: <form:input path="sno" disabled="true"/> <br>
  Student name:: <form:input path="sname"/> <form:errors path="sname"/> <span id="sname.err"></span> <br>
  Student address:: <form:input path="sadd"/><form:errors path="sadd"/> <span id="sadd.err"></span><br>
  Student Course:: <form:input path="course"/><form:errors path="course"/><span id="course.err"></span> <br>
  <form:hidden path="vflag"/>
  <input type="submit" value="editStudent">
</form:form>

<p align="center">
 <a title="home" href="welcome.htm"><img title="home" src="images/home.png" width="30" height="30"></a>
 &nbsp;&nbsp;&nbsp;&nbsp;
 <a title="back" href="stud_report.htm"><img title="back" src="images/back.png" width="30" height="30"></a>
 </p>
