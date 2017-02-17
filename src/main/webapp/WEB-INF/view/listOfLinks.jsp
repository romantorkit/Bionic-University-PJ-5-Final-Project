<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Links List</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css">

</head>
<body>
	
			<div id="content">
				<h2>List of links in database</h2>
				<table>

					<thead>
						<tr>
							<th>Link Name</th>
							<th>Link URL</th>
							<th>Subject Name</th>
							<th>Keyword Name</th>
							<th>&nbsp;</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<c:forEach var="link" items="${linkList}">
						<c:url var="editUrl" value="/links/edit/${link.id}" />
						<c:url var="deleteUrl" value="/links/delete?id=${link.id}" />
						<tr>
							<td><c:out value="${link.linkName}" /></td>
							<td><a target="_blank"
								href="<c:url value="${link.linkURL}"/>"><c:out
										value="${link.linkURL}" /></a></td>
							<td><c:out value="${link.getSubject().getSubjectName()}" /></td>
							<td><c:out value="${link.getKeyword().getKeywordName()}" /></td>
							<td><a href="${editUrl}" title=Edit><img alt="Edit"
									border="0" src="<c:url value="/resources/images/edit.png" />"
									width="16" height="16"></a></td>
							<td><a href="${deleteUrl}" title="Delete"><img
									alt="Delete" border="0"
									src="<c:url value="/resources/images/remove.png" />" width="16"
									height="16"></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		
</body>
</html>
