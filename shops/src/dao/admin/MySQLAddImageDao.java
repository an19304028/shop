package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Image;
import daofactory.Connector;

public class MySQLAddImageDao implements AddImageDao{
	private PreparedStatement st = null;

	//画像の追加
	public void addImage(Image i) {
		try {
			Connection cn = Connector.connect();
			String sql= "INSERT into shop.image_table(image_path, item_id) VALUES(?, ?)";

			st = cn.prepareStatement(sql);

			st.setString(1, i.getImagePath());
			st.setString(2, i.getItemId());

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
