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
                <li class="start selected"><a href="##">Home</a></li>
                <li class=""><a href="helloWorldForm.cfm">Hello World</a></li>
                <li class="end"><a href="userList.cfm">CRUD</a></li>
            </ul>
        </div>
    </nav>
    <div id="body" class="width">
        <section id="content">
            <article>
                <h2>ColdFusion Simple Application</h2>
                <p>This application is a ColdFusion proof of concept. It includes a 'hello world', and basic CRUD logic. Check out the source code, or other test projects by clicking on the links below. Thanks for visiting!</p>
            </article>
        </section>
        <cfinclude template ="panels/sidebar.cfm">
        <div class="clear"></div>
    </div>
    <cfinclude template ="panels/footer.cfm">
</div>
</body>
</html>
