<%--
  ~ Copyright (c) 2014. Shawn Wheeler. All rights reserved.
  --%>

<%--
    Created by Shawn Wheeler on 9/02/2014.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<style type="text/css">

    /* for hiding the page banner */
    .pagebanner {
        display: none;
    }

    /* for customizing page links */
    .pagelinks {
        color: maroon;
        margin: 20px 0px 20px 50px;
    }

    /* for shifting all the Export options*/
    .exportlinks {
        margin: 20px 0px 20px 30px;
    }

    /* For changing the spaces between export link */
    .export {
        margin-left: 30px;
    }

    /* For Table css */
    table {
        border: 1px solid #666;
        width: 60%;
        margin: 20px 0 20px 0px;
    }

    /* For odd and even row decoration */
    tr.odd {
        background-color: #fff
    }

    tr.tableRowEven, tr.even {
        background-color: #CCCCCC
    }

    /* Css for table elements */
    th, td {
        padding: 2px 4px 2px 4px;
        text-align: left;
        vertical-align: top;
    }

    thead tr {
        background-color: #999999;
    }

    /* For changing the background colour while sorting */
    th.sorted {
        background-color: #CCCCCC;
    }

    th.sorted a, th.sortable a {
        background-position: right;
        display: block;
        width: 100%;
    }

    th a:hover {
        text-decoration: underline;
        color: black;
    }

    th a, th a:visited {
        color: black;
    }
</style>

<html>
<head>
    <title>User List</title>
</head>
<body>
<s:url action="updateUser" var="createUser"/>
<a href="<s:property value="#createUser" />">New User</a><br>
<display:table id="userTable" name="users" cellpadding="5px;" cellspacing="5px;"
               style="margin-left:50px;margin-top:20px;" requestURI="">
    <display:column property="name" title="Name"/>
    <display:column property="description" title="Description"/>
    <display:column title="Update">
        <s:url id="updateUrl" action="updateUser">
            <s:param name="identity" value="#attr.userTable.identity"/>
        </s:url>
        <s:a href="%{updateUrl}">Update</s:a>
    </display:column>
    <display:column title="Update">
        <s:url id="deleteUrl" action="deleteUser">
            <s:param name="identity" value="#attr.userTable.identity"/>
        </s:url>
        <s:a href="%{deleteUrl}">Delete</s:a>
    </display:column>
</display:table>
</body>
</html>
