package store.dao.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import store.dao.CategoryDao;
import store.domain.Category;
import store.utils.JDBCUtils;

public class CategoryDaoImp implements CategoryDao {

	@Override
	public void saveCat(Category c) throws SQLException {
		String sql="insert into category values ( ? ,?)";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		qr.update(sql,c.getCid(),c.getCname());
			
	}

	@Override
	public List<Category> findAllCats() throws SQLException {
		String sql="select * from category";
		QueryRunner qr=new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanListHandler<Category>(Category.class));
		
	}
	
}