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
            <form action="ServletCRUD" method="post">



                <c:choose>
                    <c:when test="${ user == null }">
                
                    <div class="row justify-content-center">
                     <h1>Atualizar</h1>
                     
                     
                         <div class="mb-3">
                        <label for="exampleInput" class="form-label">Nome:</label>
                        <input class="form-control" type="text" name="name" required/>
                         </div>
                        
                        
                        <div class="mb-3">
                        <label for="exampleInput" class="form-label">Email:</label>
                        <input class="form-control" type="text" name="email"/>
                         </div>
                         
                         
                        <div class="mb-3">
                        <label for="exampleInput" class="form-label">País:</label>
                        <input  class="form-control" type="text" name="pais"/>
                        </div>
                        
                        <button class="btn btn-secondary col-2"  style="margin-bottom: 10px;" type="submit" name="option" value="insert">Salvar</button>
                        </div>
                        </div>
                        
                     </c:when>
                    </c:choose>
            </form>
        </div>

</body>
</html>