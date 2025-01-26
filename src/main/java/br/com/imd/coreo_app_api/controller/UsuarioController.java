package br.com.imd.coreo_app_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.coreo_app_api.model.Usuario;
import br.com.imd.coreo_app_api.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @PostMapping("/{userId}/follow/{followId}")
    public ResponseEntity<Void> followUsuario(
            @PathVariable Long userId,
            @PathVariable Long followId
    ) {
        Usuario user = usuarioRepository.findById(userId).orElse(null);
        Usuario followUser = usuarioRepository.findById(followId).orElse(null);
        if (user == null || followUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        if (!user.getFollowers().contains(followUser)) {
            user.getFollowers().add(followUser);
        }
        if (!followUser.getFollowing().contains(user)) {
            followUser.getFollowing().add(user);
        }

        usuarioRepository.save(user);
        usuarioRepository.save(followUser);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{userId}/follow/{followId}")
    public ResponseEntity<Void> unfollowUsuario(
            @PathVariable Long userId,
            @PathVariable Long followId
    ) {
        Usuario user = usuarioRepository.findById(userId).orElse(null);
        Usuario followUser = usuarioRepository.findById(followId).orElse(null);

        if (user == null || followUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Remover a relação de followers
        if (user.getFollowers().contains(followUser)) {
            user.getFollowers().remove(followUser);
        }

        // Remover a relação de following
        if (followUser.getFollowing().contains(user)) {
            followUser.getFollowing().remove(user);
        }

        // Persistir as alterações no banco de dados
        usuarioRepository.save(user);
        usuarioRepository.save(followUser);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}