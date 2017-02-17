<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<title>Collection of Java educational Links</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div id="main">
			<div id="header">
				<img src="<c:url value="/resources/images/java.png" />" />
				<h1>Collection of Java educational Links</h1>
			</div>

			<div id="menu">
				<p>
					<a href="<c:url value="/index.jsp"/>">Home</a>&nbsp; | &nbsp;<a
						href="<c:url value="/search/getSearchData.html"/>">Search Page</a>&nbsp;
					| &nbsp;<a href="<c:url value="/links/newLink"/>">Add New Link</a>&nbsp;
					| &nbsp;<a href="<c:url value="/subject/newSubject"/>">Add New
						Subject</a>&nbsp; | &nbsp;<a
						href="<c:url value="/keyword/newKeyword"/>">Add New Keyword</a>&nbsp;
					| &nbsp;<a href="<c:url value="/search/searchData.html"/>">Search
						Data</a>&nbsp; | &nbsp;<a href="<c:url value="/links/list.html"/>">Links
						List</a>
				</p>
			</div>

			<div id="content">
				<p id="divLeft">
					<img alt="Database Schema" border="0"
						src="<c:url value="/resources/images/schema.png" />"><br />
					Figure 1. Database schema and relations.
				</p>
				<h3>This app was created by Roman Torkit as a final project for
					the Java EE Preproduction course.</h3>
			</div>
			<div id="footer">
				<c:out value="© Roman Torkit - 2017" />
			</div>
		</div>

	</div>
</body>
</html>
