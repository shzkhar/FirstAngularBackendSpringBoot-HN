<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>HoMe Page</h1>
   
	<form action="saveprofile2" method="post" enctype="multipart/form-data">
	FirstName : <input type="text" name="firstname"/><br><br>
		profile : <input type="file" name="profile" /> <br>
		<br>
		<input type="Submit" value="save file" />
	</form>
</body>
</html>