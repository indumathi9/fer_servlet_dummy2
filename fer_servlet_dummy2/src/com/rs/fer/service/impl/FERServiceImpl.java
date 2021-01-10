package com.rs.fer.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.util.DBUtil;

public class FERServiceImpl implements FERService {

	@Override
	public boolean registration(User user) {

		boolean isRegister = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnection();
			String inputSQL = "insert into user(firstname, middlename, lastname, email, username, password, mobile) values (?, ?, ?, ?, ?, ?, ?)";
			
			preparedStatement = connection.prepareStatement(inputSQL);
			
			preparedStatement.setString(1, user.getFristname());
			preparedStatement.setString(2, user.getMiddlename());
			preparedStatement.setString(3, user.getLastname());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getUsername());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getMobile());

			int numOfRecAffected = preparedStatement.executeUpdate();
            isRegister = numOfRecAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);
		}
		return isRegister;

	}

	@Override
	public boolean addExpense(Expense expense) {
		boolean isRegister = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String inputSQL = "insert into expense(type,date,price,numberOfItems,total,bywhom,userid) values (?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(inputSQL);
			preparedStatement.setString(1, expense.getType());
			preparedStatement.setString(2, expense.getDate());
			preparedStatement.setFloat(3, expense.getPrice());
			preparedStatement.setInt(4, expense.getNumberOfItems());
			preparedStatement.setFloat(5, expense.getTotal());
			preparedStatement.setString(6, expense.getBywhom());
			preparedStatement.setInt(7, expense.getUserid());

			int numOfRecAffected = preparedStatement.executeUpdate();

			isRegister = numOfRecAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);
		}
		return isRegister;

	}

	@Override
	public boolean editExpense(Expense expense) {
		boolean editExpense = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String inputSQL = "update expense set type=?,date=?,price=?,numberOfItems=?,total=?,bywhom=? where id=?";
			preparedStatement = connection.prepareStatement(inputSQL);
			preparedStatement.setString(1, expense.getType());
			preparedStatement.setString(2, expense.getDate());
			preparedStatement.setFloat(3, expense.getPrice());
			preparedStatement.setInt(4, expense.getNumberOfItems());
			preparedStatement.setFloat(5, expense.getTotal());
			preparedStatement.setString(6, expense.getBywhom());
			preparedStatement.setInt(7, expense.getId());

			int numOfRecAffected = preparedStatement.executeUpdate();

			editExpense = numOfRecAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);
		}
		return editExpense;

	}

	@Override
	public int login(String username, String password) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String inputSQL = "select * from user where username=? and password=?";
			preparedStatement = connection.prepareStatement(inputSQL);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);
		}
		return 0;
	}

	@Override
	public boolean deleteExpense(int expenseId) {

		boolean deleteExpense = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String inputSQL = "delete from expense where id=?";
			preparedStatement = connection.prepareStatement(inputSQL);

			preparedStatement.setInt(1, expenseId);
			int numOfRecAffected = preparedStatement.executeUpdate();

			deleteExpense = numOfRecAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);
		}
		return deleteExpense;
	}

	@Override
	public boolean resetPassword(int Id, String currentPassword, String newpassword) {

		boolean resetPassword = false;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String inputSQL = "update user set password=? where id=? and password=?";
			preparedStatement = connection.prepareStatement(inputSQL);
			preparedStatement.setString(1, newpassword);
			preparedStatement.setInt(2, Id);
			preparedStatement.setString(3, currentPassword);

			int numOfRecAffected = preparedStatement.executeUpdate();

			resetPassword = numOfRecAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);
		}
		return resetPassword;
	}

	@Override
	public Expense getExpense(int expenseId) {
		Expense expense = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();
			String inputSQL = "select *from expense where id=?";
			preparedStatement = connection.prepareStatement(inputSQL);
			preparedStatement.setInt(1, expenseId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String type = resultSet.getString(2);
				String date = resultSet.getString(3);
				float price = resultSet.getFloat(4);
				int numOfItems = resultSet.getInt(5);
				int total = resultSet.getInt(6);
				String byWhom = resultSet.getString(7);
				int userid = resultSet.getInt(8);

				expense = new Expense();

				expense.setId(id);
				expense.setType(type);
				expense.setDate(date);
				expense.setPrice(price);
				expense.setNumberOfItems(numOfItems);
				expense.setTotal(total);
				expense.setBywhom(byWhom);
				expense.setUserid(userid);

				// System.out.println(type + "," + date + "," + price + "," + numOfItems + "," +
				// total + "," + byWhom + "," + userid);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);
		}
		return expense;
	}

	@Override
	public List<Expense> getExpenses(int userId) {

		List<Expense> expenses = new ArrayList<Expense>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();
			String inputSQL = "select *from expense where userid=?";
			preparedStatement = connection.prepareStatement(inputSQL);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			Expense expense = null;
			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String type = resultSet.getString(2);
				String date = resultSet.getString(3);
				float price = resultSet.getFloat(4);
				int numOfItems = resultSet.getInt(5);
				int total = resultSet.getInt(6);
				String byWhom = resultSet.getString(7);
				int userid = resultSet.getInt(8);

				expense = new Expense();

				expense.setId(id);
				expense.setType(type);
				expense.setDate(date);
				expense.setPrice(price);
				expense.setNumberOfItems(numOfItems);
				expense.setTotal(total);
				expense.setBywhom(byWhom);
				expense.setUserid(userid);

				expenses.add(expense);

				// System.out.println(type + "," + date + "," + price + "," + numOfItems + "," +
				// total + "," + byWhom + "," + userid);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);

		}

		return expenses;
	}

	@Override
	public List<Expense> expenseReport(int userId, String expenseType, String fromDate, String toDate) {

		List<Expense> expenseReport = new ArrayList<Expense>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.getConnection();
			String inputSQL = "select * from expense where userid=? and type=? and date between ? and ?";
			preparedStatement = connection.prepareStatement(inputSQL);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, expenseType);
			preparedStatement.setString(3, fromDate);
			preparedStatement.setString(4, toDate);

			ResultSet resultSet = preparedStatement.executeQuery();
			Expense expense = null;

			while (resultSet.next()) {

				int id = resultSet.getInt(1);
				String type = resultSet.getString(2);
				String date = resultSet.getString(3);
				float price = resultSet.getFloat(4);
				int numOfItems = resultSet.getInt(5);
				float total = resultSet.getFloat(6);
				String byWhom = resultSet.getString(7);
				int userid = resultSet.getInt(8);

				expense = new Expense();

				expense.setId(id);
				expense.setType(type);
				expense.setDate(date);
				expense.setPrice(price);
				expense.setNumberOfItems(numOfItems);
				expense.setTotal(total);
				expense.setBywhom(byWhom);
				expense.setUserid(userid);

				expenseReport.add(expense);

				// System.out.println(id+","+type + "," + date + "," + price + "," + numOfItems
				// + "," + total + "," + byWhom );
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			DBUtil.closeConnection(connection);

		}
		return expenseReport;
	}

	public User getUser(int userId) {
		User user = null;

		Connection connection = null;
		PreparedStatement Preparedstatement = null;

		try {
			connection = DBUtil.getConnection();
			String inputSQL = "select u.*,a.* from user u left join address a on u.id=a.userid where u.id=?";

			Preparedstatement = connection.prepareStatement(inputSQL);
			Preparedstatement.setInt(1, userId);
			ResultSet resultSet = Preparedstatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String firstname = resultSet.getString(2);
				String middlename = resultSet.getString(3);
				String lastname = resultSet.getString(4);
				String email = resultSet.getString(5);
				String username = resultSet.getString(6);
				String password = resultSet.getString(7);
				String mobile = resultSet.getString(8);

				user = new User();
				user.setId(id);
				user.setFristname(firstname);
				user.setMiddlename(firstname);
				user.setLastname(firstname);
				user.setEmail(email);
				user.setUsername(username);
				user.setPassword(password);
				user.setMobile(mobile);

				int addressid = resultSet.getInt(9);
				String line1 = resultSet.getString(10);
				String line2 = resultSet.getString(11);
				String city = resultSet.getString(12);
				String state = resultSet.getString(13);
				String pincode = resultSet.getString(14);
				String country = resultSet.getString(15);
				int userid = resultSet.getInt(16);

				Address address = new Address();
				address.setid(addressid);
				address.setLineone(line1);
				address.setLinetwo(line2);
				address.setCity(city);
				address.setState(state);
				address.setPincode(pincode);
				address.setCountry(country);
				address.setUserid(userid);

				user.setAddress(address);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}
		return user;

	}

	@Override
	public boolean updateUser(User user) {
		Connection connection = null;
		PreparedStatement prepaeredstatement = null;
		boolean isUpdate = false;
		try {
			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);
			String inputSQL = "UPDATE USER SET firstname=?, middlename=?, lastname=?, email=?, mobile=? WHERE  id=?";
			prepaeredstatement = connection.prepareStatement(inputSQL);
			prepaeredstatement.setString(1, user.getFristname());
			prepaeredstatement.setString(2, user.getMiddlename());
			prepaeredstatement.setString(3, user.getLastname());
			prepaeredstatement.setString(4, user.getEmail());
			prepaeredstatement.setString(5, user.getMobile());
			prepaeredstatement.setInt(6, user.getId());

			int numOfRecAffected = prepaeredstatement.executeUpdate();

			if (numOfRecAffected <= 0) {
				System.out.println("user update is failed");
			} else {
				Address address = user.getAddress();

				int addressId = address.getid();
				if (addressId <= 0) {
					String inputSQL1 = "INSERT INTO address (line1, line2, city, state, pincode, country, userid) VALUES (?, ?, ?, ?, ?, ?, ?)";

					prepaeredstatement = connection.prepareStatement(inputSQL1);
					prepaeredstatement.setString(1, address.getLineone());
					prepaeredstatement.setString(2, address.getLinetwo());
					prepaeredstatement.setString(3, address.getCity());
					prepaeredstatement.setString(4, address.getState());
					prepaeredstatement.setString(5, address.getPincode());
					prepaeredstatement.setString(6, address.getCountry());
					prepaeredstatement.setInt(7, address.getUserid());

					int numOfRecAffected11 = prepaeredstatement.executeUpdate();

					if (numOfRecAffected11 >= 1) {
						isUpdate = true;
						connection.commit();
						System.out.println("Address Inserted successfully");
					}
				} else {
					String inputSQL11 = ""
							+ "Update address set line1=?,line2=?,city=?,state=?,pincode=?,country=? where id=?";

					prepaeredstatement = connection.prepareStatement(inputSQL11);
					prepaeredstatement.setString(1, address.getLineone());
					prepaeredstatement.setString(2, address.getLinetwo());
					prepaeredstatement.setString(3, address.getCity());
					prepaeredstatement.setString(4, address.getState());
					prepaeredstatement.setString(5, address.getPincode());
					prepaeredstatement.setString(6, address.getCountry());
					prepaeredstatement.setInt(7, address.getUserid());

					int numOfRecAffected11 = prepaeredstatement.executeUpdate();

					if (numOfRecAffected11 >= 1) {
						isUpdate = true;
						connection.commit();

						System.out.println("Address updated successfully");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return isUpdate;
	}

}
