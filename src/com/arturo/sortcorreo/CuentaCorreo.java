
package com.arturo.sortcorreo;

import java.util.Objects;

public class CuentaCorreo {
    private String nombre;
    private String dominio;

    public CuentaCorreo() {
    }

    public CuentaCorreo(String nombre, String dominio) {
        this.nombre = nombre.toLowerCase();
        this.dominio = dominio.toLowerCase();
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.dominio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CuentaCorreo other = (CuentaCorreo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.dominio, other.dominio)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nombre + "@" + this.dominio;
    }
}
