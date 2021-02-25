package dao.user;

import java.util.List;

public interface GetUserDao {
	public List getUser(String userId);
	public String getUserId(String loginId);
}