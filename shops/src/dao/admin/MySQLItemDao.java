package dao.admin;

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

	@Override
	//追加
	public void addItem(Item i) {
		try {
			Connection cn = Connector.connect();
			String sql= "INSERT into shop.item_table VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

	@Override
	//編集
	public void EditItem(Item i) {
		//一旦保留by加村
//		try {
//			Connection cnConnection = Connector.connect();
//			String sqlString = "UPDATE shop.item_table set";
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

	}

	@Override
	//全取り出し
	public List getAllItem() {
		ArrayList items = new ArrayList();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT item_id, item_name, stock_count, size_id, color_id, price, category_id, detail, image_id"
								+"FROM shop.item_table ORDER BY LENGTH(item_id)";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Item i = new Item();
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
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

	@Override
	//取り出し
	public List getItem(String itemId) {
		ArrayList Item = new ArrayList();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT item_id, item_name, stock_count, size_id, color_id, price, category_id, detail, image_id"
						+ "FROM shop.item_table WHERE item_id = ?";
			//長くなったので改行

			st = cn.prepareStatement(sql);
			st.setString(1, itemId);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				Item i = new Item();
				System.out.println(i.getItemId());
				i.setItemId(rs.getString(1));
				i.setItemName(rs.getString(2));
				i.setStockCount(rs.getInt(3));
				i.setSizeId(rs.getString(4));
				i.setColorId(rs.getString(5));
				i.setPrice(rs.getInt(6));
				i.setCategoryId(rs.getString(7));
				i.setDetail(rs.getString(8));
				i.setImageId(rs.getString(9));

				Item.add(i);

				cn.close();

			}else {
				return null;
			}


		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Item;
	}

	@Override
	//削除
	public void removeItem(String itemId) {
		try {
			Connection cn = Connector.connect();
			String sql = "DELETE FROM shop.item_table WHERE item_id = ?";
			st = cn.prepareStatement(sql);
			st.setString(1, itemId);

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
