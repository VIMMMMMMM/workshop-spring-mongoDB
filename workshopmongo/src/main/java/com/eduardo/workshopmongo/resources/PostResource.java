package com.eduardo.workshopmongo.resources;

import com.eduardo.workshopmongo.domain.Post;
import com.eduardo.workshopmongo.resources.util.URL;
import com.eduardo.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){

        Post post =service.findById(id);

        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text){

        text = URL.decodeParam(text);
        List<Post> posts = service.findBytitle(text);
        return ResponseEntity.ok().body(posts);
    }
}
