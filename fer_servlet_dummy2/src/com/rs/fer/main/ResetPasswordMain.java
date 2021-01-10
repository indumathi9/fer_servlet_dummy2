package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class ResetPasswordMain {

	public static void main(String[] args) {
		int id = 8;
		String currentpassword = "abcd";
		String newpassword = "abc";

		FERService ferservice = new FERServiceImpl();
		boolean resetPassword = ferservice.resetPassword(id, currentpassword, newpassword);

		if (resetPassword) {
			System.out.println("password reset successfully");
		} else {
			System.out.println("password reset failed");
		}

	}
}