<!DOCTYPE html>
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
            <cfif structKeyExists(URL, "action") and URL.Action eq "delete">
                <cfquery name="users" datasource="#Request["DSN"]#">
                       DELETE FROM experior.test_user WHERE identity =
                       <cfqueryparam value="#URL.identity#" cfsqltype="CF_SQL_BIGINT" maxlength="36">
                </cfquery>
            <cfelseif structKeyExists(URL, "action") and URL.Action eq "update">
                <cfquery datasource="#Request["DSN"]#">
                       UPDATE experior.test_user
                       SET name = <cfqueryparam value="#Form.name#" cfsqltype="CF_SQL_VARCHAR" maxlength="45">,
                       description = <cfqueryparam value="#Form.description#" cfsqltype="CF_SQL_VARCHAR" maxlength="100">
                       WHERE identity =
                       <cfqueryparam value="#URL.identity#" cfsqltype="CF_SQL_BIGINT" maxlength="36">
                </cfquery>

            <cfelseif structKeyExists(URL, "action") and URL.Action eq "create">
                <cfquery datasource="#Request["DSN"]#">
                       INSERT INTO experior.test_user (name, description) VALUES (
                       <cfqueryparam value="#Form.name#" cfsqltype="CF_SQL_VARCHAR" maxlength="45">,
                       <cfqueryparam value="#Form.description#" cfsqltype="CF_SQL_VARCHAR" maxlength="100">
                       )
                </cfquery>
            </cfif>
            <cfquery name="users" datasource="#Request["DSN"]#">
                SELECT identity, name, description FROM experior.test_user ORDER BY name
            </cfquery>
            <article>
                <h2>User List</h2>
                <a class="button" style="margin-top:10px;" href="userForm.cfm?action=create">Create New User</a><br>
                <table cellspacing="5px;" style="margin-top:20px;" id="userTable" cellpadding="5px;">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <cfloop query = "users">
                        <tr>
                            <td><cfoutput>#name#</cfoutput></td>
                            <td><cfoutput>#description#</cfoutput></td>
                            <td><cfoutput><a href="userForm.cfm?action=update&identity=#identity#">Update</a></cfoutput></td>
                            <td><cfoutput><a href="userList.cfm?action=delete&identity=#identity#">Delete</a></cfoutput></td>
                        </tr>
                    </cfloop>
                    </tbody>
                </table>
            </article>
        </section>
        <cfinclude template ="panels/sidebar.cfm">
        <div class="clear"></div>
    </div>
    <cfinclude template ="panels/footer.cfm">
</div>
</body>
</html>
