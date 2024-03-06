package com.eduardo.workshopmongo.resources;

import com.eduardo.workshopmongo.domain.User;
import com.eduardo.workshopmongo.dto.UserDTO;
import com.eduardo.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO> >findAll(){

        List<User> list = service.findAll();
        List<UserDTO>userDTO = list.stream().map(UserDTO::new).toList();

    return ResponseEntity.ok().body(userDTO);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){

        User user =service.findById(id);

        return ResponseEntity.ok().body(new UserDTO(user));
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert( @RequestBody UserDTO userDTO){
        User user = service.fromDTO(userDTO);
        user = service.insert(user);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id){

    service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
