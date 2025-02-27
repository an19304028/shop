package daofactory;


import dao.admin.AddImageDao;
import dao.admin.ColorDao;
import dao.admin.GetImageDao;
import dao.admin.GetUserListDao;
import dao.admin.ItemDao;
import dao.admin.MySQLAddImageDao;
import dao.admin.MySQLColorDao;
import dao.admin.MySQLGetImageDao;
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
import dao.item.GetCategoryDao;
import dao.item.GetItemDetailDao;
import dao.item.GetUserItemListDao;
import dao.item.MySQLGetCategoryDao;
import dao.item.MySQLGetItemDetailDao;
import dao.item.MySQLGetUserItemListDao;
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
import dao.order.MySQLGetCartListDao;
import dao.order.MySQLGetOrderListDao;
import dao.order.MySQLRemoveAllCartDao;
import dao.order.MySQLRemoveCartDao;
import dao.order.RemoveAllCartDao;
import dao.order.RemoveCartDao;
import dao.user.AddCreditDao;
import dao.user.AddUserDao;
import dao.user.EditPasswordDao;
import dao.user.EditUserDao;
import dao.user.GetCreditDao;
import dao.user.GetPasswordDao;
import dao.user.GetUserDao;
import dao.user.LoginDao;
import dao.user.MySQLAddCreditDao;
import dao.user.MySQLAddUserDao;
import dao.user.MySQLEditPasswordDao;
import dao.user.MySQLEditUserDao;
import dao.user.MySQLGetCreditDao;
import dao.user.MySQLGetPasswordDao;
import dao.user.MySQLGetUserDao;
import dao.user.MySQLLoginDao;
import dao.user.MySQLRemoveCreditDao;
import dao.user.MySQLRemoveUserDao;
import dao.user.RemoveCreditDao;
import dao.user.RemoveUserDao;

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
	public GetImageDao getGetImageDao() { return new MySQLGetImageDao();}


	//favorite
	public AddFavoDao getAddFavoDao() { return new MySQLAddFavoDao();}
	public GetFavoListDao getGetFavoListDao() { return new MySQLGetFavoListDao();}
	public RemoveFavoDao getRemoveFavoDao() { return new MySQLRemoveFavoDao();}

	//item
	public GetItemDetailDao getGetItemDetailDao() { return new MySQLGetItemDetailDao();}
	public SearchItemDao getSearchItemDao() { return new MySQLSearchItemDao();}
	public SortItemDao getSortItemDao() { return new MySQLSortItemDao();}
	public GetUserItemListDao getGetUserItemListDao() { return new MySQLGetUserItemListDao();}
	public GetCategoryDao getGetCategoryDao() { return new MySQLGetCategoryDao();}


	//order
	public AddCartDao getAddCartDao() { return new MySQLAddCartDao();}
	public AddOrderDao getAddOrderDao() { return new MySQLAddOrderDao();}
	public GetCartListDao getGetCartListDao() { return new MySQLGetCartListDao();}
	public GetOrderListDao getGetOrderListDao() { return new MySQLGetOrderListDao();}
	public RemoveCartDao getRemoveCartDao() { return new MySQLRemoveCartDao();}
	public RemoveAllCartDao getRemoveAllCartDao() { return new MySQLRemoveAllCartDao();}


	//user
	public AddCreditDao getAddCreditDao() { return new MySQLAddCreditDao();}
	public EditUserDao getEditUserDao() { return new MySQLEditUserDao();}
	public GetCreditDao getGetCreditDao() { return new MySQLGetCreditDao();}
	public GetPasswordDao getGetPasswordDao() { return new MySQLGetPasswordDao();}
	public LoginDao getLoginDao() { return new MySQLLoginDao();}
	public RemoveCreditDao getRemoveCreditDao() { return new MySQLRemoveCreditDao();}
	public GetUserDao getGetUserDao() { return new MySQLGetUserDao();}
	public EditPasswordDao getEditPasswordDao() {return new MySQLEditPasswordDao();}


}
