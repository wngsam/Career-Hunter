<%-- 
    Document   : results
    Created on : Aug 5, 2015, 11:49:14 AM
    Author     : Sam W.
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
        <title>Career Hunter</title>

        <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css">
        <link href="assets/css/main.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
        <div class='container-fluid whitebg'>
            <center>
                <c:if test="${jobs.isEmpty()==true}"><a href="index.htm" align="center">No jobs found, try again!</a></c:if>
            </center>
            
            <div class="row col-lg-8 col-lg-offset-2">
            <c:forEach var="job" items="${jobs}">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">${job.title}</h3>
                    </div>
                    <div class="panel-body">
                        <button type="button" class="btn-sm btn-info" data-toggle="popover" data-html="true" data-placement="right" 
                                title="<a href='https://${job.website}'>${job.company}</a>"
                                data-content="
                                <img src='${job.squareLogo}'/><br>
                                Industry: ${job.industry}<br>
                                Stars: ${job.overallRating}/5<br>
                                Ratings: ${job.numberOfRatings}<br>
                                " 
                                >${job.company}
                        </button><br>
                        <div align="right">
                            Location: ${job.location}&nbsp;(${job.country})<br>
                            <i>Posted: ${job.relativeTime}</i><br><br>
                        </div>
                        <p>${job.snippet}</p><br>
                        <center><button type="button" class="btn btn-default"><a href="${job.url}">Apply</a></button></center>
                    </div>
                </div>
            </c:forEach>
                
            <ul class="pager">
                <li class="previous disabled"><a href="#">← Older</a></li>
                <li class="next"><a href="#">Newer →</a></li>
            </ul>
            </div>
        </div>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function(){
                $('[data-toggle="popover"]').popover();
            });
        </script>
    </body>
</html>
