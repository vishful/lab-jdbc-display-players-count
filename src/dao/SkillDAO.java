package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO{
	
	String sql="  SELECT Skill, COUNT(name) FROM skillName GROUP BY name";
	
	static TreeMap<Skill,Integer> skillMap= new TreeMap<Skill, Integer>(); 
	
	int count=0;
	
	Skill skill=null;
	
public TreeMap<Skill,Integer> skillCount() throws SQLException, Exception{
	
	PreparedStatement ps=ConnectionManager.getConnection().prepareStatement(SELECT_ALL_BLOGS);
	
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()) {
		skill=new Skill();
		skill.setSkillName(rs.getString("name"));
		count=rs.getInt("count("name")");
		skillMap.put(skill,count);
	}
		return true;
	}

}



/*		ConnectionManager cm=new ConnectionManager();
PreparedStatement st= cm.getConnection().prepareStatement(sql);
long id = skill.getSkillId();
String skillName=skill.getSkillName();
skill=new Skill(id,skillName);
st.setString(1, skillName);*/