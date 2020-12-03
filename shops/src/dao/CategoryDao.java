package dao;

import java.util.List;

import bean.Category;

public interface CategoryDao {
	public abstract void addCategory(Category c);
	public Category getCategory(String categoryId);
	public List getAllCategorys();

}