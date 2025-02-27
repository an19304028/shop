package dao.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Item;
import daofactory.Connector;

public class MySQLGetUserItemListDao implements GetUserItemListDao {
	private PreparedStatement st = null;

	 public List getGetUserItemList() {
		ArrayList items = new ArrayList();
		try {
			Connection cn = Connector.connect();
			//結合で書いて
			String sql = "SELECT i.item_id, i.item_name, i.stock_count, s.size_name ,c.color_name, ca.category_name, i.price, i.detail, im.image_path FROM shop.item_table i JOIN shop.size_table s USING(size_id) JOIN shop.color_table c USING(color_id) JOIN shop.category_table ca USING(category_id) JOIN shop.image_table im USING(item_id) WHERE image_path LIKE '%samne.jpg'";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Item i = new Item();
				//Image image = new Image();
				i.setItemId(rs.getString(1));
				i.setItemName(rs.getString(2));
				i.setStockCount(rs.getInt(3));
				i.setSizeName(rs.getString(4));
				i.setColorName(rs.getString(5));
				i.setCategoryName(rs.getString(6));
				i.setPrice(rs.getInt(7));
				i.setDetail(rs.getString(8));
				i.setImagePath(rs.getString(9));

				System.out.println(i.getItemId()+i.getCategoryName()+i.getSizeName());

				items.add(i);
				//items.add(image);

			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return items;
	}

}
