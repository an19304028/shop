package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Size;
import daofactory.Connector;

public class MySQLSizeDao implements SizeDao{
	private PreparedStatement st = null;


	public void addSize(Size s) {
		try {
			Connection cn = Connector.connect();

			String sql = "INSERT into shop.size_table VALUES(?,?,?)";

			st = cn.prepareStatement(sql);

			st.setString(1, s.getSizeId());
			st.setString(2, s.getSizeName());

			st.executeUpdate();


			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

	public Size getSize(String sizeId) {
		Size s = new Size();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT size_id, size_name FROM shop.size_table WHERE size_id=?";
			st = cn.prepareStatement(sql);

			st.setString(1, "'sizeId'");

			ResultSet rs = st.executeQuery();
			System.out.println(rs.getString(1));
			rs.next();
			s.setSizeId(rs.getString(1));
			s.setSizeName(rs.getString(2));

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return s;
	}
}

