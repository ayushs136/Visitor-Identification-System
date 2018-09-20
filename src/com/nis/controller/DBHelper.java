package com.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONObject;

public class DBHelper {
 public static Connection openConnection()
 {try{
   Class.forName("com.mysql.jdbc.Driver").newInstance();	 
   Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/VIS","root","123");
    return cn;
 
 }catch(Exception e){
	 System.out.println("Error:"+e);
	 return null;
 }
  }
 
 public static boolean executeNonQuery(String query,Connection cn)
 {try{
	 Statement smt=cn.createStatement();
	 smt.executeUpdate(query);
	 return(true);
	 
 }catch(Exception e){
	 System.out.println("Error:"+e);
	 return(false);
 }
	 
	 
 }
 
 
 public static ResultSet executeQuery(String query,Connection cn)
 {try{
	 Statement smt=cn.createStatement();
	ResultSet rs=smt.executeQuery(query);
	 return(rs);
	 
 }catch(Exception e){
	 System.out.println("Error:"+e);
	 return(null);
 }
	 
	 
 }
 
 public static ArrayList<JSONObject> JsonEngine(ResultSet rs) {
		ArrayList<JSONObject> resList = new ArrayList<JSONObject>();
		try {
		//get column names
		ResultSetMetaData rsMeta = rs.getMetaData();
		int columnCnt = rsMeta.getColumnCount();
		ArrayList<String> columnNames = new ArrayList<String>();
		for(int i=1;i<=columnCnt;i++) {
		columnNames.add(rsMeta.getColumnName(i).toUpperCase());
		}

		while(rs.next()) { // convert each object to an human readable JSON object
		JSONObject obj = new JSONObject();
		for(int i=1;i<=columnCnt;i++) {
		String key = columnNames.get(i - 1);
		String value = rs.getString(i);
		obj.put(key, value);
		}
		resList.add(obj);
		}
		} catch(Exception e) {
		e.printStackTrace();
		} finally {
		try {
		rs.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		return resList;
		}
	
	

}
