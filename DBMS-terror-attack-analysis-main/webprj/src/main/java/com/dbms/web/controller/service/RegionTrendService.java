package com.dbms.web.controller.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.dbms.web.controller.entity.RegionTrend;

public class RegionTrendService {
	private String url="jdbc:oracle:thin:@oracle.cise.ufl.edu:1521/orcl";
	private String uid= "daye";
	private String pwd="qwert1234";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	public List<RegionTrend> getList()throws ClassNotFoundException, SQLException{
		
		
		// for put sql 
		String sql ="WITH tamp AS\r\n"
				+ "(SELECT country_code country_code, country_name country_name, d.property_val property_damage,\r\n"
				+ "(d.killed+d.wounded)fatality, e.event_year event_year\r\n"
				+ "FROM (SELECT event_id,event_year, country_code FROM AGASKIN.EVENT)e NATURAL JOIN AGASKIN.LOCATION \r\n"
				+ "NATURAL JOIN AGASKIN.DAMAGE d\r\n"
				+ "ORDER BY e.event_year ASC)\r\n"
				+ "SELECT country_code, country_name, property_damage, fatality, frequency FROM\r\n"
				+ "(SELECT country_code, country_name, SUM(property_damage) property_damage,SUM(fatality)fatality, count(*) frequency, \r\n"
				+ " RANK() OVER(ORDER BY count(*) DESC) rank\r\n"
				+ "FROM tamp WHERE (event_year BETWEEN 2000 and 2017) \r\n"
				+ "GROUP BY country_code, country_name HAVING SUM(property_damage)>0 AND SUM(fatality) >0)\r\n"
				+ "WHERE rank <20";
		
		//for connction with driver
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
		//Make a container to take the result from the sql
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
//		if you want to make more queries copy and paste this with new sqls
//		Statement st2 = con.createStatement();
//		ResultSet rs2 = st.executeQuery(new sqls);



		List<RegionTrend> RegionTrendlist = new ArrayList<RegionTrend>();
		
		//From the above container, put the result into the list and each variable should be same with 
		//the entity (com.dbms.web.controller.entity.~~)
		while(rs.next()) {
			
			String country_code = rs.getString("country_code");
			String country_name = rs.getString("country_name");
			int property_damage = rs.getInt("property_damage");
			int fatality = rs.getInt("fatality");
			int frequency = rs.getInt("frequency");
			
			RegionTrend resulttlist = new RegionTrend(country_code,country_name,property_damage,fatality,frequency);
			
			RegionTrendlist.add(resulttlist);
			}
		
		rs.close();
		st.close();
		con.close();
		return RegionTrendlist;
		
		
	}

}
