package bean;

import java.io.Serializable;

public class Favorite implements Serializable{
	private String userId;
	private String itemId;
	public Favorite() {}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

}
