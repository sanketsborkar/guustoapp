<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Login</title>
   </head>
    <style>
	 	.div-1 {
	      background-color: #0000FF;
	    }
	    .imaging {
	      height: 100%;
	      max-width: 11%;
	    }
 	</style>
   <body>
	  <div class="div-1"><p style="color:white; font-size:20px;">Guusto</p></div>
      <h3>Login Page</h3>
      <p style="color: red;">${errorString}</p>

      <form method="POST" action="${pageContext.request.contextPath}/login">
         <table style="border-spacing: 0 15px;">
            <tr>
               <td>User Name</td>
               <td><input type="text" name="userName" value= "${user.userName}" required/> </td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type="password" name="password" value= "${user.password}" required/> </td>
            </tr>
            <tr>
               <td>Remember me</td>
               <td><input type="checkbox" name="rememberMe" value= "Y" /> </td>
            </tr>
            <tr>
               <td>
                  <input type="submit" value= "Submit" />
               </td>
               <td>
               	  <input type="reset" value="Cancel">
               </td>
            </tr>
         </table>
      </form>
   </body>
</html>