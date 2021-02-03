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
		ArrayList favo = new ArrayList();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT i.item_id, i.item_name, i.stock_count, s.size_name ,c.color_name, i.price, ca.category_name, i.detail, im.image_path FROM shop.item_table i JOIN shop.size_table s USING(size_id) JOIN shop.color_table c USING(color_id) JOIN shop.favo_table ca USING(category_id) JOIN shop.image_table im USING(item_id) WHERE userId=?";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Favorite f = new Favorite();
				f.setItemId(rs.getString(1));
				f.setItemName(rs.getString(2));
				f.setStockCount(rs.getInt(3));
				f.setSizeName(rs.getString(4));
				f.setColorName(rs.getString(5));
				f.setPrice(rs.getInt(6));
				f.setCategoryName(rs.getString(7));
				f.setDetail(rs.getString(8));
				//f.setImagePath(rs.getString(9));

				System.out.println(f.getItemId()+f.getCategoryName()+f.getSizeName());


				favo.add(f);
			}
			cn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return favo;
	}

}
