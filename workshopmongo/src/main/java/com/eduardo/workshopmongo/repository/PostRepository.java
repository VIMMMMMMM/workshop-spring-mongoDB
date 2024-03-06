package com.eduardo.workshopmongo.repository;

import com.eduardo.workshopmongo.domain.Post;
import com.eduardo.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    List<Post>findByTitleContainingIgnoreCase(String text);

}
