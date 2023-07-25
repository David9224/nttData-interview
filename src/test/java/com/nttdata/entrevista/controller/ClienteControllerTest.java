package com.nttdata.entrevista.controller;

import com.nttdata.entrevista.exceptions.ClienteException;
import com.nttdata.entrevista.exceptions.ClienteValidacionException;
import com.nttdata.entrevista.model.Cliente;
import com.nttdata.entrevista.model.TipoDocumento;
import com.nttdata.entrevista.service.ClienteService;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ClienteControllerTest {

    @InjectMocks
    private ClienteController controller;

    @Mock
    private ClienteService service;
    Optional<String> tipoDocumento;
    Optional<String> numeroDocumento;
    private Cliente cliente;
    private ResponseEntity response;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tipoDocumento = Optional.of("C");
        numeroDocumento = Optional.of("23445322");

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
    void obtenerDatosClienteOk() throws ClienteValidacionException, ClienteException {
        Mockito.when(service.obtenerDatosCliente(tipoDocumento, numeroDocumento)).thenReturn(cliente);
        response = new ResponseEntity<>(cliente, HttpStatus.OK);
        assertEquals(controller.obtenerDatosCliente(tipoDocumento, numeroDocumento), response);
    }


    @Test
    void obtenerDatosClienteClienteValidacionException() throws ClienteValidacionException, ClienteException {
        Mockito.when(service.obtenerDatosCliente(tipoDocumento, numeroDocumento)).
                thenThrow(ClienteValidacionException.class);
        assertThat(controller.obtenerDatosCliente(tipoDocumento, numeroDocumento).getStatusCode())
                .isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void obtenerDatosClienteClienteException() throws ClienteValidacionException, ClienteException {
        Mockito.when(service.obtenerDatosCliente(tipoDocumento, numeroDocumento)).
                thenThrow(ClienteException.class);
        assertThat(controller.obtenerDatosCliente(tipoDocumento, numeroDocumento).getStatusCode())
                .isEqualTo(HttpStatus.NO_CONTENT);
    }


    /*@Test
    void obtenerDatosClienteException() throws ClienteValidacionException, ClienteException {
        Mockito.doThrow(new Exception("Error")).when(service).obtenerDatosCliente(tipoDocumento, numeroDocumento);
        assertThat(controller.obtenerDatosCliente(tipoDocumento, numeroDocumento).getStatusCode())
                .isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

    }*/
}