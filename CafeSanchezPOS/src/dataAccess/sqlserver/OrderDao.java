package dataAccess.sqlserver;

import java.util.List;

import dataAccess.Dao;
import dataAccess.DaoException;
import model.Order;

public final class OrderDao extends BaseDao implements Dao<Order>{

	public OrderDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Order create(Order entity) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> read() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order update(Order entity) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Order entity) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

}
