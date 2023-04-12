package ui;

import businessLogic.OrderHandlingController;
import dataAccess.Dao;
import dataAccess.DaoException;
import dataAccess.DaoFactory;
import dataAccess.DaoFactory.Daos;
import model.Order;
import model.Product;

public class Program {

	public static void main(String[] args) {
		try {

			DaoFactory factory = new DaoFactory(Daos.Memory);

			Dao<Order> orderDao = factory.createOrderDao();
			Dao<Product> productDao = factory.createProductDao();

			OrderHandlingController orderCtrl = new OrderHandlingController(orderDao, productDao);

			MainWindow main = new MainWindow(orderCtrl);
			main.setVisible(true);
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}