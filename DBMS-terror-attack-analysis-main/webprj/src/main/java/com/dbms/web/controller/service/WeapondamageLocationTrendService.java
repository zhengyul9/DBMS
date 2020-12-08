package com.dbms.web.controller.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.web.controller.entity.WeapondamageLocationTrend;


public class WeapondamageLocationTrendService {
	private String url="jdbc:oracle:thin:@oracle.cise.ufl.edu:1521/orcl";
	private String uid= "daye";
	private String pwd="qwert1234";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	public List<WeapondamageLocationTrend> getList()throws ClassNotFoundException, SQLException{
		
		// for put sql 
		String sql ="";
		
		//for connction with driver
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
		//Make a container to take the result from the sql
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
//		if you want to make more queries copy and paste this with new sqls
//		Statement st2 = con.createStatement();
//		ResultSet rs2 = st.executeQuery(new sqls);



		List<WeapondamageLocationTrend> WeapondamageLocationTrend = new ArrayList<WeapondamageLocationTrend>();
		
		//From the above container, put the result into the list and each variable should be same with 
		//the entity (com.dbms.web.controller.entity.~~)
		while(rs.next()) {
			
//			 String event_year = rs.getString("event_year");
//			 int Biological= rs.getInt("Biological");
//			 int Chemical= rs.getInt("Chemical");
//			 int Explosives= rs.getInt("Explosives");
//			 int Fake_Weapons= rs.getInt("Fake_Weapons");
//			 int Firearms= rs.getInt("Firearms");
//			 int Incendiary= rs.getInt("Incendiary");
//			 int Meleev= rs.getInt("Melee");
//			 int Other= rs.getInt("Other");
//			 int Radiological= rs.getInt("Radiological");
//			 int Sabotage_Equipment= rs.getInt("Sabotage_Equipment");
//			 int Vehicle= rs.getInt("Vehicle");

			
			WeapondamageLocationTrend resulttlist = new WeapondamageLocationTrend();
			
			WeapondamageLocationTrend.add(resulttlist);
			}
		
		rs.close();
		st.close();
		con.close();
		return WeapondamageLocationTrend;
		
	}
}
