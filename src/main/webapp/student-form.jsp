
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<h1>
		Login
	</h1>
	
	<form method="POST" action="login" class="form">
		<fieldset>
			<legend>Student Information</legend>
			
			<input type="hidden" id="id" name="id">
			
			<div class="form-group">
				<label for="email" class="label">Email</label>
				<input type="text" id="email" name="email">
			</div>
			
			
			<div class="form-group">
				<label for="password" class="label">Password</label>
				<input type="text" id="password" name="password">
			</div>
		
			<button type="submit" class="btn">Submit</button>
		</fieldset>
	</form>
</body>
</html>