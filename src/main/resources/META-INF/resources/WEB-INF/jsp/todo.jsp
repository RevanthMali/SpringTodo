<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
	<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
</head>
<body>	
		<%@ include file="common/header.jspf" %>
		<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<h3>ADD Todo for <b>${name}</b></h3>
		<form:form method="post" modelAttribute="todo"> 
			<fieldset class="mb-3">				
				<form:label path="desc">Description</form:label>
				<form:input type="text" path="desc" id="desc" required="required"/>
				<form:errors path="desc" cssClass="text-warning"/>
			</fieldset>
			<fieldset class="mb-3">				
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" id="targetDate" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning"/>
			</fieldset>	
			<form:input type="hidden" path="id"/>
			<form:input type="hidden" path="isDone"/>	
			<input type="submit" class="btn btn-success">
		</form:form> 
	</div>
	<%@ include file="common/footer.jspf" %>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format: 'yyyy-mm-dd'
		});
	</script>
</body>
</html>