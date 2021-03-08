package com.sample.firstrestapp.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllJpaUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveJpaUser(@PathVariable int id) {
        Optional<User> singleUser = userRepository.findById(id);
        if (!singleUser.isPresent()) {
            throw new UserNotFoundException("of id -" + id);
        }

        EntityModel<User> resource = EntityModel.of(singleUser.get());
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User singleUser = userService.findOne(id);
        if (singleUser == null) {
            throw new UserNotFoundException("of id -" + id);
        }

        EntityModel<User> resource = EntityModel.of(singleUser);
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        User deletedUser = userService.deleteUserById(id);
        if (deletedUser == null) {
            throw new UserNotFoundException("of id -" + id);
        }
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteJpaUserById(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    // status - CREATED
    // input - Details of user
    // output - Return the created URL
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.addUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createJpaUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrieveAllUsersPosts(@PathVariable int id) {
        Optional<User> userOptional =  userRepository.findById(id);

        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("id-"+id);
        }

        return userOptional.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createJpaUserPost(@PathVariable int id, @RequestBody Post post) {

        Optional<User> userOptional =  userRepository.findById(id);

        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("id-"+id);
        }

        User user = userOptional.get();
        post.setUser(user);

        postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getPostId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    
}
