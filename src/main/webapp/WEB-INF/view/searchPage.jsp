<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Links</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css">

</head>
<body>
	
			<div id="content">
				<h2>Search</h2>
		<cf:form modelAttribute="result" action="search" method="POST">
			<table>
				<tr>
					<td><cf:select path="subjectId">
							<cf:option value="0"> --SELECT--</cf:option>
							<br />
							<cf:options items="${subjectAttribute}"></cf:options>
						</cf:select></td>
				</tr>

				<tr>
					<td><cf:radiobuttons cssClass = "margin" path="keywordId"
							items="${keywordAttribute}" /></td>
				</tr> 
				<tr>
					<td><input type="submit" value="Search"></td>
				</tr> 
				
			</table>

		</cf:form>

	</div>

</body>
</html>