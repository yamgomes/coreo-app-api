package br.com.imd.coreo_app_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.imd.coreo_app_api.model.Passo;
import br.com.imd.coreo_app_api.repository.PassoRepository;

@Service
public class PassoService {

    @Autowired
    private final PassoRepository passoRepository;

    public PassoService(PassoRepository passoRepository) {
        this.passoRepository = passoRepository;
    }

    public List<Passo> getAllPassos() {
        return passoRepository.findAll();
    }

    public Passo createPasso(Passo passo) {
        return passoRepository.save(passo);
    }

    public Passo getPassoById(Long id) {
        return passoRepository.findById(id).orElse(null);
    }

    public void deletePasso(Long id) {
        passoRepository.deleteById(id);
    }

    public void updatePasso(Long id, Passo passo) {
        passoRepository.save(passo);
    }
}