SELECT Nombre, (SELECT Nombre FROM Especialidades WHERE ID = D.Especialidad_ID) AS Especialidad
FROM Doctores D
WHERE D.ID IN (SELECT Doctor_ID FROM Citas WHERE Paciente_ID = (SELECT ID FROM Pacientes WHERE Nombre = 'Juan Pérez'));