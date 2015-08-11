<%-- 
    Document   : header
    Created on : Aug 11, 2015, 6:24:52 PM
    Author     : Sam W.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-inverse">
    <a class="navbar-brand" href="index.htm">Home</a>
    <div class="navbar-form navbar-right" id="login"></div>
</nav>

<div class="col-lg-8 col-lg-offset-2">
    <c:if test="${login==false}">
        <div class="alert alert-dismissible alert-danger">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <strong>Wrong password or account does not exist.</strong>
        </div>
    </c:if>

    <c:if test="${register==false}">
        <div class="alert alert-dismissible alert-danger">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <strong>Email already exists!</strong>
        </div>
    </c:if>

    <c:if test="${register==true}">
        <div class="alert alert-dismissible alert-success">
            <button type="button" class="close" data-dismiss="alert">×</button>
            <strong>Registration Complete! Please try logging in.</strong>
        </div>
    </c:if>
</div>

<div id="register" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Register Now!</h4>
            </div>
            <div class="modal-body">
                <form method="POST" action="register.htm">
                    <input type="email" class="form-control input-sm" name="email" placeholder="E-mail">
                    <input type="password" class="form-control input-sm" name="password" placeholder="Password">
                    <button type="submit" class="btn btn-danger btn-success">Register</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var login = $('#login');
        if (${not empty currentUser}) {
            login.html('<a href="logout.htm"><button type="button" class="btn btn-danger btn-sm">Logout</button></a>&nbsp;&nbsp;');
        } else {
            login.html('\
                    <form method="POST" action="login.htm">\n\
                    <input type="email" class="form-control input-sm" name="email" placeholder="E-mail">\n\
                    <input type="password" class="form-control input-sm" name="password" placeholder="Password">\n\
                    <button type="submit" class="btn btn-danger btn-sm">Login</button>\n\
                    <button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#register">Register</button>&nbsp;&nbsp;\n\
                    </form>');
        }
    });
</script>