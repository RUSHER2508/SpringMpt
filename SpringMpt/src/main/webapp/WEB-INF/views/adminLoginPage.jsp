<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-warning">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="#">Student Information System</a>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item">
        <a class="nav-link " href="./login">Admin Login</a>
      </li>
    </ul>
    
  </div>
</nav>
<div class=" col-md-4 offset-4 mt-4 card">
    <div class="card-body">
</div>

<form action="./login" method="post">
  <div class="form-group">
    <label for="AdminId">ADMIN ID</label>
    <input type="text" class="form-control" id="formGroupExampleInput" name="adminId" placeholder="Admin ID">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">PASSWORD</label>
    <input type="password" class="form-control" id="formGroupExampleInput2" name="password" placeholder="PASSWORD">
  </div>
  <input type="submit" value="SUBMIT">
  </div>
  
</form>

</body>
</html>