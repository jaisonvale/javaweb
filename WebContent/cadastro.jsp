<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import ="java.util.*, java.util.Calendar.*, java.util.Date, java.text.SimpleDateFormat, java.text.ParseException, javaweb.*
    ,javax.servlet.ServletException,
javax.servlet.annotation.WebServlet,
javax.servlet.http.HttpServlet,
javax.servlet.http.HttpServletRequest,
javax.servlet.http.HttpServletResponse"
    %>
    
<!DOCTYPE html>
<html>
<head>

<title>Cadastro</title>
<link href="css\estilo.css" rel="stylesheet" type="text/css">
<link href="../bootstrap/css/" rel="stylesheet" type="text/css">
</head>
<body>
<div class="top">
		<ul>
			<li class="aba"><a href="#">Inicio</a></li>
			<li class="aba"><a href="#">Estoque</a></li>
			<li class="aba"><a href="#">Fonecedores</a></li>
			<li class="aba"><a href="cadastro.html">Clientes</a></li>
			<li class="aba"><a href="#">Contatos</a></li>

		</ul>
	</div>
	<div>
	<div class="principal"><h1>SISTEMA DE CADASTRO DE CLINETE</h1></div>
<div class="bloco">
<form	action="#" method="post">
				
						Nome:	<input	class="box" type="text"	name="nome"	/><br	/>																				
						E-mail:	<input	class="box" type="text"	name="email"	/><br	/>																				
						Endereço:	<input	class="box" type="text"	name="endereco"	/><br	/>																				
						Data Nascimento:	<input	class="box" type="text"	name="dataNascimento"	/><br	/>
																				
				<input	class="bnt" type="submit"	value="Gravar"	/>
				<input class="bnt" type="submit" value="Delete">																
				</form>
				</div>
</div>
<% 
String nome = request.getParameter("nome");
String email = request.getParameter("email");
String endereco = request.getParameter("endereco");
String dataText = request.getParameter("dataNascimento");



%>

<%
Contato contato = new Contato();
ContatoDao dao = new ContatoDao();

if (nome != null && nome != ""){
contato.setNome(nome);
contato.setEmail(email);
contato.setEndereco(endereco);
contato.setDataNascimento(null);

dao.adiciona(contato);
}
%>

<h4 align="center">RELATORIO DE DADOS CADASTRADOS</h4>
<hr>

<% 
	List<Contato>	contatos	=	dao.getLista();
	%>
	<% 			if (contato.getNome() != null && contato.getNome() != "") {%>
	
					<%for	(Contato	contato1	:	contatos	)	{%>							
							
							<div class="container"> 
							   <div class="row"> 
							   <div class="span1"><%=contato1.getNome()%></div> 
							   <div class="span1"><%=contato1.getEmail()%></div>
							   <div class="span1"><%=contato1.getEndereco()%></div> 
							   </div> <!-- /.row --> </div> <!-- /.container -->
							
				<%}%>  
				<% }%>

</body>
</html>