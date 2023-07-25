package com.nttdata.entrevista.mock;

import com.nttdata.entrevista.model.Cliente;
import com.nttdata.entrevista.model.TipoDocumento;

public class ClienteMock {

    public static Cliente obtenerCliente(){
        return new Cliente(TipoDocumento.CEDULA, "23445322", "David", "",
                "Aristizabal", "Penaranda", 3165362658L, "Calle 1 carrera 2", "Cali");
    }
}
