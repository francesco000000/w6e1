package it.epicode.w6e1.service;

import it.epicode.w6e1.model.Autore;
import it.epicode.w6e1.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AutoreServise {
    private List<Autore> autori= new ArrayList<>();
    public List<Autore> cercaTuttiAutore(){
        return autori;
    }

    public Autore cercaAutorePerId (int id) throws NoSuchElementException {
        Optional<Autore> a = autori.stream().filter(autore->autore.getId()==id).findAny();
        if (a.isPresent()){
            return a.get();
        }
        else {
            throw new NoSuchElementException("Post non presente");
        }
    }
    public void salvaAutore(Autore autore){
        autori.add(autore);
    }
    public Autore aggiornaAutore(int id,Autore autore)throws NoSuchElementException{
        Autore a = cercaAutorePerId(id);

       a.setAvatar(autore.getAvatar());
       a.setNome(autore.getNome());
       a.setCognome(autore.getCognome());
       a.setEmail(autore.getEmail());
       a.setDataDiNascita(autore.getDataDiNascita());
        return a;
    }
    public void cancellaAutore(int id)throws NoSuchElementException{
        Autore a = cercaAutorePerId(id);
        autori.remove(a);
    }
}
