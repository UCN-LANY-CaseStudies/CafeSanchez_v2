package dataAccess.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dataAccess.Dao;
import dataAccess.DaoException;
import model.Product;

public final class ProductDao extends BaseDao implements Dao<Product> {

	public ProductDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Product create(Product entity) throws DaoException {

		throw new DaoException("Create products is not available");
	}

	@Override
	public List<Product> read() throws DaoException {

		// call to database that gets all products from the Products table
		try {

			String sql = "SELECT Id, Name, Description, Price FROM Products";
			ArrayList<Product> result = new ArrayList<>();

			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				int id = rs.getInt(1);
				String name = rs.getString(2);
				String description = rs.getString(3);
				float price = rs.getFloat(4);

				Product p = new Product(id, name, description, price);

				result.add(p);
			}

			return result;

		} catch (SQLException e) {

			throw new DaoException("An error occurred reading products from database", e);
		}
	}

	@Override
	public Product update(Product entity) throws DaoException {
		
		throw new DaoException("Update products is not available");
	}

	@Override
	public boolean delete(Product entity) throws DaoException {

		throw new DaoException("Delete products is not available");
	}

}