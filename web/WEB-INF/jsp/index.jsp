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
            
        <div class ="container-fluid" align="center">
            <a href="index.htm"><img src ="assets/img/banner.png"/></a>
            <form method="POST" action="search.htm">
                <div class="col-lg-4 col-lg-offset-4">
                    <input type="text" class="form-control" name="query" placeholder="Job title or keywords ">
                    <input type="text" class="form-control" name="location" placeholder="Location"><br>
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </form>
        </div>
        
        <footer class="footer">
            <div class="container">
                <p class="text-muted" align='center'>
                    By Sam W. 2015 &nbsp;
                    <a href="https://github.com/wngsam/Career-Hunter">GitHub</a> &nbsp Alpha 1
                </p>
            </div>
        </footer>
    
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
    </body>
</html>
