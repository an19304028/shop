package dao;

import java.util.List;
import bean.User;

public interface UserDao {
	public void addUser(User u);
	public List getUser(String userId);
	public List getAllUsers();
	public void removeUser(String userId);
}
