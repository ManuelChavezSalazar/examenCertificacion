<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Historial Clínico</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

    <div class="container mt-5">
        <h1>Historial Clínico</h1>

        <!-- Buscador de Pacientes -->
        <form action="/examenFinal/buscarPaciente" method="get">
            <div class="form-group">
                <label for="parametroBusqueda">Buscar Paciente:</label>
                <input type="text" name="parametroBusqueda" id="parametroBusqueda" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">Buscar</button>
        </form>

        <!-- Lista de Pacientes Encontrados -->
        <c:if test="${not empty pacientesEncontrados}">
            <h2>Pacientes Encontrados:</h2>
            <ul>
                <c:forEach var="paciente" items="${pacientesEncontrados}">
                    <li><a href="/examenFinal/historiaClinica/${paciente.id}">${paciente.nombre}</a></li>
                </c:forEach>
            </ul>
        </c:if>

    </div>

</body>
</html>
