package store.service;

import java.util.List;

import store.domain.Order;
import store.domain.User;
import store.utils.PageModel;

public interface OrderService {

	void saveOrder(Order order);

	PageModel findOrdersByUidWithPage(User user, int curNum)throws Exception;

	Order findOrderByOid(String oid)throws Exception;

	void updateOrder(Order order)throws Exception;
	List<Order> findAllOrders()throws Exception;
	List<Order> findAllOrdersWithState(String state)throws Exception;;
}
