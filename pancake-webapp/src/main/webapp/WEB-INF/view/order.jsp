<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Ordering</title>
	<link rel="stylesheet" href="<c:url value="assets/style.css" />" type="text/css" media="all">
</head>
<body>
	<div id="layout">
		<div id="container">
			<div id="header">
				<h1>Order your pancakes!</h1>
			</div>
			<div id="navigation">
				<ul>
					<li><a href="<c:url value='/' />">Home</a></li>
					<li><a href="<c:url value='/orderPancakesForm.html' />">Ordering</a></li>
				</ul>
			</div>
			<div id="content">
				<form:form modelAttribute="orderPancakesRequest" action="orderPancakesPost.html" enctype="multipart/form-data">
					<div class="form-group" >
						<table>
							<tr>
								<th>Type</th>
								<th>Ammount</th>
							</tr>
							<c:forEach var="orderedPancakes" items="${orderPancakesForm.orderedPancakes}">
								<tr>
									<td>${orderedPancakes.type}</td>
									<td>
										<form:select path="orderedAmounts" multiple="false">
											<form:options items="${orderPancakesForm.orderAmounts}" />
										</form:select>
									</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<p><form:input path="email" id="input_email" placeholder="Email address" /></p>
					<p><button type="submit" class="btn btn-default">Submit</button></p>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>