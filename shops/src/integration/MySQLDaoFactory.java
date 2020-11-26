package integration;

public class MySQLDaoFactory extends AbstractDaoFactory{
	public ColorDao getColorDao() {
		return new MySQLColorDao();
	}
	
}
