package br.com.imd.coreo_app_api.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuarioname;
    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coreography> coreographies;

    @ManyToMany
    @JoinTable(
            name = "usuario_followers",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "follow_id")
    )

    private List<Usuario> followers;

    @ManyToMany(mappedBy = "followers")
    private List<Usuario> following;
}
