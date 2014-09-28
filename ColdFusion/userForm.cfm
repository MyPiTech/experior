<!DOCTYPE html>
    <cfparam name = "user.name" default="">
    <cfparam name = "user.description" default="">
    <cfparam name = "user.identity" default="">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>ColdFusion Simple Application</title>
    <link rel="stylesheet" href="css/styles.css" type="text/css" />
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />
</head>
<body>
<div id="container">
    <cfinclude template ="panels/header.cfm">
    <nav>
        <div class="width">
            <ul>
                <li class="start"><a href="index.cfm">Home</a></li>
                <li class=""><a href="helloWorldForm.cfm">Hello World</a></li>
                <li class="end selected"><a href="##">CRUD</a></li>
            </ul>
        </div>
    </nav>
    <div id="body" class="width">
        <section id="content">
            <article>
                <cfif structKeyExists(URL, "action") and URL.Action eq "update">
                    <h2>Update User</h2>
                    <cfquery name="user" datasource="#Request["DSN"]#">
                        SELECT identity, name, description FROM experior.test_user WHERE identity = <cfqueryparam value="#URL.identity#" cfsqltype="CF_SQL_VARCHAR" maxlength="36">
                    </cfquery>
                    <cfset postUrl = "userList.cfm?action=update&identity=#user.identity#">
                <cfelse>
                        <h2>Create User</h2>
                    <cfset postUrl = "userList.cfm?action=create">
                </cfif>


                <a class="button" style="margin-bottom:20px;margin-top:10px;" href="userList.cfm">Return To User List</a><br>
                <cfoutput>
                <form action="#postUrl#" method="post">
                    <table>
                        <tr>
                            <td><label for="name" class="label">Name:</label></td>
                            <td><input type="text" name="name" id="name" value="#user.name#"/></td>
                        </tr>
                        <tr>
                            <td><label for="desc" class="label">Description:</label></td>
                            <td><textarea name="description" cols="30" rows="3" id="desc">#user.description#</textarea></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div align="right">
                                    <cfif structKeyExists(URL, "action") and URL.Action eq "update">
                                            <input type="submit" value="Update"/>
                                    <cfelse>
                                            <input type="submit" value="Create"/>
                                    </cfif>
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
                </cfoutput>
            </article>
        </section>
        <cfinclude template ="panels/sidebar.cfm">
        <div class="clear"></div>
    </div>
    <cfinclude template ="panels/footer.cfm">
</div>
</body>
</html>
