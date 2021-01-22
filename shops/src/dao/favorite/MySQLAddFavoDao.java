package dao.favorite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Favorite;
import daofactory.Connector;

public class MySQLAddFavoDao implements AddFavoDao{
	private PreparedStatement st = null;

	@Override
	public void addFavo(Favorite f) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			Connection cn = Connector.connect();
			String sql = "INSERT into shop.favo_table VALUES(?,?)";

			st = cn.prepareStatement(sql);

			st.setString(1, f.getUserId());
			st.setString(2, f.getItemId());

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
