package ar.com.ada.api.nasachallenge.nasachallenge.entities;

import javax.persistence.*;

@Entity
@Table(name = "temperatura")

public class Temperatura {

    @Id
    @Column(name = "temperatura_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer temperaturaid;
    @Column(name = "anio_temperatura")
    public Integer aniotemperatura;
    @Column(name = "grados_temperatura")
    public double gradostemperatura;
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

    public double getGradostemperatura() {
        return gradostemperatura;
    }

    public void setGradostemperatura(double gradostemperatura) {
        this.gradostemperatura = gradostemperatura;
    }

}