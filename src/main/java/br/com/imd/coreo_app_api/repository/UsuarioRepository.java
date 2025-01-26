package br.com.imd.coreo_app_api.repository;

import br.com.imd.coreo_app_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}