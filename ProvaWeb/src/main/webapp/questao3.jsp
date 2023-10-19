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
int numero1 = Integer.parseInt(request.getParameter("numero1"));
int numero2 = Integer.parseInt(request.getParameter("numero2"));

String mensagem ="";

if(numero1 == numero2 ){
	mensagem = "Os números são o:"+numero1+ " "+"são iguais";
}
%>
<p>Numero 1: <%= numero1%></p>
<p>Numero 2: <%= numero2 %></p>
<p>Multiplicação: <%= numero1*numero2 %></p>
<p>Divisão: <%= numero1/numero2 %></p>
<p>Divisão: <%= numero1/numero2 %></p>
<p><%=mensagem %> </p>
</body>
</html>