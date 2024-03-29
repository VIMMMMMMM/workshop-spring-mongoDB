package com.eduardo.workshopmongo.config;

import com.eduardo.workshopmongo.domain.Post;
import com.eduardo.workshopmongo.domain.User;
import com.eduardo.workshopmongo.dto.AuthorDTO;
import com.eduardo.workshopmongo.dto.CommentDTO;
import com.eduardo.workshopmongo.repository.PostRepository;
import com.eduardo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));
        Post post1 = new Post(null,simpleDateFormat.parse("05/03/2024"),"adios","indo viajar",new AuthorDTO(maria));
        Post post2 = new Post(null,simpleDateFormat.parse("07/03/2024"),"bao","acordei",new AuthorDTO(maria));

        CommentDTO comment1= new CommentDTO("boa viagem",simpleDateFormat.parse("05/03/2024"),new AuthorDTO(alex));
        CommentDTO comment2= new CommentDTO("aproveite",simpleDateFormat.parse("06/03/2024"),new AuthorDTO(bob));
        CommentDTO comment3= new CommentDTO("otimo dia",simpleDateFormat.parse("07/03/2024"),new AuthorDTO(alex));
        post1.getComments().addAll(Arrays.asList(comment1,comment2));
        post2.getComments().add(comment3);
        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);

    }
}
