<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
   
  
        <h1>Edit Employee</h1>  
       <form:form method="POST" action="/EmployeeManagement/editsave">    
        <table>
         <c:forEach var="emp" items="${editDetails}"> 
        <tr>  
           
           
         <td>Id:<input type="text" name ="id" value="${emp.id}"/></td>
         </tr>   
         <tr>    
          <td>Name : <input type="text" name ="name" value="${emp.name}"/></td>   
           
         </tr>    
         <tr>    
          <td>Salary :<input type="text" name ="salary" value="${emp.salary}"/></td>    
           
         </tr>   
         <tr>    
          <td>Designation : <input type="text" name ="designation" value="${emp.designation}"/></td>    
         
         </tr>   
           
         <tr>    
           
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
         </c:forEach> 
        </table>    
       </form:form>    
</body>
</html>