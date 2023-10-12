<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Venda Registrada com sucesso:</title>
</head>
<body>
<%
  String cliente = request.getParameter("nomeCliente");


%>
	
	<b>Cliente:</b> <%=cliente%> 
	<br />
	<br /> 
    <b>E-mail:</b>
    <br />
    <br />
    <b>Produto:</b> 
	<br /> 
	<br />
    <b>Forma Pagemento:</b>
    <br /> 
    <br />
    <b>Total de venda:</b>
    <br /> 
    <br />
    <p>status</p>
    <br />
    <br />
    <a href="listarVendasPagDigitalServlet">Lista de Vendas com pagamento digital</a>
</body>
</html>