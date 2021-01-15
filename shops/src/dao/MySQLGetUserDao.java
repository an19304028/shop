package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import dao.admin.GetUserDao;
import daofactory.Connector;

public class MySQLGetUserDao implements GetUserDao{
	private PreparedStatement st = null;
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

}
