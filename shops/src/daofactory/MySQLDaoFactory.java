package daofactory;


import dao.user.RemoveUserDao;
import dao.user.MySQLRemoveUserDao;
import dao.user.AddUserDao;
import dao.user.MySQLAddUserDao;
import dao.MySQLGetUserDao;
import dao.admin.ColorDao;
import dao.admin.GetUserDao;
import dao.admin.GetUserListDao;
import dao.admin.MySQLColorDao;
import dao.admin.MySQLGetUserListDao;

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
	public GetUserDao getUserDao() {
		// TODO 自動生成されたメソッド・スタブ
		return new MySQLGetUserDao();
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

}
