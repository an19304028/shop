package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Item;
import daofactory.Connector;

public class MySQLItemDao implements ItemDao{
	private PreparedStatement st = null;
	private Connection cn = null;

	public void addItem(Item i) {
		try {
			Connection cn = Connector.connect();

			String sql = "INSERT into shop.item_table VALUES(?,?,?,?,?,?,?,?,?)";

			st = cn.prepareStatement(sql);

			st.setString(1, i.getItemId());
			st.setString(2, i.getItemName());
			st.setInt(3, i.getStockCount());
			st.setString(4, i.getSizeId());
			st.setString(5, i.getColorId());
			st.setInt(6, i.getPrice());
			st.setString(7, i.getCategoryId());
			st.setString(8, i.getDetail());
			st.setString(9, i.getImageId());


			st.executeUpdate();


			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Item getItem(String itemId) {

		return null;

	}

	public List getAllItems() {
		ArrayList items = new ArrayList();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT item_id, item_name ,color_image_path FROM shop.color_table";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Item i  = new Item();
				i.setItemId(rs.getString(1));
				i.setItemName(rs.getString(2));
				i.setStockCount(rs.getInt(3));
				i.setSizeId(rs.getString(4));
				i.setColorId(rs.getString(5));
				i.setPrice(rs.getInt(6));
				i.setCategoryId(rs.getString(7));
				i.setDetail(rs.getString(8));
				i.setImageId(rs.getString(9));

				items.add(i);

			}
			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return items;
	}

}
