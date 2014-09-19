<%--
  ~ Copyright (c) 2014. Shawn Wheeler. All rights reserved.
  --%>

<%--
    Created by Shawn Wheeler on 9/01/2014.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Basic Hello World</title>
</head>
<body>
<h1>Enter name so Struts 2 can say hello.</h1>
<s:form action="helloSubmitted">
    <s:textfield name="messageStore.message" label="Name:"/>
    <s:submit/>
</s:form>
</body>
</html>
