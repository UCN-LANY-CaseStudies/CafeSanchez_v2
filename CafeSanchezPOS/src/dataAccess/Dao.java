package dataAccess;

import java.util.List;

public interface Dao<TEntity>{
	
	TEntity create(TEntity entity) throws DaoException;
	List<TEntity> read() throws DaoException;
	TEntity update(TEntity entity) throws DaoException;
	boolean delete(TEntity entity) throws DaoException;
}

//public class OrderDao {
//
//	private DbContext context;
//
//	public OrderDao(DbContext context) {
//
//		this.context = context;
//	}
//
//	public List<Order> getAll() throws DaoException {
//
//		try {
//			// Call to database that gets all orders from the Orders table
//			List<Order> result = new ArrayList<>();
//
//			Connection conn = context.getConnection();
//
//			String sql = "SELECT Id, CustomerName, Status, Date FROM Orders ";
//
//			PreparedStatement statement;
//
//			statement = conn.prepareStatement(sql);
//			ResultSet rs = statement.executeQuery();
//
//			while (rs.next()) {
//				// mapping order
//				Order order = new Order(rs.getInt(1));
//				order.setCustomerName(rs.getString(2));
//				order.setStatus(rs.getString(3));
//				order.setDate(rs.getDate(4));
//
//				addOrderlines(conn, order);
//
//				result.add(order);
//			}
//			return result;
//
//		} catch (SQLException e) {
//
//			throw new DaoException("An error occurred reading orders from database", e);
//		}
//	}
//
//	public Order createOrder(Order order) throws DaoException {
//
//		// Call to database that creates an order in the Orders table and
//		// orderlines in the Orderlines table
//		try {
//			Connection conn = context.getConnection();
//			conn.setAutoCommit(false);
//
//			try {
//
//				String sqlInsertOrder = "INSERT INTO Orders (Date, Status, CustomerName) VALUES (?, ?, ?)";
//				PreparedStatement statementInsertOrder = conn.prepareStatement(sqlInsertOrder);
//				statementInsertOrder.setDate(1, new Date(System.currentTimeMillis()));
//				statementInsertOrder.setString(2, Order.STATUS_ACTIVE);
//				statementInsertOrder.setString(3, order.getCustomerName());
//
//				int rowsInserted = statementInsertOrder.executeUpdate();
//
//				if (rowsInserted == 1) {
//					order.setStatus(Order.STATUS_ACTIVE);
//
//					String sqlInsertOrderline = "INSERT INTO Orderlines (OrderCustomerName, ProductName, Quantity) VALUES (?, ?, ?)";
//
//					for (Orderline ol : order.getOrderlines()) {
//						PreparedStatement statementInsertOrderline = conn.prepareStatement(sqlInsertOrderline);
//						statementInsertOrderline.setString(1, order.getCustomerName());
//						statementInsertOrderline.setString(2, ol.getProduct().getName());
//						statementInsertOrderline.setInt(3, ol.getQuantity());
//
//						rowsInserted = statementInsertOrderline.executeUpdate();
//
//						if (rowsInserted == 0) {
//							conn.rollback();
//							return null;
//						}
//					}
//				}
//				conn.commit();
//
//				return order;
//
//			} catch (SQLException e) {
//
//				conn.rollback();
//				throw e;
//			}
//
//		} catch (Exception e) {
//
//			throw new DaoException("An error occurred creating an order", e);
//		}
//	}
//
//	public Order updateOrder(Order order) throws DaoException {
//
//		// Call to database that updates an order in the Orders table
//		try {
//			Connection conn = context.getConnection();
//
//			conn.setAutoCommit(false);
//
//			try {
//				// update order
//				String sqlUpdateOrder = "UPDATE Orders SET Status = ? WHERE CustomerName = ? ";
//				PreparedStatement statement = conn.prepareStatement(sqlUpdateOrder);
//				statement.setString(1, order.getStatus());
//				statement.setString(2, order.getCustomerName());
//				int rowsUpdated = statement.executeUpdate();
//
//				if (rowsUpdated == 1) {
//					// clear order lines
//					String sqlDeleteOrderlines = "DELETE FROM Orderlines WHERE OrderCustomerName = ?";
//					PreparedStatement statementDeleteOrderlines = conn.prepareStatement(sqlDeleteOrderlines);
//					statementDeleteOrderlines.setString(1, order.getCustomerName());
//					statementDeleteOrderlines.execute();
//
//					// add order lines
//					String sqlInsertOrderlines = "INSERT INTO Orderlines (OrderCustomerName, ProductName, Quantity) VALUES (?, ?, ?)";
//
//					for (Orderline ol : order.getOrderlines()) {
//						PreparedStatement statementInsertOrderline = conn.prepareStatement(sqlInsertOrderlines);
//						statementInsertOrderline.setString(1, order.getCustomerName());
//						statementInsertOrderline.setString(2, ol.getProduct().getName());
//						statementInsertOrderline.setInt(3, ol.getQuantity());
//						statementInsertOrderline.execute();
//					}
//				}
//				conn.commit();
//				return order;
//
//			} catch (SQLException e) {
//
//				conn.rollback();
//				throw e;
//			}
//		} catch (SQLException e) {
//
//			throw new DaoException("An error occurred updating order in database", e);
//		}
//	}
//
//	private void addOrderlines(Connection conn, Order order) throws SQLException {
//
//		String sqlSelectOrderlines = "SELECT Products.Id, Products.Name, Products.Description, Products.Price, Quantity "
//				+ "FROM Orderlines " + "JOIN Products ON Products.Id = Orderlines.ProductId " + "WHERE OrderId = ? ";
//
//		// get order lines
//		PreparedStatement statementSelectOrderlines = conn.prepareStatement(sqlSelectOrderlines);
//
//		statementSelectOrderlines.setInt(1, order.getId());
//
//		ResultSet rsOrderlines = statementSelectOrderlines.executeQuery();
//
//		while (rsOrderlines.next()) {
//			// mapping product
//			Product p = new Product(rsOrderlines.getInt(1), rsOrderlines.getString(2), rsOrderlines.getString(3),
//					rsOrderlines.getInt(4));
//			// mapping order lines
//			int quantity = rsOrderlines.getInt(4);
//
//			Orderline ol = new Orderline(quantity, p);
//			order.addOrderline(ol);
//		}
//	}
//}