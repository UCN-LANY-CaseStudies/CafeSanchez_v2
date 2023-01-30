package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDao {
	
	private Context context;
	
	public ProductDao(Context context) {

		this.context = context;
	}

	public List<Product> getAll(){
		
		// call to database that gets all products from the Products table
		
		String sql = "SELECT Id, Name, Description, Price FROM Products";
		ArrayList<Product> result = new ArrayList<>();
		
		try {
			Connection conn = context.getConnection();
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
			
		} catch (SQLException e) {

			e.printStackTrace();
		}		
		return result;
	}
}
