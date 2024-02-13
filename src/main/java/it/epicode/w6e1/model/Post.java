package it.epicode.w6e1.model;

import lombok.Data;

import java.net.URI;
import java.time.LocalTime;
import java.util.Random;

@Data
public class Post {

    private int id= new Random().nextInt(1,Integer.MAX_VALUE);
    private String categoria;
    private String titolo;
    private URI cover ;
    private LocalTime tempoLettura;
    private Autore autore;

    public Post(URI cover) {
        this.cover = cover;
    }
}
