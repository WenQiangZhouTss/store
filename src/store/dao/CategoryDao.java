package store.dao;

import java.sql.SQLException;
import java.util.List;

import store.domain.Category;

public interface CategoryDao {

	List<Category> findAllCats()throws SQLException;

	void saveCat(Category c)throws SQLException;

}
