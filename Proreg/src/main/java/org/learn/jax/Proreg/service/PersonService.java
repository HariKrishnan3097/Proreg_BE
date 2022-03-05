package org.learn.jax.Proreg.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.learn.jax.Proreg.model.Person;

public class PersonService {

	Connection con;

	public PersonService() {
		try {
			String DB_URL = "jdbc:mysql://localhost:3306/proreg";
			String USER = "root";
			String PASS = "Youknowme@123";

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			System.out.println(e + " An error occured");

		}
	}

	public Person insertPerson(Person p) {

		String query = "insert into person(firstName,lastName,gender,birthdayDate,regDate,email,address) values(?,?,?,?,?,?,?)";

		try {

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, p.getFirstName());
			ps.setString(2, p.getLastName());
			ps.setString(3, p.getGender());
			ps.setString(4, p.getBirthdayDate());
			ps.setString(5, p.getRegDate());
			ps.setString(6, p.getEmail());
			ps.setString(7, p.getAddress());

			ps.execute();

		} catch (Exception e) {
			System.out.println(e + " An error occured");
		}

		return p;
	}

	public List<Person> getAllPerson() throws SQLException {

		ArrayList<Person> data = new ArrayList<Person>();

		String query = "select * from person";

		PreparedStatement ps = con.prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			Person persons = new Person();

			persons.setFirstName(rs.getString("firstName"));
			persons.setLastName(rs.getString("lastName"));
			persons.setAddress(rs.getString("address"));
			persons.setBirthdayDate(rs.getString("birthdayDate"));
			persons.setEmail(rs.getString("email"));
			persons.setGender(rs.getString("gender"));
			persons.setRegDate(rs.getString("regDate"));
			persons.setPersonId(rs.getString("personId"));

			data.add(persons);

		}

		return data;

	}

	public String deletePerson(String id) {
		String query = " delete from person p where p.personId = " + id;
		try {

			PreparedStatement ps = con.prepareStatement(query);
			ps.execute();

		} catch (Exception e) {
			System.out.println(e + " An error occured");
		}
		return id;

	}

	public ArrayList<Person> getPersonById(String id) throws SQLException {

		ArrayList<Person> data = new ArrayList<Person>();

		String query = " select * from person p where p.personId = " + id;

		PreparedStatement ps = con.prepareStatement(query);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			Person persons = new Person();

			persons.setFirstName(rs.getString("firstName"));
			persons.setLastName(rs.getString("lastName"));
			persons.setAddress(rs.getString("address"));
			persons.setBirthdayDate(rs.getString("birthdayDate"));
			persons.setEmail(rs.getString("email"));
			persons.setGender(rs.getString("gender"));
			persons.setRegDate(rs.getString("regDate"));
			persons.setPersonId(rs.getString("personId"));
			data.add(persons);

		}

		return data;

	}

}
