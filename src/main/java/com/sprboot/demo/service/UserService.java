package com.sprboot.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprboot.demo.dto.UserData;
import com.sprboot.demo.repository.UserRepository;


@Service
public class UserService {
	
@Autowired
UserRepository  userRepository ;

	public void save(UserData user) throws SQLException {
		 userRepository.save(user);
	}
	public void update(UserData user) throws SQLException {
		 userRepository.update(user);
	}
	public void delete(UserData user) throws SQLException {
		 userRepository.delete(user);
	}
	
	public  List<UserData> getAllUsers() throws SQLException{
		
		return userRepository. getAllUsers();
	}
	
	public UserData getbyid(Integer id) throws SQLException {
		return userRepository.getbyId(id);
		
	
	}
	
		
	}
	
		
	

