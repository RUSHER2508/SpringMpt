<%@page import="com.spring.beans.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-warning">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="#"><% Admin admin = (Admin)session.getAttribute("admin");
	if(admin != null){
		out.print("<h6>Hello " + "admin" +"</h6>");
	}else{
		response.sendRedirect("./login");
	}
%>
  </a>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="./login">Login <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="./createStudent">Create</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="./update">Update</a>
      </li>
            <li class="nav-item">
        <a class="nav-link" href="./deleteStudent">Delete</a>
      </li>
            <li class="nav-item">
        <a class="nav-link" href="./getDetails">Get  student information</a>
      </li>
            <li class="nav-item">
        <a class="nav-link" href="./grade">Grade</a>
      </li>
                  <li class="nav-item">
        <a class="nav-link" href="./aggregate">Aggregate</a>
      </li>
                  <li class="nav-item">
        <a class="nav-link" href="./logout">Logout</a>
      </li>
      
    </ul>
    
  </div>
</nav>


<div class=" col-md-4 offset-4 mt-4 card">
    <div class="card-body">
</div>

<form action="./update" method="post">
  <div class="form-group">
    <label for="regNo">Reg no</label>
    <input type="text" class="form-control" id="formGroupExampleInput" name="regno" placeholder="Regno">
  </div>

  <div class="form-group">
    <label for="oldEmail">OLD EMAIL</label>
    <input type="text" class="form-control" id="formGroupExampleInput" name="oldEmail" placeholder="OLD EMAIL">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">NEW EMAIL</label>
    <input type="newEmail" class="form-control" id="formGroupExampleInput2" name="newEmail" placeholder="NEW EMAIL">
  </div>
  <input type="submit" value="SUBMIT">
  </div>
  
</form>


</body>
</html>