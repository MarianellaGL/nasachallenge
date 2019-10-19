package ar.com.ada.api.nasachallenge.nasachallenge.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.nasachallenge.nasachallenge.entities.Temperatura;

@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura, Integer> {

    List<Temperatura> findAllByAniotemperatura(int aniotemperatura);

}
