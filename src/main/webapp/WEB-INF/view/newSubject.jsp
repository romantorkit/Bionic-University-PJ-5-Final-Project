<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="cf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01   
       Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new subject</title>

<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css">
	<%-- <style>.error{color:red; font-weight:bold;}</style> --%>
</head>
<body>
	
			<div id="content">
				<h2>Add new subject to database</h2>
		<cf:form method="POST" action="addSubject" modelAttribute="subject">
			<cf:hidden path="id" />

			<table class="width450">
				<tr>
					<td><cf:label path="subjectName">Subject</cf:label></td>
					<td><cf:input path="subjectName" /><br />
					<cf:errors path="subjectName" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" />&nbsp;<input type="reset" value="Reset" /></td>
				</tr>
			</table>
		</cf:form>
	</div>
	
</body>
</html>
