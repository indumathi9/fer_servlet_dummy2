package com.rs.fer.main;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class UpdateUserMain {

	public static void main(String[] args) {

		int userId = 1;
		FERService ferservice = new FERServiceImpl();
		User user = ferservice.getUser(userId);

		user.setFristname("prathima");
		user.setMiddlename("");
		user.setLastname("nuthalapati");

		user.setEmail("prathima@gmail.com");
		user.setMobile("4764535678");

		Address address = user.getAddress();
		address.setLineone("11");
		address.setLinetwo("12");
		address.setCity("hyd");
		address.setState("AP");
		address.setPincode("7856457");
		address.setCountry("IND");
		address.setUserid(user.getId());

		
		boolean isUpdate = ferservice.updateUser(user);

		if (isUpdate) {
			System.out.println("user updated successfully...");

		} else {
			System.out.println("user update failed");
		}
	}
}