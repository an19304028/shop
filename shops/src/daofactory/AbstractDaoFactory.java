package daofactory;

import java.io.InputStream;
import java.util.Properties;
import command.CommandFactory;
import dao.user.AddCreditDao;
import dao.user.AddUserDao;
import dao.user.EditUserDao;
import dao.user.GetCreditDao;
import dao.user.GetPasswordDao;
import dao.user.LoginDao;
import dao.user.RemoveCreditDao;
import dao.admin.AddImageDao;
import dao.admin.ColorDao;
import dao.admin.GetImageDao;
import dao.admin.GetUserListDao;
import dao.admin.ItemDao;
import dao.admin.RemoveImageDao;
import dao.favorite.AddFavoDao;
import dao.favorite.GetFavoListDao;
import dao.favorite.RemoveFavoDao;
import dao.item.GetCategoryDao;
import dao.item.GetItemDetailDao;
import dao.item.GetUserItemListDao;
import dao.item.SearchItemDao;
import dao.item.SortItemDao;

import dao.order.AddCartDao;
import dao.order.AddOrderDao;
import dao.order.GetCartListDao;
import dao.order.GetOrderListDao;
import dao.order.RemoveAllCartDao;
import dao.order.RemoveCartDao;
import dao.user.RemoveUserDao;


public abstract class AbstractDaoFactory {
	public static AbstractDaoFactory getFactory() {
		AbstractDaoFactory factory = null;
		Properties p = new Properties();
		try {
			InputStream file = CommandFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			//p.load(new FileInputStream("../dao.properties"));
			

			p.load(file);
			String name = p.getProperty("mysql");
			System.out.println("DAOプロパティ名:"+name);
			Class c = Class.forName(name);
			factory = (AbstractDaoFactory)c.newInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return factory;
	}
	public abstract ColorDao getColorDao();
	public abstract AddUserDao getAddUserDao();
	public abstract GetUserListDao getUserListDao();
	public abstract RemoveUserDao getRemoveUserDao();
	
	//dao.admin
	public abstract AddImageDao getAddImageDao();	
	public abstract ItemDao getItemDao();
	public abstract RemoveImageDao getRemoveImageDao();
	public abstract GetImageDao getGetImageDao();

	
	//dao.favorite
	public abstract AddFavoDao getAddFavoDao();
	public abstract GetFavoListDao getGetFavoListDao();
	public abstract RemoveFavoDao getRemoveFavoDao();

	//dao.item
	public abstract GetItemDetailDao getGetItemDetailDao();
	public abstract SearchItemDao getSearchItemDao();
	public abstract SortItemDao getSortItemDao();
	public abstract GetUserItemListDao getGetUserItemListDao();
	public abstract GetCategoryDao getGetCategoryDao();


	//dao.order
	public abstract AddCartDao getAddCartDao();
	public abstract AddOrderDao getAddOrderDao();
	public abstract GetCartListDao getGetCartListDao();
	public abstract GetOrderListDao getGetOrderListDao();
	public abstract RemoveCartDao getRemoveCartDao();
	public abstract RemoveAllCartDao getRemoveAllCartDao();


	//dao.user
	public abstract AddCreditDao getAddCreditDao();
	public abstract EditUserDao getEditUserDao();
	public abstract GetCreditDao getGetCreditDao();
	public abstract GetPasswordDao getGetPasswordDao();
	public abstract LoginDao getLoginDao();
	public abstract RemoveCreditDao getRemoveCreditDao();


}
