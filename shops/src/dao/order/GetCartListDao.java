package dao.order;

import java.util.List;

public interface GetCartListDao {
	public List getCartList(String userId);
	public int getTotalAmount(String userId);
	public int getPoint(String userId);

}
