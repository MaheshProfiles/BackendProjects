package com.amvlabs.jobmelaapp.ws.ui.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.amvlabs.jobmelaapp.ws.io.entity.UserEntity;
import com.amvlabs.jobmelaapp.ws.repository.UserRepository;
import com.amvlabs.jobmelaapp.ws.ui.service.UserService;
import com.amvlabs.jobmelaapp.ws.ui.shared.Utils;
import com.amvlabs.jobmelaapp.ws.ui.shared.dto.UserDto;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	

	@Autowired
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto createUser(UserDto user) {

		
		if(userRepository.findUserByEmail(user.getEmail())!=null) throw new RuntimeException("Record Already Exists");
		 
		UserEntity entity = new UserEntity();
		
		BeanUtils.copyProperties(user, entity);
		
		entity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		String publicUserID = utils.generateUserID(30);
		entity.setUserID(publicUserID);
		
		
		UserEntity storedUserDetails = userRepository.save(entity);

		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}

}
