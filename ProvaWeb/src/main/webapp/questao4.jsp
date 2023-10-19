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
String nome = request.getParameter("nome");
int idade = Integer.parseInt(request.getParameter("idade"));


String mensagem ="";

if(idade >= 18 ){
	mensagem = nome+" "+"é maior de idade. Autorização dada para realizar compras parceladas.";
}else if(idade <18 ){
	mensagem = nome+" "+"tem"+" "+idade+ "é um cliente menor de idade. Compras apenas a vista.";
}
%>

<p>Nome do(a) cliente : <%=nome %> </p>
<p>Idade : <%=idade %> </p>
<p><%=mensagem %> </p>
</body>
</html>