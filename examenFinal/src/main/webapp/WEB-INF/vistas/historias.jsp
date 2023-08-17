<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <head>
    <title>Listado de Historias Médicas</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
</head>
<body>
    <div class="container mt-4">
        <h1>Listado de Historias Médicas</h1>

        <div class="mb-4">
            <label for="buscar">Buscar Paciente:</label>
            <input type="text" id="buscar" class="form-control">
        </div>

        <div class="row">
            <div class="col-md-4">
                <select id="pacientes" class="form-select mb-4">
                    <!-- Opciones de pacientes -->
                </select>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <h2>Historia Clínica del Paciente</h2>
                <div id="historias-container">
                    <!-- Datos de historias médicas -->
                </div>
            </div>
        </div>
    </div>

    <script>
    $(document).ready(function() {
        $("#buscar").on("input", function() {
            var parametroBusqueda = $(this).val();
            obtenerPacientes(parametroBusqueda);
        });

        $("#pacientes").on("change", function() {
            var pacienteId = $(this).val();
            obtenerHistorias(pacienteId);
        });
    });

    function obtenerPacientes(parametroBusqueda) {
        $.ajax({
            url: "/examenFinal/api/pacientes/buscar?parametro=" + parametroBusqueda,
            method: "GET",
            dataType: "json",
            success: function(data) {
                var selectPacientes = $("#pacientes");
                selectPacientes.empty();
                $.each(data, function(index, paciente) {
                    selectPacientes.append("<option value='" + paciente.idPaciente + "'>" + paciente.nombrePaciente + "</option>");
                });
            }
        });
    }

    function obtenerHistorias(pacienteId) {
        $.ajax({
            url: "/examenFinal/api/historias/listar?idPaciente=" + pacienteId,
            method: "GET",
            dataType: "json",
            success: function(data) {
                var historiasContainer = $("#historias-container");
                historiasContainer.empty();
                $.each(data, function(index, historia) {
                    // Aquí construye la estructura HTML para mostrar los datos de la historia
                });
            }
        });
    }
</script>
<script>
    $(document).ready(function() {
        $("#buscar").on("input", function() {
            var parametroBusqueda = $(this).val();
            obtenerPacientes(parametroBusqueda);
        });

        $("#pacientes").on("change", function() {
            var pacienteId = $(this).val();
            obtenerHistorias(pacienteId);
        });
    });

    function obtenerPacientes(parametroBusqueda) {
        $.ajax({
            url: "/examenFinal/api/pacientes/buscar?parametro=" + parametroBusqueda,
            method: "GET",
            dataType: "json",
            success: function(data) {
                var selectPacientes = $("#pacientes");
                selectPacientes.empty();
                $.each(data, function(index, paciente) {
                    selectPacientes.append("<option value='" + paciente.idPaciente + "'>" + paciente.nombrePaciente + "</option>");
                });
            }
        });
    }

    function obtenerHistorias(pacienteId) {
        $.ajax({
            url: "/examenFinal/api/historias/listar?idPaciente=" + pacienteId,
            method: "GET",
            dataType: "json",
            success: function(data) {
                var historiasContainer = $("#historias-container");
                historiasContainer.empty();
                $.each(data, function(index, historia) {
                    // Aquí construye la estructura HTML para mostrar los datos de la historia
                });
            }
        });
    }
</script>

</body>

</html>
