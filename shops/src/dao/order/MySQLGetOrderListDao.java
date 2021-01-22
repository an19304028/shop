package dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Order;
import daofactory.Connector;

public class MySQLGetOrderListDao implements GetOrderListDao{

	private PreparedStatement st = null;
	@Override
	public List getOrderList() {
		ArrayList order = new ArrayList();
		try {
			Connection cn = Connector.connect();

			String sql = "SELECT FROM shop.order_table";
			st = cn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Order o = new Order();

				o.set(rs.getString(1));
				o.set(rs.getString(2));
				o.set(rs.getString(3));
				o.set(rs.getString(4));
				o.set(rs.getString(5));
				o.set(rs.getString(6));
				o.set(rs.getString(7));


				order.add(o);
			}
			cn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return order;
	}
}
