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
    String mensagem ="";
    
    if(mes == 12 ){
    	mensagem = "Falta pouco para o ano novo";
    }
	%>
<p> o mes é: <%=mes%> </p>
<b><%=mensagem %> </b>

	


</body>
</html>