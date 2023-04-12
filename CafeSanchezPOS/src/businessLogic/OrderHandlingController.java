package businessLogic;

import java.util.List;
import java.util.stream.Collectors;

import dataAccess.Dao;
import model.Order;
import model.Product;

public class OrderHandlingController {
	
	private Dao<Order> orderDao;
	private Dao<Product> productDao;
	
	public OrderHandlingController(Dao<Order> orderDao, Dao<Product> productDao) { // constructor is private to enforce singleton
		
		this.productDao = productDao;
		this.orderDao = orderDao;
	}

	public boolean createOrder(Order order) throws Exception {
		
		Order createdOrder = orderDao.create(order);
		
		return createdOrder.getStatus().equals(Order.STATUS_ACTIVE);
	}

	public boolean finishOrder(Order selectedOrder) throws Exception {
		
		selectedOrder.setStatus(Order.STATUS_FINISHED);
		Order updatedOrder = orderDao.update(selectedOrder);
		
		return updatedOrder.getStatus().equals(Order.STATUS_FINISHED);
	}

	public List<Product> getProducts() throws Exception {

		return  productDao.read();
	}

	public List<Order> getActiveOrders() throws Exception {
		
		List<Order> orders = orderDao.read();
		
		if(orders == null)
			return null; 
		
		return orders.stream().filter(O -> O.getStatus().equals(Order.STATUS_ACTIVE)).collect(Collectors.toList());		
	}
	

}
