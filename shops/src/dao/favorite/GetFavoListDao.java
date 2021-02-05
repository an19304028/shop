package dao.favorite;

import java.util.List;;

public interface GetFavoListDao {
	public List getFavoList(String userId);
	public boolean getCheckfavo(String userId, String itemId);

}
