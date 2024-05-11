package MyPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Students {
 public void createDataBase(){
	 try {
		 String url = "jdbc:mysql://localhost:3306/";
		 String username = "root";
		 String password = "#@!Roki****";
		 
		 Connection conn = DriverManager.getConnection(url,username,password);
		 Statement stm = conn.createStatement();
		 String query = "create database RollNo";
		 boolean bl = stm.execute(query);
		 
		 conn.close();
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
  }
 public void createTable() {
	 try {
		 String url = "jdbc:mysql://localhost:3306/";
		 String dbName = "RollNo";
		 String username = "root";
		 String password = "#@!Roki****";
		 
		 Connection conn = DriverManager.getConnection(url+dbName,username,password);
		 Statement stm = conn.createStatement();
		 
		 String query = "create table class9 (roll int(3) PRIMARY KEY, name varchar(20))";
		 boolean bl = stm.execute(query);
		 System.out.println("Successfully table created");
		 conn.close();
		 
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
 }
 public void createData() {
	 try {
		 String url = "jdbc:mysql://localhost:3306/";
		 String dbName = "RollNo";
		 String username = "root";
		 String password = "#@!Roki****";
		 
		 Connection conn = DriverManager.getConnection(url+dbName,username,password);
		 
		 
		 String query = "INSERT into class9 (Roll, Name) VALUES (?,?)";
		 PreparedStatement pstm = conn.prepareStatement(query);
		 
		 pstm.setInt(1, 5);
		 pstm.setString(2, "koushik Roy");
		 
		 //pstm.execute();
		 pstm.executeUpdate();
		 System.out.println("Successfully data INSERT");
		 conn.close();
		 
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
 }
public void readData() {
	 try {
		 String url = "jdbc:mysql://localhost:3306/";
		 String dbName = "RollNo";
		 String username = "root";
		 String password = "#@!Roki****";
		 
		 Connection conn = DriverManager.getConnection(url+dbName,username,password);
		 
		 
		 String query = "Select * from class9";
		 Statement stm = conn.createStatement();
		 	 
		 //stm.execute(query);
		ResultSet rset = stm.executeQuery (query);
		 
		while(rset.next()) {
			System.out.print(" roll = "+rset.getInt(1));
			System.out.print(" --> Name = "+rset.getString(2));
			System.out.println();
		}
		 System.out.println("Successfully data READ");
		 conn.close();
		 
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
	
}
public void updateData() {
	 try {
		 String url = "jdbc:mysql://localhost:3306/";
		 String dbName = "RollNo";
		 String username = "root";
		 String password = "#@!Roki****";
		 
		 Connection conn = DriverManager.getConnection(url+dbName,username,password);
		 		 
		 String query = "UPDATE class9 set Name = ? where Roll = ?";
		 PreparedStatement pstm = conn.prepareStatement(query);
		 pstm.setString(1, "Rakesh Roy");
		 pstm.setInt(2, 4);
		 
		 pstm.execute();
		 System.out.println("Successfully data UPDATED");
		 conn.close();
		 
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
	
}
public void deleteData() {
	try {
		 String url = "jdbc:mysql://localhost:3306/";
		 String dbName = "RollNo";
		 String username = "root";
		 String password = "#@!Roki****";
		 
		 Connection conn = DriverManager.getConnection(url+dbName,username,password);
		 String query = "DELETE from class9 where roll = ?";
		 
		 PreparedStatement pstm = conn.prepareStatement(query);
		 pstm.setInt(1,3);
		 pstm.executeUpdate();
		 System.out.println("DELETED Successfully");
		 conn.close();
	 } catch (Exception e) {
		 e.printStackTrace();
	 }
	
}
}

