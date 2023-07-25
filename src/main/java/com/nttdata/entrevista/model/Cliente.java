package com.nttdata.entrevista.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @JsonIgnore
    private TipoDocumento tipoDocumento;
    @JsonIgnore
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Long telefono;
    private String direccion;
    private String ciudadResidencia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return tipoDocumento == cliente.tipoDocumento && Objects.equals(numeroDocumento, cliente.numeroDocumento) && Objects.equals(primerNombre, cliente.primerNombre) && Objects.equals(segundoNombre, cliente.segundoNombre) && Objects.equals(primerApellido, cliente.primerApellido) && Objects.equals(segundoApellido, cliente.segundoApellido) && Objects.equals(telefono, cliente.telefono) && Objects.equals(direccion, cliente.direccion) && Objects.equals(ciudadResidencia, cliente.ciudadResidencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoDocumento, numeroDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, direccion, ciudadResidencia);
    }
}
