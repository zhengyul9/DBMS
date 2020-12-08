package com.dbms.web.controller.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.dbms.web.controller.entity.SuccessRate;

public class SuccessRateService {
	private String url="jdbc:oracle:thin:@oracle.cise.ufl.edu:1521/orcl";
	private String uid= "daye";
	private String pwd="qwert1234";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
public List<SuccessRate> getList()throws ClassNotFoundException, SQLException{
		
		// for put sql 
		String sql ="WITH tamp AS\n"
				+ "(\n"
				+ "    SELECT region_name, event_year, ROUND(success/(success+failed), 3) as rate FROM\n"
				+ "    (\n"
				+ "        SELECT region_name, event_year, COUNT(Was_success) as success FROM AGASKIN.Attack \n"
				+ "        NATURAL JOIN AGASKIN.Event\n"
				+ "        NATURAL JOIN AGASKIN.Location\n"
				+ "        WHERE gang_name = 'Separatists'     -- input begin\n"
				+ "        AND event_year BETWEEN 1990 AND 2020    -- input end\n"
				+ "        AND Was_success = 1\n"
				+ "        GROUP BY region_name, event_year\n"
				+ "    ) a1\n"
				+ "    NATURAL JOIN\n"
				+ "    (\n"
				+ "        SELECT region_name, event_year, COUNT(Was_success) as failed FROM AGASKIN.Attack \n"
				+ "        NATURAL JOIN AGASKIN.Event\n"
				+ "        NATURAL JOIN AGASKIN.Location\n"
				+ "        WHERE gang_name = 'Separatists'     -- input begin\n"
				+ "        AND event_year BETWEEN 1990 AND 2020    -- input end\n"
				+ "        AND Was_success = 0\n"
				+ "        GROUP BY region_name, event_year\n"
				+ "    ) a2\n"
				+ "    ORDER BY event_year\n"
				+ ")\n"
				+ "SELECT a.event_year, NVL(b.rate,0)CentralAmericaAndCaribbean, NVL(c.rate,0)AustralasiaAndOceania, NVL(d.rate,0)SouthAmerica,\n"
				+ "    NVL(e.rate,0)CentralAsia, NVL(f.rate,0)MiddleEastAndNorthAfrica, NVL(g.rate,0)EastAsia,\n"
				+ "    NVL(h.rate,0)SouthAsia, NVL(i.rate,0)EasternEurope, NVL(j.rate,0)SoutheastAsia,\n"
				+ "    NVL(k.rate,0)WesternEurope, NVL(l.rate,0)SubSaharanAfrica, NVL(m.rate,0)NorthAmerica\n"
				+ "FROM (SELECT DISTINCT event_year FROM tamp)a\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE region_name='Central America and Caribbean')b\n"
				+ "ON a.event_year = b.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE region_name='Australasia and Oceania')c\n"
				+ "ON a.event_year = c.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE region_name='South America')d\n"
				+ "ON a.event_year = d.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE region_name='Central Asia')e\n"
				+ "ON a.event_year = e.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE region_name='Middle East and North Africa')f\n"
				+ "ON a.event_year = f.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE region_name='East Asia')g\n"
				+ "ON a.event_year = g.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE region_name='South Asia')h\n"
				+ "ON a.event_year = h.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE region_name='Eastern Europe')i\n"
				+ "ON a.event_year = i.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE region_name='Southeast Asia')j\n"
				+ "ON a.event_year = j.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE region_name='Western Europe')k\n"
				+ "ON a.event_year = k.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE region_name='Sub-Saharan Africa')l\n"
				+ "ON a.event_year = l.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE region_name='North America')m\n"
				+ "ON a.event_year = m.event_year\n"
				+ "ORDER BY a.event_year";
		
		//for connction with driver
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
		//Make a container to take the result from the sql
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
//		if you want to make more queries copy and paste this with new sqls
//		Statement st2 = con.createStatement();
//		ResultSet rs2 = st.executeQuery(new sqls);



		List<SuccessRate> SuccessRatelist = new ArrayList<SuccessRate>();
		
		//From the above container, put the result into the list and each variable should be same with 
		//the entity (com.dbms.web.controller.entity.~~)
		while(rs.next()) {
			
			 String event_year = rs.getString("event_year");
			 float CentralAmericaAndCaribbean = rs.getFloat("CentralAmericaAndCaribbean");
			 float AustralasiaAndOceania = rs.getFloat("AustralasiaAndOceania");
			 float SouthAmerica = rs.getFloat("SouthAmerica");
			 float CentralAsia = rs.getFloat("CentralAsia");
			 float MiddleEastAndNorthAfrica = rs.getFloat("MiddleEastAndNorthAfrica");
			 float EastAsia = rs.getFloat("EastAsia");
			 float SouthAsia = rs.getFloat("SouthAsia");
			 float EasternEurope = rs.getFloat("EasternEurope");
			 float Southeastasia = rs.getFloat("SoutheastAsia");
			 float WesternEurope = rs.getFloat("WesternEurope");
			 float SubSaharanAfrica = rs.getFloat("SubSaharanAfrica");
			 float NorthAmerica = rs.getFloat("NorthAmerica");

			SuccessRate resulttlist = new SuccessRate(event_year, CentralAmericaAndCaribbean, AustralasiaAndOceania, SouthAmerica, CentralAsia, MiddleEastAndNorthAfrica, EastAsia,SouthAsia, EasternEurope,Southeastasia,WesternEurope,SubSaharanAfrica,NorthAmerica );
			
			SuccessRatelist.add(resulttlist);
			}
		
		rs.close();
		st.close();
		con.close();
		return SuccessRatelist;
		
		
	}

}
