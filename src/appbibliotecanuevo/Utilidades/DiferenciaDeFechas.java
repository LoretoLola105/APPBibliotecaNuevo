/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appbibliotecanuevo.Utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Otras
 */
public class DiferenciaDeFechas {
    
    public static synchronized int diferenciaFechasString(String fechaInicialStr, String fechaFinalStr) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Ajustado al formato de la base de datos
    Date fechaInicial = sdf.parse(fechaInicialStr);
    Date fechaFinal = sdf.parse(fechaFinalStr);

    long fechaInicialMs = fechaInicial.getTime();
    long fechaFinalMs = fechaFinal.getTime();
    long diferencia = fechaFinalMs - fechaInicialMs;
    double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
    return (int) dias;
}
}
