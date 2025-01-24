package br.com.imd.coreo_app_api.model;

import jakarta.persistence.*;

@Entity
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private int order;

    @ManyToOne
    @JoinColumn(name = "coreography_id")
    private Coreography coreography;

}
