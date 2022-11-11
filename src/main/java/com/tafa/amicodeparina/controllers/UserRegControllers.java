package com.tafa.amicodeparina.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tafa.amicodeparina.service.UserService;
import com.tafa.amicodeparina.controllers.dto.UserRegDto;

@Controller
@RequestMapping("/registration")
public class UserRegControllers {

	private UserService userService;

	public UserRegControllers(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public UserRegDto userRegistrationDto() {
        return new UserRegDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	} 
	

}
