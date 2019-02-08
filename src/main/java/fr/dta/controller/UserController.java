package fr.dta.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import fr.dta.modele.User;
import fr.dta.service.UserService;

@Controller
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	// create
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody @Valid User resource) {
		userService.create(resource);
	}
		
	// findbById
	@RequestMapping(value ="{id}", method = RequestMethod.GET)
	@ResponseBody
	public User findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	// findAll
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public List<User> findAllUsers() {
		return userService.findAll();
	}

	// update
	@RequestMapping(value ="{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void update(@PathVariable Long id, @RequestBody User resource) {
		userService.update(id, resource);
	}
	
	// delete
	@RequestMapping(value ="{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id, @RequestBody User resource) {
		userService.delete(id, resource);
	}
	
	
}
