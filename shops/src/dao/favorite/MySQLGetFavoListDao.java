package dao.favorite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Favorite;
import daofactory.Connector;

public class MySQLGetFavoListDao implements GetFavoListDao{
	private PreparedStatement st = null;

	@Override
	public List getFavoList() {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList favo = new ArrayList();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT user_id,item_id FROM shop.favo_table ";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Favorite f = new Favorite();
				f.setUserId(rs.getString(1));
				f.setItemId(rs.getString(2));

				favo.add(f);
			}
			cn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return favo;
	}

}
