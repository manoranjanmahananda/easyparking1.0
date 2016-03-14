<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
    <div align="center">
        <form:form action="booking.html" method="post" commandName="bookingForm">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Procede for Booking!!!!</h2></td>
                </tr>
                <tr>
                    <td>Vehicle No:</td>
                    <td><form:input path="vehicleNo" /></td>
                </tr>
                
                <tr>
                    <td>Time-In:</td>
                    <td><form:input path="timeIn" /></td>
                </tr>
                <tr>
                    <td>Time-Out:</td>
                    <td><form:input path="timeOut" /></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><form:input type="hidden" path="parkingId" /></td>
                </tr>
               
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Book" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>