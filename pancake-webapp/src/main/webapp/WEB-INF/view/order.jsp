<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Pancake App</title>
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
					<li><a href="<c:url value='/orderForm.html' />">Ordering</a></li>
				</ul>
			</div>
			<div id="content">
				<form:form modelAttribute="orderRequest" action="orderPost.html">
					<div class="form-group" >
						<table>
							<tr>
								<th>Type</th>
								<th>Ammount</th>
							</tr>
							<c:forEach var="type" items="${orderFormModel.availablePancakes}" varStatus="iterIndex">
								<tr>
									<form:hidden path="orderedAmounts[${iterIndex.index}].type" value="${type}" />
									<td>${type}</td>
									<td><form:select path="orderedAmounts[${iterIndex.index}].amount" items="${orderFormModel.availableAmounts}" multiple="false" /></td>
								</tr>
							</c:forEach>
						</table>
						<p><form:errors path="orderedAmounts" element="div" cssClass="validation-error" /></p>
					</div>
					<p>
						<form:input path="email" placeholder="Email address" />
						<form:errors path="email" element="div" cssClass="validation-error" />
					</p>
					<p><button type="submit" class="btn btn-default">Submit</button></p>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>