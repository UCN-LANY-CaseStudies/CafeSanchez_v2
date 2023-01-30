package database;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Product;

class ProductDaoTest {

	Context context = null;
	ProductDao productDao = null;

	@BeforeEach
	void setUp() throws Exception {
		context = new Context();
		productDao = new ProductDao(context);
	}

	@Test
	void test_getAll() {

		List<Product> result = productDao.getAll();

		assertTrue(result.size() == 9);
	}

}
