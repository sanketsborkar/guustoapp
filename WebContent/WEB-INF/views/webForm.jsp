<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Submit Web Form</title>
   </head>
   <script type="text/javascript">
		function CheckColors(val){
		 var element = document.getElementById('carrierText').parentElement.parentElement;
		 if(val=='Other')
		   element.style.display='contents';
		 else  
		   element.style.display='none';
		}
	</script>
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
   	  <div class="div-1"><p style="color:white; font-size:20px;">GTA Phones</p></div>
      <h3>Enter your details</h3>
      
      <p style="color: red;">${errorString}</p>
      
      <form method="POST" action="${pageContext.request.contextPath}/submitTelusData">
         <table style="border-spacing: 0 15px;">
            <tr>
               <td>First Name*</td>
               <td><input type="text" name="firstName" value="${webForm.firstName}" maxlength="50" required/></td>
            </tr>
            <tr>
               <td>Last Name*</td>
               <td><input type="text" name="lastName" value="${webForm.lastName}" maxlength="50" required/></td>
            </tr>
            <tr>
               <td>Business Name*</td>
               <td><input type="text" name="businessName" value="${webForm.businessName}" required/></td>
            </tr>
            <tr>
               <td>Email Address*</td>
               <td><input type="email" name="emailAddress" value="${webForm.emailAddress}" required/></td>
            </tr>
            <tr>
               <td>Address*</td>
               <td><input type="text" name="address" value="${webForm.address}" maxlength="100" required/></td>
            </tr>
            <tr>
               <td>City*</td>
               <td><input type="text" name="city" value="${webForm.city}" required/></td>
            </tr>
            <tr>
               <td>Province*</td>
               <td><input type="text" name="province" value="${webForm.province}" required/></td>
            </tr>
            <tr>
               <td>Postal Code*</td>
               <td><input type="text" name="postalCode" value="${webForm.postalCode}" pattern="[A-Za-z][0-9][A-Za-z] [0-9][A-Za-z][0-9]" maxlength="7" required/></td>
            </tr>
            <tr>
               <td>Phone Number*</td>
               <td><input type="tel" name="phoneNumber" value="${webForm.phoneNumber}" pattern="[0-9]{10}" maxlength="10" required/></td>
            </tr>
            <tr>
               <td>Date of Birth*</td>
               <td><input type="date" name="dateOfBirth" value="${webForm.dateOfBirth}" min="1900-01-01" max="2022-01-01" required/></td>
            </tr>
            <tr>
               <td>Type of carrier*</td>
               <td>
	                <select name="carrier" id="carrier" onchange='CheckColors(this.value);'>
					  <option value="" disabled selected>Please select</option>
					  <option value="Rogers">Rogers</option>
					  <option value="Bell">Bell</option>
					  <option value="Telus">Telus</option>
					  <option value="Fido">Fido</option>
					  <option value="Virgin">Virgin</option>
					  <option value="Koodo">Koodo</option>
					  <option value="Chatr">Chatr</option>
					  <option value="Freedom">Freedom</option>
					  <option value="Lucky Mobile">Lucky Mobile</option>
					  <option value="Public Mobile">Public Mobile</option>
					  <option value="Other">Other</option>
					</select>
				</td>
            </tr>
            <tr style='display:none;'>
               <td>Enter carrier*</td>
               <td>
	                <input type="text" name="carrierText" id="carrierText" />
				</td>
            </tr>
            <tr>
               <td>                   
                   	<input type="submit" value="Submit" />
               </td>
               <td>
               		<input type="reset" value="Cancel">
               </td>
            </tr>
         </table>
      </form>
      
   </body>
</html>