<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Insert title here</title>
</head>
<body style="background-color:#efeef4;">
<h1>
<font color="grey">
${msg}
</font>
</h1>
<br>
<br>
<div class="span3">
    <h2>REGISTER</h2>
    <form action="Register" method="post">
    <label>Name</label>
    <input type="text" name="name" class="span3" required="required">
    <label>Gender</label>
    <input type="radio" name="gender" value="male"> Male
    <input type="radio" name="gender" value="female"> Female
    <label>Date Of Birth</label>
    <input type="text" name="dob" class="span3">
    <label>Religion</label>
    <input type="text" name="religion" class="span3" required="required">
    <label>Mother Tongue</label>
    <input type="text" name="mothertongue" class="span3" required="required">
    <label>Cast</label>
    <input type="text" name="cast" class="span3" required="required">
    <label>Country</label>
    <input type="text" name="country" class="span3" required="required">
    <label>MobileNo</label>
    <input type="text" name="mobileno" class="span3"  required="required">
    <label>Email ID</label>
    <input type="email" name="emailid" class="span3" required="required">
    <label>Password</label>
    <input type="password" name="password" class="span3" pattern=".{8,}" title="Must contain at least 8 or more characters">
    <input type="submit" value="Sign up" class="btn btn-primary pull-left">
    <div class="clearfix"></div>
    </form>
</div>
</body>
</html>