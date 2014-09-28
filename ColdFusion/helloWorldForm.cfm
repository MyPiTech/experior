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
                <li class="selected"><a href="##">Hello World</a></li>
                <li class="end"><a href="userList.cfm">CRUD</a></li>
            </ul>
        </div>
    </nav>
    <div id="body" class="width">
        <section id="content">
            <article>
                    <form action="helloWorldConfirm.cfm" method="post">
                        <table>
                            <tr>
                                <td><label for="nameInput" class="label">Name:</label></td>
                                <td><input type="text" value="" id="nameInput" name="nameInput"/></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <div align="right"><input type="submit"  value="Submit"/></div>
                                </td>
                            </tr>
                        </table>
                    </form>
            </article>
        </section>
        <cfinclude template ="panels/sidebar.cfm">
        <div class="clear"></div>
    </div>
    <cfinclude template ="panels/footer.cfm">
</div>
</body>
</html>
