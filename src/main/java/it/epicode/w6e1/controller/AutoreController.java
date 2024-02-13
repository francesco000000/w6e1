package it.epicode.w6e1.controller;

import it.epicode.w6e1.model.Autore;
import it.epicode.w6e1.service.AutoreServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class AutoreController {
    @Autowired
    private AutoreServise autoreServise;
    @GetMapping("/autori")
    public List<Autore> getAll(){
        return autoreServise.cercaTuttiAutore();
    }
    @GetMapping("/aurori/{id}")
    public ResponseEntity<Autore> getPersonaByIdPathVariable(@PathVariable int id) {
        try {
            Autore a = autoreServise.cercaAutorePerId(id);
            return new ResponseEntity<Autore>(a, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/autori")
    public void saveAutore(@RequestBody Autore autore){
        autoreServise.salvaAutore(autore);
    }
    @PutMapping("/autori/{id}")
    public Autore upDateAutore(@PathVariable int id,@RequestBody Autore autore){
        return autoreServise.aggiornaAutore(id,autore);
    }
    @DeleteMapping("/autori/{id}")
    public void deleteAutore(@PathVariable int id){
        autoreServise.cancellaAutore(id);
    }
}
