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
        
        <nav class="navbar navbar-inverse">
            <form class="navbar-form navbar-right" id="login" method="POST" action="#">
                <input type="email" class="form-control input-sm" name="email" placeholder="E-mail">
                <input type="password" class="form-control input-sm" name="password" placeholder="Password">
                <button type="submit" class="btn btn-danger btn-sm">Login</button>
                <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#register">Register</button>&nbsp;&nbsp;
            </form>
        </nav>
    
        <div id="register" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Register Now!</h4>
                    </div>
                    
                    <div class="modal-body">
                        <p>TBA</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                    
                </div>
            </div>
        </div>
    
        <div class ="container-fluid vcenter" align="center">
            <a href="index.htm"><img src ="assets/img/banner.png"/></a>
            <form method="POST" action="search.htm">
                <div class="col-lg-4 col-lg-offset-4">
                    <input type="text" class="form-control" name="query" placeholder="Job title or keywords "><br>
                    <input type="text" class="form-control" name="location" placeholder="Location"><br>
                        Days:&nbsp;<input type="number" name="days" min="1" max="45" value="1">&nbsp;
                        Radius:&nbsp;<input type="number" name="radius" min="5" max="100" value="25"><br><br>
                    <button type="submit" class="btn-lg btn-info">Search</button>
                </div>
            </form>
        </div>
    
        
    
        <footer class="footer">
            <div class="container">
                <p class="text-muted" align='center'>
                    By Sam W. 2015 &nbsp;
                    <a href="https://github.com/wngsam/Career-Hunter">GitHub</a> &nbsp Alpha 2
                </p>
            </div>
        </footer>
    
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
    </body>
</html>
