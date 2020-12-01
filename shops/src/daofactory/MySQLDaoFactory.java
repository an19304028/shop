package daofactory;

import dao.CategoryDao;
import dao.ColorDao;
import dao.MySQLCategoryDao;
import dao.MySQLColorDao;

public class MySQLDaoFactory extends AbstractDaoFactory{
	public ColorDao getColorDao() {
		return new MySQLColorDao();
	}
	public CategoryDao getCategoryDao() {
		return new MySQLCategoryDao();
	}
	public FavoriteDao getFavoriteDao() {
		return new MySQLFavoriteDao();
	}
	public ImageDao getImageDao() {
		return new MySQLImageDao();
	}
	public ItemDao getItemDao() {
		return new MySQLItemDao();
	}
	public OrderDao getOrderDao() {
		return new MySQLOrderDao();
	}
	public OrderDetailDao getOrderDetailDao() {
		return new MySQLOrderDetailDao();
	}
	public SizeDao getSizeDao() {
		return new MySQLSIzeDao();
	}
	public UserDao getUserDao() {
		return new MySQLUserDao();
	}
	
}
