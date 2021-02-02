package dao.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Item;
import daofactory.Connector;

public class MySQLGetItemDetailDao implements GetItemDetailDao{
	private PreparedStatement st = null;

	@Override
	public List getItemDetail(String key) {
		// TODO 自動生成されたメソッド・スタブ
		ArrayList item = new ArrayList();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT i.item_id, i.item_name, i.stock_count, s.size_name ,c.color_name, ca.category_name, i.price, i.detail FROM shop.item_table i JOIN shop.size_table s USING(size_id) JOIN shop.color_table c USING(color_id) JOIN shop.category_table ca USING(category_id) Where item_id=?";
			st = cn.prepareStatement(sql);
			
			st.setString(1,key);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Item i = new Item();
				i.setItemId(rs.getString(1));
				i.setItemName(rs.getString(2));
				i.setStockCount(rs.getInt(3));
				i.setSizeName(rs.getString(4));
				i.setColorName(rs.getString(5));
				i.setCategoryName(rs.getString(6));
				i.setPrice(rs.getInt(7));
				i.setDetail(rs.getString(8));
				//i.setImagePath(rs.getString(9));

				item.add(i);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return item;

}
}