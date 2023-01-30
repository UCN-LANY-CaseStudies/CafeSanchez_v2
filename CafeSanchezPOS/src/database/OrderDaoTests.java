package database;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Order;

class OrderDaoTests { // Database integration tests

	Context context = null;
	OrderDao orderDao = null;
	
	@BeforeEach
	void setup() {
		context = new Context();
		orderDao = new OrderDao(context);
	}
	
	@Test
	void test_getAll() {
		// Arrange
		
		// Act
		List<Order> orders = orderDao.getAll();
		
		// Assert
		assertTrue(orders.size() == 10);		
	}
	
	@Test
	void test_getSingle() {
		// Arrange
		int orderId = 1;
		
		// Act
		Order result = orderDao.getSingle(orderId);
		
		// Assert
		assertNotNull(result);
	}
	
	@Test
	void test_createOrder() {
		
		fail("Not implemented");
	}	
	
	@Test
	void test_updateOrder() {
		
		fail("Not implemented");
	}

}
