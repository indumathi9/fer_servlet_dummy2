package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetUserMain {
	public static void main(String[] args) {

		int userId = 1;

		FERService ferservice = new FERServiceImpl();
		User user = ferservice.getUser(userId);

		if (user == null) {
			System.out.println("no user found");
		} else {
			System.out.println("firstName:" + user.getFristname());
			System.out.println("MiddleName:" + user.getFristname());
			System.out.println("LastName:" + user.getFristname());
			System.out.println("...................................");
			System.out.println("Email:" + user.getEmail());
			System.out.println("Mobile:" + user.getMobile());
			System.out.println(".....................................");
			System.out.println("Line1:" + user.getAddress().getLineone());
			System.out.println("Line2:" + user.getAddress().getLinetwo());
			System.out.println("City:" + user.getAddress().getCity());
			System.out.println("State:" + user.getAddress().getState());
			System.out.println("Pincode:" + user.getAddress().getPincode());
			System.out.println("Country:" + user.getAddress().getCountry());
			System.out.println("..............................................");

		}

	}
}
