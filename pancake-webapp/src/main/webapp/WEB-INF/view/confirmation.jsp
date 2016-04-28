<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<h1>Thank you for ordering!</h1>
			</div>
			<div id="navigation">
				<ul>
					<li><a href="<c:url value='/' />">Home</a></li>
					<li><a href="<c:url value='/orderForm.html' />">Ordering</a></li>
				</ul>
			</div>
			<div id="content">
			<p>You ordered:</p>
				<ul>
					<c:forEach var="orderedAmount" items="${orderRequest.orderedAmounts}">
						<c:if test="${orderedAmount.amount!='0'}">
							<li>${orderedAmount.type} (${orderedAmount.amount} pcs)</li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>