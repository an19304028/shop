package daofactory;

import dao.ColorDao;
import dao.GetAllUsersDao;
import dao.GetUserDao;
import dao.MySQLColorDao;
import dao.MySQLGetAllUsersDao;
import dao.MySQLGetUserDao;
import dao.MySQLRemoveUserDao;
import dao.RemoveUserDao;
import dao.MySQLAddUserDao;
import dao.AddUserDao;

public class MySQLDaoFactory extends AbstractDaoFactory{
	public ColorDao getColorDao() {
		return new MySQLColorDao();
	}

	public AddUserDao getAddUserDao() {
		return new MySQLAddUserDao();
	}

	@Override
	public GetAllUsersDao getAllUsersDao() {
		// TODO 自動生成されたメソッド・スタブ
		return new MySQLGetAllUsersDao();
	}

	@Override
	public GetUserDao getUserDao() {
		// TODO 自動生成されたメソッド・スタブ
		return new MySQLGetUserDao();
	}

	@Override
	public RemoveUserDao getRemoveUserDao() {
		// TODO 自動生成されたメソッド・スタブ
		return new MySQLRemoveUserDao();
	}
	
}
