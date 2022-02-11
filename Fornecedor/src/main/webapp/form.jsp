<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pimpolhos ADM</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
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
                <div class="col-12 navHamb">
                    <ul class="navbar-nav menuLateralTab">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="#">Meu perfil</a>
                        </li>
                        <hr>
                        <li class="nav-item">
                            <a class="nav-link clientes " aria-current="page" href="#">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link categorias" href="#">Categorias</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link produtos" href="#">Produtos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link fornecedores" href="#">Fornecedores</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link pedidos" href="#">Pedidos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link marcas" href="#">Marcas</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
      
   </nav>

    <div class="row bodyRow" style="justify-content:space-around;">
        <div class="col-2 navLateral">
            <ul class="navbar-nav menuLateralTab">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="#">Meu perfil</a>
                </li>
                <hr>
                <li class="nav-item">
                    <a class="nav-link clientes " aria-current="page" href="#">Clientes</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link categorias" href="#">Categorias</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link produtos" href="#">Produtos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fornecedores" href="#">Fornecedores</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link pedidos" href="#">Pedidos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link marcas" href="#">Marcas</a>
                </li>
            </ul>
        </div>

	<div class="col-md-12 col-lg-9 conteudo">
		  <form action="ServletPimpolhos" method="post">
				<c:choose>
					<c:when test="${ fornecedor == null }">
						<div class="container col-10 input-marca">
							<h2 style="margin: 30px 0px 50px 0px;">Cadastrar Fornecedor</h2>
							<input style="border-radius: 5px; border: 1px solid gray; height: 30px; padding: 10px;" type="text" name="name" required/><br>
						
							<button style="margin-top: 13px; width: 20%; " class="btn btn-primary" type="submit" name="option" value="insert">Salvar</button>
						</div>
					</c:when>
					<c:otherwise>
						<div class="container col-10 input-marca">
							<input type="hidden" name="cod_fornecedor" value="${fornecedor.cod_fornecedor}"/><br>
							<h2 style="margin-bottom: 50px; ">Atualizar Fornecedor</h2>
							<input style="border-radius: 5px; border: 1px solid gray; height: 30px; padding: 10px; type="text" name="name" value="${fornecedor.nome_fornecedor}" required/><br>
							
						
							<button class="btn btn-primary" type="submit" name="option" value="update">Atualizar</button>
						</div>
					</c:otherwise>
				</c:choose>
		</form>
	</div>
</div>
	
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
</body>
</html>