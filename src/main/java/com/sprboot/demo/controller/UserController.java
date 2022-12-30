package com.sprboot.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprboot.demo.dto.GenericResponse;
import com.sprboot.demo.dto.UserData;
import com.sprboot.demo.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private	UserService userService;
		
		@PostMapping(value = "/create")
		private GenericResponse<UserData> createUser(@RequestBody UserData user) throws SQLException {
			userService.save(user);
			GenericResponse<UserData> response=new  GenericResponse<UserData>();
			
			return response;
		}
		@PutMapping(value ="/update")
		private GenericResponse<UserData> updateUser(@RequestBody UserData user) throws SQLException {
			userService.update(user);
			GenericResponse<UserData> response=new  GenericResponse<UserData>();
			
			response.setData(null);
			response.setDataList(null);
			response.setMessage("user data updated successfully");
			response.setStatus("success");
			return response;
			

		}
		@DeleteMapping(value ="/delete")
		private GenericResponse<UserData> deleteUser(@RequestBody UserData user) throws SQLException {
			userService.delete(user);
			GenericResponse<UserData> response=new  GenericResponse<UserData>();
			
	  		response.setData(null);
			response.setDataList(null);
			response.setMessage("user data deleted successfully");
			response.setStatus("success");
			return response;
			
	}
		@GetMapping(value ="/get")
		public GenericResponse<UserData> getvalue() throws SQLException {
			List<UserData> users=userService.getAllUsers();
			GenericResponse<UserData> response=new  GenericResponse<UserData>();
			
			response.setData(null);
			response.setDataList(users);
			response.setMessage("user data getted successfully");
			response.setStatus("success");
			return response;
			
	}
		@GetMapping(value = "/getbyid/{id}")
		public GenericResponse<UserData> getbyvalue(@PathVariable Integer id) throws SQLException {
			UserData user =userService.getbyid(id);

			GenericResponse<UserData> response = new GenericResponse<UserData>();
			response.setStatus("value GetById success");
			response.setData(user);
			response.setDataList(null);
			response.setMessage("GetById successfully showed");
			return response;
	}
	

}
