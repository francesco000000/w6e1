package it.epicode.w6e1.model;

import lombok.Data;

import java.net.URI;
import java.time.LocalDate;
import java.util.Random;

@Data
public class Autore {
    private int id= new Random().nextInt(1,Integer.MAX_VALUE);
    private  String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private URI avatar;

    public Autore(URI avatar) {
        this.avatar = avatar;
    }
}

