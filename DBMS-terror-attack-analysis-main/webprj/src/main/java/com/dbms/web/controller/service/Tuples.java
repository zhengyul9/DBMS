package com.dbms.web.controller.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.dbms.web.controller.entity.Table;

public class Tuples {
	private String url="jdbc:oracle:thin:@oracle.cise.ufl.edu:1521/orcl";
	private String uid= "daye";
	private String pwd="qwert1234";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
public List<Table> getList()throws ClassNotFoundException, SQLException{
		
		// for put sql 
		String sql ="SELECT COUNT(*),'Weapon' AS NAME FROM AGASKIN.Weapon    --45\r\n"
				+ "UNION\r\n"
				+ "SELECT COUNT(*),'Target' AS NAME FROM AGASKIN.Target     --139\r\n"
				+ "UNION\r\n"
				+ "SELECT COUNT(*),'Location' AS NAME FROM AGASKIN.Location  --205\r\n"
				+ "UNION\r\n"
				+ "SELECT COUNT(*),'Attack' AS NAME  FROM AGASKIN.Attack    --180764\r\n"
				+ "UNION\r\n"
				+ "SELECT COUNT(*),'Damage' AS NAME  FROM AGASKIN.Damage\r\n"
				+ "UNION\r\n"
				+ "SELECT COUNT(*),'Event' AS NAME  FROM AGASKIN.Event ";
		
		//for connction with driver
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
		//Make a container to take the result from the sql
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
//		if you want to make more queries copy and paste this with new sqls
//		Statement st2 = con.createStatement();
//		ResultSet rs2 = st.executeQuery(new sqls);



		List<Table> SuccessRatelist = new ArrayList<Table>();
		
		//From the above container, put the result into the list and each variable should be same with 
		//the entity (com.dbms.web.controller.entity.~~)
		while(rs.next()) {
			
			 String event_year = rs.getString("NAME");
			 int num=rs.getInt(1);

			Table resulttlist = new Table();
			resulttlist.setSize(num);
			resulttlist.setTablename(event_year);
			
			SuccessRatelist.add(resulttlist);
			}
		
		rs.close();
		st.close();
		con.close();
		return SuccessRatelist;
		
		
	}

}
