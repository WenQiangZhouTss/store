package store.service;

import java.sql.SQLException;
import java.util.List;

import store.domain.Product;
import store.utils.PageModel;

public interface ProductService {

	List<Product> findNewProducts()throws SQLException ;

	List<Product> findHotProducts()throws SQLException ;

	Product findProductByPid(String pid)throws SQLException ;

	PageModel findProductsWithCidAndPage(String cid, int curNum)throws SQLException ;

	void saveProduct(Product product)throws SQLException ;

}
