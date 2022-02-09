<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pimpolhos ADM</title>
<link rel="stylesheet" href="style.css" type="text/css">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
 <nav class="navbar navbar-expand-lg navbar-light ">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Pimpolhos</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">

            </div>
        </div>
    </nav>

    <div class="row bodyRow" style="justify-content:space-around;">
        <div class="col-2 navLateral">
            <ul class="navbar-nav menuLateralTab">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="#">Clientes</a>
                </li>
                <hr>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="#">Clientes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Categorias</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Produtos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Fornecedores</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pedidos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Marcas</a>
                </li>
            </ul>
        </div>
        
        
        
        
        <div class="col-9 conteudo">
            <form action="ServletPimpolhos" method="post">



         <c:choose>
			<c:when test="${ usuario == null }">
			<div class="container mt-5 col-6" style="outline: 1px solid #d5d5d5; border-radius: 11px; padding: 16px;">
				<label style="margin-right: 17px;">Nome:</label><input type="text" name="nome" required/><br>
				<label style="margin-right: 23px;">CPF:</label><input type="text" name="cpf"/><br>
				<label style="margin-right: 32px;">Email:</label><input type="text" name="email"/><br>
			    <label style="margin-right: 32px;">Senha:</label><input type="text" name="senha"/><br>
			    
			    
				<button style="margin-top: 13px;" class="btn btn-primary" type="submit" name="option" value="insert">Salvar</button>
				</div>
			</c:when>
			<c:otherwise>
			<div class="container mt-5 col-6" style="outline: 1px solid #d5d5d5; border-radius: 11px; padding: 16px;">
				<input type="hidden" name="cod_cliente" value="${usuario.cod_cliente}"/><br>
				<label style="margin-right: 17px;">Nome:</label>
				<input type="text" name="name" value="${usuario.nome}" required/><br>
				<label style="margin-right: 23px;">cpf:</label>
				<input type="text" name="name" value="${usuario.cpf}" required/><br>
				<label style="margin-right: 23px;">Email:</label>
				<input type="text" name="email" value="${usuario.email}"/><br>
				<label style="margin-right: 32px;">Senha:</label>
				<input type="text" name="pais" value="${usuario.senha}"/><br>
			
				<button class="btn btn-primary" type="submit" name="option" value="update">Atualizar</button>
			</div>
			</c:otherwise>
		</c:choose>
            </form>
        </div>
</body>
</html>