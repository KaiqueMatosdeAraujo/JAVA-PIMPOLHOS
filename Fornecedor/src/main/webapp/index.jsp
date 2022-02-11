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

            </div>
        </div>
    </nav>



    <div class="row bodyRow" style="justify-content:space-around;">
        <div class="col-xl-2 navLateral">
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
        
        
        <div class="container">
<form action="ServletPimpolhos" method="post">
		<button type="submit" class="btn btn-primary"name="option" value="insertForm">Adicionar Fornecedor</button>
	</form>
	
		<table class="table table-bordered" >
			<thead>
				<tr>
					<th>#Cod Fornecedor</th>
					<th>Nome Fornecedor</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="fornecedor" items="${listUser}">
					<tr>
						<form action="ServletPimpolhos" method="post">
							<td>
								<c:out value="${fornecedor.cod_fornecedor}"/>
								<input type="hidden" name="cod_fornecedor" value="${fornecedor.cod_fornecedor}"/>
							</td>
							<td><c:out value="${fornecedor.nome_fornecedor}"/></td>
							
							<td><button class="btn btn-primary" type="submit" name="option" value="delete">Deletar</button>
							<button class="btn btn-primary" type="submit" name="option" value="updateForm">Atualizar</button></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</div>

</body>
</html>