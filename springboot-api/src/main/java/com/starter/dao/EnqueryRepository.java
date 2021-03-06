package com.starter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.starter.service.Enquery;



@Component
public class EnqueryRepository {
	
	@Autowired
	ConnectionManger connectionManger;
	Statement statement = null;
	DataSource dataSource = null;
	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	public boolean testEnquery() throws SQLException{
		String sql = "create table ENQUERY(STUDENT_NAME varchar(20),"
				+ "CONTACT_NUMBER int(20) primary key,COURSE varchar(10),QUALIFICATION varchar(20),EMAIL_ID varchar(30))";
		
		dataSource = connectionManger.getDataSource();
		connection  =  dataSource.getConnection();
		statement = connection.createStatement();
		statement.execute(sql);
		return connection.isClosed();
	}
	
	public boolean postEnquery(Enquery enquery){
		
		String query = "INSERT INTO AppsPro.ENQUERY VALUES(?,?,?,?,?)";
		
		try {
		 dataSource = connectionManger.getDataSource();
		 connection  =  dataSource.getConnection();
		 connection.setAutoCommit(false);
		 preparedStatement = connection.prepareStatement(query);
		 
		 preparedStatement.setString(1, enquery.getName());
		 preparedStatement.setLong(2, enquery.getContactNumber());
		 preparedStatement.setString(3,enquery.getCourse());
		 preparedStatement.setString(4, enquery.getQualification());
		 preparedStatement.setString(5,enquery.getEmailId());
		 
		if(!preparedStatement.execute()) {
			connection.commit();
			return true;
		    }
	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
				preparedStatement.close();
				connection.close();	
			} catch (SQLException e) {
				e.printStackTrace();
			}					
		}	
		return false;
	}

	
   public List<Enquery> getEnqueries() throws SQLException{
		String query = "select * from AppsPro.ENQUERY";
		List<Enquery> enqueries = new ArrayList<>();
		
		 dataSource = connectionManger.getDataSource();
		 connection  =  dataSource.getConnection();
		 statement = connection.createStatement();
		 resultSet = statement.executeQuery(query);
		 while (resultSet.next()) {
			 Enquery enquery = new Enquery();
			 enquery.setName(resultSet.getString(1));
			 enquery.setContactNumber(resultSet.getLong(2));
			 enquery.setCourse(resultSet.getString(3));
			 enquery.setQualification(resultSet.getString(4));
			 enquery.setEmailId(resultSet.getString(5));
			 enqueries.add(enquery);
		}
		return enqueries;
	}

}
