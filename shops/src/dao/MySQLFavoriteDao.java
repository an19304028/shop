package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Favorite;
import daofactory.Connector;

public class MySQLFavoriteDao {

	private PreparedStatement st = null;


	public void addFavorite(Favorite f) {
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

	public Favorite getFavorite(String userId) {
		Favorite fav = new Favorite();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT user_id, item_id FROM shop.favo_table WHERE user_id=?";
			st = cn.prepareStatement(sql);
//
//			st.setString(1, userId);
//
			ResultSet rs = st.executeQuery();
			System.out.println("user_id:"+rs.getString(1));
			System.out.println("お気に入り商品:"+rs.getString(2));
//			rs.next();
			fav.setUserId(rs.getString(1));
			fav.setItemId(rs.getString(2));
//
			cn.commit();
			cn.close();


		}catch(SQLException e) {
			e.printStackTrace();
		}

		return fav;
	}

	public List getAllFavorites() {
		ArrayList favos = new ArrayList();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT user_id, item_id FROM shop.favo_table";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Favorite fav = new Favorite();
				fav.setUserId(rs.getString(1));
				fav.setItemId(rs.getString(2));

				favos.add(fav);

			}
			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return favos;
	}


}
