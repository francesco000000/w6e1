package it.epicode.w6e1.service;

import it.epicode.w6e1.model.Autore;
import it.epicode.w6e1.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostService {
    private List<Post> posts = new ArrayList<>();
    @Autowired
    private AutoreServise autoreServise;
    public List<Post> cercaTuttiPost(){
        return posts;
    }
    public Post cercaPostPerId (int id) throws NoSuchElementException {
        Optional<Post> p = posts.stream().filter(post->post.getId()==id).findAny();
        if (p.isPresent()){
            return p.get();
        }
        else {
            throw new NoSuchElementException("Post non presente");
        }
    }
    public void salvaPost(Post post){
        posts.add(post);
    }
    public Post aggiornaPost(int id,Post post)throws NoSuchElementException{
      Post p = cercaPostPerId(id);
      Autore a = autoreServise.cercaAutorePerId(post.getAutore().getId());

      p.setAutore(a);
      p.setCategoria(post.getCategoria());
      p.setTitolo(post.getTitolo());
      p.setTempoLettura(post.getTempoLettura());
      p.setCover(post.getCover());
      return p;
    }
    public void cancellaPost(int id)throws NoSuchElementException{
        Post p = cercaPostPerId(id);
        posts.remove(p);
    }
}
