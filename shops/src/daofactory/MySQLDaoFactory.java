package daofactory;


import dao.user.RemoveUserDao;
import dao.user.MySQLRemoveUserDao;
import dao.user.RemoveCreditDao;
import dao.user.AddCreditDao;
import dao.user.AddUserDao;
import dao.user.EditUserDao;
import dao.user.GetCreditDao;
import dao.user.GetPasswordDao;
import dao.user.LoginDao;
import dao.user.MySQLAddCreditDao;
import dao.user.MySQLAddUserDao;
import dao.user.MySQLRemoveCreditDao;
import dao.admin.AddImageDao;
import dao.admin.ColorDao;

import dao.admin.GetUserListDao;
import dao.admin.ItemDao;
import dao.admin.MySQLAddImageDao;
import dao.admin.MySQLColorDao;
import dao.admin.MySQLGetUserListDao;
import dao.admin.MySQLItemDao;
import dao.admin.MySQLRemoveImageDao;
import dao.admin.RemoveImageDao;
import dao.favorite.AddFavoDao;
import dao.favorite.GetFavoListDao;
import dao.favorite.MySQLAddFavoDao;
import dao.favorite.MySQLGetFavoListDao;
import dao.favorite.MySQLRemoveFavoDao;
import dao.favorite.RemoveFavoDao;
import dao.item.GetItemDetailDao;
import dao.item.MySQLGetItemDetailDao;
import dao.item.MySQLSearchItemDao;
import dao.item.MySQLSortItemDao;
import dao.item.SearchItemDao;
import dao.item.SortItemDao;
import dao.order.AddCartDao;
import dao.order.AddOrderDao;
import dao.order.GetCartListDao;
import dao.order.GetOrderListDao;
import dao.order.MySQLAddCartDao;
import dao.order.MySQLAddOrderDao;
import dao.order.MySQLGetOrderListDao;
import dao.order.MySQLRemoveCartDao;
import dao.order.RemoveCartDao;

public class MySQLDaoFactory extends AbstractDaoFactory{
	public ColorDao getColorDao() {
		return new MySQLColorDao();
	}



	@Override
	public RemoveUserDao getRemoveUserDao() {
		// TODO 自動生成されたメソッド・スタブ
		return new MySQLRemoveUserDao();
	}

	@Override
	public GetUserListDao getUserListDao() {
		// TODO 自動生成されたメソッド・スタブ
		return new MySQLGetUserListDao();
	}



	@Override
	public AddUserDao getAddUserDao() {
		// TODO 自動生成されたメソッド・スタブ
		return new MySQLAddUserDao();
	}
	
	//admin
	public AddImageDao getAddImageDao() { return new MySQLAddImageDao();}
	public ItemDao getItemDao() { return new MySQLItemDao();}
	public RemoveImageDao getRemoveImageDao() { return new MySQLRemoveImageDao();}


	//favorite
	public AddFavoDao getAddFavoDao() { return new MySQLAddFavoDao();}
	public GetFavoListDao getGetFavoListDao() { return new MySQLGetFavoListDao();}
	public RemoveFavoDao getRemoveFavoDao() { return new MySQLRemoveFavoDao();}

	//item
	public GetItemDetailDao getGetItemDetailDao() { return new MySQLGetItemDetailDao();}
	public SearchItemDao getSearchItemDao() { return new MySQLSearchItemDao();}
	public SortItemDao getSortItemDao() { return new MySQLSortItemDao();}

	//order
	public AddCartDao getAddCartDao() { return new MySQLAddCartDao();}
	public AddOrderDao getAddOrderDao() { return new MySQLAddOrderDao();}
	public GetCartListDao getGetCartListDao() { return new MySQLGetCartListDao();}
	public GetOrderListDao getGetOrderListDao() { return new MySQLGetOrderListDao();}
	public RemoveCartDao getRemoveCartDao() { return new MySQLRemoveCartDao();}

	//user
	public AddCreditDao getAddCreditDao() { return new MySQLAddCreditDao();}
	public EditUserDao getEditUserDao() { return new MySQLEditUserDao();}
	public GetCreditDao getGetCreditDao() { return new MySQLGetCreditDao();}
	public GetPasswordDao getGetPasswordDao() { return new MySQLGetPasswordDao();}
	public LoginDao getLoginDao() { return new MySQLLoginDao();}
	public RemoveCreditDao getRemoveCreditDao() { return new MySQLRemoveCreditDao();}


}
