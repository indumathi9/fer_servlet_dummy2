package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {
		User user = new User();
		user.setFristname("abc");
		user.setMiddlename("");
		user.setLastname("ln");
		user.setEmail("prathima@123");
		user.setUsername("ABCD");
		user.setPassword("abcd");
		user.setMobile("987564353");

		FERService ferService = new FERServiceImpl();
		boolean isRegister = ferService.registration(user);

		if (isRegister) {
			System.out.println("user registerd successfully");
		} else {
			System.out.println("user registration failed");
		}
	}
}