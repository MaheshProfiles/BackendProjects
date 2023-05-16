package com.amvlabs.jobapp.ws.ui.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amvlabs.jobapp.ws.ui.model.request.UserDetailsRequestModel;
import com.amvlabs.jobapp.ws.ui.model.response.UserRest;
import com.amvlabs.jobapp.ws.ui.service.UserService;
import com.amvlabs.jobapp.ws.ui.shared.dto.UserDto;


@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "Get user was called";
	}

	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest returnValue = new UserRest();
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete user was called";
	}

	@PutMapping
	public String updateUser() {
		return "Update user was called";
	}

}
