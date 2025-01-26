package br.com.imd.coreo_app_api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Coreography {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "coreography", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Passo> passos;

    private boolean isPublic;

}
