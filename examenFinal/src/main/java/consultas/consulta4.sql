SELECT P.Nombre AS NombrePaciente, HC.Diagnostico, HC.Tratamiento
FROM Pacientes P
JOIN Historia_Clinica HC ON P.ID = HC.Paciente_ID
WHERE HC.Fecha_Cita = (SELECT MAX(Fecha_Cita) FROM Historia_Clinica WHERE Paciente_ID = P.ID)
ORDER BY P.ID ASC;