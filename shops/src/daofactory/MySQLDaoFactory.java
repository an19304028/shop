package daofactory;

import dao.AddUserDao;
import dao.ColorDao;
import dao.GetUserListDao;
import dao.GetUserDao;
import dao.MySQLAddUserDao;
import dao.MySQLColorDao;
import dao.MySQLGetUserListDao;
import dao.MySQLGetUserDao;
import dao.MySQLRemoveUserDao;
import dao.RemoveUserDao;

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
