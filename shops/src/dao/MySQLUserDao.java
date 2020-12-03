package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import daofactory.Connector;

public class MySQLUserDao implements UserDao{
	private PreparedStatement st = null;

	@Override
	public void addUser(User u) {
		try {
			Connection cn = Connector.connect();
			
			String sql = "INSERT INTO shop.user_table(name, kana, mail, login_id, password, gender, birthday, tell, postal_code, address) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			st = cn.prepareStatement(sql);
			
			st.setString(1, u.getName());
			st.setString(2, u.getKana());
			st.setString(3, u.getMail());
			st.setString(4, u.getLoginId());
			st.setString(5, u.getPassword());
			st.setString(6, u.getGender());
			st.setString(7, u.getBirthday());
			st.setString(8, u.getTell());
			st.setString(9, u.getPostalCode());
			st.setString(10, u.getAddress());
	
			st.executeUpdate();
			
			
			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List getUser(String userId) {
		ArrayList user = new ArrayList();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT user_id name, kana, mail, login_id, password, gender, birthday, tell, postal_code, address, point FROM shop.user_table WHERE user_id=?";
			
			st = cn.prepareStatement(sql);
			st.setString(1, userId);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				
				User u = new User();
				System.out.println(u.getUserId());
				
				u.setUserId(rs.getString(1));
				u.setName(rs.getString(2));
				u.setKana(rs.getString(3));
				u.setMail(rs.getString(4));
				u.setLoginId(rs.getString(5));
				u.setPassword(rs.getString(6));
				u.setGender(rs.getString(7));
				u.setBirthday(rs.getString(8));
				u.setTell(rs.getString(9));
				u.setPostalCode(rs.getString(10));
				u.setAddress(rs.getString(11));
				u.setPoint(rs.getInt(12));
				
				user.add(u);
			}else {
				return null;
			}
			
		cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public List getAllUsers() {
		ArrayList user = new ArrayList();
		try {
			Connection cn = Connector.connect();
			
			String sql = "SELECT user_id, name, kana, mail, login_id, password, gender, birthday, tell, postal_code, address, point FROM shop.user_table ORDER BY user_id";
			st = cn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				User u = new User();
				
				u.setUserId(rs.getString(1));
				u.setName(rs.getString(2));
				u.setKana(rs.getString(3));
				u.setMail(rs.getString(4));
				u.setLoginId(rs.getString(5));
				u.setPassword(rs.getString(6));
				u.setGender(rs.getString(7));
				u.setBirthday(rs.getString(8));
				u.setTell(rs.getString(9));
				u.setPostalCode(rs.getString(10));
				u.setAddress(rs.getString(11));
				u.setPoint(rs.getInt(12));
				
				user.add(u);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	public void removeUser(String userId) {
		try {
			Connection cn = Connector.connect();
			String sql = "DELETE FROM shop.user_table WHERE user_id=?";
			st = cn.prepareStatement(sql);
			st.setString(1,userId);
			
			st.executeUpdate();
			
			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
