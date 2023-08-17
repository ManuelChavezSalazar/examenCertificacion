SELECT P.Nombre AS NombrePaciente, D.Nombre AS NombreDoctor
FROM Pacientes P
JOIN Citas C ON P.ID = C.Paciente_ID
JOIN Doctores D ON C.Doctor_ID = D.ID;