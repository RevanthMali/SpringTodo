<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<title>List todos Page</title>
	</head>
	<body>
		<div class="container">
		<div>Welcome <b>${name}!!<b></div><br>
		<div>Your todos are</div><br>
		<table class="table">
		  <thead>
		    <th>id</th>
		    <th>Description</th>
		    <th>Target Date</th>
		    <th>Is Done?</th>
		    <th>Delete Todo</th>
		    </thead>
		  <tbody>
		     <c:forEach items="${todos}" var="todo">
		     		<tr>
		     			<td>${todo.id}</td>
		     			<td>${todo.desc}</td>
		     			<td>${todo.targetDate}</td>
		     			<td>${todo.isDone}</td>
		     			<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
		     		     <td><a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a></td>
		     		
		     		</tr>		     
		     </c:forEach>
		  </tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>
		</div>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	
	</body>
</html>