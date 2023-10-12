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
    int mes = Integer.parseInt(request.getParameter("mes"));
    int dia = Integer.parseInt(request.getParameter("dia"));
    int ano = Integer.parseInt(request.getParameter("ano"));
    String pais = request.getParameter("pais");
	%>
<p> Data:<%=mes%>/<%=dia%>/<%=ano%>/<%=pais%> </p>


</body>
</html>