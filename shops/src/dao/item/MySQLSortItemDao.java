package dao.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Item;
import daofactory.Connector;

public class MySQLSortItemDao implements SortItemDao {
	private PreparedStatement st = null;

	@Override
	public List sortItem(String key) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList item = new ArrayList();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT item_id, item_name, stock_count, size_id, color_id, price, category_id, detail, image_path From shop.item_table";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Item i = new Item();
				i.setItemId(rs.getString(1));
				i.setItemName(rs.getString(2));
				i.setStockCount(rs.getInt(3));
				i.setSizeId(rs.getString(4));
				i.setColorId(rs.getString(5));
				i.setCategoryId(rs.getString(6));
				i.setDetail(rs.getString(7));
				i.setImagePath(rs.getString(8));

				item.add(i);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

}
