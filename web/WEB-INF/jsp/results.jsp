<%-- 
    Document   : results
    Created on : Aug 5, 2015, 11:49:14 AM
    Author     : Desktop
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="icon" href="assets/img/favicon.ico">
        <title>CareerHunter</title>

        <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
        <c:if test="${jobs.isEmpty()==true}">Empty!</c:if>
        <c:forEach var="job" items="${jobs}" varStatus="count">
            ${job.title}<br>
            ${job.company}<br>
            &nbsp;&nbsp;X ${job.website}<br>
            &nbsp;&nbsp;X ${job.industry}<br>
            &nbsp;&nbsp;X ${job.numberOfRatings}<br>
            <img src="${job.squareLogo}"/><br>
            &nbsp;&nbsp;X ${job.overallRating}<br>
            ${job.country}<br>
            ${job.location}<br>
            ${job.source}<br>
            ${job.date}<br>
            ${job.snippet}<br>
            <a href="${job.url}">Apply!</a><br>
            ${job.relativeTime}<br>
            -------------------<br>
        </c:forEach>
            
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
    </body>
</html>
