package com.ssb.rest.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class userResource {

	@Autowired
	private UserDaoService userDaoService;
	
	

	@RequestMapping(method = RequestMethod.GET,path = "/users")
	public List<User> getAllUsers(){
		return userDaoService.getAllUser();
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/users/{id}")
	public EntityModel<User> getUsers(@PathVariable int id){
		User user = userDaoService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("Id :" +id);
		}
		EntityModel<User> entityModel = EntityModel.of(user);
        Link link= WebMvcLinkBuilder.linkTo(
                methodOn(this.getClass()).getAllUsers()).withRel("all-users");
        entityModel.add(link);
        return entityModel;
	}
	
	@RequestMapping(method = RequestMethod.POST,path = "/users")
	public ResponseEntity<Object> getUsers(@Valid @RequestBody User user){
		User savedUser =userDaoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
