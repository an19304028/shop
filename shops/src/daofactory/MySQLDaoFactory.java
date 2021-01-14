package daofactory;

import dao.AddUserDao;
import dao.ColorDao;
import dao.GetAllUsersDao;
import dao.GetUserDao;
import dao.MySQLAddUserDao;
import dao.MySQLColorDao;
import dao.MySQLRemoveUserDao;
import dao.RemoveUserDao;

public class MySQLDaoFactory extends AbstractDaoFactory{
	public ColorDao getColorDao() {
		return new MySQLColorDao();
	}

	public AddUserDao getAddUserDao() {
		return new MySQLAddUserDao();
	}

	@Override
	public RemoveUserDao getRemoveUserDao() {
		// TODO 自動生成されたメソッド・スタブ
		return new MySQLRemoveUserDao();
	}

	@Override
	public GetUserDao getUserDao() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public GetAllUsersDao getAllUsersDao() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
