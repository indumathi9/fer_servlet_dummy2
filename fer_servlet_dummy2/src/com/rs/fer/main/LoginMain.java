package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class LoginMain {

	public static void main(String[] args) {
		String username = "ABCD";
		String password = "abcd";
		FERService ferService = new FERServiceImpl();
		int userId = ferService.login(username, password);

		if (userId>0) {
			System.out.println("login is successfull");
		} else {
			System.out.println("login failed");
		}
	}
}