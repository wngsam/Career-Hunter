<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="icon" href="assets/img/favicon.ico">
        <title>Career Hunter</title>

        <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="assets/css/main.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
        <jsp:include page="navbar.jsp" />
    
        <div class ="container-fluid" align="center">
            <br>
            <div class="col-lg-4 col-lg-offset-4">
                <a href="index.htm"><img src ="assets/img/banner.png"/></a><br>
                By Sam W. 2015 &nbsp;
                <a href="https://github.com/wngsam/Career-Hunter">GitHub</a> &nbsp Alpha 2.5<br><br>
                
                <form method="POST" action="search.htm">
                    <input type="text" class="form-control" name="query" placeholder="Job title or keywords "><br>
                    <input type="text" class="form-control" name="location" placeholder="Location"><br>
                    Days:&nbsp;<input type="number" name="days" min="1" max="45" value="1">&nbsp;
                    Miles:&nbsp;<input type="number" name="radius" min="5" max="100" value="25"><br><br>
                    <button type="submit" class="btn btn-info">Search</button>
                </form>
            </div>
        </div>
    
        
    </body>
</html>
