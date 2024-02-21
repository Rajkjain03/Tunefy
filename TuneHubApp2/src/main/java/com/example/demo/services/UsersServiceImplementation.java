package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService {
	@Autowired
	UsersRepository ur;

	@Override
	public String addUser(Users user) {

		ur.save(user);
		return "User is created and saved";

	}

	@Override
	public boolean emailExists(String email) {

		if (ur.findByEmail(email) == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean validateUser(String email, String password) {

		Users user = ur.findByEmail(email);
		if(user == null) {
			return false;
		}
		String db_password = user.getPassword();
		if (db_password.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String findRole(String email) {
		return (ur.findByEmail(email).getRole());
	}

	@Override
	public Users getUser(String email) {
		return ur.findByEmail(email);
	}

	@Override
	public void updateUser(Users u) {
		ur.save(u);
	}
}
