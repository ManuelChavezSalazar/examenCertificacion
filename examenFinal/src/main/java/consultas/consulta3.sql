SELECT D.Nombre AS NombreDoctor, SUM(F.Monto) AS MontoFacturado
FROM Doctores D
JOIN Citas C ON D.ID = C.Doctor_ID
JOIN Facturas F ON C.Factura_ID = F.ID
GROUP BY D.Nombre
ORDER BY NombreDoctor DESC;