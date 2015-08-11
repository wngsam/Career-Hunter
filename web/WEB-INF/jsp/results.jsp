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
        
        <jsp:include page="navbar.jsp" />
        
        <div class='container-fluid whitebg'>
            <center>
                <c:if test="${jobs.isEmpty()}"><a href="index.htm" align="center">No jobs found, try again!</a></c:if>
            </center>
            
            <div class="row col-lg-8 col-lg-offset-2">
                
            <c:forEach var="job" items="${jobs}">
                
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">${job.title}</h3>
                    </div>
                    <div class="panel-body">
                        <button type="button" class="btn-sm btn-info" data-toggle="popover" data-html="true" data-placement="right" 
                                title="MODAL TITLE"
                                data-content="
                                MODAL CONTENT
                                " 
                                >BUTTON NAME
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
                <li class="previous disabled" id="prev"><a href="prev.htm">← Prev</a></li>
                <li class="next" id="next"><a href="next.htm">Next →</a></li>
            </ul>
            </div>
        </div>
        
        <script>
            $(document).ready(function(){
                $('[data-toggle="popover"]').popover();
                if(${canPrev}){
                    $("#prev").removeClass("disabled");
                }
                if(${jobs.isEmpty()}){
                    $("#next").addClass("disabled");
                }
            });
        </script>
    </body>
</html>
