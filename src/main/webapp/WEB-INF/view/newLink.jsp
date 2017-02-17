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
<title>Add new link</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css">
<%-- <style>.error{color:red; font-weight:bold;}</style> --%>
</head>
<body>
	
			<div id="content">
				<h2>Add new link to database</h2>

				<cf:form method="POST" action="addLink" modelAttribute="link">
					<cf:hidden path="id" />

					<table class="width450">
						<tr>
							<td><cf:label path="linkName">Link Name</cf:label></td>
							<td><cf:input path="linkName" />&nbsp;
						</tr>
						<tr>
							<td><cf:label path="linkURL">Link URL</cf:label></td>
							<td><cf:input path="linkURL" />&nbsp;
						</tr>
						<tr>
							<td><cf:label path="subject">Subject</cf:label></td>
							<td><cf:select path="subject">
									<cf:option value="0"> --SELECT--</cf:option>
									<cf:options items="${subjectAttribute}"></cf:options>
								</cf:select></td>
						</tr>
						<tr>
							<td><cf:label path="keyword">Keyword</cf:label></td>
							<td><cf:select path="keyword">
									<cf:option value="0"> --SELECT--</cf:option>
									<cf:options items="${keywordAttribute}"></cf:options>
								</cf:select></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="Submit" />&nbsp;<input
								type="reset" value="Reset" /></td>
						</tr>
					</table>
				</cf:form>
			</div>
		
</body>
</html>
