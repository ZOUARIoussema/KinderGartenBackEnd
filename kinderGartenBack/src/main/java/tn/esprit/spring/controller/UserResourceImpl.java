package tn.esprit.spring.controller;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.config.springSecurity.JwtTokenProvider;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.service.implementation.MailServiceImpl;
import tn.esprit.spring.service.interfaceS.IMailService;
import tn.esprit.spring.service.interfaceS.IUserService;

@RestController
@RequestMapping("/user")
public class UserResourceImpl {

	private static Logger log = LoggerFactory.getLogger(UserResourceImpl.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IUserService userS;

	@Autowired
	private IMailService mailS;

	@PostMapping(value = "/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody User user) {

		log.info("UserResourceImpl : authenticate");
		JSONObject jsonObject = new JSONObject();
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			if (authentication.isAuthenticated()) {
				String email = user.getEmail();
				jsonObject.put("name", authentication.getName());
				jsonObject.put("authorities", authentication.getAuthorities());
				jsonObject.put("token",
						tokenProvider.createToken(email, userRepository.findByEmail(email).getRole().toString()));
				return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
			}
		} catch (JSONException e) {
			try {
				jsonObject.put("exception", e.getMessage());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
		}
		return null;
	}

	@PostMapping("/add")
	public void addUser(@RequestBody User user) {

		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

		userS.add(user);
	}

	@PostMapping("/sendSecretKey")
	public void sendSecretKey(String key) {

		mailS.sendSimpleMail("oussema.zouari@esprit.tn", "ttt", "tt");

	}

	public void changePassword() {

	}

}
