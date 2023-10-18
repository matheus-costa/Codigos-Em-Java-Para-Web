<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p><strong>Nome:</strong><${param.nome}</p>
<p><strong>Sobrenome2:</strong><${param.sobrenome}</p>

<c:if test= "param.nome.equals('fulano'))">
  <u>${param.nome}</u>
</c:if> 

</body>
</html>