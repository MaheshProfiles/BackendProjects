package com.amvlabs.jobapp.ws.ui.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amvlabs.jobapp.ws.io.entity.UserEntity;
import com.amvlabs.jobapp.ws.repository.UserRepository;
import com.amvlabs.jobapp.ws.ui.service.UserService;
import com.amvlabs.jobapp.ws.ui.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto user) {

		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		
		entity.setEncryptedPassword("Test");
		
		entity.setUserID("TestUserID");
		
		UserEntity storedUserDetails = userRepository.save(entity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}

}
