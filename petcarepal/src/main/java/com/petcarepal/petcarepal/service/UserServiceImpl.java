package com.petcarepal.petcarepal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.petcarepal.petcarepal.dto.UserDto;
import com.petcarepal.petcarepal.model.User;
import com.petcarepal.petcarepal.repository.UserRepository;

import jakarta.mail.internet.MimeMessage;
import net.bytebuddy.utility.RandomString;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

	@Override
	public User save(UserDto userDto , String url) {
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getRole(), userDto.getFullname() , passwordEncoder.encode(userDto.getConfirm()), userDto.getPetinfo() , userDto.getPhone(), userDto.getVerificationCode());
		RandomString rn = new RandomString();
		userDto.setVerificationCode(rn.make(64));
		
		User savedUser = userRepository.save(user);
		sendVerification(userDto,url);
		return savedUser;
	}
	public void sendVerification(UserDto userDto , String url) {
		String from = "debdutta.basu.2020@gmail.com";
		String to = userDto.getEmail();
		String subject = "Account Verification";
		String content="Dear [[name]],<br>"
				+ "Please click the link below to verify your registration:<br>"
				+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
				+"Thank you,<br>"
				+ "PetCarePal";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			
			helper.setFrom(from,"PetCarePal");
			helper.setTo(to);
			helper.setSubject(subject);
			
			content  = content.replace("[[name]]", userDto.getFullname());
			
			String siteUrl = "http://localhost:8082"+"/verify?code="+userDto.getVerificationCode();
			content = content.replace("[[URL]]", siteUrl);
			helper.setText(content,true);
			
			mailSender.send(message);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
