<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@page import="java.util.ArrayList,beans.RegistrationBean" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<h1>
<center>
Welcome ${uid}
</h1>
</center>
<br>
<br>
<div class="container">
<table class="table table-bordered">
 <tr><th>Name</th><th>Gender</th><th>Date Of Birth</th><th>Religion</th><th>Mother Tongue</th><th>Cast</th><th>Country</th><th>Mobile Number</th><th>Email Id</th></tr>
 <% 
 ArrayList<RegistrationBean> list=(ArrayList<RegistrationBean>)request.getAttribute("LIST");
 
 %>
 
 <%
   for(RegistrationBean e:list)
   {
	  %>
   	 <tr>
   	<td> <%=e.getName()%> </td>
   	<td> <%=e.getGender()%> </td>
	<td> <%=e.getDob()%> </td>
	 <td><%=e.getReligion()%> </td>
	 <td><%=e.getMothertongue()%> </td>
	 <td><%=e.getCast()%> </td>
	 <td><%=e.getCountry()%> </td>
	 <td><%=e.getMobileno()%> </td>
	 <td><%=e.getEmailid()%> </td>
	 <tr/>
	 <%
	 }
  %>
  
         
        
 
  </body>
  </table>
  </div>
  </html>