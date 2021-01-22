package daofactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import command.CommandFactory;
import dao.user.AddUserDao;
import dao.admin.ColorDao;
import dao.admin.GetUserListDao;

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
}
