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
	<div align="right">
		<p align="right">Welcome <%=session.getAttribute("username")%></p>
		<a href="${pageContext.request.contextPath}/logout">Logout</a>
	</div>
	<h3>View Merchant Data</h3>
    <p style="color: red;">${errorString}</p>

    <table border="1" cellpadding="5" cellspacing="1" id="merchantTable">
    	<thead>
	       <tr>
	          <th>Name</th>
	          <th>Type</th>
	          <th>Range</th>
	          <th>Country</th>
	       </tr>
	    </thead>
	    <tbody id="merchantDataBody">
       <c:forEach items="${merchantDataList}" var="merchantDataList" >
          <tr>
             <td>${merchantDataList.name}</td>
             <td>${merchantDataList.type}</td>
             <td>${merchantDataList.range}</td>
             <td>${merchantDataList.country}</td>
          </tr>
       </c:forEach>
        </tbody>
    </table>

 </body>
 <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/fixedcolumns/3.2.2/js/dataTables.fixedColumns.min.js"></script>
 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
 <script type="text/javascript">
	$(document).ready(function () {
	    // Setup - add a text input to each footer cell
	    $('#merchantTable thead tr')
	        .clone(true)
	        .addClass('filters')
	        .appendTo('#merchantTable thead');
	 
	    var table = $('#merchantTable').DataTable({
	        orderCellsTop: true,
	        fixedHeader: true,
	        initComplete: function () {
	            var api = this.api();
	 
	            // For each column
	            api.columns()
	                .eq(0)
	                .each(function (colIdx) {
	                    // Set the header cell to contain the input element
	                    var cell = $('.filters th').eq(
	                        $(api.column(colIdx).header()).index()
	                    );
	                    var title = $(cell).text();
	                    $(cell).html('<input type="text" placeholder="' + title + '" />');
	 
	                    // On every keypress in this input
	                    $(
	                        'input',
	                        $('.filters th').eq($(api.column(colIdx).header()).index())
	                    )
	                        .off('keyup change')
	                        .on('keyup change', function (e) {
	                            e.stopPropagation();
	 
	                            // Get the search value
	                            $(this).attr('title', $(this).val());
	                            var regexr = '({search})'; //$(this).parents('th').find('select').val();
	 
	                            var cursorPosition = this.selectionStart;
	                            // Search the column for that value
	                            api
	                                .column(colIdx)
	                                .search(
	                                    this.value != ''
	                                        ? regexr.replace('{search}', '(((' + this.value + ')))')
	                                        : '',
	                                    this.value != '',
	                                    this.value == ''
	                                )
	                                .draw();
	 
	                            $(this)
	                                .focus()[0]
	                                .setSelectionRange(cursorPosition, cursorPosition);
	                        });
	                });
	        },
	    });
	});
 </script>
</html>