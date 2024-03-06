package com.eduardo.workshopmongo.services;

import com.eduardo.workshopmongo.domain.Post;
import com.eduardo.workshopmongo.repository.PostRepository;
import com.eduardo.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }
    public List<Post> findBytitle(String text){
        return postRepository.searchByTitle(text);
    }
    public List<Post>fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime()+ 24*60*60*1000);
        return postRepository.searchAll(text,minDate,maxDate);
    }
}