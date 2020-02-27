package com.arturo.sortcorreo;

import com.arturo.dao.CuentasCorreoDAO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import utilidades.Utilidades;

public class Main {

    public static void main(String[] args) {

        File fileInput = new File("cuentas.txt");
        File fileOutput = new File("cuentasOrganizadas.txt");
        List<CuentaCorreo> cuentasSinOrden = new ArrayList<>();
        try {
            try (BufferedReader entrada = new BufferedReader(new FileReader(fileInput))) {
                String linea = entrada.readLine();
                String[] datos = new String[2];
                int i = 1;
                while (linea != null) {
                    linea = linea.trim();
                    System.out.println("Leyendo línea: " + linea);
                    if (!Utilidades.esValido(linea)) {
                        if(!linea.isEmpty()) System.err.println("Error en la línea " + i + ": esta línea esta mal ingresada: " + linea);
                        linea = entrada.readLine();
                        i++;
                        continue;
                    }

                    datos = linea.split("@");
                    cuentasSinOrden.add(new CuentaCorreo(datos[0], datos[1]));
                    linea = entrada.readLine();
                    i++;
                }

            }

            List<CuentaCorreo> cuentas = CuentasCorreoDAO.organizarCuentas(cuentasSinOrden);

            try (PrintWriter salida = new PrintWriter(new FileWriter(fileOutput))) {
                cuentas.forEach(cuenta -> salida.println(cuenta));
            }

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }
}
