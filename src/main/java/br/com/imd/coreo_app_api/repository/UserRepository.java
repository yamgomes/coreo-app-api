package br.com.imd.coreo_app_api.repository;

import br.com.imd.coreo_app_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}