package dao.user;

import bean.User;

public interface LoginDao {
	public User login(String loginId);
	public String getUserId(String loginId);
	public int getPoint(String loginId);
	public String getCartCount(String loginId);
}
