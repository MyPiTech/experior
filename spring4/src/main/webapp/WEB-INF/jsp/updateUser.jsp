<%--
  ~ Copyright (c) 2014. Shawn Wheeler. All rights reserved.
  --%>

<%--
    Created by Shawn Wheeler on 9/02/2014.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url var="home" value="/home"/>
<c:url var="hello" value="/helloWorldForm" />
<c:url var="crud" value="/listUsers" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Spring MVC 4/JSTL Simple Application</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>" type="text/css" />
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
</head>
<body>
<div id="container">
    <header>
        <div class="width">
            <h1><a href="${home}">Spring MVC 4/JSTL Simple Application</a></h1>
        </div>
    </header>
    <nav>
        <div class="width">
            <ul>
                <li class="start"><a href="${home}">Home</a></li>
                <li class=""><a href="${hello}">Hello World</a></li>
                <li class="end selected"><a href="#">CRUD</a></li>
            </ul>
        </div>
    </nav>
    <div id="body" class="width">
        <section id="content">
            <article>
                <h2>${headerText}</h2>
                <a href="${crud}" class="button">Return To User List</a><br/>
                <form:form commandName="userForm" method="POST">
                    <table>
                        <tr>
                            <td><form:label path="name" class="label">Name:</form:label></td>
                            <td><form:input path="name"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="description" class="label">Description:</form:label></td>
                            <td><form:textarea cols="30" rows="3" path="description"/></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div align="right"><input type="submit" id="user" value="${buttonText}"/> </div>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </article>
        </section>
        <aside class="sidebar">
            <ul>
                <li>
                    <h4>Pages</h4>
                    <ul>
                        <li><a href="${home}">Home Page</a></li>
                        <li><a href="${hello}">Hello World!</a></li>
                        <li><a href="#">Basic CRUD Example</a></li>
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
                <li><a href="${home}">Home Page</a></li>
                <li><a href="${hello}">Hello World!</a></li>
                <li><a href="#">Basic CRUD Example</a></li>
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
            </ul>

            <div class="clear"></div>
        </div>
        <div class="footer-bottom">
            <p>&copy; MyPiTech 2014 - <a href="http://zypopwebtemplates.com/" target="_blank">Free CSS Website Templates</a> by ZyPOP</p>
        </div>
    </footer>
</div>
</body>
</html>

