package ar.com.ada.api.nasachallenge.nasachallenge.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @Column(name = "codigo_pais")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //identity = autoincremental
    public Integer codigopais;

    @Column(name = "nombre_pais")
    public String nombrepais;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    public List<Temperatura> temperaturasporpais = new ArrayList<Temperatura>();


    public Pais(String nombrepais, Integer codigopais) {
        this.nombrepais = nombrepais;
        this.codigopais = codigopais;
    }

    public Integer getCodigopais() {
        return codigopais;
    }

    public void setCodigopais(Integer codigopais) {
        this.codigopais = codigopais;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }

    public Pais() {

    }

    public List<Temperatura> getTemperaturasporpais() {
        return temperaturasporpais;
    }

   





}