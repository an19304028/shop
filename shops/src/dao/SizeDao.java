package dao;

import bean.Size;

public interface SizeDao {
	public abstract void addSize(Size s);
	public Size getSize(String sizeId);
}