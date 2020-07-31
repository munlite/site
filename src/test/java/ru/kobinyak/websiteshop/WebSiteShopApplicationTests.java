package ru.kobinyak.websiteshop;

import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.kobinyak.websiteshop.data.*;
import ru.kobinyak.websiteshop.models.*;
import ru.kobinyak.websiteshop.services.CartServiceImpl;
import ru.kobinyak.websiteshop.services.CategoryService;
import ru.kobinyak.websiteshop.services.ProductService;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class WebSiteShopApplicationTests {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CatalogRepository catalogRepository;
	@Autowired
	private ClientRepositiry clientRepositiry;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private ProductInOrderRepository productInOrderRepository;
	@Test
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	void findProduct(){
//		Category category = new Category();
//		category.setName("Игрушки");
//		categoryRepository.save(category);
//
//		Product product = new Product();
//		product.setName("Мишка");
//		productRepository.save(product);
//
//
//
//		Product product1 = new Product();
//		product1.setName("Танк");
//		productRepository.save(product1);
//
//		Catalog catalog = new Catalog();
//		catalog.setCategory(category);
//		catalog.setProduct(product);
//		catalogRepository.save(catalog);
//		Catalog catalog1 = new Catalog();
//		catalog1.setProduct(product1);
//		catalogRepository.save(catalog1);
		Product product2 = new Product();
		product2.setName("Волк");
		productRepository.save(product2);
		Catalog catalog2 = new Catalog();
		catalog2.setProduct(product2);
		catalog2.setCategory(categoryRepository.findById(1).get());
		catalogRepository.save(catalog2);
		categoryRepository.findAllProductByName("Игрушки").stream().map(Product::getName).forEach(System.out::println);

	}

	@Test
	void getCategory(){
		productRepository.findCategoryByProductName("Танк").stream().map(Category::getName).forEach(System.out::println);
		productRepository.findCategoryByProductId(8).stream().map(Category::getName).forEach(System.out::println);
	}

	@Test
	void getClient(){
		Client client = new Client();
		client.setFirstname("Andrey1");
		client.setLastname("Lol1");
		client.setAddress("hbhbad222");
		client.setEmail("andrey1@mail.ru");
		clientRepositiry.save(client);
	}

	@Test
	void saveOrder(){
//		Client client = new Client();
		ProductInOrder productInOrder = new ProductInOrder();
		productInOrder.setProduct(productRepository.findById(2).get());
		productInOrder.setAmount(10);
		productInOrder.setOrder(orderRepository.findById(10).get());
		productInOrderRepository.save(productInOrder);
//		ProductInOrder productInOrder1 = new ProductInOrder();
//		productInOrder.setProduct(productRepository.findById(3).get());
//		productInOrder.setAmount(10);
//		productInOrder.setOrder(orderRepository.findById(10).get());
//		productInOrderRepository.save(productInOrder1);
	}
	@Test
	void productinorder() {
		//System.out.println(productInOrderRepository.findAllByIdOrder(3));
	}
	@Test
	void selectClient() {
		ProductInOrder productInOrder = new ProductInOrder();

		productInOrder.setProduct(productRepository.findById(2).get());
		productInOrder.setAmount(3);
		productInOrder.setOrder(orderRepository.findById(3).get());
//		productInOrderRepository.updateAmountOrder(2,3, 5);
		productInOrderRepository.delete(2,3);
	}
	@Test
	void selec(){

	}
}
