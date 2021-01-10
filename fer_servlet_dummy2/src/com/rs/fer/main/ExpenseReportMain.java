package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;

public class ExpenseReportMain {

	public static void main(String[] args) {

		int userId = 2;
		String expenseType = "fruits";
		String fromDate = "1/11/2020";
		String toDate = "2/12/2021";

		FERService ferservice = new FERServiceImpl();
		List<Expense> expenseReport = ferservice.expenseReport(userId, expenseType, fromDate, toDate);
		if (expenseReport == null || expenseReport.isEmpty()) {
			System.out.println(" expenseReport not found");
		} else {
			for (Expense expense : expenseReport) {
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
}