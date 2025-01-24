package br.com.imd.coreo_app_api.controller;

import br.com.imd.coreo_app_api.model.Coreography;
import br.com.imd.coreo_app_api.repository.CoreographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coreographies")
public class CoreographyController {

    @Autowired
    private CoreographyRepository coreographyRepository;

    @GetMapping
    public List<Coreography> getAllCoreographies() {
        return coreographyRepository.findAll();
    }

    @PostMapping
    public Coreography createCoreography(@RequestBody Coreography coreography) {
        return coreographyRepository.save(coreography);
    }

    @GetMapping("/{id}")
    public Coreography getCoreographyById(@PathVariable Long id) {
        return coreographyRepository.findById(id).orElse(null);
    }
}
