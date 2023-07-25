package com.nttdata.entrevista.impl;

import com.nttdata.entrevista.exceptions.ClienteException;
import com.nttdata.entrevista.exceptions.ClienteValidacionException;
import com.nttdata.entrevista.model.Cliente;
import com.nttdata.entrevista.model.TipoDocumento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClienteImplTest {

    @InjectMocks
    private ClienteImpl clienteImpl;

    private Cliente cliente;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente();
        cliente.setDireccion("Calle 1 carrera 2");
        cliente.setTelefono(3165362658L);
        cliente.setCiudadResidencia("Cali");
        cliente.setPrimerNombre("David");
        cliente.setPrimerApellido("Aristizabal");
        cliente.setNumeroDocumento("23445322");
        cliente.setSegundoApellido("Penaranda");
        cliente.setSegundoNombre("");
        cliente.setTipoDocumento(TipoDocumento.CEDULA);
    }

    @Test
    void obtenerDatosCliente() throws ClienteValidacionException, ClienteException {
        Optional<String> tipoDocumento = Optional.of("C");
        Optional<String> numeroDocumento = Optional.of("23445322");
        assertEquals(clienteImpl.obtenerDatosCliente(tipoDocumento, numeroDocumento), cliente);
    }

    @Test
    void noEncuentraDatosCliente() {
        Optional<String> tipoDocumento = Optional.of("P");
        Optional<String> numeroDocumento = Optional.of("1112226107");

        assertThrows(ClienteException.class, () -> { clienteImpl.obtenerDatosCliente(tipoDocumento, numeroDocumento); });
    }


    @Test
    void datosClienteVacios() {
        Optional<String> tipoDocumento = Optional.of("");
        Optional<String> numeroDocumento = Optional.of("");

        assertThrows(ClienteValidacionException.class,
                () -> { clienteImpl.obtenerDatosCliente(tipoDocumento, numeroDocumento); });
    }


    @Test
    void datosClienteNulos() {
        assertThrows(ClienteValidacionException.class,
                () -> { clienteImpl.obtenerDatosCliente(Optional.empty(), Optional.empty()); });
    }

}