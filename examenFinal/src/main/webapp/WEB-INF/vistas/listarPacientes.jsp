<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Pacientes</title>
</head>
<body>
    <h1>Listado de Pacientes</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Fecha de Nacimiento</th>
        </tr>
        <c:forEach var="paciente" items="${pacientes}">
            <tr>
                <td>${paciente.idPaciente}</td>
                <td>${paciente.nombrePaciente}</td>
                <td>${paciente.fechaNacimiento}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>



