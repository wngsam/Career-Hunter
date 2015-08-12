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
                        <table>
                            <tr>
                                <td>
                                    <a href="https://${job.company.url}"><img src ="${job.company.logo}" height="75" width="75"/></a>
                                </td>
                                <td width="70%">
                                    ${job.company.name}<br>
                                    ${job.company.url}<br>
                                    Industry:&nbsp;${job.company.industry}<br>
                                    Total Ratings:&nbsp;${job.company.totalRatings}&nbsp;Overall Score:&nbsp;
                                    <button type="button" class="btn-sm btn-info" data-toggle="popover" data-html="true" data-placement="right" 
                                            title="Ratings"
                                            data-content="
                                            Culture & Values:&nbsp;${job.company.culturalRating}/5<br>
                                            Work/Life Balance:&nbsp;${job.company.balanceRating}/5<br>
                                            Senior Management:&nbsp;${job.company.leadershipRating}/5<br>
                                            Comp & Benefits:&nbsp;${job.company.benefitsRating}/5<br>
                                            Career Opportunities:&nbsp;${job.company.careerRating}/5<br>
                                            Recommend To A Friend:&nbsp;${job.company.recommendRating}%<br>
                                            " 
                                            >${job.company.overallRating}
                                    </button><br>
                                    Verdict:&nbsp;${job.company.ratingDescription}
                                </td>
                            </tr>
                        </table>
                               
                        <div align="right">
                            Location: ${job.location}&nbsp;(${job.country})<br>
                            <i>Posted: ${job.relativeTime}</i><br>
                            By: ${job.source}<br><br>
                        </div>
                        <p>${job.snippet}&nbsp;&nbsp;<button type="button" class="btn-xs btn-default"><a href="${job.url}">More</a></button></p><br>
                        <hr>
                        <div class="container">
                            <div class="row">
                                <div class="col-xs-6">
                                    Featured Review<br>
                                    ${job.company.review.headline}<br><br>
                                    <table>
                                        <tr>
                                            <td width="50%">
                                                Title:&nbsp;${job.company.review.jobTitle}<br>
                                                <i>${job.company.review.location}</i><br>
                                            </td>
                                            <td>
                                                Date:&nbsp;${job.company.review.time}<br>
                                                Current&nbsp;Job?&nbsp;${job.company.review.currentJob}<br>
                                                Score:&nbsp;${job.company.review.overall}<br>
                                            </td>
                                        </tr>
                                    </table><br>
                                    Pros:<br>${job.company.review.pros}<br><br>
                                    Cons:<br>${job.company.review.cons}<br>
                                </div>
                                <div class="col-xs-6">
                                    Chief Executive Officer<br>
                                    <img src="${job.company.ceo.image}" height="100" width="100" /><br>
                                    ${job.company.ceo.name}<br>
                                    ${job.company.ceo.title}<br>
                                    Ratings:&nbsp;${job.company.ceo.numOfRatings}<br>
                                    Approval:&nbsp;${job.company.ceo.approval}%<br>
                                </div>
                            </div>
                        </div><br>
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
