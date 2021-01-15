package daofactory;

import dao.AddUserDao;
import dao.ColorDao;
import dao.GetAllUsersDao;
import dao.GetUserDao;
import dao.MySQLAddUserDao;
import dao.MySQLColorDao;
import dao.MySQLGetAllUsersDao;
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
	public GetAllUsersDao getAllUsersDao() {
		// TODO 自動生成されたメソッド・スタブ
		return new MySQLGetAllUsersDao();
	}



	@Override
	public AddUserDao getAddUserDao() {
		// TODO 自動生成されたメソッド・スタブ
		return new MySQLAddUserDao();
	}

}
