package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.image;
import daofactory.Connector;

public class MySQLImageDao implements ImageDao {
	private PreparedStatement st = null;
	private Connection cn = null;

	public void addImage(image i) {
		try {
			Connection cn = Connector.connect();

			String sql = "INSERT into shop.image_table VALUES(?,?)";

			st = cn.prepareStatement(sql);

			st.setString(1, i.getImageId());
			st.setString(2, i.getImagePath());

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public image getImage(String imageId) {
		image i = new image();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT image_id,image_path,item_id FROM shop.image_table WHERE image_id=?";
			st = cn.prepareStatement(sql);

			st.setString(1, imageId);

			ResultSet rs = st.executeQuery();
			System.out.println(rs.getString(1));
			rs.next();
			i.setImageId(rs.getString(1));
			i.setImagePath(rs.getString(2));

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return i;
	}
}
