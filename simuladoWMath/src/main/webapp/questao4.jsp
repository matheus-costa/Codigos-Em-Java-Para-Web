<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <% 
      String numero = request.getParameter("num");
      int num = Integer.parseInt(numero);
      int dobro=num*2;
      %>

      
      <p> 0 dobro de <%=num %> é <%= dobro %>.</p>


</body>
</html>