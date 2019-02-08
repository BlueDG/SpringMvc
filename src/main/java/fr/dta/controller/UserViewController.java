package fr.dta.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.dta.modele.User;
import fr.dta.service.UserService;

@Controller
@SessionAttributes("user")
@RequestMapping("/user")
public class UserViewController {

	@Autowired
	UserService userService;
	
	//value = "/redirect", 
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView display() {

		User user = new User(); // tu fais l'objet
		//ModelAndView mav = new ModelAndView("redirect:/user"); // tu crées le mav
		ModelAndView mav = new ModelAndView("user");
		mav.addObject("user", user); 
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute User user, BindingResult br) {
		if(br.hasErrors()) {
			return "Fail";
		}
		userService.create(user);
		return "ok";
		
		
	}
	
}
