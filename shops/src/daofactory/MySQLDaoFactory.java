package daofactory;

import dao.CategoryDao;
import dao.ColorDao;
import dao.FavoriteDao;
import dao.ImageDao;
import dao.ItemDao;
import dao.MySQLCategoryDao;
import dao.MySQLColorDao;
import dao.MySQLFavoriteDao;
import dao.MySQLImageDao;
import dao.MySQLItemDao;
import dao.MySQLOrderDao;
import dao.MySQLOrderDetailDao;
import dao.MySQLSizeDao;
import dao.MySQLUserDao;
import dao.OrderDao;
import dao.OrderDetailDao;
import dao.SizeDao;
import dao.UserDao;

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
		return new MySQLSizeDao();
	}
	public UserDao getUserDao() {
		return new MySQLUserDao();
	}
	
}
