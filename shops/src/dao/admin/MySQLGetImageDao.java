package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Image;
import daofactory.Connector;

public class MySQLGetImageDao implements GetImageDao{
	private PreparedStatement st = null;

	@Override
	public List getImage(String itemId) {
		ArrayList images = new ArrayList();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT image_path FROM shop.image_table WHERE item_id = ?";
			st = cn.prepareStatement(sql);
			st.setString(1, itemId);
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				Image i = new Image();
				i.setImagePath(rs.getString(1));

				images.add(i);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return images;
	}

}
