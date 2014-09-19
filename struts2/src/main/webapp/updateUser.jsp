<%--
  ~ Copyright (c) 2014. Shawn Wheeler. All rights reserved.
  --%>

<%--
    Created by Shawn Wheeler on 9/02/2014.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Update Client</title>
</head>
<body>
<s:form action="userSubmitted">
    <s:hidden name="user.identity"/>
    <s:textfield name="user.name" label="Name"/>
    <s:textarea name="user.description" label="Description" cols="20" rows="5"/>

    <s:url action="listUsers" var="listClientsURL"/>
    <s:if test="%{#parameters.identity== null}">
        <s:submit value="Create"/>
    </s:if>
    <s:else>
        <s:submit value="Update"/>
    </s:else>
    <a href="<s:property value="#listClientsURL" />">Cancel</a>
</s:form><br>


</body>
</html>
