package com.petcarepal.petcarepal.homecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.petcarepal.petcarepal.model.UserDtls;
import com.petcarepal.petcarepal.repository.UserRepository;





@Controller
public class indexcontroller {

	@Autowired
    private UserRepository userRepo;
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/creche_locator")
	public String locator() {
		return "locator";
	}
	@GetMapping("/medicine")
	public String Medicine() {
		return "medicine";
	}
	@GetMapping("/success")
	public String success() {
		return "page_success";
	}
	@GetMapping("/signup")
	public String Register(Model model){
		model.addAttribute("user", new UserDtls());
		return "register";
	}
	@PostMapping("/process_register")
	public String processRegister(UserDtls user) {
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	     
	    userRepo.save(user);
	     
	    return "page_success";
	}
	
}
