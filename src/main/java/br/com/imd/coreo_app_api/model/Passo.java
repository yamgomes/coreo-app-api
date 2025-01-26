package br.com.imd.coreo_app_api.model;

import jakarta.persistence.*;

@Entity
public class Passo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private Integer ordem;

    @ManyToOne
    @JoinColumn(name = "coreography_id")
    private Coreography coreography;

}
