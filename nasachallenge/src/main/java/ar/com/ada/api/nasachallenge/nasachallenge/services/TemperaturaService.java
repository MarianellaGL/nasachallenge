package ar.com.ada.api.nasachallenge.nasachallenge.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.nasachallenge.nasachallenge.entities.Pais;
import ar.com.ada.api.nasachallenge.nasachallenge.entities.Temperatura;
import ar.com.ada.api.nasachallenge.nasachallenge.excepciones.AnioPaisException;
import ar.com.ada.api.nasachallenge.nasachallenge.repo.TemperaturaRepository;

@Service
public class TemperaturaService {

    @Autowired
    TemperaturaRepository repo;
    @Autowired
    PaisService ps;

    public void save(Temperatura t){

        repo.save(t);

    }

    public List<Temperatura> getTemperatura() {

        return repo.findAll();
    }

    public Temperatura buscarPorCodigoTemperatura(Integer temperaturaid) {

        Optional<Temperatura> t = repo.findById(temperaturaid);

        if (t.isPresent())
            return t.get();
        return null;
    }

    
    public Temperatura agregarTemperaturaAnio(Integer aniotemperatura,Integer codigopais, double gradostemperatura) throws AnioPaisException {

        Temperatura t = new Temperatura();
        t.setAniotemperatura(aniotemperatura);
        t.setPais(ps.buscarPorCodigoPais(codigopais));
        t.setGradostemperatura(gradostemperatura);

        repo.save(t);

        return t;

    }

     public Temperatura bajaTemperatura(Integer temperaturaid) {
        Temperatura t = this.buscarPorCodigoTemperatura(temperaturaid);
        t.setAniotemperatura(0);
        repo.save(t);

        return t;
    }

    public List<Temperatura> listarTemperaturasPorAnio(Integer aniotemperatura) {

        for (Temperatura t : repo.findAllByAniotemperatura(aniotemperatura)) {
            if (t.getAniotemperatura() == aniotemperatura) {
                   List<Temperatura> temperaturas = new ArrayList<Temperatura>();
                temperaturas.add(t);
            
       

        return temperaturas;
        }
    }

        return null;

}
    /*
     * [{ “nombrePais”: “Argentina”, “grados”: 29 },
     * 
     * { “nombrePais”: “Venezuela”, “grados”: 45 }]
     * 
     */

    public Temperatura buscarTemperaturaMaximaPais(Integer codigopais) {
        Pais p = ps.buscarPorCodigoPais(codigopais);
        double tmax;
        tmax = -100;
        Temperatura tempEncontrada = new Temperatura();
        for (Temperatura t : p.getTemperaturasporpais()) {
            if (t.getGradostemperatura() >= tmax) {
                tmax = t.getGradostemperatura();
                tempEncontrada = t;
            }
        }
        return tempEncontrada;
    }

}

 
 



