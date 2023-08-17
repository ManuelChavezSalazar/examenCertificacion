SELECT (SELECT Nombre FROM Doctores WHERE ID = C.Doctor_ID) AS NombreDoctor, COUNT(DISTINCT C.Paciente_ID) AS CantidadPacientes
FROM Citas C
GROUP BY C.Doctor_ID
ORDER BY NombreDoctor;