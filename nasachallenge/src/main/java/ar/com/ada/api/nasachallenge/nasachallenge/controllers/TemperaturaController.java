package ar.com.ada.api.nasachallenge.nasachallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.nasachallenge.nasachallenge.entities.Temperatura;
import ar.com.ada.api.nasachallenge.nasachallenge.excepciones.AnioPaisException;
import ar.com.ada.api.nasachallenge.nasachallenge.models.request.TemperaturaAnioRequest;
import ar.com.ada.api.nasachallenge.nasachallenge.models.response.ListaTempAnioResponse;
import ar.com.ada.api.nasachallenge.nasachallenge.models.response.TempMaxResponse;
import ar.com.ada.api.nasachallenge.nasachallenge.models.response.TemperaturaAnioResponse;
import ar.com.ada.api.nasachallenge.nasachallenge.models.response.TemperaturaBajaResponse;
import ar.com.ada.api.nasachallenge.nasachallenge.services.PaisService;
import ar.com.ada.api.nasachallenge.nasachallenge.services.TemperaturaService;

@RestController
public class TemperaturaController {

    @Autowired
    TemperaturaService temperaturaService;
    @Autowired
    PaisService ps;

    @PostMapping("/temperaturas")
    public TemperaturaAnioResponse postAgregarTemperaturaAnio(@RequestBody TemperaturaAnioRequest req)
            throws AnioPaisException {

        TemperaturaAnioResponse r = new TemperaturaAnioResponse();

        Temperatura t = temperaturaService.agregarTemperaturaAnio(req.aniotemperatura, req.codigopais, req.gradostemperatura);

        r.temperaturaid = t.getTemperaturaid();
        r.isOk = true;
        r.message = "Nueva temperatura cargada con éxito";

        return r;
    }

    @GetMapping("/temperaturas/paises/{id}")
    public List<Temperatura> listarTemperaturasPorPais(@PathVariable Integer id) {
        List<Temperatura> lt = ps.getTemperaturasporpais(id);
        return lt;
    }

    @DeleteMapping("/temperaturas/{temperaturaid}")
    public TemperaturaBajaResponse bajaTemperatura(@PathVariable Integer temperaturaid) {
        TemperaturaBajaResponse r = new TemperaturaBajaResponse();

        temperaturaService.bajaTemperatura(temperaturaid);

        r.isOk = true;
        r.message = "Temperatura eliminada con éxito.";
        r.temperaturaid = temperaturaid;
        return r;
    }

    @GetMapping("/temperaturas/anios/{aniotemperatura}") // falta formatear el json
    public List<Temperatura> getTemperaturasPorAnio(@PathVariable Integer aniotemperatura){ 
        return temperaturaService.listarTemperaturasPorAnio(aniotemperatura);
    }

    @GetMapping("/temperaturas/maximas/{codigopais}")
    public TempMaxResponse getTemperaturaMaximaPais(@PathVariable Integer codigopais) {
        TempMaxResponse r = new TempMaxResponse();

        Temperatura t = temperaturaService.buscarTemperaturaMaximaPais(codigopais);

        r.nombrePais = t.getPais().getNombrepais();
        r.temperaturaMaxima = t.getGradostemperatura();
        r.aniotemperatura = t.getAniotemperatura();
        return r;

    }

}
