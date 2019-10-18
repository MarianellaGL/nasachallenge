package ar.com.ada.api.nasachallenge.nasachallenge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.nasachallenge.nasachallenge.entities.Pais;


@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer>{







}
