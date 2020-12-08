package com.dbms.web.controller.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dbms.web.controller.entity.WeaponTrend;

public class WeaponService {
	private String url="jdbc:oracle:thin:@oracle.cise.ufl.edu:1521/orcl";
	private String uid= "daye";
	private String pwd="qwert1234";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	public List<WeaponTrend> getList()throws ClassNotFoundException, SQLException{
		String sql ="WITH tamp AS\r\n"
				+ "(SELECT wep_type, event_year, COUNT(*)num FROM AGASKIN.Weapon\r\n"
				+ "NATURAL JOIN AGASKIN.Event\r\n"
				+ "WHERE event_year >= 1985\r\n"
				+ "AND event_year <= 2000\r\n"
				+ "AND weapon_id <> -9\r\n"
				+ "GROUP BY wep_type, event_year)\r\n"
				+ "SELECT c9.*,NVL(v.num,0)Vehicle FROM\r\n"
				+ "(SELECT c8.*,NVL(s.num,0)Sabotage_Equipment FROM\r\n"
				+ "(SELECT c7.*,NVL(r.num,0)Radiological FROM\r\n"
				+ "(SELECT c6.*,NVL(o.num,0)Other FROM\r\n"
				+ "(SELECT c5.*,NVL(m.num,0)Melee FROM\r\n"
				+ "(SELECT c4.*,NVL(i.num,0)Incendiary FROM\r\n"
				+ "(SELECT c3.*,NVL(f1.num,0)Firearms FROM (SELECT c2.*, NVL(f.num,0)Fake_Weapons FROM (SELECT c1.*, NVL(e.num,0)Explosives FROM (SELECT c.event_year event_year, c.Chemical, NVL(b.num,0)Biological \r\n"
				+ "FROM (SELECT x.event_year event_year,NVL(y.num,0) Chemical FROM (SELECT DISTINCT event_year FROM tamp)x LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Chemical')y\r\n"
				+ "ON x.event_year = y.event_year)c LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Biological')b ON c.event_year = b.event_year) c1 \r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Explosives')e ON c1.event_year = e.event_year)c2\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Fake Weapons')f ON c2.event_year = f.event_year)c3 \r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Firearms')f1 ON c3.event_year = f1.event_year)c4\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Incendiary')i ON c4.event_year = i.event_year)c5\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Melee')m ON c5.event_year = m.event_year)c6\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Other')o ON c6.event_year = o.event_year)c7\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Radiological')r ON c7.event_year = r.event_year)c8\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Sabotage Equipment')s ON c8.event_year = s.event_year)c9\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Vehicle (not explosive)')v ON c9.event_year = v.event_year\r\n"
				+ "ORDER BY c9.event_year ASC";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<WeaponTrend> wtlist = new ArrayList<WeaponTrend>();
		while(rs.next()) {
			 String event_year = rs.getString("event_year");
			 int Biological= rs.getInt("Biological");
			 int Chemical= rs.getInt("Chemical");
			 int Explosives= rs.getInt("Explosives");
			 int Fake_Weapons= rs.getInt("Fake_Weapons");
			 int Firearms= rs.getInt("Firearms");
			 int Incendiary= rs.getInt("Incendiary");
			 int Meleev= rs.getInt("Melee");
			 int Other= rs.getInt("Other");
			 int Radiological= rs.getInt("Radiological");
			 int Sabotage_Equipment= rs.getInt("Sabotage_Equipment");
			 int Vehicle= rs.getInt("Vehicle");

			
			 WeaponTrend weapont = new WeaponTrend(event_year,Biological,Chemical,Explosives,Fake_Weapons,Firearms,Incendiary,Meleev,Other,Radiological,Sabotage_Equipment,Vehicle);
			
			wtlist.add(weapont);
			}
		rs.close();
		st.close();
		con.close();
		return wtlist;
		
		
	}
	
	public List<WeaponTrend> getList2()throws ClassNotFoundException, SQLException{
		String sql ="WITH tamp AS\r\n"
				+ "(SELECT wep_type, event_year, COUNT(*)num FROM AGASKIN.Weapon\r\n"
				+ "NATURAL JOIN AGASKIN.Event\r\n"
				+ "WHERE event_year >= 2000\r\n"
				+ "AND weapon_id <> -9\r\n"
				+ "GROUP BY wep_type, event_year)\r\n"
				+ "SELECT c9.*,NVL(v.num,0)Vehicle FROM\r\n"
				+ "(SELECT c8.*,NVL(s.num,0)Sabotage_Equipment FROM\r\n"
				+ "(SELECT c7.*,NVL(r.num,0)Radiological FROM\r\n"
				+ "(SELECT c6.*,NVL(o.num,0)Other FROM\r\n"
				+ "(SELECT c5.*,NVL(m.num,0)Melee FROM\r\n"
				+ "(SELECT c4.*,NVL(i.num,0)Incendiary FROM\r\n"
				+ "(SELECT c3.*,NVL(f1.num,0)Firearms FROM (SELECT c2.*, NVL(f.num,0)Fake_Weapons FROM (SELECT c1.*, NVL(e.num,0)Explosives FROM (SELECT c.event_year event_year, c.Chemical, NVL(b.num,0)Biological \r\n"
				+ "FROM (SELECT x.event_year event_year,NVL(y.num,0) Chemical FROM (SELECT DISTINCT event_year FROM tamp)x LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Chemical')y\r\n"
				+ "ON x.event_year = y.event_year)c LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Biological')b ON c.event_year = b.event_year) c1 \r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Explosives')e ON c1.event_year = e.event_year)c2\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Fake Weapons')f ON c2.event_year = f.event_year)c3 \r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Firearms')f1 ON c3.event_year = f1.event_year)c4\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Incendiary')i ON c4.event_year = i.event_year)c5\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Melee')m ON c5.event_year = m.event_year)c6\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Other')o ON c6.event_year = o.event_year)c7\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Radiological')r ON c7.event_year = r.event_year)c8\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Sabotage Equipment')s ON c8.event_year = s.event_year)c9\r\n"
				+ "LEFT OUTER JOIN (SELECT * FROM tamp WHERE wep_type='Vehicle (not explosive)')v ON c9.event_year = v.event_year\r\n"
				+ "ORDER BY c9.event_year ASC";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<WeaponTrend> wtlist = new ArrayList<WeaponTrend>();
		while(rs.next()) {
			 String event_year = rs.getString("event_year");
			 int Biological= rs.getInt("Biological");
			 int Chemical= rs.getInt("Chemical");
			 int Explosives= rs.getInt("Explosives");
			 int Fake_Weapons= rs.getInt("Fake_Weapons");
			 int Firearms= rs.getInt("Firearms");
			 int Incendiary= rs.getInt("Incendiary");
			 int Meleev= rs.getInt("Melee");
			 int Other= rs.getInt("Other");
			 int Radiological= rs.getInt("Radiological");
			 int Sabotage_Equipment= rs.getInt("Sabotage_Equipment");
			 int Vehicle= rs.getInt("Vehicle");

			
			 WeaponTrend weapont = new WeaponTrend(event_year,Biological,Chemical,Explosives,Fake_Weapons,Firearms,Incendiary,Meleev,Other,Radiological,Sabotage_Equipment,Vehicle);
			
			wtlist.add(weapont);
			}
		rs.close();
		st.close();
		con.close();
		return wtlist;
		
		
	}
}
