package com.nttdata.entrevista.controller;

import com.nttdata.entrevista.exceptions.ClienteException;
import com.nttdata.entrevista.exceptions.ClienteValidacionException;
import com.nttdata.entrevista.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping()
    public ResponseEntity obtenerDatosCliente(@RequestParam(name = "tipoDocumento") Optional<String> tipoDocumento,
                                              @RequestParam(name = "numeroDocumento") Optional<String> numeroDocumento){
        try{
            return  new ResponseEntity(service.obtenerDatosCliente(tipoDocumento, numeroDocumento), HttpStatus.OK);
        } catch (ClienteValidacionException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ClienteException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
