package br.com.imd.coreo_app_api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Coreography {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "coreography", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Step> steps;

    private boolean isPublic;

}
