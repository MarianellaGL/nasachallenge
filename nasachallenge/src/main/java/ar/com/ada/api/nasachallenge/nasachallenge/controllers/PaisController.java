package ar.com.ada.api.nasachallenge.nasachallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.nasachallenge.nasachallenge.entities.Pais;
import ar.com.ada.api.nasachallenge.nasachallenge.excepciones.CodigoPaisException;
import ar.com.ada.api.nasachallenge.nasachallenge.excepciones.NombrePaisException;
import ar.com.ada.api.nasachallenge.nasachallenge.models.request.ActualizarPaisRequest;
import ar.com.ada.api.nasachallenge.nasachallenge.models.request.PaisRequest;
import ar.com.ada.api.nasachallenge.nasachallenge.models.response.ActualizarPaisResponse;
import ar.com.ada.api.nasachallenge.nasachallenge.models.response.PaisResponse;
import ar.com.ada.api.nasachallenge.nasachallenge.services.PaisService;

@RestController
public class PaisController {

    @Autowired
    PaisService ps;
    

    @PostMapping("/paises")
    public PaisResponse postAgregarPais(@RequestBody PaisRequest req) throws CodigoPaisException{

        PaisResponse r = new PaisResponse();

         int paisCreadoId = ps.agregarPais(req.codigopais, req.nombrepais);

        r.isOk = true;
        r.message = "País ingresado con éxito";


        return r;
    }

    @GetMapping("/paises")
    
    public List<Pais>getPaises(){

        List<Pais> lp = ps.getPaises();

        return lp;

    }

     @GetMapping("/paises/{id}")
    public Pais getPaisByCodigoPais(@PathVariable Integer id){


        Pais p = ps.buscarPorCodigoPais(id);

        return p;
    }

    @PutMapping("/paises/{id}")
    public ActualizarPaisResponse actualizarPais(@RequestBody ActualizarPaisRequest req) throws NombrePaisException{

        ActualizarPaisResponse r = new ActualizarPaisResponse();

        int paisCreadoId = ps.actuallizarPais(req.nombrepais)

        r.isOk = true;
        r.message = "País ingresado con éxito";


        return r;

    }




    }






