package com.rs.fer.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.impl.FERServiceImpl;
import com.rs.fer.util.DBUtil;

public class EditExpenseMain {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement Preparedstatement = null;

		Expense expense = new Expense();
		expense.setType("tea");
		expense.setDate("1/11/2020");
		expense.setPrice((float) 10.0);
		expense.setNumberOfItems(1);
		expense.setTotal((float) 10.0);
		expense.setBywhom("me");
		expense.setId(4);

		FERService ferservice = new FERServiceImpl();
		boolean editExpense = ferservice.editExpense(expense);
		if (editExpense) {
			System.out.println("expense edited succesfully");
		} else {
			System.out.println("expense edition failed");
		}

	}

}
