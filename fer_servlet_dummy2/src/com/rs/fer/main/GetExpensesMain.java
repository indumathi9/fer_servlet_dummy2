package com.rs.fer.main;

import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpensesMain {

	public static void main(String[] args) {

		int userId = 2;

		FERService ferservice = new FERServiceImpl();
		List<Expense> expenses = ferservice.getExpenses(userId);
		if (expenses == null || expenses.isEmpty()) {
			System.out.println("no expenses were found");
		} else {
			for (Expense expense : expenses) {
				System.out.println("Id:" + expense.getId());
				System.out.println("Type:" + expense.getType());
				System.out.println("Date:" + expense.getDate());
				System.out.println("Price:" + expense.getPrice());
				System.out.println("Number Of Items:" + expense.getNumberOfItems());
				System.out.println("Total:" + expense.getTotal());
				System.out.println("ByWhom:" + expense.getBywhom());
				System.out.println("UserId:" + expense.getUserid());
				System.out.println("...................................................");

			}

		}
	}

}
