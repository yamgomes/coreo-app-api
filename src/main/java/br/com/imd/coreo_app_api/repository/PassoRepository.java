package br.com.imd.coreo_app_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.imd.coreo_app_api.model.Passo;

public interface PassoRepository extends JpaRepository<Passo, Long> {
}