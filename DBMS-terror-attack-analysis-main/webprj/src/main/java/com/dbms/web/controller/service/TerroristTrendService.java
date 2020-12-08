package com.dbms.web.controller.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.web.controller.entity.TerroristTrend;

public class TerroristTrendService {
	private String url="jdbc:oracle:thin:@oracle.cise.ufl.edu:1521/orcl";
	private String uid= "zhengyu";
	private String pwd="Lzy961005";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	public List<TerroristTrend> getList()throws ClassNotFoundException, SQLException{
		// for put sql 
		String sql ="WITH tamp AS\n"
				+ "(\n"
				+ "    SELECT gang_name, attack_type, event_year, COUNT(Event_id) AS num FROM AGASKIN.Event\n"
				+ "    NATURAL JOIN AGASKIN.Attack\n"
				+ "    WHERE gang_name = ANY(\n"
				+ "        SELECT gang_name FROM (\n"
				+ "            SELECT gang_name, count(event_id) as attack_count  FROM AGASKIN.ATTACK\n"
				+ "            NATURAL JOIN AGASKIN.Event\n"
				+ "            WHERE gang_name <> 'Unknown' \n"
				+ "            AND event_year BETWEEN 1990 AND 2000    -- input\n"
				+ "            GROUP BY gang_name      -- this is the list the user chooses from ***Note: it will be updated every time the time period changes\n"
				+ "            ORDER BY COUNT(event_id) DESC\n"
				+ "            )\n"
				+ "        WHERE ROWNUM <= 10\n"
				+ "        )\n"
				+ "    AND Event_year BETWEEN 1990 AND 2000    -- input\n"
				+ "    AND gang_name = 'Irish Republican Army (IRA)'         -- input\n"
				+ "    GROUP BY gang_name, attack_type, event_year\n"
				+ "    ORDER BY gang_name, attack_type, event_year\n"
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
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
//		if you want to make more queries copy and paste this with new sqls
//		Statement st2 = con.createStatement();
//		ResultSet rs2 = st.executeQuery(new sqls);



		List<TerroristTrend> TerroristTrendlist = new ArrayList<TerroristTrend>();
		
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

			
			TerroristTrend resulttlist = new TerroristTrend(event_year, UnarmedAssault, ArmedAssault, Hijacking, HostageTaking, Bombing, Facility, Assassination, Kidnapping);
			
			TerroristTrendlist.add(resulttlist);
			}
		
		rs.close();
		st.close();
		con.close();
		return TerroristTrendlist;
		
		
	}
	
	public List<TerroristTrend> getList2()throws ClassNotFoundException, SQLException{
		// for put sql 
		String sql ="WITH tamp AS\n"
				+ "(\n"
				+ "    SELECT targ_type, attack_type, event_month, COUNT(event_id) AS num FROM AGASKIN.Event\n"
				+ "    NATURAL JOIN (\n"
				+ "        SELECT target_id, targ_type FROM AGASKIN.Target\n"
				+ "        WHERE targ_type <> 'Unknown')\n"
				+ "    NATURAL JOIN (\n"
				+ "        SELECT attack_type, event_id FROM AGASKIN.Attack\n"
				+ "        WHERE attack_type <> 'Unknown')\n"
				+ "    WHERE event_month BETWEEN 1 AND 12   -- input\n"
				+ "    AND targ_type = 'Abortion Related'\n"
				+ "    GROUP BY targ_type, attack_type, event_month\n"
				+ ")\n"
				+ "SELECT a.event_month, NVL(b.num,0)UnarmedAssault, NVL(c.num,0)Hijacking, NVL(d.num,0)HostageTaking,\n"
				+ "    NVL(e.num,0)Bombing, NVL(f.num,0)Kidnapping, NVL(g.num,0)Facility,\n"
				+ "    NVL(h.num,0)Assassination, NVL(i.num,0)ArmedAssault\n"
				+ "FROM (SELECT DISTINCT event_month FROM tamp)a\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Unarmed Assault')b\n"
				+ "ON a.event_month = b.event_month\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Hijacking')c\n"
				+ "ON a.event_month = c.event_month\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Hostage Taking (Barricade Incident)')d\n"
				+ "ON a.event_month = d.event_month\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Bombing/Explosion')e\n"
				+ "ON a.event_month = e.event_month\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Hostage Taking (Kidnapping)')f\n"
				+ "ON a.event_month = f.event_month\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Facility/Infrastructure Attack')g\n"
				+ "ON a.event_month = g.event_month\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Assassination')h\n"
				+ "ON a.event_month = h.event_month\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE attack_type='Armed Assault')i\n"
				+ "ON a.event_month = i.event_month\n"
				+ "ORDER BY a.event_month ASC";
		
		//for connction with driver
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
		//Make a container to take the result from the sql
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
//		if you want to make more queries copy and paste this with new sqls
//		Statement st2 = con.createStatement();
//		ResultSet rs2 = st.executeQuery(new sqls);



		List<TerroristTrend> TerroristTrendlist = new ArrayList<TerroristTrend>();
		
		//From the above container, put the result into the list and each variable should be same with 
		//the entity (com.dbms.web.controller.entity.~~)
		while(rs.next()) {
		
			String event_year = rs.getString("event_month");
			 int UnarmedAssault = rs.getInt("UnarmedAssault");
			 int ArmedAssault = rs.getInt("ArmedAssault");
			 int Hijacking = rs.getInt("Hijacking");
			 int HostageTaking = rs.getInt("HostageTaking");
			 int Bombing = rs.getInt("Bombing");
			 int Facility = rs.getInt("Facility");
			 int Assassination = rs.getInt("Assassination");
			 int Kidnapping = rs.getInt("Kidnapping");

			
			TerroristTrend resulttlist = new TerroristTrend(event_year, UnarmedAssault, ArmedAssault, Hijacking, 
					HostageTaking, Bombing, Facility, Assassination, Kidnapping);
			
			TerroristTrendlist.add(resulttlist);
			}
		
		rs.close();
		st.close();
		con.close();
		return TerroristTrendlist;
		
		
	}

}
