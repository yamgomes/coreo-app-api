package br.com.imd.coreo_app_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.imd.coreo_app_api.model.Coreography;
import br.com.imd.coreo_app_api.service.PassoService;
import br.com.imd.coreo_app_api.service.CoreographyService;

@RestController
@RequestMapping("/coreographies")
public class CoreographyController {

    @Autowired
    private CoreographyService coreographyService;

    @PostMapping
    public ResponseEntity<Coreography> createCoreography(@RequestBody Coreography coreography) {
        return ResponseEntity.status(HttpStatus.CREATED).body(coreographyService.createCoreography(coreography));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoreography(Long id) {
        coreographyService.deleteCoreography(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coreography> getCoreographyById(Long id) {
        return ResponseEntity.ok(coreographyService.getCoreographyById(id));
    }

    @GetMapping
    public ResponseEntity<List<Coreography>> getAllCoreographies() {
        return ResponseEntity.ok(coreographyService.getAllCoreographies());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCoreography(Long id, @RequestBody Coreography coreography) {
        coreographyService.updateCoreography(id, coreography);
        return ResponseEntity.noContent().build();
    }
}
