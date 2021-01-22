package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import daofactory.Connector;

public class MySQLRemoveImageDao implements RemoveImageDao{
	private PreparedStatement st = null;
	@Override
	//画像の削除
	public void removeImage(String imageId) {
		try {
			Connection cn = Connector.connect();
			String sql = "DELETE FROM shop.image_table WHERE image_id = ?";
			st = cn.prepareStatement(sql);
			st.setString(1, imageId);

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
