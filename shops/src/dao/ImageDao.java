package dao;

import bean.image;

public interface ImageDao {
	public abstract void addImage(image i);
	public image getImage(String imageId);
}
