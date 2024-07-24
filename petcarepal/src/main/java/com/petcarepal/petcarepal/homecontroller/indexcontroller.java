package com.petcarepal.petcarepal.homecontroller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.petcarepal.petcarepal.dto.UserDto;
import com.petcarepal.petcarepal.service.CustomSuccessHandler;
import com.petcarepal.petcarepal.service.UserService;

import jakarta.servlet.http.HttpServletRequest;





@Controller
public class indexcontroller {

	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	CustomSuccessHandler cs;
	@Autowired
    private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/product1")
	public String prd1() {
		return "product1";
	}
	@GetMapping("/product2")
	public String prd2() {
		return "product2";
	}
	@GetMapping("/product3")
	public String prd3() {
		return "product3";
	}
	@GetMapping("/creche_locator")
	public String locator() {
		return "locator";
	}
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	@GetMapping("/cart")
	public String cart() {
		return "cart";
	}
	@GetMapping("/medicine")
	public String Medicine() {
		return "medicine";
	}
	@GetMapping("/user-page")
	public String UserPage(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "home";
	}
	@GetMapping("/success")
	public String success() {
		return "page_success";
	}
	@GetMapping("/signup")
	public String Register(@ModelAttribute("user") UserDto userDto){
		return "register";
	}
	@PostMapping("/process_register")
	public String processRegister(@ModelAttribute("user") UserDto userDto , Model model, HttpServletRequest request) {
		
		
		String email = userDto.getEmail();
        if (userService.emailExists(email)) {
            model.addAttribute("emailExists", true);
            return "register"; 
        }
        String password = userDto.getPassword();
        if (!isValidPassword(password)) {
            model.addAttribute("passwordInvalid", true);
            return "register"; 
        }
        String confirm = userDto.getConfirm();
        if (!password.equals(confirm)) {
            model.addAttribute("passwordMismatch", true);
            return "register"; 
        }
		String url = request.getRequestURL().toString();
		url = url.replace(request.getServletPath(), "");
		userService.save(userDto,url);
		model.addAttribute("message", "Registered Successfuly!");
	    
	    return "page_success";
	    
	}
	 public boolean isValidPassword(String password) {
	        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
	        return password.matches(regex);
	    }
	
}
