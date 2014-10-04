<%--
  ~ Copyright (c) 2014. Shawn Wheeler. All rights reserved.
  --%>

<%--
    Created by Shawn Wheeler on 9/02/2014.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:url action="hello" var="helloURL"/>
<s:url action="listUsers" var="crud"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Struts 2 Simple Application</title>
    <link rel="stylesheet" href="css/styles.css" type="text/css" />
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
</head>
<body>
<div id="container">
    <header>
        <div class="width">
            <h1><a href="index.jsp">Struts 2 Simple Application</a></h1>
        </div>
    </header>
    <nav>
        <div class="width">
            <ul>
                <li class="start"><a href="index.jsp">Home</a></li>
                <li class=""><a href="<s:property value="#helloURL"/>">Hello World</a></li>
                <li class="end selected"><a href="<s:property value="#crud"/>">CRUD</a></li>
            </ul>
        </div>
    </nav>
    <div id="body" class="width">
        <section id="content">
            <article>
                <h2>User List</h2>
                <s:url action="updateUser" var="createUser"/>
                <a class="button" style="margin-top:10px;" href="<s:property value="#createUser" />">Create New User</a><br>
                <display:table id="userTable" name="users" cellpadding="5px;" cellspacing="5px;"
                               style="margin-top:20px;" requestURI="">
                    <display:column property="name" title="Name"/>
                    <display:column property="description" title="Description"/>
                    <display:column title="Update">
                        <s:url id="updateUrl" action="updateUser">
                            <s:param name="identity" value="#attr.userTable.identity"/>
                        </s:url>
                        <s:a href="%{updateUrl}">Update</s:a>
                    </display:column>
                    <display:column title="Delete">
                        <s:url id="deleteUrl" action="deleteUser">
                            <s:param name="identity" value="#attr.userTable.identity"/>
                        </s:url>
                        <s:a href="%{deleteUrl}">Delete</s:a>
                    </display:column>
                </display:table>
            </article>
        </section>
        <aside class="sidebar">
            <ul>
                <li>
                    <h4>Pages</h4>
                    <ul>
                        <li><a href="index.jsp">Home Page</a></li>
                        <li><a href="<s:property value="#helloURL"/>">Hello World!</a></li>
                        <li><a href="<s:property value="#crud"/>">Basic CRUD Example</a></li>
                    </ul>
                </li>

            </ul>

        </aside>
        <div class="clear"></div>
    </div>
    <footer>
        <div class="footer-content width">
            <ul>
                <li><h4>Pages</h4></li>
                <li><a href="index.jsp">Home Page</a></li>
                <li><a href="<s:property value="#helloURL"/>">Hello World!</a></li>
                <li><a href="<s:property value="#crud"/>">Basic CRUD Example</a></li>
            </ul>

            <ul>
                <li><h4>Test Applications</h4></li>
                <li><a href="http://www.mypitech.com:8080/angularjs/" target="_blank">Angular JS &#38; REST API</a></li>
                <li><a href="http://www.shawnsoft.com/cfSimpleApplication/" target="_blank">ColdFusion 11</a></li>
                <li><a href="http://www.mypitech.com:8080/jsf2/" target="_blank">JSF 2</a></li>
                <li><a href="http://www.mypitech.com:8080/wicket6/" target="_blank">Wicket 6</a></li>
            </ul>

            <ul class="endfooter">
                <li><h4>Code Repositories</h4></li>
                <li><a href="https://github.com/MyPiTech/experior/tree/master/angularjs" target="_blank">Angular JS</a></li>
                <li><a href="https://github.com/MyPiTech/experior/tree/master/coldfusion11" target="_blank">ColdFusion 11</a></li>
                <li><a href="https://github.com/MyPiTech/experior/tree/master/jsf2" target="_blank">JSF 2</a></li>
                <li><a href="https://github.com/MyPiTech/experior/tree/master/rest_api" target="_blank">REST API</a></li>
                <li><a href="https://github.com/MyPiTech/experior/tree/master/struts2" target="_blank">Struts 2</a></li>
                <li><a href="https://github.com/MyPiTech/experior/tree/master/wicket6" target="_blank">Wicket 6</a></li>
            </ul>>

            <div class="clear"></div>
        </div>
        <div class="footer-bottom">
            <p>&copy; MyPiTech 2014 - <a href="http://zypopwebtemplates.com/" target="_blank">Free CSS Website Templates</a> by ZyPOP</p>
        </div>
    </footer>
</div>
</body>
</html>



<%--<style type="text/css">

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
</style>--%>
