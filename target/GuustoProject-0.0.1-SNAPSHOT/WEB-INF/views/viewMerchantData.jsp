<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>View Merchant Data</title>
 </head>
 <style>
 	.div-1 {
      background-color: #0000FF;
    }
    .imaging {
      height: 100%;
    }
 </style>
 <body>
	<div class="div-1"><p style="color:white; font-size:20px;" >Guusto</p></div>
    <h3>View Merchant Data</h3>

    <p style="color: red;">${errorString}</p>

    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>Name</th>
          <th>Type</th>
          <th>Range</th>
          <th>Country</th>
       </tr>
       <c:forEach items="${merchantDataList}" var="merchantDataList" >
          <tr>
             <td>${merchantDataList.name}</td>
             <td>${merchantDataList.type}</td>
             <td>${merchantDataList.range}</td>
             <td>${merchantDataList.country}</td>
          </tr>
       </c:forEach>
    </table>

 </body>
</html>