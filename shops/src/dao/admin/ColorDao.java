package dao.admin;

import java.util.List;

import bean.Color;


public interface ColorDao {
	public void addColor(Color c);
	public List getColor(String colorId);
	public List getAllColors();
	public List getMaxColorId();
	public void removeColor(String colorId);
}
