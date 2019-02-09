package com.example.IskconErpAPI.domain;

import javax.persistence.*;

@Entity
@Table(name = "rath_yatra")
public class RathYatra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Double lattitude;
    Double longitude;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLattitude() {
        return lattitude;
    }

    public void setLattitude(Double lattitude) {
        this.lattitude = lattitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
