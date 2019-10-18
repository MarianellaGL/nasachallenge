package ar.com.ada.api.nasachallenge.nasachallenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.nasachallenge.nasachallenge.entities.Pais;
import ar.com.ada.api.nasachallenge.nasachallenge.excepciones.CodigoPaisException;
import ar.com.ada.api.nasachallenge.nasachallenge.repo.PaisRepository;

@Service
public class PaisService {

    @Autowired
    PaisRepository repo;

    public void save(Pais p) {

        repo.save(p);
    }

    public List<Pais> getPaises() {

        return repo.findAll();
    }

    public Pais buscarPorCodigoPais(Integer id) {

        Optional<Pais> p = repo.findById(id);

        if (p.isPresent())
            return p.get();
        return null;
    }

    
    public int agregarPais(Integer codigopais, String nombrepais) throws CodigoPaisException {

        Pais p = new Pais();
        p.setCodigopais(codigopais);
        p.setNombrepais(nombrepais);
        

        

        repo.save(p);

        return p.getCodigopais();

    }
 
   public Pais updatePais(int id, String nombrepais) {
        Pais p = new Pais();
        p.setNombrepais(nombrepais);
        p.setCodigopais(id);
        repo.save(p);
        return p;
    }



}