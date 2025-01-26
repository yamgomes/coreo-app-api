package br.com.imd.coreo_app_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.imd.coreo_app_api.model.Coreography;
import br.com.imd.coreo_app_api.repository.CoreographyRepository;

@Service
public class CoreographyService {

    @Autowired
    private final CoreographyRepository coreographyRepository;

    public CoreographyService(CoreographyRepository coreographyRepository) {
        this.coreographyRepository = coreographyRepository;
    }

    public List<Coreography> getAllCoreographies() {
        return coreographyRepository.findAll();
    }

    public Coreography createCoreography(Coreography coreography) {
        return coreographyRepository.save(coreography);
    }

    public Coreography getCoreographyById(Long id) {
        return coreographyRepository.findById(id).orElse(null);
    }

    public void deleteCoreography(Long id) {
        coreographyRepository.deleteById(id);
    }

    public void updateCoreography(Long id, Coreography coreography) {
        coreographyRepository.save(coreography);
    }
}