package com.rs.fer.main;

import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class DeleteExpensemain {

	public static void main(String[] args) {
		int expenseId = 1;
		FERService ferservice = new FERServiceImpl();

		boolean deleteExpense = ferservice.deleteExpense(expenseId);

		if (deleteExpense) {
			System.out.println(" deleted succesfully");
		} else {
			System.out.println(" deletion failed");
		}

	}
}
