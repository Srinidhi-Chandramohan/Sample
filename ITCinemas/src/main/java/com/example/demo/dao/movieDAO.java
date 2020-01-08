package com.example.demo.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;
import com.example.demo.model.Movie;

@Repository
public class movieDAO {
static Connection connection = null;
	
	public static Connection connectToDb() {		
		try {
			// Register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// create connection
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "prasanna", "1234");
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List getMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	public List getSeats() {
		// TODO Auto-generated method stub
		return null;
	}

	public void postUserData() {
		// TODO Auto-generated method stub
		
	}

	public void postAdminData() {
		// TODO Auto-generated method stub
		
	}

	public void gerAdminData() {
		// TODO Auto-generated method stub
		
	}

	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		try {
			Connection con=connectToDb();
			PreparedStatement stmt = con.prepareStatement("insert into movie values(?,?,?,?,?)");
			stmt.setInt(1,movie.getMovieId());
			stmt.setString(2,movie.getMovieName());
			stmt.setDouble(3,movie.getMovieRating());
			stmt.setInt(4,movie.getAvilableSeats());
			stmt.setInt(5, movie.getTotalSeats());
			int affectedRows=stmt.executeUpdate();
			System.out.println("Inside dao :");
			System.out.println("Affected Rows = "+affectedRows);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public boolean adminSignUp() {
		// TODO Auto-generated method stub
		Admin ad=new Admin();
		try {
			Connection con=connectToDb();
			PreparedStatement stmt = con.prepareStatement("insert into admin values(?,?,?,?,?)");
			stmt.setString(1,ad.getUserName());
			stmt.setString(2,ad.getPassword());
			stmt.setString(3,ad.getConfirmPassword());
			stmt.setDouble(4,ad.getPhone());
			stmt.setString(5,ad.getEmail());
			int affectedRows=stmt.executeUpdate();
			System.out.println("Inside dao :");
			System.out.println("Affected Rows = "+affectedRows);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return false;
	}
}
