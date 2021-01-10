package com.rs.fer.main;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class GetExpenseMain {

	public static void main(String[] args) {
		int expenseId = 2;

		FERService ferservice = new FERServiceImpl();
		Expense expense = ferservice.getExpense(expenseId);
		if (expense == null) {
			System.out.println("expense not found");
		} else {
			System.out.println("Id:" + expense.getId());
			System.out.println("Type:" + expense.getType());
			System.out.println("Date:" + expense.getDate());
			System.out.println("Price:" + expense.getPrice());
			System.out.println("Number Of Items:" + expense.getNumberOfItems());
			System.out.println("Total:" + expense.getTotal());
			System.out.println("ByWhom:" + expense.getBywhom());
			System.out.println("UserId:" + expense.getUserid());

		}

	}
}