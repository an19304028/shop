package dao;

import java.util.List;

import bean.Color;


public interface ColorDao {
	public void addColor(Color c);
	public Color getColor(String colorId);
	public List getAllColors();
}
