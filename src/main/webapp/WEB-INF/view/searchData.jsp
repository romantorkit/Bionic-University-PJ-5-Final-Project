<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="cf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Data</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css">

</head>
<body>
			<div id="content">
				<h2>Available search parameters</h2>
				<div id="divLeft">
					<table>

						<tr>
							<th colspan=3>Subject</th>
						</tr>
						<c:forEach var="s" items="${subjectList}">
							<c:url var="editUrl" value="/subject/edit/${s.id}" />
							<c:url var="deleteUrl" value="/subject/delete?id=${s.id}" />
							<tr>
								<td><c:out value="${s.subjectName}" /></td>
								<td><a href="${editUrl}" title="Edit"><img alt="Edit"
										border="0" src="<c:url value="/resources/images/edit.png" />"
										width="16" height="16"></a></td>
								<td><a href="${deleteUrl}" title="Delete"><img alt="Delete"
										border="0" src="<c:url value="/resources/images/remove.png" />"
										width="16" height="16"></a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div>
					<table class="width450">

						<tr>
							<th colspan=3>Keyword</th>
						</tr>
						<c:forEach var="k" items="${keywordList}">
							<c:url var="editUrl" value="/keyword/edit/${k.id}" />
							<c:url var="deleteUrl" value="/keyword/delete?id=${k.id}" />
							<tr>
								<td><c:out value="${k.keywordName}" /></td>
								<td><a href="${editUrl}"title=Edit><img alt="Edit"
										border="0" src="<c:url value="/resources/images/edit.png" />"
										width="16" height="16"></a></td>
								<td><a href="${deleteUrl}" title="Delete"><img alt="Delete"
										border="0" src="<c:url value="/resources/images/remove.png" />"
										width="16" height="16"></a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="divClear"></div>
			</div>

</body>
</html>
