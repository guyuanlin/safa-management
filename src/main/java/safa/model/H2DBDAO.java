package safa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.common.base.Optional;

public class H2DBDAO {
	
	private static final String PERSISTENCE_FILE = "safa.management.persistence";
	private static H2DBDAO INSTANCE = new H2DBDAO();
	
	private EntityManagerFactory entityManagerFactory;
	private Optional<ArrayList<Product>> defaultProductList;
	private Optional<ArrayList<Color>> defaultColorList;
	
	private H2DBDAO() {
		entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_FILE);
		defaultProductList = Optional.of(new ArrayList<Product>());
		defaultColorList = Optional.of(new ArrayList<Color>());
	}
	
	public static H2DBDAO getInstance() {
		return INSTANCE;
	}
	
	public void addProduct(Product product) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public void upateProduct(Product product) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(product);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public boolean containsProduct(String productID) {
		EntityManager em = entityManagerFactory.createEntityManager();
		boolean result = false;
		try {
			em.getTransaction().begin();
			result = !(em.find(Product.class, productID) == null);
			em.getTransaction().commit();
			return result;
		} finally {
			em.close();
		}
	}
	
	public Product getProduct(String productID) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Product product = null;
		try {
			em.getTransaction().begin();
			product = em.find(Product.class, productID);
			em.getTransaction().commit();
			return product;
		} finally {
			em.close();
		}
	}
	
	public void deleteProduct(Product product) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(product);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public List<Product> getAllProducts() {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Product> products = defaultProductList.get();
		try {
			em.getTransaction().begin();
			products = em.createQuery("from Product", Product.class).getResultList();
			em.getTransaction().commit();
			return products;
		} finally {
			em.close();
		}
	}
	
	public void addColor(Color color) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(color);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public boolean containsColor(String colorName) {
		EntityManager em = entityManagerFactory.createEntityManager();
		boolean result = false;
		try {
			em.getTransaction().begin();
			result = !(em.find(Color.class, colorName) == null);
			em.getTransaction().commit();
			return result;
		} finally {
			em.close();
		}
	}
	
	public Color getColor(String colorName) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Color color = null;
		try {
			em.getTransaction().begin();
			color = em.find(Color.class, colorName);
			em.getTransaction().commit();
			return color;
		} finally {
			em.close();
		}
	}
	
	public List<Color> getAllColors() {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Color> colors = defaultColorList.get();
		try {
			em.getTransaction().begin();
			colors = em.createQuery("from Color", Color.class).getResultList();
			em.getTransaction().commit();
			return colors;
		} finally {
			em.close();
		}
	}
	
	public void close() {
		entityManagerFactory.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		H2DBDAO dao = H2DBDAO.getInstance();
		
		List<Color> colors = dao.getAllColors();
		System.out.println("Color 列表：");
		for(Color color : colors) {
			System.out.println(color);
		}
		
		dao.addColor(new Color("紅色"));
		if(!dao.containsColor("紅色")) {
			dao.addColor(new Color("紅色"));
		}
		colors = dao.getAllColors();
		System.out.println("Color 列表：");
		for(Color color : colors) {
			System.out.println(color);
		}
		
//		System.out.println(dao.containsProduct("1"));
//		Product product4 = dao.getProduct("1");
//		product4.setName("2222");
//		dao.upateProduct(product4);
//		
//		colors = dao.getAllProducts();
//		for(Product product : colors) {
//			System.out.println(product);
//		}
		
//		dao.addProduct(new Product(new ProductPK("1", "23.5", new Color("紅色"))));
//		
//		List<Product> products = dao.getAllProducts();
//		for(Product product : products) {
//			System.out.println(product);
//		}
//		System.out.println(dao.containsProduct("1"));
//		Product product4 = dao.getProduct("1");
//		product4.setName("2222");
//		dao.upateProduct(product4);
//		
//		products = dao.getAllProducts();
//		for(Product product : products) {
//			System.out.println(product);
//		}
	}
}
