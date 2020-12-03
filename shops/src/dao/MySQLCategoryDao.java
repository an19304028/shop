package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Category;
import daofactory.Connector;

public class MySQLCategoryDao implements CategoryDao{
	private PreparedStatement st = null;
	private Connection cn = null;

	public void addCategory(Category c) {
		try {
			Connection cn = Connector.connect();

		String sql = "INSERT into shop.category_table VALUES(?,?,?)";

			st = cn.prepareStatement(sql);

			st.setString(1, c.getCategoryId());
			st.setString(2, c.getCategoryName());

			st.executeUpdate();

			cn.commit();
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

		public Category getCategory(String categoryId) {
			Category c = new Category();
			try {
				Connection cn = Connector.connect();
				String sql = "SELECT category_id, category_name FROM shop.category_table WHERE category_id=?";
				st = cn.prepareStatement(sql);

				st.setString(1, categoryId);

				ResultSet rs = st.executeQuery();
				System.out.println(rs.getString(1));
				rs.next();
				c.setCategoryId(rs.getString(1));
				c.setCategoryName(rs.getString(2));

				cn.commit();
				cn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}

			return c;
			}
		public List getAllCategorys() {
			ArrayList categorys = new ArrayList();
			try {
				Connection cn = Connector.connect();
				String sql = "SELECT category_id, category_name FROM shop.category_table";
				st = cn.prepareStatement(sql);

				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					Category c = new Category();
					c.setCategoryId(rs.getString(1));
					c.setCategoryName(rs.getString(2));

					categorys.add(c);

			}
				cn.commit();
				cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
			return categorys;
	}
}
