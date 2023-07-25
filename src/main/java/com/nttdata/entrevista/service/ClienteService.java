package com.nttdata.entrevista.service;

import com.nttdata.entrevista.exceptions.ClienteException;
import com.nttdata.entrevista.exceptions.ClienteValidacionException;
import com.nttdata.entrevista.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ClienteService {
    Cliente obtenerDatosCliente(Optional<String> tipoDocumento, Optional<String> numeroDocumento) throws ClienteValidacionException, ClienteException;
}
