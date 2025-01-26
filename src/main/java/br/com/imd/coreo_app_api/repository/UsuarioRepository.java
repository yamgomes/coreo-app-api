package br.com.imd.coreo_app_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imd.coreo_app_api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}