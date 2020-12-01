package daofactory;

import dao.ColorDao;
import dao.MySQLColorDao;

public class MySQLDaoFactory extends AbstractDaoFactory{
	public ColorDao getColorDao() {
		return new MySQLColorDao();
	}
	
}
