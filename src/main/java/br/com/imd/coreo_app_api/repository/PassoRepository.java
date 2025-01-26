package br.com.imd.coreo_app_api.repository;

import br.com.imd.coreo_app_api.model.Passo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassoRepository extends JpaRepository<Passo, Long> {
}