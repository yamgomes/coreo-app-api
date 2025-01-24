package br.com.imd.coreo_app_api.repository;

import br.com.imd.coreo_app_api.model.Coreography;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoreographyRepository extends JpaRepository<Coreography, Long> {
}