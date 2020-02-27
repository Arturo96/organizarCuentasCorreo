
package com.arturo.dao;

import com.arturo.sortcorreo.CuentaCorreo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class CuentasCorreoDAO {
    
    private static List<CuentaCorreo> cuentasOrdenadas = new ArrayList<>();
    private static List<CuentaCorreo> cuentasPorDominio = new ArrayList<>();

    public static List<CuentaCorreo> organizarCuentas(List<CuentaCorreo> cuentas) {
        
        cuentas.sort(Comparator.comparing(CuentaCorreo::getDominio));

        String dominioActual = cuentas.get(0).getDominio();
        for (CuentaCorreo cuenta : cuentas) {
            if (cuenta.getDominio().equals(dominioActual)) {
                cuentasPorDominio.add(cuenta);
            } else {
                dominioActual = cuenta.getDominio();
                agregarCuentasOrdenadas();

                cuentasPorDominio.add(cuenta);

            }
        }

        agregarCuentasOrdenadas();
        System.out.println(cuentasOrdenadas);
        
        return cuentasOrdenadas;
    }

    public static void agregarCuentasOrdenadas() {
        cuentasPorDominio.sort(Comparator.comparing(CuentaCorreo::getNombre));

        for (CuentaCorreo cuentaPorDominio : cuentasPorDominio) {
            cuentasOrdenadas.add(cuentaPorDominio);
        }
        cuentasPorDominio.clear();
    }    
        
    
    
}
