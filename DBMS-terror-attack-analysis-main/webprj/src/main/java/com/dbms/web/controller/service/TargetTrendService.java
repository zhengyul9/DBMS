package com.dbms.web.controller.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.dbms.web.controller.entity.TargetTrend;


public class TargetTrendService {
	private String url="jdbc:oracle:thin:@oracle.cise.ufl.edu:1521/orcl";
	private String uid= "daye";
	private String pwd="qwert1234";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	public List<TargetTrend> getList(String target)throws ClassNotFoundException, SQLException{
		
		// for put sql 
		String sql ="WITH tamp AS\n"
				+ "(\n"
				+ "    SELECT targ_type, attack_type, event_year, COUNT(event_id) AS num FROM AGASKIN.Event\n"
				+ "    NATURAL JOIN (\n"
				+ "        SELECT target_id, targ_type FROM AGASKIN.Target\n"
				+ "        WHERE targ_type <> 'Unknown')\n"
				+ "    NATURAL JOIN (\n"
				+ "        SELECT attack_type, event_id FROM AGASKIN.Attack\n"
				+ "        WHERE attack_type <> 'Unknown')\n"
				+ "    WHERE event_year BETWEEN 1985 AND 2003   -- input\n"
				+ "    AND targ_type = ?       -- input\n"
				+ "    GROUP BY targ_type, attack_type, event_year\n"
				+ ")\n"
				+ "SELECT a.event_year, NVL(b.num,0)UnarmedAssault, NVL(c.num,0)Hijacking, NVL(d.num,0)HostageTaking,\n"
				+ "    NVL(e.num,0)Bombing, NVL(f.num,0)Kidnapping, NVL(g.num,0)Facility,\n"
				+ "    NVL(h.num,0)Assassination, NVL(i.num,0)ArmedAssault\n"
				+ "FROM (SELECT DISTINCT event_year FROM tamp)a\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Unarmed Assault')b\n"
				+ "ON a.event_year = b.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Hijacking')c\n"
				+ "ON a.event_year = c.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Hostage Taking (Barricade Incident)')d\n"
				+ "ON a.event_year = d.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Bombing/Explosion')e\n"
				+ "ON a.event_year = e.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Hostage Taking (Kidnapping)')f\n"
				+ "ON a.event_year = f.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Facility/Infrastructure Attack')g\n"
				+ "ON a.event_year = g.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Assassination')h\n"
				+ "ON a.event_year = h.event_year\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Armed Assault')i\n"
				+ "ON a.event_year = i.event_year\n"
				+ "ORDER BY a.event_year ASC";
		
		//for connction with driver
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
		//Make a container to take the result from the sql
		//Statement st = con.createStatement();
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, target);
		ResultSet rs = statement.executeQuery();
		
//		if you want to make more queries copy and paste this with new sqls
//		Statement st2 = con.createStatement();
//		ResultSet rs2 = st.executeQuery(new sqls);



		List<TargetTrend> TargetTrendlist = new ArrayList<TargetTrend>();
		
		//From the above container, put the result into the list and each variable should be same with 
		//the entity (com.dbms.web.controller.entity.~~)
		while(rs.next()) {
			
			 String event_year = rs.getString("event_year");
			 int UnarmedAssault = rs.getInt("UnarmedAssault");
			 int ArmedAssault = rs.getInt("ArmedAssault");
			 int Hijacking = rs.getInt("Hijacking");
			 int HostageTaking = rs.getInt("HostageTaking");
			 int Bombing = rs.getInt("Bombing");
			 int Facility = rs.getInt("Facility");
			 int Assassination = rs.getInt("Assassination");
			 int Kidnapping = rs.getInt("Kidnapping");
		
			TargetTrend resulttlist = new TargetTrend(event_year, UnarmedAssault, ArmedAssault, Hijacking, HostageTaking, Bombing, Facility, Assassination, Kidnapping);
			
			TargetTrendlist.add(resulttlist);
			}
		
		rs.close();
		//st.close();
		statement.close();
		con.close();
		return TargetTrendlist;
		
		
	}
	
public List<String> getListTarget()throws ClassNotFoundException, SQLException{
		
		// for put sql 
		String sql ="select distinct(Targ_type) from AGASKIN.Target";
		
		//for connction with driver
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
		//Make a container to take the result from the sql
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
//		if you want to make more queries copy and paste this with new sqls
//		Statement st2 = con.createStatement();
//		ResultSet rs2 = st.executeQuery(new sqls);



		List<String> TargetList = new ArrayList<String>();
		
		//From the above container, put the result into the list and each variable should be same with 
		//the entity (com.dbms.web.controller.entity.~~)
		while(rs.next()) {
			
			 String event_year = rs.getString("TARG_TYPE");
			 
		
			//TargetTrend resulttlist = new TargetTrend(event_year, UnarmedAssault, ArmedAssault, Hijacking, HostageTaking, Bombing, Facility, Assassination, Kidnapping);
			
			TargetList.add(event_year);
			}
		
		rs.close();
		st.close();
		con.close();
		return TargetList;
		
		
	}
	
}
	
	