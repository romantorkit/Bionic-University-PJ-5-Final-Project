<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="main">
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="menu" /> 
        <tiles:insertAttribute name="body" />
        <tiles:insertAttribute name="footer" /> 
    </div>
    </div>
</body>
</html>
