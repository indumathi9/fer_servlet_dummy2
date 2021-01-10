package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;
import com.rs.fer.util.DBUtil;

public class AddExpenseMain {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement Preparedstatement = null;

		Expense expense = new Expense();
		expense.setType("grociries");
		expense.setDate("2/12/2020");
		expense.setPrice((float) 40);
		expense.setNumberOfItems(1);
		expense.setTotal((float) 40);
		expense.setBywhom("prathima");
		expense.setUserid(2);

		FERService ferservice = new FERServiceImpl();
		boolean addExpense = ferservice.addExpense(expense);
		if (addExpense) {
			System.out.println("expense added succesfully");
		} else {
			System.out.println("expense addition failed");
		}

	}
}
