package ar.com.ada.api.nasachallenge.nasachallenge.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "temperatura")

public class Temperatura {

    @Id
    @Column(name = "temperatura_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer temperaturaid;
    @Column(name = "anio_temperatura")
    public Integer aniotemperatura;
    @ManyToOne
    @JoinColumn(name = "codigo_pais", referencedColumnName = "codigo_pais")
    public Pais pais;

    public Integer getTemperaturaid() {
        return temperaturaid;
    }

    public void setTemperaturaid(Integer temperaturaid) {
        this.temperaturaid = temperaturaid;
    }

    public Integer getAniotemperatura() {
        return aniotemperatura;
    }

    public void setAniotemperatura(Integer aniotemperatura) {
        this.aniotemperatura = aniotemperatura;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Temperatura() {

    }



}