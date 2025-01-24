package br.com.imd.coreo_app_api.repository;

import br.com.imd.coreo_app_api.model.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Step, Long> {
}