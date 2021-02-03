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
			//変更保留
			String sql= "INSERT into shop.item_table(item_name, stock_count, size_id, color_id, price, category_id, detail) VALUES(?, ?, ?, ?, ?, ?, ?)";

			st = cn.prepareStatement(sql);

			st.setString(1, i.getItemName());
			st.setInt(2, i.getStockCount());
			st.setString(3, i.getSizeId());
			st.setString(4, i.getColorId());
			st.setInt(5, i.getPrice());
			st.setString(6, i.getCategoryId());
			st.setString(7, i.getDetail());

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
		try {
			Connection cn = Connector.connect();
			String sql = "UPDATE shop.item_table set stock_count = ?, detail = ? where item_id = ?";

			st = cn.prepareStatement(sql);

			st.setInt(1, i.getStockCount());
			st.setString(2, i.getDetail());
			st.setString(3, i.getItemId());

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	//全取り出し
	public List getAllItem() {
		ArrayList items = new ArrayList();
		try {
			Connection cn = Connector.connect();
			//結合で書いて
			String sql = "SELECT shop.item_table.item_id, item_name, stock_count, size_id, color_id, price, category_id, detail, image_path FROM shop.item_table LEFT JOIN shop.image_table USING(item_id) ORDER BY LENGTH(shop.item_table.item_id)";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Item i = new Item();
				//Image image = new Image();
				i.setItemId(rs.getString(1));
				i.setItemName(rs.getString(2));
				i.setStockCount(rs.getInt(3));
				i.setSizeId(rs.getString(4));
				i.setColorId(rs.getString(5));
				i.setPrice(rs.getInt(6));
				i.setCategoryId(rs.getString(7));
				i.setDetail(rs.getString(8));
				i.setImagePath(rs.getString(9));

				System.out.println(i.getImagePath());

				items.add(i);
				//items.add(image);

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
			//結合で書いて
			String sql = "SELECT item_id, item_name, stock_count, size_id, color_id, price, category_id, detail, image_path FROM shop.item_table LEFT JOIN shop.image_table USING(item_id) WHERE item_id = ?";

			st = cn.prepareStatement(sql);
			st.setString(1, itemId);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				Item i = new Item();
				//Image image = new Image();
				System.out.println(i.getItemId());
				i.setItemId(rs.getString(1));
				i.setItemName(rs.getString(2));
				i.setStockCount(rs.getInt(3));
				i.setSizeId(rs.getString(4));
				i.setColorId(rs.getString(5));
				i.setPrice(rs.getInt(6));
				i.setCategoryId(rs.getString(7));
				i.setDetail(rs.getString(8));
				i.setImagePath(rs.getString(9));

				Item.add(i);
				//Item.add(image);

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

	public List getMaxItemId() {
		ArrayList maxId = new ArrayList();
		try {
			Connection cn = Connector.connect();
			String sql = "SELECT MAX(item_id) FROM shop.item_table";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			rs.next();
			Item i = new Item();
			String max  = rs.getString(1);
			System.out.println("最大値"+max);
			i.setItemId(max);

			maxId.add(i);
			System.out.println(maxId);

			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return maxId;
	}

}
