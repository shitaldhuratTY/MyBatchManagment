package com.tyss.benchmanage.controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.tyss.benchmanage.dto.Requriments;



public class RequrimentIdGenerator implements IdentifierGenerator{
	private final String DEFAULT_SEQUENCE_NAME = "hibernate_sequence";
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object arg1) throws HibernateException {
		Requriments user=new Requriments();
		Serializable result = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String prefix = "REQUIREMENTS";
		

		try {
			connection = session.connection();
			statement = connection.createStatement();
			try {
				/*
				 * uncomment below line if you are using mysql and the sequence DOES NOT EXIST.
				 * As we all know MySql does not support sequence, instead there is AUTO INCREMENT
				 * if you are using other databases change SQL according to that
				 * e.g. Oracle: "SELECT "+sequenceName+".NEXTVAL FROM DUAL"
				 * PostgreSQL: "SELECT  NEXTVAL('+sequenceName+"')  
				 * */
				int next_val=01;
				statement.executeUpdate("UPDATE " + DEFAULT_SEQUENCE_NAME + " SET next_val=next_val+1");
				resultSet = statement.executeQuery("SELECT next_val FROM  " + DEFAULT_SEQUENCE_NAME);
			} catch (Exception e) {

				System.out.println("In catch, cause : Table is not available.");
				// if sequence is not found then creating the sequence
				// Below code is for MySql database you change according to your database
				statement.execute("CREATE table " + DEFAULT_SEQUENCE_NAME + " (next_val INT NOT NULL)");
				statement.executeUpdate("INSERT INTO " + DEFAULT_SEQUENCE_NAME + " VALUES(0)");
				//==> LAST_INSERT_ID(next_val+1)  -> this is inbuilt function of MySql so by using this we can achieve our custom sequence like auto increment
				statement.executeUpdate("UPDATE " + DEFAULT_SEQUENCE_NAME + " SET next_val=LAST_INSERT_ID(next_val+1)");
				resultSet = statement.executeQuery("SELECT next_val FROM  " + DEFAULT_SEQUENCE_NAME);
				//e.printStackTrace();
			}
		
			if (resultSet.next()) {
		System.out.println("hi:"+resultSet.getInt(1));
				int nextValue = resultSet.getInt(1);
				String suffix = String.format("%01d", nextValue);
				result = prefix.concat(suffix);
				System.out.println("Custom generated sequence is na  : " + result);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}


