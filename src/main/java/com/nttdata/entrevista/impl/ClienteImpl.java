package com.nttdata.entrevista.impl;

import com.nttdata.entrevista.exceptions.ClienteException;
import com.nttdata.entrevista.exceptions.ClienteValidacionException;
import com.nttdata.entrevista.mock.ClienteMock;
import com.nttdata.entrevista.model.Cliente;
import com.nttdata.entrevista.model.TipoDocumento;
import com.nttdata.entrevista.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClienteImpl implements ClienteService {

    private final Logger LOG = Logger.getLogger("ClienteImpl");
    private final static Cliente clienteMock = ClienteMock.obtenerCliente();

    @Override
    public Cliente obtenerDatosCliente(Optional<String> tipoDocumento, Optional<String> numeroDocumento)
            throws ClienteValidacionException, ClienteException {
        validarTipoNumeroDocumento(tipoDocumento, numeroDocumento);

        TipoDocumento tipo = obtnerTipoDocumento(tipoDocumento.get());
        if (tipo.equals(clienteMock.getTipoDocumento()) && numeroDocumento.get().equals(clienteMock.getNumeroDocumento())){
            LOG.info("Se encontro el cliente con tipo documento: "+ tipoDocumento.get() + " numero: " + numeroDocumento.get());
            return clienteMock;
        }
        LOG.warning("No se encontro el cliente con tipo documento: " + tipoDocumento.get() + " numero: " + numeroDocumento.get());
        throw new ClienteException("No se encontro el cliente con tipo documento: " + tipoDocumento.get() + " numero: " + numeroDocumento.get());
    }

    private TipoDocumento obtnerTipoDocumento(String tipoDocumento){
        if(TipoDocumento.CEDULA.getIdentificacionDocumento().equals(tipoDocumento)){
            return TipoDocumento.CEDULA;
        }
        return TipoDocumento.PASAPORTE;
    }

    private void validarTipoNumeroDocumento(Optional<String> tipoDocumento, Optional<String> numeroDocumento) throws ClienteValidacionException{
        if (tipoDocumento.isEmpty() || numeroDocumento.isEmpty()){
            LOG.warning("Tipo documento o numero de documento se encuentran vacios");
            throw new ClienteValidacionException("Tipo Documento y Numero de Documento Obligatorios");
        }
        if (tipoDocumento.get().equals("") || numeroDocumento.get().equals("")){
            LOG.warning("Tipo documento o numero de documento se encuentran vacios");
            throw new ClienteValidacionException("Tipo Documento y Numero de Documento Obligatorios");
        }
    }
}
