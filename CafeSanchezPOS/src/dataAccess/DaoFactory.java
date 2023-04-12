package dataAccess;

import dataAccess.sqlserver.OrderDao;
import model.Order;
import model.Product;

public class DaoFactory {

	private Daos daoType = Daos.Unknown;

	public DaoFactory(Daos daoType) {
		this.daoType = daoType;
	}

	public Dao<Product> createProductDao() throws DaoException {

		switch (daoType) {
		case Memory:
			return new dataAccess.memory.ProductDao();
		case SqlServer:
			return new dataAccess.sqlserver.ProductDao();
		default:
			throw new DaoException("Could not create DAO of type: " + daoType);
		}

	}

	public Dao<Order> createOrderDao() throws DaoException {

		switch (daoType) {
		case Memory:
			return new dataAccess.memory.OrderDao();
		case SqlServer:
			return new dataAccess.sqlserver.OrderDao();
		default:
			throw new DaoException("Could not create OrderDao for " + daoType);
		}
	}

	public enum Daos {
		Unknown, Memory, SqlServer
	}
}
