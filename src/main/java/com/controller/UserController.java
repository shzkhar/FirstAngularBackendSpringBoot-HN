package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.ResponseBean;
import com.Entity.UserEntity;
import com.repository.UserRepository;


@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/insertUserEntityData ")
	public ResponseEntity<ResponseBean<UserEntity>> signup(@RequestBody UserEntity userEntity) {
		
		Optional<UserEntity> dbUser = userRepository.findByEmail(userEntity.getEmail());
		
		if (dbUser.isEmpty()) {
			userRepository.save(userEntity);

			ResponseBean<UserEntity> res = new ResponseBean<>();
			res.setData(userEntity);
			res.setMsg("signup done");

			return ResponseEntity.ok(res);// 200 new user
		} else {
			ResponseBean<UserEntity> res = new ResponseBean<>();
			res.setData(userEntity);
			res.setMsg("Email already Taken");

			return ResponseEntity.unprocessableEntity().body(res);

//			return new ResponseEntity<UserEntity>(user, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}
}
